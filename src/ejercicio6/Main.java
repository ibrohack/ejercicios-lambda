package ejercicio6;

import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Main {

    public static void main(String[] args) {
        ArrayList<String> nombres = new ArrayList<>();
        nombres.add("Ana");
        nombres.add("Luis");
        nombres.add("Carlos");
        nombres.add("Marta");
        nombres.add("Pedro");
        nombres.add("Eva");
        nombres.add("Alejandro");

        Predicate<String> masDe4Letras = nombre -> nombre.length() > 4;
        Consumer<String> mostrarMayusculas = nombre -> System.out.println(nombre.toUpperCase());

        System.out.println("Con bucle for-each:");
        for (String nombre : nombres) {
            if (masDe4Letras.test(nombre)) {
                mostrarMayusculas.accept(nombre);
            }
        }

        // Equivalente con streams: filter usa el Predicate y forEach el Consumer
        System.out.println("Con streams:");
        nombres.stream()
                .filter(masDe4Letras)
                .forEach(mostrarMayusculas);
    }
}
