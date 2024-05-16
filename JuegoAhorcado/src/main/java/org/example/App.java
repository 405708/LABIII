package org.example;

import java.util.Objects;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bienvenido al ahorcado!, ingrese su nombre:");
        Jugador jugadorPartida = new Jugador(scanner.nextLine());
        Juego juego = new Juego(jugadorPartida);
        while (juego.MostrarResultado()) {
            System.out.println("La palabra es:" + juego.getPalabraAdivinada());
            System.out.println("Ingrese la letra para adivinar la palabra:");
            String inputJugador = scanner.nextLine();
            juego.ValidarLetra(inputJugador);
        }
        System.out.println("La partida termino!");
        System.out.println("Ud. pudo adivinar " + juego.palabraAdivinada);
        System.out.println("La palabra era:" + juego.palabraActual);
        if (Objects.equals(juego.palabraAdivinada, juego.palabraActual)) {
            System.out.println("Felicitaciones "+juego.getJugadorActual().getNomJugador());
        } else {
            System.out.println("Intentalo nuevamente "+juego.getJugadorActual().getNomJugador());
        }
    }
}
