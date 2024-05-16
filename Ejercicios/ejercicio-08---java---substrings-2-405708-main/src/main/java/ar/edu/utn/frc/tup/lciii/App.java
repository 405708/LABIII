package ar.edu.utn.frc.tup.lciii;

import java.util.Scanner;

/**
 * Hello Substrings 2!
 *
 */
public class App 
{

    /**
     * This is the main program, the solution need to be whited
     * in method SubStringHandler.getSmallestAndLargest
     * 
     */
    public static void main( String[] args )
    {
        Scanner sc = new Scanner(System.in);
        System.out.println( "Hello to Strings - Exercise level 2!" );
        do {
            try {
                System.out.println("Ingresar un string, o la palabra -end- para finalizarlo: ");
                String s = sc.next();
                if (s.equals("end")) {
                    break;
                }
                System.out.println("Ingresar la cantidad de substrings a encontrar: ");
                int k = sc.nextInt();
                System.out.println("El resultado es: ");
                System.out.println(SubStringHandler.getSmallestAndLargest(s, k));
            } catch (Exception e) {
                System.out.println("El valor no es correcto, ingrese nuevamente");
                sc.next();
            }
        } while (true);
        System.out.println( "Final del programa" );
    }
}
