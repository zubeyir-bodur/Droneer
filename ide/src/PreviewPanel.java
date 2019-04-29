import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PreviewPanel extends JPanel
{
   final int DELAY = 10;
   
//   private Battle battle;
   private Timer timer;
   
   public PreviewPanel()
   {
      timer = new Timer( DELAY, new ActionListener(){
         public void actionPerformed( ActionEvent e)
         {
            repaint();
         }
      });
   }
   
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
   }
}