package modelo;

import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Clase que representa una Tarjeta de Crédito.
 * Contiene información sobre el titular, el número de identificación, el pin, el límite,
 * la fecha de caducidad, el número de la tarjeta, el cvv y los movimientos realizados con la tarjeta.
 * El CVV se genera aleatoriamente un número de 3 dígitos.
 * La clase puede efectuar pagos y cada pago se representa como un Movimiento.
 * @author José María Campos Trujillo
 * @version 1.0
 * @see Movimiento
 */
public class TarjetaCredito {
    private static final String NIF_PATTERN = "^[0-9]{8}[TRWAGMYFPDXBNJZSQVHLCKEtrwagmyfpdxbnjzsqvhlcke]$";
    private static final char[] LETRAS_NIF = {'T','R','W','A','G','M','Y','F','P','D','X','B','N','J','Z','S','Q','V','H','L','C','K','E'};
    private static final String NIE_PATTERN = "^[XYZxyz][0-9]{7}[TRWAGMYFPDXBNJZSQVHLCKEtrwagmyfpdxbnjzsqvhlcke]$";
    private static final String CIF_PATTERN = "^[ABCDEFGHJKLMNPQRSUVWabcdefghjklmnpqrsuvw]{1}[0-9]{7}[0-9A-J]{1}$";
    private static final String TITULAR_PATTERN = "^(?=\\S)[A-Za-zÁÉÍÓÚÑáéíóúñ\\s]{15,80}(?<=\\S)$";
    private static final String PIN_PATTERN = "^\\d{4,}$";
    private static final String CARD_PATTERN = "^\\d{16}$";
    private static final double MIN_LIMIT = 500;
    private static final double MAX_LIMIT = 5000;
    private final String titular;
    private final String nif;
    private String pin;
    private int limite;
    private final int mesCaducidad;
    private final int añoCaducidad;
    private final String numeroTarjeta;
    private String cvv;
    private final Movimiento[] movimientos;
    private int posicionSiguienteMovimiento = 0;
    private double totalGastado = 0;

    /**
     * Constructor principal de la clase TarjetaCredito.
     * Recibe el nombre del titular, el nif, el pin, el límite y el número de la tarjeta.
     * Valida que los campos sean correctos antes de asignarlos.
     * @param nombre Nombre del titular de la tarjeta, Debe de contener exclusivamente caracteres alfabéticos,
     * no empezar o terminar por espacios y tener una longitud entre 15 y 80 caracteres ambos incluidos.
     * @param nif NIF del titular de la tarjeta, debe de ser un NIE, DNI o CIF formado correctamente
     * sin espacios al principio ni al final, también debe ser un NIE, DNI o CIF correcto, ya que se
     * realizará los cálculos necesarios para validarlo.
     * @param pin PIN de la tarjeta, debe de ser un número de mínimo 4 cifras.
     * @param limite Límite de la tarjeta, debe de ser un número comprendido entre 500 - 5000 ambos incluidos
     * @param numeroTarjeta Número de la tarjeta, debe de ser un número de 16 dígitos y se comprobará su
     * validez realizando el Algoritmo de Luhn.
     * @throws IllegalArgumentException Lanzará la Excepción si el nombre del titular no contiene exclusivamente caracteres alfabéticos,
     * empieza o termina con espacios o tiene una longitud menor a 15 caracteres o mayor a 80 caracteres.
     * @throws IllegalArgumentException Lanzará la Excepción si el NIF no es un NIE, DNI o CIF válido tanto de forma,
     * como de cálculo (Se realizará los cálculos necesarios para comprobar la validez del NIF)
     * @throws IllegalArgumentException Si el PIN no es un número de 4 dígitos
     * @throws IllegalArgumentException Si el límite de la tarjeta está fuera del rango 500 - 5000.
     * @throws IllegalArgumentException Si el número de la tarjeta no es un dígito de 16 dígitos o no es válido
     * realizando el Algoritmo de Luhn.
     */
     public TarjetaCredito(String nombre, String nif, String pin,int limite, String numeroTarjeta){
        if (!validarTitular(nombre)) // Valida el Titular
            throw new IllegalArgumentException("El campos del nombre debe de tener al menos 15 caracteres y un máximo de 80");
        if (!validarNIF_NIE_CIF(nif)) // Valida el NIF
            throw new IllegalArgumentException("El NIF no es válido");
        if (!validarPin(pin)) // Valida el PIN
            throw new IllegalArgumentException("El pin debe de contener mínimo 4 dígitos");
        if (!validarLimite(limite)) // Valida el Límete
            throw new IllegalArgumentException("Limite fuera de rango debe estar entre 500 y 5000");
        if (!comprobarNumeroTarjeta(numeroTarjeta)) // Valida el Número de la Tarjeta
            throw new IllegalArgumentException("El numero de la tarjeta es erróneo");
        // Asignamos los Valores
        this.titular = nombre;
        this.nif = nif;
        this.pin = pin;
        this.limite = limite;
        this.mesCaducidad = LocalDate.now().getMonthValue(); // Obtenemos el dia del mes
        this.añoCaducidad = LocalDate.now().getYear()+5; // Obtenemos el año actual y le sumamos 5
        this.numeroTarjeta = numeroTarjeta;
        this.cvv = crearCVV();
        this.movimientos = new Movimiento[50];
    }

