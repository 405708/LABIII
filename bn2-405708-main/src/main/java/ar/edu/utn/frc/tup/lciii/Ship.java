package ar.edu.utn.frc.tup.lciii;


/**
 * Esta clase representa un barco
 *
 * El barco es parte de la flota de cada jugador y
 * tiene una posicion y un estado que puede ser AFLOAT (a flote)
 * o SUNKEN (hndidio)
 *
 * @see Position
 * @see ShipStatus
 *
 */
public class Ship {

    /**
     * Position of the ship
     */
    private Position position;

    /**
     * Status of the ship
     */
    private ShipStatus shipStatus;

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public ShipStatus getShipStatus() {
        return shipStatus;
    }

    public void setShipStatus(ShipStatus shipStatus) {
        this.shipStatus = shipStatus;
    }

    public Ship() {
    }

    public Ship(Position position, ShipStatus shipStatus) {
        this.position = position;
        this.shipStatus = shipStatus;
    }

    public void sinkShip()
    {
        this.shipStatus = ShipStatus.SUNKEN;
    }

    /**
     * Este meto-do debe validar si un Ship es igual a otro en base a su posición.
     * Es decir, si la posición de la istancia del barco tiene los mismo datos
     * de position que el objeto pasado por parametro.
     *
     * @param obj El Ship a comparar contra la instancia en la que se ejecuta el meto-do
     *
     * @see Object#equals(Object)
     *
     * @return true si este Ship tiene la misma posicion que obj, false si no se da esta condición.
     */
    @Override
    public boolean equals(Object obj) {
        // TOD-O: Retornar la validacion de la comparacion de position
        // TOD-O: Remember to replace the return statement with the correct object
        Ship ship = (Ship) obj;
        boolean state = false;

        if (this.position.equals(ship.getPosition()))
        {
            state = true;
        }
        return state;
    }
}
