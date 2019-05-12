package examples;

import drones.Drone;

/**
 * To change your drone name, type your drone name
 * to 'XXXX'. Make sure file name is the same as
 * your class name.
 */
public class Dummy extends Drone
{
	// Change 'XXXX' to your dronename
	public Dummy( int x, int y)
	{
		super(x, y, "src/resources/drone.png");
	}

	/**
	 * This method is repeated throughout the battle
	 */	
	@Override	
	public void run()
	{
		while(true)
		{
			// TODO
		}
	}
	
	/**
	 * Determine how your drone will react 
	 * when it scannes an enemy drone.
	 */
	@Override
	public void onScannedDrone()
	{
		// TODO
	}

	/**
	 * Determine how your drone will react 
	 * when it hits to the wall.
	 */
	@Override
	public void onHitBorder()
	{
		// TODO
	}
}