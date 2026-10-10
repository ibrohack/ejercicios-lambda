package ejercicio3;

public class Main {

    public static void main(String[] args) {
        Operacion suma = (a, b) -> a + b;
        Operacion resta = (a, b) -> a - b;
        Operacion multiplicacion = (a, b) -> a * b;

        int x = 10;
        int y = 4;

        System.out.println(x + " + " + y + " = " + suma.calcular(x, y));
        System.out.println(x + " - " + y + " = " + resta.calcular(x, y));
        System.out.println(x + " * " + y + " = " + multiplicacion.calcular(x, y));
    }
}
