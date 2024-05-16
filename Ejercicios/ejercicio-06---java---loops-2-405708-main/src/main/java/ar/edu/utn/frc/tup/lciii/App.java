package ar.edu.utn.frc.tup.lciii;

import java.util.Scanner;

/**
 * Loops & Math 2!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Insertar un numero de querys");
        int t = in.nextInt();
        for(int i=0;i<t;i++)
        {
            System.out.println("Ingresar 3 Numeros, 2 al azar y el tercero con la cantidad de veces");
            int a = in.nextInt();
            int b = in.nextInt();
            int n = in.nextInt();

            int result = a + b * 2^n;
            n = n-1;
            if (n < 1)
            {
                System.out.println(result);
            }
            else return;
            //Completar!!!


        }
        in.close();
    }
}
