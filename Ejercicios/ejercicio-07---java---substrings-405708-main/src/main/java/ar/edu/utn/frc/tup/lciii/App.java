package ar.edu.utn.frc.tup.lciii;

import java.util.Scanner;

/**
 * Sub-Strings!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Ingresar un string: ");
        String s = in.next();
        System.out.println("Indique Start: ");
        int start = in.nextInt();
        System.out.println("Indique End: ");
        int end = in.nextInt();

        String r = s.substring(start, end);

        System.out.println(r);

    }
}
