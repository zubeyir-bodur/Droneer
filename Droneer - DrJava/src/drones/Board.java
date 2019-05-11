package drones;

import examples.*;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.event.*;

/**
 * The base JPanel where the drones will fight
 *
 * @author Baykam Say
 * @version 06/05/2019
 */
public class Board extends JPanel implements ActionListener {
   
   protected static final int DELAY = 5;
   
   private Drone myDrone;
   private Drone enemyDrone;
   private Timer timer;
   private Thread myThread;
   private Thread enemyThread;
   //private DroneerMaster master;
   
   boolean gameOver;
   
   /**
    * Create a new board.
    */
   public Board( Drone myDrone, Drone enemyDrone) {

      //master = new DroneerMaster();
      
      setFocusable(true);
      
      gameOver = false;
      
      this.myDrone = myDrone;
      this.enemyDrone = enemyDrone;
      
      myThread = new Thread(myDrone);
      enemyThread = new Thread(enemyDrone);
         
      initComponents();
      
      //setPreferredSize( new Dimension( 700, 500));
   }

   public Thread getMyThread()
   {
      return myThread;
   }
   
   public Thread getEnemyThread()
   {
      return enemyThread;
   }
   
   public Timer getTimer()
   {
      return timer;
   }
   
   /**
    * Initialize the components of the board.
    */
   private void initComponents() {
     
      myThread.start();
      enemyThread.start();
      
      timer = new Timer(DELAY, this);
      timer.start();
   }

   /**
    * Refresh the screen
    * 
    * @param ae The action event
    */
   @Override
   public void actionPerformed(ActionEvent ae) {
      
      checkGameOver();
      
      updateLasers(myDrone.getLasers());
      updateLasers(enemyDrone.getLasers());
      
      updatePlayerDrone();
      updateEnemyDrone();
      
      checkCollisions(enemyDrone);
      checkCollisions(myDrone);
      
      checkCollisions(myDrone.getLasers(), enemyDrone);
      checkCollisions(enemyDrone.getLasers(), myDrone);

      repaint();
   }
   
   /**
    * Checks if the game is over, if it is stops the timer.
    */
   private void checkGameOver() {
      if (gameOver) {
         timer.stop();
      }
   }
   
   /**
    * Moves or removes the lasers depending on if they are visible or not.
    * 
    * @param lasers The lasers that will be updated
    */
   private void updateLasers(List<Laser> lasers) {
      
      for (int i = lasers.size() - 1; i >= 0; i--) {
         
         Laser l = lasers.get(i);
         
         if (l.isVisible()) {
            l.move();
         } else {
            lasers.remove(l);
         }
      }
   }
   
   /**
    * Updates the player drone. Calls the onScannedDrone() method if the player drone sees another 
    * drone. Ends the game if the player drone is dead.
    */
   private void updatePlayerDrone() {

      if (myDrone.isVisible()) {
         
         if (myDrone.scan(enemyDrone.getHitbox(), this.getWidth(), this.getHeight())) {

            myDrone.onScannedDrone();
         }
         
      } else {
         System.out.println("Lost");
         gameOver = true;
      }
   }
   
   /**
    * Updates the enemy drone. Calls the onScannedDrone() method if the enemy drone sees another 
    * drone. Ends the game if the enemy drone is dead.
    */
   private void updateEnemyDrone() {

      if (enemyDrone.isVisible()) {
         
         if (enemyDrone.scan(myDrone.getHitbox(), this.getWidth(), this.getHeight())){
            
            enemyDrone.onScannedDrone();
         }
         
      } else {
         System.out.println("Won");
         gameOver = true;
      }
   }
   
   /**
    * Checks the collisions between the boundaries and a drone.
    *
    * @param Drone The drone
    */
   private void checkCollisions(Drone d) {
      
      if (d.getX() < 0) {
         d.hit();
         d.setX(1);
         d.onHitBorder();
      }
      
      if (d.getX() + d.getR() > this.getWidth()) {
         d.hit();
         d.setX(this.getWidth() - d.getR() - 1);
         d.onHitBorder();
      }
      
      if (d.getY() < 0) {
         d.hit();
         d.setY(1);
         d.onHitBorder();
      }
      
      if (d.getY() + d.getR() > this.getHeight()) {
         d.hit();
         d.setY(this.getHeight() - d.getR() - 1);
         d.onHitBorder();
      }
   }
   
   /**
    * Checks the collisions between the lasers and a drone.
    * 
    * @param lasers The list of lasers
    * @param Drone The drone
    */
   private void checkCollisions(List<Laser> lasers, Drone d) {
      
      Ellipse2D hitbox = d.getHitbox();
      
      for (Laser l : lasers) {
         
         Ellipse2D.Double laserHitbox = l.getHitbox();
         
         if (hitbox.intersects(laserHitbox.getBounds2D())) {
            d.hit();
            l.setVisible(false);
         }
      }
   }
   
   /**
    * Paint the drones.
    * 
    * @param g The graphics object
    */
   @Override
   public void paintComponent(Graphics g) {
      super.paintComponent(g);
      
      List<Laser> playerLasers = myDrone.getLasers();
      List<Laser> enemyLasers = enemyDrone.getLasers();
      
      for (Laser l : playerLasers) {
         drawLaser((Graphics2D) g, l);
      }

      for (Laser l : enemyLasers) {
         drawLaser((Graphics2D) g, l);
      }

      drawDrone((Graphics2D) g, myDrone);
      drawDrone((Graphics2D) g, enemyDrone);
      
      Toolkit.getDefaultToolkit().sync(); // to make the animations smoother
   }

   /**
    * Draw the drone at a specified angle.
    * 
    * @param g2d The graphics2d object
    * @param d The drone that will be drawn
    */
   private void drawDrone(Graphics2D g2d, Drone d) {
      
      // for testing purposes, remove later
//      g2d.drawOval((int) d.getHitbox().getX(), (int) d.getHitbox().getY(), 
//              (int) d.getHitbox().getWidth(), (int) d.getHitbox().getHeight());
      
      AffineTransform a = AffineTransform.getRotateInstance(d.getAngle(), d.getX() + d.getR() / 2D, 
              d.getY()+ d.getR() / 2D);
      g2d.setTransform(a);
      
      g2d.drawImage(d.getImage(), (int) d.getX(), (int) d.getY(), this);
   }
   
   /**
    * Draw the laser.
    * 
    * @param g2d The graphics2d object
    * @param l The laser that will be drawn.
    */
   private void drawLaser(Graphics2D g2d, Laser l) {
      g2d.drawImage(l.getImage(), (int) l.getX(), (int) l.getY(), this);
   }
}
