package drones;

import examples.*;

/*
 * @author - Uður Erdem Seyfi
 * @version - 11.05.2019
 */
public class UpdatableBoard extends Board{
    public UpdatableBoard(){
        super(new SquareDrone(54,396), new RandomDrone(755,639) );
    }
}
