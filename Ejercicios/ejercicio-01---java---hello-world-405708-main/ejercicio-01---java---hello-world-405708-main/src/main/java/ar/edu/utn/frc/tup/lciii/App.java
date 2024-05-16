package ar.edu.utn.frc.tup.lciii;

/**
 * Hello Java!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        //Mostrar en la pantalla
        System.out.println("Hello World");
        System.out.println("Hello Java");

        //Le paso valores y me devuelve el int + un bool diciendo si es true o false
        int numero = 123;
        boolean flag = true;
        System.out.println("Numero " + numero +" "+ flag);

        //Creo un string y realizo una validacion para saber si ese string posee una parte especificada
        String cadena = "Hola";
        if(cadena.contains("ol"))
        {
            System.out.println("Existe");
        }
        else{
            System.out.println("No Existe");
        }

        //Compara sin importar Mayus
        //String cadena2 = "Hola";
        //String x = "ho";
        //x.equalsIgnoreCase(cadena2);

        //Concatenacion
        String cadena3 = "Hola ";
        String x = "Java";

        String nuevo = cadena3.concat(x);
        System.out.println((nuevo+ nuevo.length()+ " "+ nuevo.charAt(3)));

        //Ciclo While
        int n = 0;
        while(n < 5){
            System.out.println("Numero" + n);
            n++;
        }

        //Do While
        int m = 0;
        do {
            System.out.println("Numero" + m);
            m++;
        }
        while(m < 5);

        //Ciclo Foreach
        for (int i = 0; i < 6; i++) {
            System.out.println(i);
        }

        //Ciclo For
        for(String s : nuevo){
            //para trabajar con List
        }
    }
}






















