package ar.edu.utn.frc.tup.lciii;

import java.util.Locale;
import java.util.Scanner;

/**
 * Hello Strings 3!
 *
 */
public class App 
{

    /**
     * This is the main program
     * 
     */
    public static void main( String[] args )
    {
        Scanner sc=new Scanner(System.in);
        //System.out.println("Ingrese la 1er String: ");
        String a =sc.next();
        //System.out.println("Ingrese la 2da String: ");
        String b =sc.next();

        //largo total de las strings
        int largo = a.length() + b.length();

        //cual es mayor lexicograficamente
        String esLexi = a.compareTo(b) > 0 ? "Yes" : "No";

        //1er letra mayuscula de ambas strings
        String aMayus = a.substring(0, 1).toUpperCase() + a.substring(1,a.length());
        String bMayus = b.substring(0, 1).toUpperCase() + b.substring(1, b.length());
        String concat = aMayus + " " + bMayus;

        System.out.println(largo);
        System.out.println(esLexi);
        System.out.println(concat);

        sc.close();
    }
}
