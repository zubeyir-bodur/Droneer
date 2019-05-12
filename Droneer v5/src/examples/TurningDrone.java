package examples;

import drones.Drone;

/**
 * To change your drone name, type your drone name to 'XXXX'. Make sure file
 * name is the same as your class name.
 */
public class TurningDrone extends Drone {
   // Change 'XXXX' to your dronename
   public TurningDrone(int x, int y) {
      super(x, y, "src/resources/drone.png");
   }

   /**
    * This method is repeated throughout the battle
    */
   @Override
   public void run() {
      while (true) {
         turn(60);
      }
   }

   /**
    * Determine how your drone will react when it scans an enemy drone.
    */
   @Override
   public void onScannedDrone() {
      fire();
   }

   /**
    * Determine how your drone will react when it hits to the wall.
    */
   @Override
   public void onHitBorder() {
      turn(180);
      move(300);
   }
}