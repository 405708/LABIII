package ar.edu.utn.frc.tup.lciii;

import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Map;

public class AnagramsHandler {

    static Boolean isAnagram(String a, String b) {
        // Complete the function
        // IMPORTANT!: Change the return statement in order to return your result.



        //Busque como hacerlo
        if(a.length() != b.length())
        {
            return false;
        }
        //Los pongo en minuscula
        a = a.toLowerCase();
        b = b.toLowerCase();

        //Creo un mapeo para a y b
        Map<Character, Integer> frequencyMapA = new HashMap<>();
        Map<Character, Integer> frequencyMapB = new HashMap<>();

        //Paso -a- a un array y escano el mapa
        for (char c : a.toCharArray())
        {
            frequencyMapA.put(c, frequencyMapA.getOrDefault(c, 0) + 1);
        }
        // hago lo mismo para -b-
        for (char c : b.toCharArray()) {
            frequencyMapB.put(c, frequencyMapB.getOrDefault(c, 0) + 1);
        }
        // Comparo los mapas con las frecuencias, es decir la cantidad de letras de cada una para ver si son iguales
        return frequencyMapA.equals(frequencyMapB);
    }
}
