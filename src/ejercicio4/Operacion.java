package ejercicio4;

/**
 * Interfaz funcional para una operación entre dos enteros.
 */
@FunctionalInterface
public interface Operacion {
    int calcular(int a, int b);
}
