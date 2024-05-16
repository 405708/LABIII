package ar.edu.utn.frc.tup.lciii;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Esta clase mantiene el estado de un juego.
 *
 * Un juego es una partida de las muchas que puede jugar el Player
 * en una misma corrida del programa.
 *
 */
public class BattleShipGame {

    /**
     * Expresion regular para validar entradas de posiciones
     */
    private static final String POSITION_INPUT_REGEX = "[0-9]{1} [0-9]{1}";

    /**
     * Numero de barcos requeridos para jugar
     */
    private static final Integer FLEET_SIZE = 20;

    /**
     * Scanner para capturar las entradas del usuario
     */
    private Scanner scanner = new Scanner(System.in);

    /**
     * Jugador asignado al usuario
     */
    private Player player;

    /**
     * Jugador asignado a la app
     */
    private Player appPlayer;

    /**
     * Tablero de la flota del jugador
     */
    private Board playerFleetBoard;

    /**
     * Tablero de marcación de la flota enemiga del jugador
     */
    private Board playerEnemyFleetBoard;

    /**
     * Tablero de la flota de la app
     */
    private Board appFleetBoard;

    /**
     * Tablero de marcación de la flota enemiga de la app
     */
    private Board appEnemyFleetBoard;

    /**
     * Lista de los disparos efectuados por el jugador
     */
    private List<Position> playerShots;

    /**
     * Lista de los disparos efectuados por la app
     */
    private List<Position> appShots;

    /**
     * Lista de los barcos del jugador
     */
    private List<Ship> playerShips;

    /**
     * Lista de los barcos de la app
     */
    private List<Ship> appShips;

    /**
     * Jugador que gano el juego
     */
    private Player winner;
    // TOD-O: more attributes if necessary

    private int playerMatchScore;
    private int appPlayerMatchScore;


