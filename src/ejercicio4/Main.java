package ejercicio4;

public class Main {

    /**
     * Aplica la operación recibida a los dos números.
     */
    static int operar(int a, int b, Operacion operacion) {
        return operacion.calcular(a, b);
    }

    public static void main(String[] args) {
        // La lambda se pasa directamente como argumento
        int suma = operar(10, 4, (a, b) -> a + b);
        int multiplicacion = operar(10, 4, (a, b) -> a * b);

        System.out.println("Suma: " + suma);
        System.out.println("Multiplicación: " + multiplicacion);
    }
}
