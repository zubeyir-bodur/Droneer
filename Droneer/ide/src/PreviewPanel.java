import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
//import droneer.drone.*;
//import droneer.battle.*;

public class PreviewPanel extends JPanel
{
   final int DELAY = 10;
   
// private Battle battle;
   private Timer timer;
   
//   public PreviewPanel( Drone droneOfPlayer)
//   {
//      timer = new Timer( DELAY, new ActionListener() {
//         public void actionPerformed( ActionEvent e)
//         {
//            repaint();
//         }
//      });
//      ArrayList<Drone> drones = new ArrayList<Drone>();
//      DummyDrone dummy = new DummyDrone();
//      drones.add(droneOfPlayer);
//      drones.add(dummy);  
//      battle = new Battle(drones);
//   }
   
//   public class DummyDrone extends Drone
//   {
//      @Override
//      void run()
//      {
//         // stay still
//      }
//   }
   
   public void start()
   {
      timer.start();
   }
   
   public void pause()
   {
      timer.stop();
   }
   
   public void stop()
   {
      timer.restart();
      timer.stop();
   }
   
   @Override
   public void paintComponent( Graphics g)
   {
      super.paintComponent(g);
      // Painting drones, bullets. TO DO
//      for ( int i = 0; i < 2; i++) 
//         fillOval( battle.getDrones().get(i).getX(),
//               battle.getDrones().get(i).getY(),
//               battle.getDrones().get(i).getWidth(),
//               battle.getDrones().get(i).getHeight() );
// Burda drone'larý çiziyor. Bullet diye bi class da yazmamýz lazým galiba bullet'larý çizemeyebiliriz.
   }
}