    // TOD-O: getters & setters...
    public Scanner getScanner() {
        return scanner;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Player getAppPlayer() {
        return appPlayer;
    }

    public void setAppPlayer(Player appPlayer) {
        this.appPlayer = appPlayer;
    }

    public Board getPlayerFleetBoard() {
        return playerFleetBoard;
    }

    public void setPlayerFleetBoard(Board playerFleetBoard) {
        this.playerFleetBoard = playerFleetBoard;
    }

    public Board getPlayerEnemyFleetBoard() {
        return playerEnemyFleetBoard;
    }

    public void setPlayerEnemyFleetBoard(Board playerEnemyFleetBoard) {
        this.playerEnemyFleetBoard = playerEnemyFleetBoard;
    }

    public Board getAppFleetBoard() {
        return appFleetBoard;
    }

    public void setAppFleetBoard(Board appFleetBoard) {
        this.appFleetBoard = appFleetBoard;
    }

    public Board getAppEnemyFleetBoard() {
        return appEnemyFleetBoard;
    }

    public void setAppEnemyFleetBoard(Board appEnemyFleetBoard) {
        this.appEnemyFleetBoard = appEnemyFleetBoard;
    }

    public List<Position> getPlayerShots() {
        return playerShots;
    }

    public void setPlayerShots(List<Position> playerShots) {
        this.playerShots = playerShots;
    }

    public List<Position> getAppShots() {
        return appShots;
    }

    public void setAppShots(List<Position> appShots) {
        this.appShots = appShots;
    }

    public List<Ship> getPlayerShips() {
        return playerShips;
    }

    public void setPlayerShips(List<Ship> playerShips) {
        this.playerShips = playerShips;
    }

    public List<Ship> getAppShips() {
        return appShips;
    }

    public void setAppShips(List<Ship> appShips) {
        this.appShips = appShips;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }
    // TOD-O: constructors if necessary...

    public BattleShipGame(Player player, Player appPlayer) {
        this.player = player;
        this.appPlayer = appPlayer;
        this.playerFleetBoard = new Board();
        this.playerEnemyFleetBoard = new Board();
        this.appFleetBoard = new Board();
        this.appEnemyFleetBoard = new Board();
        this.playerShots = new ArrayList<>();
        this.appShots = new ArrayList<>();
        this.playerShips = new ArrayList<>();
        this.appShips = new ArrayList<>();
        this.winner = null;
        this.playerFleetBoard.initBoardFleet();
        this.playerEnemyFleetBoard.initBoardEnemyFleet();
        this.appFleetBoard.initBoardFleet();
        this.appEnemyFleetBoard.initBoardEnemyFleet();
        this.playerMatchScore = 0;
        this.appPlayerMatchScore = 0;
    }

    public BattleShipGame() {
    }

    /**
     * Este meto-do genera una lista de posiciones aleatoria para
     * la flota de barcos con la que jugará la App.
     *
     * Este meto-do valida que las posiciones de la cada barco de la flota es unica
     * y que se encuentra dentro de los margenes del tablero.
     *
     * Por cada barco de la flota debe agregarlo en la lista "appShips"
     *
     * @see #getPlayerFleetPositions()
     * @see #generateAppShot()
     * @see #getRandomPosition()
     *
     */
    public void generateAppFleetPositions() {
        do {
            Position position = this.getRandomPosition();
            if(isAvailablePosition(appShips, position)) {
                this.appShips.add(new Ship(position, ShipStatus.AFLOAT));
            }
        } while (this.appShips.size() < FLEET_SIZE);
        appFleetBoard.setShipPositions(playerShips);
    }

    /**
     * Este meto-do gestiona el pedido de posiciones de cada barco al jugador,
     * y los agrega en la lista "playerShips".
     *
     * Se le pide al usuario por pantalla cada par de coordenadas como
     * dos Enteros separados por un espacio en blanco. Por cada coordenada que el usuario ingresa,
     * debe validarse que este dentro de los margenes del tablero y que NO haya colocado ya
     * otro barco en dicha posicion.
     *
     * Cuando el usuario ha colocado to-dos los barcos (20 en total),
     * el meto-do los posiciona en el tablero del usuario.
     *
     * @see #generateAppFleetPositions()
     * @see #getPlayerShot()
     *
     */
    public void getPlayerFleetPositions() {
        // TOD-O: Hacer un bucle para pedir las posiciones hasta alcanzar el limite
        // TOD-O: Mostrar un mensaje por pantalla pidiendo posicionar el barco.
        // TOD-O: Usar el metodo this.getPosition() para pedir la posicion.
        // TOD-O: Validar si la posicion esta disponible en la lista de barcos.
        // TOD-O: Mostrar un mensaje de error comentando que ya establecio esa posicion.
        // TOD-O: Si esta disponible, crear el barco y agregarlo a la lista de barcos.
        // TOD-O: Al finalizar el bucle, setear en el board las posiciones de los barcos.
        Integer pos = 1;
        do {
            System.out.println("Posicione Su Barco");
            Position position =  this.getPosition();
            if(isAvailablePosition(playerShips, position))
            {
                Ship ship = new Ship(position, ShipStatus.AFLOAT);
                playerShips.add(ship);
            }
            else System.out.println("Posicion Ya Establecida, Elija Otra");
            pos++;
        }
        while (pos <= FLEET_SIZE);

        playerFleetBoard.setShipPositions(playerShips);


    }

    /**
     * Este meto-do gestiona la acción de disparar por parte del usuario.
     * Cuando el usuario estableció el disparo, debe agregarlo a la lista de
     * disparos realizados "playerShots" y cargarlo en su board de la flota enemiga "playerEnemyFleetBoard"
     * según haya derribado un barco o encontrado agua.
     *
     * Si el disparo alcanza un barco enemigo, se debe cambiar el barco de dicha posicion a ShipStatus.SUNKEN
     * mediante el meto-do de Ship "sinkShip()"
     *
     * Se le pide al usuario por pantalla cada par de coordenadas como
     * dos Enteros separados por un espacio en blanco. Por cada coordenada que el usuario ingresa,
     * debe validarse que este dentro de los margenes del tablero.
     *
     * @see #getPlayerFleetPositions()
     *
     */
    public void getPlayerShot() {
        Position position = null;
        do {
            System.out.println("Donde quiere disparar?");
            position = this.getPosition();
            if(isAvailableShot(playerShots, position)) {
                this.playerShots.add(position);
                if(this.impactEnemyShip(appShips, position)) {
                    System.out.println("Barco Hundido");
                    playerEnemyFleetBoard.setShipOnBoard(position);
                } else {
                    playerEnemyFleetBoard.setWaterOnBoard(position);
                }
            } else {
                System.out.println("Ya disparó a esa posición.!" +
                        System.lineSeparator() + "Elija otra posicion...");
            }
        } while (position == null);
        // TOD-O: Preguntar si la posicion del disparo impacto un barco enemigo.
        // TOD-O: Setear segun hubo un impacto o no, agua o un barco, en el tablero de marcacion de la flota enemiga

    }

    /**
     * Este meto-do genera de manera aleatoria un disparo por parte de la app.
     * El meto-do genera dos enteros entre 0 y 9 para definir las coordenadas
     * donde efectuará el disparo.
     *
     * El meto-do valida que el disparo no se haya hecho antes de cargarlo en
     * la lista de disparos de la app.
     *
     * Cuando la app estableció el disparo, debe agregarlo a la lista de
     * disparos realizados "appShots" y cargarlo en su board de la flota enemiga "appEnemyFleetBoard"
     * según haya derribado un barco o encontrado agua.
     *
     * Si el disparo alcanza un barco enemigo, se debe cambiar el barco de dicha posicion a ShipStatus.SUNKEN
     * mediante el meto-do de "ship.sinkShip()"
     *
     * @see #generateAppFleetPositions()
     * @see #getRandomPosition()
     */
    public void generateAppShot() {
        // TOD-O: Generar una posicion random para el disparo de la app usando el metodo getRandomPosition()
        // TOD-O: Validar si aun no se uso esa posicion en la lista de disparos de la app.
        // TOD-O: Si el disparo ya se hizo, volver a generar disparos hasta que salga alguno valido
        // TOD-O: Cuando el disparo no haya sido usado antes, agregarlo a la lista de disparos de la app
        Position randomShot = new Position();
        do {
            randomShot = getRandomPosition();
        }while(!this.isAvailableShot(appShots, randomShot));
        this.appShots.add(randomShot);
        if(this.impactEnemyShip(playerShips, randomShot)) {
            appEnemyFleetBoard.setShipOnBoard(randomShot);
        } else {
            appEnemyFleetBoard.setWaterOnBoard(randomShot);
        }

    }

    /**
     * Este meto-do imprime por pantalla el estado del juego, que incluye
     * cuantos barcos tiene cada jugar a flote y cuantos hundidos
     *
     * @see Player
     * @see #playerShips
     * @see #appShips
     * @see #player
     * @see #appPlayer
     *
     */
    public void printGameStatus() {
        // TOD-O: Imprimir por pantalla el status del juego
        // TOD-O: Incluir barcos flotando y hundidos de cada jugador
        if (winner==null)
        {
            System.out.println("La partida Esta en Juego");
        }
        else System.out.println("La partida Finalizo");

        System.out.println("Estadisticas");
        System.out.println(player.getPlayerName() + " Tiene: ");
        System.out.println(GetPlayerSunkedShips() +  " Barcos Hundidos");
        System.out.println(FLEET_SIZE-(GetPlayerSunkedShips()) +" Barcos Flotando");
        System.out.println("El jugador de la App tiene: ");
        System.out.println(GetAppPlayerSunkedShips() + " Barcos Hundidos");
        System.out.println((FLEET_SIZE-GetAppPlayerSunkedShips())+ " Barcos Flotando");
    }

    /**
     * Este meto-do dibuja los tableros del Player junto al titulo de cada uno.
     *
     * @see Board#drawBoard()
     *
     */
    public void drawPlayerBoards() {
        System.out.println("TU FLOTA" + System.lineSeparator());
        // TOD-O: Dibujar el tablero del usuario
        playerFleetBoard.drawBoard();
        System.out.println("FLOTA ENEMIGA" + System.lineSeparator());
        // TOD-O: Dibujar el tablero de marcacion de la flota enemiga del usurio
        playerEnemyFleetBoard.drawBoard();
    }

    /**
     * Este meto-do muestra un mensaje de finalizacion de la partida,
     * muestra el nombre del ganador, el puntaje obtenido en esta partida
     * y los puntajes acumulados a traves de las partidas jugadas.
     *
     * @see System#out
     */
    public void goodbyeMessage() {
        // TOD-O: Imprimir por pantalla un mensaje de despedida
        System.out.println("Gracias por jugar! A continuacion las estadisticas:");
        System.out.println("El ganador fue " + winner);
        System.out.println("El jugador tiene un score de: " + playerMatchScore);
        System.out.println("Tiene un total de " + player.getGamesWon() + " Victorias");
        System.out.println("El jugador de la app tiene un score de: " + appPlayerMatchScore);
        System.out.println("Tiene un total de " + appPlayer.getGamesWon() + " Victorias");


    }

    /**
     * Este meto-do calcula los puntos obtenidos por cada jugador en esta partida
     * y se los suma a los que ya traia de otras partidas.
     *
     * @see Player
     * @see #playerShips
     * @see #appShips
     * @see #player
     * @see #appPlayer
     *
     */
    public void calculateScores() {
        // TOD-O: Se debe completar este metodo
        // TOD-O: Calcular los puntos obtenidos por cada jugador en este juego
        // TOD-O: Sumar los puntos al score de cada jugardor
        // TOD-O: Sumar la partida ganada al jugador que ganó
        if (winner == appPlayer)
        {
            appPlayer.setGamesWon(appPlayer.getGamesWon()+1);
            appPlayer.setScore(appPlayer.getScore()+20);
            this.appPlayerMatchScore = 20;
            player.setScore(player.getScore()+GetPlayerSunkedShips());
            this.playerMatchScore = GetPlayerSunkedShips();
        }
        else if (winner == player)
        {
            player.setGamesWon(player.getGamesWon()+1);
            player.setScore(player.getScore()+20);
            this.playerMatchScore = 20;
            appPlayer.setScore(appPlayer.getScore()+GetAppPlayerSunkedShips());
            this.appPlayerMatchScore = GetAppPlayerSunkedShips();
        }
        else
        {
            player.setScore(player.getScore()+GetPlayerSunkedShips());
            this.playerMatchScore = GetPlayerSunkedShips();
            appPlayer.setScore(appPlayer.getScore()+GetAppPlayerSunkedShips());
            this.appPlayerMatchScore = GetAppPlayerSunkedShips();
        }

    }

    private Integer GetPlayerSunkedShips() {
        Integer sunkenShips = 0;
        for (Ship playerShip : playerShips)
        {
            if (playerShip.getShipStatus() == ShipStatus.SUNKEN)
            {
                sunkenShips++;
            }
        }
        return sunkenShips;
    }
    private Integer GetAppPlayerSunkedShips() {
        Integer sunkenShips = 0;
        for (Ship appShip : appShips)
        {
            if (appShip.getShipStatus() == ShipStatus.SUNKEN)
            {
                sunkenShips++;
            }
        }
        return sunkenShips;
    }



    /**
     * Este meto-do verifica si hubo un impacto con el disparo,
     * si el disparo impacto, hunde el barco y retorna true.
     * Si el disparo no impacto retorna false
     *
     * @param fleetEnemyShips Lista de barcos de la flota enemiga
     * @param shot
     *
     * @see Position#equals(Object)
     * @see Ship#sinkShip()
     *
     * @return true si el disparo impacta, false si no lo hace.
     */
    private Boolean impactEnemyShip(List<Ship> fleetEnemyShips, Position shot) {
        // TOD-O: Recorrer la lista de Ships pasada por parametro y validar si existe un barco en la posicion pasada por parametro
        // TOD-O: Si existe un barco en esa posicion, hundir el barco el metodo sinkShip()
        // TOD-O: Retornar true si se hundio un barco, o false si no se hizo.
        // TOD-O: Remember to replace the return statement with the correct object
        boolean shipSunken = false;
        for (Ship ship : fleetEnemyShips)
        {
            if (Objects.equals(ship.getPosition(), shot))
            {
                ship.sinkShip();
                shipSunken = true;
            }
        }
        return shipSunken;
    }

    /**
     * Este meto-do define si el juego terminó.
     * El juego termina cuando uno de los dos jugadores (El player o la app)
     * a hundido to-dos los barcos del contrario.
     *
     * Cuando el juego termina, este meto-do setea en el atributo winner quien ganó.
     *
     * @see #validateSunkenFleet(List)
     * @see #winner
     *
     * @return true si el juego terminó, false si aun no hay un ganador
     */
    public Boolean isFinish() {
        // TOD-O: Validar si todos lo barcos de algun jugador fueron undidos
        // TOD-O: Si algun jugador ya perdio todos sus barcos, setear el ganador en winner
        // TOD-O: Retornar true si hubo un ganador, o false si no lo hubo
        // TOD-O: Remember to replace the return statement with the correct object
        boolean contFinish = false;
        if (validateSunkenFleet(playerShips))
        {
            winner = appPlayer;
            contFinish = true;
        }
        else if (validateSunkenFleet(appShips))
        {
            winner = player;
            contFinish = true;
        }

        return contFinish;
    }

    /**
     * Este meto-do valida si aun queda algun barco a flote en la flota,
     * para determinar si toda la flota fue hundida.
     *
     * @param fleet
     *
     * @see Ship#getShipStatus()
     * @see ShipStatus
     *
     * @return true si toda la flota fue hundida, flase si al menos queda un barco a flote.
     */
    private Boolean validateSunkenFleet(List<Ship> fleet) {
        // TOD-O: Recorrer la lista de barcos y validar si todo fueron hundidos
        // TOD-O: Retornar true si todos fueron undidos o false si al menos queda un barco a flote
        // TOD-O: Remember to replace the return statement with the correct object
        int barcosHundidos = 0;
        for (Ship ship : fleet)
        {
            if (ship.getShipStatus() == ShipStatus.SUNKEN)
            {
                barcosHundidos++;
            }
        }
        if (barcosHundidos == FLEET_SIZE)
        {
            return true;
        }
        else return false;
    }

    /**
     * Este meto-do gestiona la acción de pedir coordenads al usuario.
     *
     * Se le pide al usuario por pantalla cada par de coordenadas como
     * dos Enteros separados por un espacio en blanco. Por cada coordenada que el usuario ingresa,
     * debe validarse que este dentro de los margenes del tablero.
     *
     * @see #isValidPositionInput(String)
     * @see Position#Position()
     * @see String#split(String)
     *
     * @return La posicion elegida por el usuario.
     */
    private Position getPosition() {
        Position position = null;
        do {
            System.out.println("Ingrese una coordenada en un formato de dos numeros " +
                    "enteros entre 0 y 9 separados por un espacio en blanco.");

            String input = scanner.nextLine();

            if (isValidPositionInput(input)) {
                //TOD-O: Separar los enteros de input en dos Integers y crear Position
                String separate = Pattern.quote(" ");
                String[] parts = input.split(separate);
                String part1 = parts[0];
                String part2 = parts[1];
                Integer posRow = Integer.parseInt(part1);
                Integer posCol = Integer.parseInt(part2);
                position = new Position(posRow, posCol);

            } else {
                // TOD-O: Mostrar un mensaje de error sobre como ingreso los datos
                System.out.println("Datos mal ingresados");
            }
        } while(position == null);
        return position;
    }

    /**
     * Este meto-do valida que la entrada del usuario como String este en el formato establecido
     * de dos numeros enteros entre 0 y 9 separados por un espacio en blanco.
     *
     * @see BattleShipMatch#getYesNoAnswer(String)
     * @see Pattern#compile(String)
     * @see Pattern#matcher(CharSequence)
     * @see Matcher#matches()
     *
     * @param input La entrada que se capturo del usuario
     * @return true si el formato es valido, false si no lo es
     */
    private Boolean isValidPositionInput(String input) {
        Pattern pattern = Pattern.compile(POSITION_INPUT_REGEX);
        if (pattern.matcher(input).matches()) {
            return true;
        }
        else
        {
            return false;
        }
        // TO-DO: Remember to replace the return statement with the correct object

    }

    /**
     * Este meto-do retorna una posición random que puede ser usada
     * para representar una posicion de un barco o un disparo random de la app.
     *
     * @see Random
     * @see Random#nextInt(int)
     * @see Position
     *
     * @return la posición del disparo random.
     */
    private Position getRandomPosition() {
        // TOD-O: Generar 2 numeros random entre 0 y 9 para establecer la row y column
        int posCol = (int)(Math.random() * 9);
        int posRow = (int)(Math.random() * 9);

        // TOD-O: Crear la Posicion a partir de la row y column
        Position position = new Position(posRow, posCol);
        // TOD-O: Retornar la Position
        // TOD-O: Remember to replace the return statement with the correct object
        return position;
    }

    /**
     * Este meto-do valida que la posición nueva no exista en la lista de posiciones que ya fueron cargadas
     * para eso recibe por parametro la lista donde hará la busqueda y la posicion a buscar.
     *
     * El meto-do otorga un mecanismo de validacion de que un objeto del tipo Position
     * no existe en una lista del tipo List<Position>
     *
     * @see List#contains(Object)
     * @see Position#equals(Object)
     *
     * @param listShots la lista donde se hará la busqueda
     * @param position La nueva posicion a buscar
     * @return true si la posición no existe en la lista, false si ya existe esa posicion.
     */
    private Boolean isAvailableShot(List<Position> listShots, Position position) {
        // TOD-O: Validar que la lista de posiciones NO tenga la posision indicada
        int conteo = 0;
        for (Position pos : listShots)
        {
            if(pos == position)
            {
                conteo++;
            }
        }
        if (conteo > 0)
        {
            return false;
        }
        else return true;
        // TOD-O: Remember to replace the return statement with the correct object
    }

    /**
     * Este meto-do valida que la posición pasada por parametro no exista dentro de las
     * posiciones de los barcos de la lista "listToCheck".
     *
     * @param listToCheck la lista donde se hará la busqueda
     * @param position La nueva posicion a buscar
     *
     * @see List#contains(Object)
     * @see Ship#equals(Object)
     *
     * @return true si la posición no existe en la lista, false si ya existe esa posicion.
     */
    private Boolean isAvailablePosition(List<Ship> listToCheck, Position position) {
        // TOD-O: Validar que la lista de Ship NO tenga un Ship con la posision indicada
        int conteo = 0;
        for(Ship ship : listToCheck)
        {
            if (Objects.equals(ship.getPosition(), position))
            {
                conteo++;
            }
        }
        if (conteo > 0)
        {
            return false;
        }
        else return true;
        // TOD-O: Remember to replace the return statement with the correct object

    }

}
