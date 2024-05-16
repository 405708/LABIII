package ar.edu.utn.frc.tup.lciii;

import java.util.Scanner;

/**
 * if - else Conditional!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese un Numero: ");
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int resultado = n%2;
        if(resultado == 1 || n >= 6 && n <= 20 && resultado == 0)
        {
            System.out.println("Weird");
        }
        else if(n >= 2 && n <= 5 && resultado == 0)
        {
            System.out.println("Not Weird");
        }

        scanner.close();
    }
}
