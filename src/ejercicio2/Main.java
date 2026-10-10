package ejercicio2;

public class Main {

    public static void main(String[] args) {
        // La lambda implementa el único método abstracto de OperacionSuma
        OperacionSuma suma = (a, b, c) -> a + b + c;

        System.out.println("1 + 2 + 3 = " + suma.calcular(1, 2, 3));
        System.out.println("10 + 20 + 30 = " + suma.calcular(10, 20, 30));
    }
}