    /**
     * Constructor de copia de la clase TarjetaCredito.
     * Recibe un objeto TarjetaCredito y crea una copia profunda con los mismos datos.
     * @param tarjeta Objeto TarjetaCredito a copiar.
     */
    public TarjetaCredito(TarjetaCredito tarjeta){
        // Asignamos los atributos
        this(tarjeta.titular,tarjeta.nif,tarjeta.pin,tarjeta.limite,tarjeta.numeroTarjeta);
        this.posicionSiguienteMovimiento = tarjeta.posicionSiguienteMovimiento;
        this.totalGastado = tarjeta.totalGastado;
        this.cvv = tarjeta.cvv;
        // Asignamos los movimientos al nuevo array
        for (int i = 0; i < posicionSiguienteMovimiento; i++) {
            this.movimientos[i] = new Movimiento(tarjeta.movimientos[i]);
        }
    }

    /**
     Método que devuelve el titular de la tarjeta.
     @return El nombre del titular de la tarjeta.
     */
    public String getTitular() {
        return titular;
    }

    /**
     Método que devuelve el NIF del titular de la tarjeta.
     @return el NIF del titular de la tarjeta.
     */
    public String getNif() {
        return nif;
    }

    /**
     * Método que devuelve el pin de la tarjeta.
     * @return el pin de la tarjeta.
     */
    public String getPin() {
        return pin;
    }

    /**
     * Método para establecer un nuevo pin en la tarjeta.
     * El nuevo PIN debe de ser un número de al menos 4 cifras.
     * @param pin El nuevo pin de la tarjeta. Debe de ser un número de 4 cifras
     */
    public void setPin(String pin) {
        if (validarPin(pin)) // Validamos que el PIN sea correcto
            this.pin = pin;
    }

    /**
     * Método que devuelve el límite de la tarjeta.
     * @return el límite de la tarjeta.
     */
    public int getLimite() {
        return limite;
    }

    /**
     * Método para establecer un nuevo límite en la tarjeta.
     * El nuevo Límite debe de estar entre 500 - 5000 ambos incluidos
     * @param limite el nuevo límite de la tarjeta, comprendido entre 500 - 5000 ambos incluidos
     */
    public void setLimite(int limite) {
        if (validarLimite(limite))
            this.limite = limite;
    }

    /**
     * Método que devuelve el mes de caducidad de la tarjeta.
     * @return el mes de caducidad de la tarjeta.
     */
    public int getMesCaducidad() {
        return mesCaducidad;
    }

    /**
     * Método que devuelve el año de caducidad de la tarjeta.
     * @return el año de caducidad de la tarjeta.
     */
    public int getAñoCaducidad() {
        return añoCaducidad;
    }

    /**
     * Método que devuelve el número de la tarjeta.
     * @return el número de la tarjeta.
     */
    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    /**
     * Método que devuelve el cvv de la tarjeta.
     * @return el cvv de la tarjeta.
     */
    public String getCvv() {
        return cvv;
    }

