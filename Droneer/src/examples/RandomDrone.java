package examples;

import drones.Drone;

/**
 * A simple drone that moves randomly
 * 
 * @author Baykam Say
 * @version 09/05/2019
 */
public class RandomDrone extends Drone {
   
   /**
    * Construct the drone at the point P(x, y).
    * 
    * @param x The x location
    * @param y The y location
    */
   public RandomDrone(int x, int y) {
      super(x, y, "src/resources/drone.png");
   }
   
   /**
    * Move randomly when the game starts.
    */
   @Override
   public void run() {
      
      while (true) {
         move((int) (Math.random() * 100));
         turn(360 + (int) (Math.random() * 360));
      }
   }
   
   /**
    * Fire once when the drone is scanned.
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