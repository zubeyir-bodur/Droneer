package drones;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Timer;

/**
 * Basic drone class for creating drones on top of it.
 * 
 * @author Baykam Say
 * @version 06/05/2019
 */
public class Drone extends Sprite implements Runnable {
   
   private final int MOVE_SPEED = 2;
   private final int ROTATION_SPEED = 2;
   
   private double angle;
   private Timer moveTimer;
   private Timer turnTimer;
   
   /**
    * Creates a new instance with specified x and y locations and a given image name.
    * 
    * @param x The x location of the drone
    * @param y The y location of the drone
    * @param imageName The name of the image of the sprite
    */
   public Drone(int x, int y, String imageName) {
      super(x, y, imageName);
      
      angle = 0;
   }
   
   /**
    * Return the angle of the drone.
    * 
    * @return the angle of the drone.
    */
   public double getAngle() {
      return angle;
   }

   /**
    * Move the drone for a specific distance.
    * 
    * @param distance The distance the drone will travel
    */
   public void move(int distance) {
      
      if (distance > 0) {
         x += MOVE_SPEED * Math.cos(angle);
         y += MOVE_SPEED * Math.sin(angle);
         
         try {
            Thread.sleep(5);
         } catch (InterruptedException ex) {
            Logger.getLogger(Drone.class.getName()).log(Level.SEVERE, null, ex);
         }
         
         move(distance - MOVE_SPEED);
      }
   }
   
   /**
    * Turn the drone clockwise for a specific degrees.
    * 
    * @param degrees The amount of degrees that the drone will turn
    */
   public void turn(int degrees) {
      
      angle = angle % (Math.PI * 2);
      
      if (degrees > ROTATION_SPEED) {
         angle += Math.toRadians(ROTATION_SPEED);
         
         try {
            Thread.sleep(5);
         } catch (InterruptedException ex) {
            Logger.getLogger(Drone.class.getName()).log(Level.SEVERE, null, ex);
         }
         turn(degrees - ROTATION_SPEED);
      } else {
         
         angle += Math.toRadians(degrees);
         
         try {
            Thread.sleep(5);
         } catch (InterruptedException ex) {
            Logger.getLogger(Drone.class.getName()).log(Level.SEVERE, null, ex);
         }
      }
   }
   
   /**
    * The action that will be done when the game starts.
    */
   @Override
   public void run() {

      move(100);
      turn(90);
      move(200);

   }
}