    /**
     * Método que permite realizar un pago con la tarjeta de crédito.
     * El pago se representará como un movimiento en la Tarjeta.
     * Se realizará el pago si la suma de todos los pagos anteriores mas el actual no sobrepase el Límite de la Tarjeta
     * @param cantidad La cantidad a pagar, debe de ser un valor positivo
     * @param concepto Concepto del pago, no puede estar vacío y no debe de sobrepasar los 50 caracteres
     * @throws IllegalArgumentException Lanza la Excepción si la cantidad es un valor negativo.
     * @throws IllegalArgumentException Lanza la Excepción si el concepto está vacío o posee más de 50 caracteres
     * @return true si el pago fue realizado exitosamente, false en caso contrario.
     */
    public boolean pagar(double cantidad, String concepto){
        if (!Movimiento.validarCantidad(cantidad)){ // Validamos la cantidad
            throw new IllegalArgumentException("La cantidad debe de ser positiva");
        }
        if (!Movimiento.validarConcepto(concepto)){ // Validamos el concepto
            throw new IllegalArgumentException("El concepto no debe permanecer vacío y debe poseer un máximo de 50 caracteres.");
        }
        boolean movimientoRealizado = false;
        // Comprobamos que no exceda el límite sumando el gasto actual + los gastos anteriores y que exista espacio para guardar movimientos
        if (gastado()+cantidad <= limite && posicionSiguienteMovimiento != movimientos.length){
            this.movimientos[posicionSiguienteMovimiento++] = new Movimiento(cantidad,concepto); // Añadimos el movimiento e incrementamos el contador
            totalGastado += cantidad; // Sumamos el pago
            movimientoRealizado = true;
        }
       return movimientoRealizado;
    }

    /**
     * Calcula el total gastado en la tarjeta.
     * Basándose en los movimientos realizados
     * @return El total gastado en la tarjeta.
     */
    public double gastado(){
        return totalGastado;
    }

    /**
     * Este método devuelve una cadena que contiene los últimos movimientos realizados en la tarjeta.
     * @param numero Este parámetro especifica cuántos movimientos se deben mostrar. Debe ser un valor entero mayor a cero y menor o igual a número de movimientos.
     * @return Devuelve una cadena con los últimos movimientos realizados en la tarjeta.
     * @throws IllegalArgumentException Lanza la Excepción si el valor del parámetro número es menor o igual a cero o mayor al número de movimientos realizados.
     */

    public String movimientos(int numero){
        // Validamos que el número no sea negativo y que poseemos tantos movimientos como el número insertado
        if (numero <= 0 || numero > posicionSiguienteMovimiento){
            throw new IllegalArgumentException("Valor fuera del rango");
        }
        int posicionInicio = posicionSiguienteMovimiento - numero; // Calculamos la posición para recorrer el array
        StringBuilder movimientosString = new StringBuilder();
        // Si existen los añadimos al StringBuilder
        for (int i = posicionInicio; i < posicionSiguienteMovimiento; i++) {
            movimientosString.append(this.movimientos[i]).append("-------------------").append("\n");
        }
        return movimientosString.toString();
    }

    /**
     * Este Método devuelve el total de movimientos realizados
     * @return Los movimientos realizados
     */
    public int numeroMovimientos(){
        return posicionSiguienteMovimiento;
    }

    private static boolean validarExpresion(String entrada, String patron){
        Pattern pattern = Pattern.compile(patron);
        Matcher matcher = pattern.matcher(entrada);
        return matcher.matches();
    }

    /**
     * Método para validar el nombre del titular de la tarjeta.
     * Comprueba que el nombre tenga al menos 15 caracteres y un máximo de 80 y que este compuesto
     * exclusivamente de caracteres alfabéticos.
     * @param titular Nombre del titular de la tarjeta
     * @return true si el nombre es válido, false en caso contrario
     */
    public static boolean validarTitular(String titular){
        return validarExpresion(titular,TITULAR_PATTERN);
    }

    /**
     * Método para validar el pin de la tarjeta.
     * Comprueba que el pin tenga al menos 4 cifras.
     * @param pin Pin de la tarjeta
     * @return true si el pin es válido, false en caso contrario
     */
    public static boolean validarPin(String pin){
        return validarExpresion(pin,PIN_PATTERN);
    }

    /**
     * Método para validar el límite de la tarjeta
     * Comprueba si el límite se encuentra entre 500 - 5000
     * @param limite Límite de la tarjeta
     * @return True si el límite es válido y false en caso contrario
     */
    public static boolean validarLimite(int limite){
        return limite >= MIN_LIMIT && limite <= MAX_LIMIT;
    }

