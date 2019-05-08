package drones;
import java.awt.EventQueue;
import javax.swing.JFrame;

/**
 * A JFrame for testing purposes
 * 
 * @author Baykam Say
 * @version 06/05/2019
 */
public class Test extends JFrame {
   
   Board b;
   
   /**
    * Create the JFrame.
    */
   public Test() {
      
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setTitle("Droneer");
      
      b = new Board();
      
      add(b);
      
      pack();
      setLocationRelativeTo(null);
   }
   
   /**
    * Create an instance of the Test.
    * 
    * @param args The command line arguments
    */
   public static void main(String[] args) {
      
      EventQueue.invokeLater(new Runnable() {
         
         @Override
         public void run() {
            new Test().setVisible(true);
         }
      });
   }
   
}
