package drones;

import examples.*;

/*
 * @author - Uður Erdem Seyfi
 * @version - 11.05.2019
 */
public class UpdatableBoard extends Board{
    public UpdatableBoard(){
        super(new RandomDrone(372,865), new SquareDrone(436,624) );
    }
}
