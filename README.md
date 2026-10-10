# Ejercicios de lambdas

Resolución de los ejercicios del documento *Ejercicios de lambdas.docx* (expresiones lambda e
interfaces funcionales en Java).

- El **Ejercicio 1** es teórico y se responde en este README.
- Los **Ejercicios 2 a 6** tienen código, cada uno en su propio paquete dentro de `src/`.

## Estructura

```
ejercicios-lambda/
├── README.md
├── Ejercicios de lambdas.docx
└── src/
    ├── ejercicio2/   OperacionSuma.java, Main.java
    ├── ejercicio3/   Operacion.java, Main.java
    ├── ejercicio4/   Operacion.java, Main.java
    ├── ejercicio5/   Main.java
    └── ejercicio6/   Main.java
```

## Compilar y ejecutar

Requisitos: JDK 8 o superior (probado con JDK 25).

Desde la carpeta raíz del proyecto:

```bash
javac -d bin src/ejercicio*/*.java
java -cp bin ejercicio2.Main
```

Cambia `ejercicio2` por el número del ejercicio que quieras ejecutar. También se puede ejecutar
cada `Main` directamente desde VS Code con la extensión de Java.

---

## Ejercicio 1

### ¿Existen lambdas en otros lenguajes?

Sí. Las expresiones lambda (funciones anónimas) vienen del **cálculo lambda** de Alonzo Church
(años 30) y existen en la mayoría de lenguajes modernos. Java las incorporó en la versión 8 (2014).
Algunos ejemplos de una función que duplica un número:

| Lenguaje                | Sintaxis                      |
|-------------------------|-------------------------------|
| Java                    | `x -> x * 2`                  |
| Python                  | `lambda x: x * 2`             |
| JavaScript / TypeScript | `x => x * 2` (*arrow function*) |
| C#                      | `x => x * 2`                  |
| C++ (desde C++11)       | `[](int x) { return x * 2; }` |
| Kotlin                  | `{ x: Int -> x * 2 }`         |
| Scala                   | `(x: Int) => x * 2`           |
| Haskell                 | `\x -> x * 2`                 |
| Lisp / Scheme           | `(lambda (x) (* x 2))`        |

### Para usar lambdas, ¿podemos usar interfaces funcionales que hayamos creado nosotros?

Sí. En Java una lambda siempre se asigna a una **interfaz funcional**, que es cualquier interfaz con
**un único método abstracto** (SAM, *Single Abstract Method*). Da igual que sea del JDK
(`Predicate`, `Consumer`, `Function`, `Runnable`...) o creada por nosotros.

- La anotación `@FunctionalInterface` es **opcional**, pero se recomienda: el compilador da error si
  la interfaz no tiene exactamente un método abstracto.
- La interfaz puede tener además métodos `default` y `static`, porque no son abstractos.
- La lambda tiene que coincidir con la firma del método abstracto (número y tipo de parámetros y
  tipo de retorno).

```java
@FunctionalInterface
interface Operacion {
    int calcular(int a, int b);
}

Operacion suma = (a, b) -> a + b;
System.out.println(suma.calcular(10, 4)); // 14
```

Los ejercicios 2, 3 y 4 usan interfaces funcionales propias (`OperacionSuma` y `Operacion`).

---

## Ejercicio 2

> Crea una interfaz funcional para obtener la suma de tres números y pon un ejemplo de uso de la
> lambda correspondiente.

Código: [src/ejercicio2/](src/ejercicio2/)

**Nota:** el enunciado pide sumar **tres** números, pero el ejemplo del documento declara
`int calcular(int a, int b)` con solo dos parámetros. Se ha seguido el texto del enunciado, así que
el método recibe tres parámetros:

```java
@FunctionalInterface
public interface OperacionSuma {
    int calcular(int a, int b, int c);
}

OperacionSuma suma = (a, b, c) -> a + b + c;
```

Salida:

```
1 + 2 + 3 = 6
10 + 20 + 30 = 60
```

---

## Ejercicio 3

> Utilizando la interfaz `Operacion`, crea tres lambdas: suma, resta y multiplicación. Prueba las
> tres con 10 y 4.

Código: [src/ejercicio3/](src/ejercicio3/)

El documento no define la interfaz `Operacion`, así que se declara con la misma firma que el ejemplo
del ejercicio 2, `int calcular(int a, int b)`:

```java
Operacion suma = (a, b) -> a + b;
Operacion resta = (a, b) -> a - b;
Operacion multiplicacion = (a, b) -> a * b;
```

Salida:

```
10 + 4 = 14
10 - 4 = 6
10 * 4 = 40
```

---

## Ejercicio 4

> Crea el método `static int operar(int a, int b, Operacion operacion)`, que debe utilizar la
> operación recibida para calcular el resultado. Después úsalo para realizar una suma y una
> multiplicación.

Código: [src/ejercicio4/](src/ejercicio4/)

El método no sabe qué operación hace: solo llama a `calcular`. La lambda que se le pasa decide el
comportamiento.

```java
static int operar(int a, int b, Operacion operacion) {
    return operacion.calcular(a, b);
}

int suma = operar(10, 4, (a, b) -> a + b);
int multiplicacion = operar(10, 4, (a, b) -> a * b);
```

Salida:

```
Suma: 14
Multiplicación: 40
```

---

## Ejercicio 5

> Crea un `Predicate` que determine si un número es mayor que 100.

Código: [src/ejercicio5/](src/ejercicio5/)

`Predicate<T>` es una interfaz funcional del JDK (`java.util.function`) cuyo método `test(T)`
devuelve un `boolean`.

```java
Predicate<Integer> mayorQue100 = n -> n > 100;
```

Se prueba con varios valores, incluido el caso límite `100`, que no es mayor que 100:

```
50 > 100: false
100 > 100: false
101 > 100: true
250 > 100: true
```
