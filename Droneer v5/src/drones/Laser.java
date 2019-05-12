package drones;

/**
 * The lasers that the drones fire.
 *
 * @author Baykam Say
 * @version 03/05/2019
 */
public class Laser extends Sprite {

   private final int SPEED = 7;
   private final double angle;

   /**
    * Construct a new laser at the point P(x, y) moving along the trajectory of the
    * angle.
    * 
    * @param x     The x point of the laser
    * @param y     The y point of the laser
    * @param angle The angle of the trajectory of the laser
    */
   public Laser(double x, double y, double angle) {
      super(x, y, "src/resources/laser.gif"); // for some reason the png version gave errors

      this.angle = angle;
   }

   /**
    * Move the laser at a specified speed on the linear trajectory specified by its
    * angle.
    */
   public void move() {
      x += SPEED * Math.cos(angle);
      y += SPEED * Math.sin(angle);
   }
}
