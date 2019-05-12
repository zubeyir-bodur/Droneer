package examples;

import drones.Drone;

/**
 * To change your drone name, type your drone name to 'XXXX'. Make sure file
 * name is the same as your class name.
 */
public class CornerDrone extends Drone {
   private int hit;

   // Change 'XXXX' to your dronename
   public CornerDrone(int x, int y) {
      super(x, y, "src/resources/dronePurple.png");
      hit = 0;
   }

   /**
    * This method is repeated throughout the battle
    */
   @Override
   public void run() {
      while (hit < 2) {
         move(2);
      }

      while (true) {
         turn(-90);
         turn(90);
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
      hit++;
      turn(-90);
   }
}