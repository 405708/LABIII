package ar.edu.utn.frc.tup.lciii;

import java.util.List;

/**
 * Esta clase representa un tablero de la Batall Naval
 *
 * Las diferentes instancias pueden ser el tablero del jugador,
 * el tablero de la app y los tableros de marcación de la flota enemiga
 */
public class Board {

    /**
     * Number of row required to play
     */
    private static final Integer ROWS = 10;

    /**
     * Number of columns required to play
     */
    private static final Integer COLUMNS = 10;

    /**
     * Letter to represent the water object in the board
     */
    private static final String WATER = "\u001B[34mW";

    /**
     * Letter to represent the ship object in the board
     */
    private static final String SHIP = "\u001B[32mS";

    /**
     * Letter to represent a hide cell in the board
     */
    private static final String HIDE = "_";

    /**
     * Board to draw in the screen
     */
    private String[][] board;
    // TOD-O: more attributes if necessary

    public String[][] getBoard() {
        return board;
    }

    public void setBoard(String[][] board) {
        this.board = board;
    }

    // TOD-O: constructors if necessary...
    public Board() {
        this.board = new String[ROWS][COLUMNS];
    }

    /**
     * Este meto-do dibuja el tablero
     *
     * @see StringBuilder
     * @see #ROWS
     * @see #COLUMNS
     * @see #board
     *
     */
    public void drawBoard() {
        StringBuilder sb = new StringBuilder();
        sb.append("    0   1   2   3   4   5   6   7   8   9\n");
        sb.append("  -----------------------------------------\n");
        for(int f = 0; f < ROWS; f++) {
            sb.append(f + " |");
            for(int c = 0; c < COLUMNS; c++) {
                sb.append(" " + this.board[f][c] + "\u001B[0m" + " ");
                sb.append("|");
            }
            sb.append("  " + f + "\n");
            sb.append("  -----------------------------------------\n");
        }
        sb.append("    0   1   2   3   4   5   6   7   8   9\n");
        System.out.println(sb);
    }

    /**
     * Este meto-do posiciona la lista de barcos en el tablero
     *
     * @param ShipList Lista de barcos a posicionar
     *
     * @see Ship#getPosition()
     * @see #SHIP
     */
    public void setShipPositions(List<Ship> ShipList) {
        for(Ship ship : ShipList) {
            this.board[ship.getPosition().getRow()][ship.getPosition().getColumn()] = SHIP;
        }
    }

    /**
     * Este meto-do pone "W" (water/agua) en la posicion del tablero pasada por parametro
     *
     * @param position Posicion donde poner agua
     *
     * @see #WATER
     */
    public void setWaterOnBoard(Position position) {
        // TOD-O: Setear en el board el valor de WATER en la posicion indicada por parametro
        this.board[position.getRow()][position.getColumn()] = WATER;
    }

    /**
     * Este meto-do pone "S" (shgip/barco) en la posicion del tablero pasada por parametro
     *
     * @param position Posicion donde poner un barco
     *
     * @see #SHIP
     */
    public void setShipOnBoard(Position position) {
        this.board[position.getRow()][position.getColumn()] = SHIP;
    }

    /**
     * Este meto-do inicia el tablero para la flota del jugador
     * con agua en todas sus celdas.
     *
     * @see #ROWS
     * @see #COLUMNS
     * @see #WATER
     */
    public void initBoardFleet() {
        // TOD-O: Iniciartodo el board con el valor de WATER
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                this.board[i][j] = WATER;
            }
        }
    }

    /**
     * Este meto-do inicia el tablero para la flota enemiga
     * con "_" (guiones bajos) en todas sus celdas. Este es el modo oculto
     * de lo que hay en el tablero.
     *
     * @see #ROWS
     * @see #COLUMNS
     * @see #HIDE
     */
    public void initBoardEnemyFleet() {
        for(int f = 0; f < ROWS; f++) {
            for(int c = 0; c < COLUMNS; c++) {
                this.board[f][c] = HIDE;
            }
        }
    }
}
