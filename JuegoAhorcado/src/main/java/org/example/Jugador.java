package org.example;

public class Jugador {
    private String nomJugador;
    private int vidasJugador;

    public int getVidasJugador() {
        return vidasJugador;
    }

    public void setVidasJugador(int vidasJugador){
        this.vidasJugador=vidasJugador;
    }

    public String getNomJugador() {
        return nomJugador;
    }

    public void setNomJugador(String nomJugador) {
        this.nomJugador = nomJugador;
    }

    public Jugador(String nombre){
        nomJugador=nombre;
        vidasJugador=5;
    }

    public Jugador(){
        nomJugador="";
        vidasJugador=5;
    }

    public void DescontarVida(){
        vidasJugador--;
    }
}
