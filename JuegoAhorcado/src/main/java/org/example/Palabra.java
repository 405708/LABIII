package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;


public class Palabra {
    List<String> palabras = new ArrayList<>();

    public Palabra(){
        String[] listPalabras= {"perro","chancha","dinosaurio","pelota","jeringa","programacion","laboratorio","computadora","elefante","jirafa"};
        palabras.addAll(Arrays.asList(listPalabras).subList(0, 10));
    }

    public List<String> getPalabras() {
        return palabras;
    }

    public void setPalabras(List<String> palabras) {
        this.palabras = palabras;
    }

    public String BuscarPalabra(){
        int randomNum = ThreadLocalRandom.current().nextInt(0, palabras.size()-1);
        return palabras.get(randomNum);
    }
}
