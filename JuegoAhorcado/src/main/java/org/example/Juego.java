package org.example;

import java.util.Arrays;
import java.util.Objects;

public class Juego {
    public Jugador jugadorActual;
    public Palabra palabrasJuego;
    public String palabraActual;
    public String palabraAdivinada;

    public Juego(Jugador jugador){
        jugadorActual = jugador;
        palabrasJuego = new Palabra();
        palabraActual = palabrasJuego.BuscarPalabra();
        palabraAdivinada="";
        for (int i = 0; i < palabraActual.length(); i++) {
            palabraAdivinada = palabraAdivinada + '_';
        }
    }

    public Jugador getJugadorActual() {
        return jugadorActual;
    }

    public void setJugadorActual(Jugador jugadorActual) {
        this.jugadorActual = jugadorActual;
    }

    public String getPalabraActual() {
        return palabraActual;
    }

    public void setPalabraActual(String palabraActual) {
        this.palabraActual = palabraActual;
    }

    public String getPalabraAdivinada() {
        return palabraAdivinada;
    }

    public void setPalabraAdivinada(String palabraAdivinada) {
        this.palabraAdivinada = palabraAdivinada;
    }

    public void ValidarLetra(String charAdivinar){
        char[] charsPalabra = charAdivinar.toCharArray();
        char[] charsAdivinado = palabraAdivinada.toCharArray();
        int adivinado = 0;
        for (int i = 0; i < palabraActual.length(); i++) {
            if((charsPalabra[0] == palabraActual.charAt(i))&&(charsAdivinado[i] == '_')){
                adivinado++;
                charsAdivinado[i]=charsPalabra[0];
            }
        }
        palabraAdivinada= new String(charsAdivinado);
        if (adivinado==0){
            jugadorActual.DescontarVida();
        }
    }

    public boolean MostrarResultado(){
        boolean aux=true;
        if(jugadorActual.getVidasJugador()==0){
            aux=false;
        }
        else if (Objects.equals(palabraAdivinada, palabraActual)) {
            aux = false;
        }
        return aux;
    }
}
