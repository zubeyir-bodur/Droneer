package drones;

import java.awt.Point;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Basic drone class for creating drones on top of it.
 * 
 * @author Baykam Say
 * @version 06/05/2019
 */
public abstract class Drone extends Sprite implements Runnable {
   
   private final int MOVE_SPEED = 2;
   private final int ROTATION_SPEED = 2;
   private final int COOLDOWN = 1000;
   
   protected boolean running;
   private long lastFired;
   private int health;
   private double angle;
   private double distance;
   private List<Laser> lasers;
   
   /**
    * Creates a new instance with specified x and y locations and a given image name.
    * 
    * @param x The x location of the drone
    * @param y The y location of the drone
    * @param imageName The name of the image of the sprite
    */
   public Drone(int x, int y, String imageName) {
      super(x, y, imageName);
      
      running = true;
      lastFired = System.currentTimeMillis();
      health = 100;
      angle = 0;
      distance = -1;
      lasers = new ArrayList<>();
   }
   
   /**
    * Return the angle of the drone.
    * 
    * @return the angle of the drone.
    */
   public final double getAngle() {
      return angle;
   }

   /**
    * Returns the health of the drone.
    * 
    * @return the health of the drone.
    */
   public final int getHealth() {
      return health;
   }
   
   /**
    * Is called when the drone is hit, decrements health by 10.
    */
   final void hit() {
      health -= 10;
      System.out.println("ouch");
      if (health <= 0) {
         visible = false;
      }
   }
   
   /**
    * Move the drone for a specific distance.
    * 
    * @param distance The distance the drone will travel
    */
   public final void move(int distance) {
      
      if (running) {
         if (distance > 0) {
            x += MOVE_SPEED * Math.cos(angle);
            y += MOVE_SPEED * Math.sin(angle);

            try {
               Thread.sleep(Board.DELAY);
            } catch (InterruptedException ex) {
               Logger.getLogger(Drone.class.getName()).log(Level.SEVERE, null, ex);
            }

            move(distance - MOVE_SPEED);
         }
      } else {

         try {
            Thread.sleep(100);
         } catch (InterruptedException ex) {
            Logger.getLogger(Drone.class.getName()).log(Level.SEVERE, null, ex);
         }

         move(distance);
      }
   }
   
   /**
    * Turn the drone clockwise for a specific degrees.
    * 
    * @param degrees The amount of degrees that the drone will turn
    */
   public final void turn(int degrees) {
      
//      angle = angle % (Math.PI * 2);
      
      if (degrees > 0) {
         if (degrees > ROTATION_SPEED) {
            angle += Math.toRadians(ROTATION_SPEED);

            try {
               Thread.sleep(Board.DELAY);
            } catch (InterruptedException ex) {
               Logger.getLogger(Drone.class.getName()).log(Level.SEVERE, null, ex);
            }
            turn(degrees - ROTATION_SPEED);
         } else {

            angle += Math.toRadians(degrees);

            try {
               Thread.sleep(Board.DELAY);
            } catch (InterruptedException ex) {
               Logger.getLogger(Drone.class.getName()).log(Level.SEVERE, null, ex);
            }
         }
      } else {
         if (- degrees > ROTATION_SPEED) {
            angle -= Math.toRadians(ROTATION_SPEED);

            try {
               Thread.sleep(Board.DELAY);
            } catch (InterruptedException ex) {
               Logger.getLogger(Drone.class.getName()).log(Level.SEVERE, null, ex);
            }
            turn(degrees + ROTATION_SPEED);
         } else {

            angle += Math.toRadians(degrees);

            try {
               Thread.sleep(Board.DELAY);
            } catch (InterruptedException ex) {
               Logger.getLogger(Drone.class.getName()).log(Level.SEVERE, null, ex);
            }
         }
      }
   }
   
   /**
    * Scans the front of the drone, if the ellipse is on the front returns true; if not returns false.
    * 
    * @param e The ellipse that will be tested
    * @param width The width of the board
    * @param height The height of the board
    * @return true if the ellipse is in front of the drone, false if not.
    */
   public final boolean scan(Ellipse2D.Double e, int width, int height) {
      return getIntersection(e, width, height) != null;
   }
   
