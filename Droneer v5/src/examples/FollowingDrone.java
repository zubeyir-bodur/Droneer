package examples;

import drones.*;

public class FollowingDrone extends Drone {

   private double enemyAngle;
   private boolean droneScanned;
   private int turnAmount;

   public FollowingDrone(int x, int y) {
      super(x, y, "src/resources/droneRed.png");
      droneScanned = false;
      turnAmount = 1;
   }

   /**
    * This method is repeated throughout the battle
    */
   @Override
   public void run() {

      while (true) {

         while (!droneScanned) {
            turn(2);
         }

         move(100);
         droneScanned = false;
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
      turn(90);
   }

}
