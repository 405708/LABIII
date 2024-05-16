package ar.edu.utn.frc.tup.lciii;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Hello Map!
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
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. */
        Scanner scan = new Scanner(System.in);
        Map<String, String> contactos = new HashMap<>();

        int n = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < n; i++) {
            String nom = scan.nextLine().trim();
            String tel = scan.nextLine().trim();

            contactos.put(nom, tel);
        }

        while (scan.hasNext()){
            String busqueda = scan.nextLine().trim();
            if (contactos.containsKey(busqueda)){
                System.out.println(busqueda + "=" + contactos.get(busqueda));
            } else {
                System.out.println("Not found");
            }
        }

        scan.close();
    }
}
