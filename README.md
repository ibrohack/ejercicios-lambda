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
