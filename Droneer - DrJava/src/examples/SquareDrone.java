package examples;

import drones.Drone;

/**
 * A simple drone that draws a square.
 * 
 * @author Baykam Say
 * @version 09/05/2019
 */
public class SquareDrone extends Drone {
   
   /**
    * Construct the drone at the point P(x, y).
    * 
    * @param x The x location
    * @param y The y location
    */
   public SquareDrone(int x, int y) {
      super(x, y, "src/resources/dronePurple.png");
   }
   
   /**
    * Draw a square when the game starts.
    */
   @Override
   public void run() {
      
      while (true) {
         move(100);
         turn(30);
      }
   }

   /**
    * Fire once when a drone is scanned.
    */
   @Override
   public void onScannedDrone() {
      fire();
   }

   /**
    * Turn around when hit a border.
    */
   @Override
   public void onHitBorder() {
      running = false;
      new Thread(new Runnable() {

         @Override
         public void run() {
            turn(180);
            running = true;
         }
      }).start();
   }
   
   
}
