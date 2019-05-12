package examples;

import drones.*;

/**
 * A drone that traces the enemy movements crudely
 * 
 * @author Baykam Say
 * @version 12.5.19
 */

public class TracingDrone extends Drone {

   private double enemyAngle;
   private boolean droneScanned;
   private int turnAmount;

   public TracingDrone(int x, int y) {
      super(x, y, "src/resources/drone.png");
      droneScanned = false;
      turnAmount = 1;
   }

   /**
    * This method is repeated throughout the battle
    */
   @Override
   public void run() {
//		while (!droneScanned) {
//			turn(1);
//		}
//		
//		while (true) {
//			if (droneScanned) {
//				
//				turnAmount = (int) (enemyAngle - this.getAngle());
//			} else if (turnAmount == 0) {
//				
//				turnAmount = 1;
//			} else {
//				
//				turnAmount *= -2;
//			}
//			
//			droneScanned = false;
//			turn(turnAmount);
//		}

      turnAmount = 1;

      while (true) {

         while (!droneScanned) {
            turn(turnAmount);
            turnAmount *= -2;
         }
         droneScanned = false;
         turn((int) (enemyAngle - this.getAngle()));

         turnAmount = 1;

      }

   }

   /**
    * Determine how your drone will react when it scans an enemy drone.
    */
   @Override
   public void onScannedDrone() {
      fire();
      enemyAngle = Math.toDegrees(this.getAngle());
      droneScanned = true;
   }

   /**
    * Determine how your drone will react when it hits to the wall.
    */
   @Override
   public void onHitBorder() {
      turn(180);
      move(100);
   }
}
