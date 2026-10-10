package ejercicio5;

import java.util.function.Predicate;

public class Main {

    public static void main(String[] args) {
        Predicate<Integer> mayorQue100 = n -> n > 100;

        int[] numeros = {50, 100, 101, 250};

        for (int n : numeros) {
            System.out.println(n + " > 100: " + mayorQue100.test(n));
        }
    }
}
