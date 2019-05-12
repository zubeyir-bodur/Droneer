package drones;

import examples.*;

/*
 * @author - Uður Erdem Seyfi
 * @version - 11.05.2019
 */
public class UpdatableBoard extends Board{
    public UpdatableBoard(){
        super(new RandomDrone(1647,613), new SquareDrone(1690,649) );
    }
}
