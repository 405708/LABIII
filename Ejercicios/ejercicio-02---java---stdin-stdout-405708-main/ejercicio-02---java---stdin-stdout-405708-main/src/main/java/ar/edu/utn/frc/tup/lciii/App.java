package ar.edu.utn.frc.tup.lciii;

import java.util.Scanner;

/**
 * Stdin & Stdout!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Ingrese un Nombre: ");
        String b = scan.next();
        System.out.println("Ingrese un Numero: ");
        int a = scan.nextInt();
        scan.close();

        System.out.println(("Mi String es: "+ b));
        System.out.println("Mi Int es: " + a);

    }
}
