package ejercicio2;

/**
 * Interfaz funcional para sumar tres números.
 */
@FunctionalInterface
public interface OperacionSuma {
    int calcular(int a, int b, int c);
}
