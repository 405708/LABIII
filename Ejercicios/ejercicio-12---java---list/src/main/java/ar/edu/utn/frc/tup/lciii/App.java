package ar.edu.utn.frc.tup.lciii;

import javax.script.ScriptContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Hello List!
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

        String result;

        //cant elementos del array
        int n = scan.nextInt();

        //array de n elementos
        List<Integer> l = new ArrayList<>(n);

        //se llena el array
        for (int i = 0; i < n; i++){
            l.add(scan.nextInt());
        }

        //cant queries
        int q = scan.nextInt();
        scan.nextLine();

        //se procesa cada query
        for (int i = 0; i < q; i++){
            //lee si la query es Insert o Delete
            String tipoQuery = scan.nextLine();

            if (tipoQuery.equals("Insert")){
                String[] partes = scan.nextLine().split(" ");
                int indice = Integer.parseInt(partes[0]);
                int valor = Integer.parseInt(partes[1]);
                l.add(indice, valor);
            } else if (tipoQuery.equals("Delete")){
                int indice = Integer.parseInt(scan.nextLine());
                l.remove(indice);
            }

        }

        for (int i = 0; i < l.size(); i++){
            System.out.print(l.get(i));
            if (i < l.size() - 1){
                System.out.print(" ");
            }
        }

        System.out.print("\r\n");

        scan.close();
    }
}
