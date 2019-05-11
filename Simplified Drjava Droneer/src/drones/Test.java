package drones;
import java.awt.EventQueue;
import javax.swing.JFrame;
import examples.*;

/**
 * A JFrame for testing purposes
 * 
 * @author Baykam Say, Alp Uneri
 * @version 11.5.19
 */
public class Test extends JFrame {
   
   Board b;
   
   /**
    * Create the JFrame.
    */
   public Test() {
      
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setTitle("Droneer");
      
      b = new UpdatableBoard();
      
      add(b);
      
      //pack();
      setExtendedState(JFrame.MAXIMIZED_BOTH); 
      setUndecorated(true);
      
      setLocationRelativeTo(null);
   }
   
   public Board getBoard()
   {
      return b;
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