   /**
    * Returns the intersection point of the line of sight of the drone and the ellipse that is chosen.Also calculates the distance between this point and the drone.
    * 
    * @param e The ellipse that will be tested
    * @param width The width of the board
    * @param height The height of the board
    * @return The intersection point of the line of sight of the drone and the ellipse that is chosen.
    */
   public final Point getIntersection(Ellipse2D.Double e, int width, int height) {
      
      Point result; 
      
      double xI; // x intersection 1
      double yI; // y intersection 1
      double distance;

      // the specifications of e 
      double xE = e.getCenterX();
      double yE = e.getCenterY();
      double rE = e.getWidth() / 2;

      // position of the drone
      double xD = x + r / 2;
      double yD = y + r / 2;

      // center the drone so that the calculations are simpler
      double x1 = xD - xE;
      double y1 = yD - yE;

      double m = Math.tan(angle); // calculate the slope

      double mP = -1 / m; // slope perpendicular to the angle

      // an arbitrary point on the line perpendicular to the trajectory of the drone
      double xA = 0;
      double yA = yD - mP * xD;

      // -------------------------------------- CHANGE HERE ---------------------------------------
      // Tried to see if the ellipse is on the back or on the front but failed
//      if ((xE - xA) * (yD - yA) - (yE - yA) * (xD - xA) < 0) {

         // a, b, c in a*x^2+b*x+c = 0
         double a = 1 + m * m;
         double b = 2 * m * y1 - 2 * m * x1;
         double c = m * x1 * m * x1 - 2 * m * x1 * y1 + y1 * y1 - rE * rE;

         // calculate the delta
         double delta = b * b - 4 * a * c;

         // if delta < 0 no intersection, if > 0 two intersections, if = 0 one intersection
         if (delta < 0) {

            result = null;
            distance = -1;
         } else {

            xI = (-b + Math.sqrt(delta)) / (2 * a);
            yI = m * (xI - x1) + y1;

            distance = Math.sqrt((xI - x1) * (xI - x1) + (yI - y1) * (yI - y1));

            if (delta > 0) {

               double xI2; // x intersection 2
               double yI2; // y intersection 2
               double distance2;

               xI2 = (-b - Math.sqrt(delta)) / (2 * a);
               yI2 = m * (xI2 - x1) + y1;

               distance2 = Math.sqrt((xI2 - x1) * (xI2 - x1) + (yI2 - y1) * (yI2 - y1));

               // compare the distances between the first point and the second point
               if (distance2 < distance) {
                  xI = xI2;
                  yI = yI2;
                  distance = distance2;
               }
            }

            result = new Point((int) (xI + xE), (int) (yI + yE));
         }
         // ------------------------------------- CHANGE HERE --------------------------------------
//      } else {
//         
//         distance = -1;
//         result = null;
//      }

      this.distance = distance;
      return result;
   } 
   
   /**
    * Returns the distance between the front of the drone and the nearest obstacle.
    * 
    * @return The distance between the front of the drone and the nearest obstacle.
    */
   public final double getDistance() {
      return distance;
   }
   
   /**
    * Fire a laser by adding it to the lasers list.
    */
   public final void fire() {
      if (System.currentTimeMillis() - lastFired > COOLDOWN) {
         
         lasers.add(new Laser(x + r/2, y + r/2, angle));
         lastFired = System.currentTimeMillis();
      }
   }
   
   /**
    * Return the list of lasers.
    * 
    * @return the list of lasers.
    */
   public final List<Laser> getLasers() {
      return lasers;
   }
   
   /**
    * Is called when a drone is scanned.
    */
   public abstract void onScannedDrone();
   
   /**
    * Is called when a border is hit.
    */
   public abstract void onHitBorder();
   
//   /**
//    * The action that will be done when the game starts.
//    */
//   @Override
//   public abstract void run();
}