    /**
     * Método para validar el número de dígitos de la tarjeta
     * Comprueba que la tarjeta tenga solo número de 0 a 9 y una longitud de 16 dígitos
     * @param numero Número de la tarjeta
     * @return True si el número es válido y false en caso contrario
     */
    public static boolean validarDigitosTarjeta(String numero){
        return validarExpresion(numero,CARD_PATTERN);
    }


    /**
     * Método para validar el número de la tarjeta.
     * Comprueba que el número tenga 16 dígitos y si es válido obteniendo el dígito de control y comparándolo con el último dígito de la tarjeta.
     * Se realiza a través del algoritmo de Luhn.
     * @param numero Número de la tarjeta
     * @return true si el número es válido, false en caso contrario
     */
    public static boolean comprobarNumeroTarjeta(String numero){
        // Validamos que el número tenga 16 dígitos numéricos
        if (!validarDigitosTarjeta(numero)) // Valida el formato de la tarjeta
            return false;
        // Obtenemos el dígito de control
        String digitoControl = obtenerDigitoControl(numero); // Obtenemos el dígito de control
        // Comparamos si el dígito de control de la función es igual al dígito de control de la tarjeta
        return digitoControl.charAt(0) == numero.charAt(numero.length()-1); // Comparamos si son iguales
    }

    /**
     * Método para obtener el dígito de control de la tarjeta
     * Se le pasa la tarjeta con el último dígito sustituido por un 0.
     * Valida que el número de la Tarjeta tenga 16 dígitos si no lanzará una Excepción
     * @param numero Número de la tarjeta
     * @return Devuelve el Dígito de Control de la tarjeta introducida
     * @throws IllegalArgumentException Lanzará la Excepción si el número de la Tarjeta no posea 16 dígitos
     */
    public static String obtenerDigitoControl(String numero){
        // Validamos que tenga 16 dígitos y que el último dígito sea un 0
        if (!validarDigitosTarjeta(numero)){
            throw new IllegalArgumentException("El número debe contener 16 dígitos");
        }
        // Creamos un String reemplazando el último dígito por 0
        String numeroSinUltimoDigito = numero.substring(0,numero.length()-1) + "0";
        // Realizamos el algoritmo, recorremos el número al reves y los pares los multiplicamos por 2
        int suma = 0;
        int digitoDeControl;
        boolean esPar= false; // Variable para detectar cuál es par
        for (int i = numeroSinUltimoDigito.length() - 1; i >= 0; i--) {
            int digit = Integer.parseInt(numeroSinUltimoDigito.substring(i, i + 1)); // Obtenemos el dígito
            if (esPar) { // Comprobamos si se encuentra en la posición par
                digit = digit * 2;
            }
            // Si poseen dos dígitos le restamos nueve y lo sumamos, los impares lo sumamos directamente
            if (digit > 9) {
                digit = digit - 9;
            }
            suma += digit; // Sumamos
            esPar = !esPar; // Invertimos
        }
        //Por último comparamos si la suma mod 10 es 0 el resultado es 0 sino es 10 - (suma % 10)
        digitoDeControl = suma % 10 == 0 ? 0 : 10-(suma % 10);
        return String.valueOf(digitoDeControl);
    }

    /**
     * Método para validar si es NIF, NIE o CIF
     * Se le pasa un NIF, NIE o CIF y comprueba si es válido sintácticamente y si es válido realizando los algoritmos necesarios
     * @param nif El NIF, NIE o CIF
     * @return True si es válido y false en el caso contrario
     */
    public static boolean validarNIF_NIE_CIF(String nif){
        return validarNIFCalc(nif) || validarNIECalc(nif) || validarCIFCalc(nif);
    }

    /**
     * Método para validar un NIF
     * Comprueba el formato/sintaxis y valida el Dígito de Control (Letra)
     * @param nif El NIF introducido
     * @return True si es válido u false en caso contrario
     */
    public static boolean validarNIFCalc(String nif){
        if (!validarExpresion(nif,NIF_PATTERN)) // Comprobamos que sea válido el formato
           return false;
        nif = nif.toUpperCase(); // Lo pasamos a mayúsculas
        int numeros = Integer.parseInt(nif.substring(0,8)); // Obtenemos todos los dígitos menos la letra
        char letra = LETRAS_NIF[numeros % 23]; // Calculamos la letra
        return letra == nif.charAt(8); // Comprobamos que sean iguales
    }

