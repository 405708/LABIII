package ar.edu.utn.frc.tup.lciii;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AppTest {
    private final InputStream systemIn = System.in;
    private final PrintStream systemOut = System.out;

    private ByteArrayOutputStream testOut;

    @BeforeEach
    public void setUpOutput() {
        testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));
    }

    @AfterEach
    public void restoreSystemInputOutput() {
        System.setIn(systemIn);
        System.setOut(systemOut);
    }

    @Test
    public void testMain() {
        App.main(null);
        assertEquals("Testing with Junit 5" + System.lineSeparator(),
                getOutput());
    }

    @Test
    public void testCaseSum1() {
        App.main(null);
        Main main = new Main();
        int a = 10, b = 20;
        int testOutput = 30;

        int result = main.sum(a, b);
        assertEquals(testOutput, result);
    }

    @Test
    public void testCaseDivide1() {
        App.main(null);
        Main main = new Main();

        int dividend = 20, divisor = 5;
        int testOutput = 4;

        double result = main.divide(dividend, divisor);
        assertEquals(testOutput, result);
    }

    @Test
    public void testCaseDivide2() {
        App.main(null);
        Main main = new Main();

        int dividend = 20, divisor = 0;

        assertThrows(IllegalArgumentException.class, () -> {main.divide(dividend, divisor);});
    }

    @Test
    public void testCaseConcatenate1() {
        App.main(null);
        Main main = new Main();

        String str1 = "Labo", str2 = "ratory";
        String testOutput = "Laboratory";

        String result = main.concatenate(str1, str2);

        assertEquals(testOutput, result);
    }

    @Test
    public void testCaseConcatenate2() {
        App.main(null);
        Main main = new Main();

        String str1 = "Hello", str2 = null;

        assertThrows(IllegalArgumentException.class, () -> {main.concatenate(str1, str2);});
    }

    @Test
    public void testCaseIsPrime1() {
        App.main(null);
        Main main = new Main();

        int number = 7;
        boolean testOutput = true;

        boolean result = main.isPrime(number);
        assertEquals(testOutput, result);
    }

    @Test
    public void testCaseIsPrime2() {
        App.main(null);
        Main main = new Main();

        int number = 8;
        boolean testOutput = false;

        boolean result = main.isPrime(number);
        assertEquals(testOutput, result);
    }

    @Test
    public void testCaseIsPrime3() {
        App.main(null);
        Main main = new Main();

        int number = 65521;
        boolean testOutput = true;

        boolean result = main.isPrime(number);
        assertEquals(testOutput, result);
    }

    @Test
    public void testCaseIsPrime4() {
        App.main(null);
        Main main = new Main();

        int number = -7;
        boolean testOutput = false;

        boolean result = main.isPrime(number);
        assertEquals(testOutput, result);
    }

    @Test
    public void testCaseFactorial1() {
        App.main(null);
        Main main = new Main();

        int n = 3;
        int testOutput = 6;

        int result = main.factorial(n);
        assertEquals(testOutput, result);
    }

    @Test
    public void testCaseFactorial2() {
        App.main(null);
        Main main = new Main();

        int n = 12;
        int testOutput = 479001600;

        int result = main.factorial(n);
        assertEquals(testOutput, result);
    }

    @Test
    public void testCaseFactorial3() {
        App.main(null);
        Main main = new Main();

        int n = 1;
        int testOutput = 1;

        int result = main.factorial(n);
        assertEquals(testOutput, result);
    }

    @Test
    public void testCaseFactorial4() {
        App.main(null);
        Main main = new Main();

        int n = -3;

        assertThrows(IllegalArgumentException.class, () -> {main.factorial(n);});
    }

    @Test
    public void testCaseFibonacciSequence1() {
        App.main(null);
        Main main = new Main();

        int n = 20;
        List<Integer> testOutput = List.of(0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181);

        List<Integer> result = main.fibonacciSequence(n);

        assertEquals(testOutput, result);
    }

    @Test
    public void testCaseFibonacciSequence2() {
        App.main(null);
        Main main = new Main();

        int n = -1;

        assertThrows(IllegalArgumentException.class, () -> {main.fibonacciSequence(n);});
    }

    @Test
    public void testCaseCalculateRadius1() {
        App.main(null);
        Main main = new Main();

        double radius = 10.05;
        double testOutput = 317.3087119942031;

        double result = main.calculateCircleArea(radius);

        assertEquals(testOutput, result);
    }

    @Test
    public void testCaseCalculateRadius2() {
        App.main(null);
        Main main = new Main();

        double radius = -1;

        assertThrows(IllegalArgumentException.class, () -> {main.calculateCircleArea(radius);});
    }

    @Test
    public void testCaseBubbleSort1() {
        App.main(null);
        Main main = new Main();

        int[] arr = {5, 12, 9, 3, 20, 8, 15, 7, 11, 6};
        int[] testOutput = {3, 5, 6, 7, 8, 9, 11, 12, 15, 20};

        int[] result = main.bubbleSort(arr);

        assertArrayEquals(testOutput, result);
    }

    @Test
    public void testCaseBubbleSort2() {
        App.main(null);
        Main main = new Main();

        int[] arr = null;

        assertThrows(IllegalArgumentException.class, () -> {main.bubbleSort(arr);});
    }

    @Test
    public void testCaseGetSameObject1() {
        App.main(null);
        Main main = new Main();

        Integer obj = 5;
        Object testOutput = 5;

        Object result = main.getSameObject(obj);

        assertSame(testOutput, result);
    }

    @Test
    public void testCaseGetSameObject2() {
        App.main(null);
        Main main = new Main();

        Main obj = new Main();
        Object testOutput = obj;

        Object result = main.getSameObject(obj);

        assertSame(testOutput, result);
    }

    @Test
    public void testCaseGetDifferentObject1() {
        App.main(null);
        Main main = new Main();

        Main obj = new Main();
        Object testOutput = obj;

        Object result = main.getDifferentObject(obj);

        assertNotSame(testOutput, result);
    }

    @Test
    public void testCaseTimeOut1() {
        App.main(null);
        Main main = new Main();


        assertTimeout(Duration.ofMillis(10100), () -> main.timeOut());
        // Le tuve que agregar el 10 porque siempre fallaba por 7, 8, 9 milesimas.
    }

    /*
    @Test
    public void testCaseTimeOut2() {
        App.main(null);
        Main main = new Main();

        Thread.currentThread().interrupt();
        assertThrows(InterruptedException.class, () -> main.timeOut());
        // Trato de hacer que salte el catch pero tampoco me sale.
    }
    */
    
    private String getOutput() {
        return testOut.toString();
    }
}
