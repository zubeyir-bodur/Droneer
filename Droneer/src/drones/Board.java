package drones;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * The base JPanel where the drones will fight
 *
 * @author Baykam Say
 * @version 06/05/2019
 */
public class Board extends JPanel implements ActionListener {
   
   private Drone d;
   private Timer timer;
   
   /**
    * Create a new board.
    */
   public Board() {
      setPreferredSize(new Dimension(800, 600));
      setFocusable(true);
      
      initComponents();
   }

   /**
    * Initialize the components of the board.
    */
   private void initComponents() {
      d = new Drone(100, 100, "src/resources/drone.png");
      
      new Thread(d).start();
      
      timer = new Timer(5, this);
      timer.start();
   }

   /**
    * Refresh the screen
    * 
    * @param ae The action event
    */
   @Override
   public void actionPerformed(ActionEvent ae) {
      repaint();
   }
   
   /**
    * Paint the drones.
    * 
    * @param g The graphics object
    */
   @Override
   public void paintComponent(Graphics g) {
      super.paintComponent(g);
      
      drawDrone((Graphics2D) g);
      g.drawOval((int)d.getHitbox().getX(),(int) d.getHitbox().getY(),(int) d.getHitbox().getWidth(),(int) d.getHitbox().getHeight());
      
      Toolkit.getDefaultToolkit().sync(); // to make the animations smoother
   }

   /**
    * Draw the drones at a specified angle.
    * 
    * @param g2d The graphics2d object
    */
   private void drawDrone(Graphics2D g2d) {
      
      AffineTransform a = AffineTransform.getRotateInstance(d.getAngle(), d.getX() + d.getR() / 2D, d.getY()+ d.getR() / 2D);
      g2d.setTransform(a);
      
      g2d.drawImage(d.getImage(), d.getX(), d.getY(), this);
   }
}
