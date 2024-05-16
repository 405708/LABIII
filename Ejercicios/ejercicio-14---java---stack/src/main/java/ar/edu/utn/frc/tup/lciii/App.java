package ar.edu.utn.frc.tup.lciii;

import java.util.Scanner;
import java.util.Stack;

/**
 * Hello Stack!
 *
 */
public class App 
{
    /**
     * This is the main program
     * 
     */

    public static void main( String[] args ) {
        Scanner scan = new Scanner(System.in);

        while(scan.hasNext()) {
            String cadenaInput = scan.next();
            System.out.println(esBalanceado(cadenaInput) ? "true" : "false");
        }

        scan.close();
    }


//                char top = stack.pop();
//                if ((ch == ')' && top != '(') ||
//                        (ch == '}' && top != '{') ||
//                        (ch == ']' && top != '[')) {
//                    return false;
//                }
//            }
//        }
//
//        // If stack is not empty, there are unmatched opening brackets
//        return stack.isEmpty();
//    }


    private static boolean esBalanceado(String cadena){
        Stack<Character> pila = new Stack<>();

        for (int i = 0; i < cadena.length(); i++) {
            char carac = cadena.charAt(i);

            if (carac == '(' || carac == '{' || carac == '[') {
                pila.push(carac);
            } else {
                if (pila.isEmpty()){
                    return false;
                }

                char tope = pila.pop();
                if ((carac == ')' && tope != '(') ||
                        (carac == '}' && tope != '{') ||
                        (carac == ']' && tope != '[')) {
                    return false;
                }
            }
        }

        return pila.isEmpty();

    }
}