    /**
     * Método para validar un NIE
     * Comprueba el formato/sintaxis y valida el Dígito de Control (Letra)
     * @param nie El NIE introducido
     * @return True si es válido y false en caso contrario
     */
    public static boolean validarNIECalc(String nie){
        if (!validarExpresion(nie,NIE_PATTERN)) // Comprobamos que sea válido el formato
            return false;
        nie = nie.toUpperCase(); // Lo pasamos a mayúsculas
        String numeros =nie.substring(1,8); // Obtenemos los dígitos
        switch (nie.charAt(0)){ // Sustituimos la letra en caso de ser Y o Z ya que X vale 0
            case 'Y' -> numeros = "1" + numeros;
            case 'Z' -> numeros = "2" + numeros;
        }
        char letra = LETRAS_NIF[Integer.parseInt(numeros) % 23]; // Obtenemos la letra
        return letra == nie.charAt(8); // Comparamos que sean iguales la letra del NIE con la calcualda
    }

    /**
     * Método para validar un CIF
     * Comprueba el formato/sintaxis y valida el Dígito de Control
     * @param cif El CIF introducido a validar
     * @return True si el CIF es válido y false en caso contrario
     */
    public static boolean validarCIFCalc(String cif){
        if (!validarExpresion(cif,CIF_PATTERN))
            return false;
        char[] tabla = {'J','A','B','C','D','E','F','G','H','I'};//en realidad la "J" debe estar en la última posición pero como
        boolean esValido = false;
        int digitoControl;
        cif = cif.toUpperCase();
        int suma = 0;
        boolean esImpar = true; // Variable para detectar cuál es impar
        for (int i = 1; i < 8; i++) {
            int digito = Integer.parseInt(cif.substring(i,i+1)); // Obtenemos el dígito
            if (esImpar) { // Comprobamos si se encuentra en la posición par
                digito = digito * 2;
            }
            // Si poseen dos dígitos le restamos nueve y lo sumamos, los impares lo sumamos directamente
            if (digito > 9) {
                digito -= 9;
            }
            suma += digito; // Sumamos
            esImpar = !esImpar; // Invertimos
        }
        if (suma != 0){
            digitoControl = suma % 10;//calculamos el dígito de control que es el módulo de la suma de los productos
            digitoControl = 10 - digitoControl;//complemento a 10 del digito de control
            if (digitoControl==10){//si el digito de control es 10 se le asigna el 0
                digitoControl = 0;
            }
            if(Character.isLetter(cif.charAt(8)) && tabla[digitoControl]==cif.charAt(8)) {//si es un caracter el último dígito se compara con la tabla que debe ocupar la posicion del dc
                esValido = true;
            } else{
                if (Character.isDigit((cif.charAt(8)))){
                    if (digitoControl==Integer.parseInt(cif.substring(8,9))){
                        esValido = true;

                    }
                }
            }
        }
        return esValido;
    }

    // Crear CVV aleatoriamente
    private String crearCVV(){
        String cvv ="";
        for (int i = 0; i < 3; i++) {
            cvv += ((int) (Math.random() * 10));
        }
        return cvv;
    }

    /**
     * Devuelve una representación en formato de cadena del objeto TarjetaCredito.
     * Incluye los valores de los atributos "titula", "NIF", "límite" y "Cantidad Gastada" con un formato específico.
     * @return Devuelve un String que representa la TarjetaCredito.
     */
    @Override
    public String toString() {
        return "Titular: "+this.titular+"\n" +
                "NIF: "+this.nif+"\n" +
                "Caducidad: "+this.mesCaducidad+"/"+this.añoCaducidad+"\n"+
                "Número: "+this.numeroTarjeta+"\n"+
                "Límite de Saldo: "+this.limite+"\n" +
                "Cantidad Gastada: "+this.gastado();
    }


    /**
     * Compara si dos objetos TarjetaCredito son idénticos en cuanto a sus valores de atributos.
     * Se considera que dos objetos son iguales si el número de la tarjeta es igual.
     * @param obj El objeto TarjetaCredito con el cual se comparará el objeto actual.
     * @return True si los objetos son iguales, false en caso contrario.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        TarjetaCredito tarjetaCreditoAComparar = (TarjetaCredito)  obj;
        return this.numeroTarjeta.equals(tarjetaCreditoAComparar.numeroTarjeta);
    }
}
