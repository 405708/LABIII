package ar.edu.utn.frc.tup.lciii;

import java.util.Scanner;

/**
 * Stdin & Stdout 2!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Ingrese un Numero: ");
        int i = scan.nextInt();
        System.out.println("Ingrese un Double: ");
        double d = scan.nextDouble();
        System.out.println("Ingrese un Texto: ");
        String s = scan.next();

        System.out.println("String: " +s);
        System.out.println("Double: " +d);
        System.out.println("Int: " +i);

    }
}
