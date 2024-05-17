package ar.edu.utn.frc.tup.lciii;

import java.util.ArrayList;
import java.util.List;

public class    Main {

    /**
     * Suma dos números enteros.
     *
     * @param a El primer número entero.
     * @param b El segundo número entero.
     * @return La suma de los dos números.
     */
    public int sum(int a, int b) {
        return a + b;
    }

    /**
     * Divide dos números enteros.
     *
     * @param dividend El dividendo.
     * @param divisor  El divisor.
     * @return El resultado de la división.
     * @throws IllegalArgumentException Si el divisor es cero.
     */
    public double divide(int dividend, int divisor) {
        if (divisor == 0) {
            throw new IllegalArgumentException("Cannot divide by zero");
        }
        return (double) dividend / divisor;
    }

    /**
     * Concatena dos cadenas.
     *
     * @param str1 La primera cadena.
     * @param str2 La segunda cadena.
     * @return La concatenación de las dos cadenas.
     * @throws IllegalArgumentException Si alguna de las cadenas es nula.
     */
    public String concatenate(String str1, String str2) {
        if (str1 == null || str2 == null) {
            throw new IllegalArgumentException("Input strings cannot be null");
        }
        return str1 + str2;
    }

    /**
     * Determina si un número entero es primo.
     *
     * @param number El número entero a verificar.
     * @return true si el número es primo, false de lo contrario.
     */
    public boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * Calcula el factorial de un número entero no negativo.
     * @param n El número entero del cual se calculará el factorial.
     * @return El factorial de "n".
     * @throws IllegalArgumentException Si "n" es negativo.
     */
    public int factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Number must be non-negative");
        }
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    /**
     * Genera los primeros "n" números de la secuencia de Fibonacci.
     * @param n El número de elementos en la secuencia.
     * @return Una lista que contiene los primeros "n" números de la secuencia de Fibonacci.
     * @throws IllegalArgumentException Si "n" es negativo.
     */
    public List<Integer> fibonacciSequence(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Number of elements must be non-negative");
        }
        List<Integer> sequence = new ArrayList<>();
        int a = 0, b = 1;
        for (int i = 0; i < n; i++) {
            sequence.add(a);
            int temp = a;
            a = b;
            b = temp + b;
        }
        return sequence;
    }

    /**
     * Calcula el área de un círculo dado su radio.
     * @param radius El radio del círculo.
     * @return El área del círculo.
     * @throws IllegalArgumentException Si el radio es negativo.
     */
    public double calculateCircleArea(double radius) {
        if (radius < 0) {
            throw new IllegalArgumentException("Radius must be non-negative");
        }
        return Math.PI * radius * radius;
    }

    /**
     * Ordena una matriz de enteros utilizando el algoritmo de ordenamiento de burbuja.
     * @param arr La matriz de enteros a ordenar.
     * @return La matriz ordenada.
     * @throws IllegalArgumentException Si la matriz de entrada es nula.
     */
    public int[] bubbleSort(int[] arr) {
        if (arr == null) {
            throw new IllegalArgumentException("Input array cannot be null");
        }
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // swap arr[j+1] and arr[j]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }

    /**
     * Retorna el mismo objeto que se pasa como argumento.
     *
     * @param obj El objeto que se retornará.
     * @return El mismo objeto que se pasó como argumento.
     */
    public Object getSameObject(Object obj) {
        return obj;
    }

    /**
     * Retorna un nuevo objeto cada vez que se llama a este método, ignorando el argumento.
     *
     * @param obj Ignorado en este método.
     * @return Un nuevo objeto en cada invocación.
     */
    public Object getDifferentObject(Object obj) {
        return new Object();
    }

    /**
     * Método que induce un tiempo de espera de 10 segundos.
     * Útil para probar el comportamiento de métodos con restricciones de tiempo.
     */
    public void timeOut() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
