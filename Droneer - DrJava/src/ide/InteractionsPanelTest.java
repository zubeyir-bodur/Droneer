package ide;
import javax.swing.*;

/**
 * BU CLASS TEST 
 */
public class InteractionsPanelTest
{
   public static void main( String[] args )
   {
      InteractionsPanel test = new InteractionsPanel("Compiler JDK 8.0_191 ready.");
      JFrame myFrame = new JFrame();
      myFrame.add(test);
      myFrame.setLocation(-7, 380);
      myFrame.pack();
      myFrame.setVisible(true);
      
      test.update("36 error found:\nInteger 1000000000 is too large.\nInteger 1000000000 is too large.\nInteger 1000000000 is too large.\nInteger 1000000000 is too large.\nInteger 1000000000 is too large.\nInteger 1000000000 is too large.\nInteger 1000000000 is too large.\nInteger 1000000000 is too large.\nInteger 1000000000 is too large.\nInteger 1000000000 is too large.\nInteger 1000000000 is too large.\nInteger 1000000000 is too large.\nInteger 1000000000 is too large.\nInteger 1000000000 is too large.\nInteger 1000000000 is too large.\nInteger 1000000000 is too large.\nInteger 1000000000 is too large.\nInteger 1000000000 is too large.\nInteger 1000000000 is too large.\nInteger 1000000000 is too large.\nInteger 1000000000 is too large.\nInteger 1000000000 is too large.\nInteger 1000000000 is too large.\nInteger 1000000000 is too large.\nInteger 1000000000 is too large.\nInteger 1000000000 is too large.\nInteger 1000000000 is too large.\nInteger 1000000000 is too large.\nInteger 1000000000 is too large.\nInteger 1000000000 is too large.\nInteger 1000000000 is too large.\nInteger 1000000000 is too large.\nInteger 1000000000 is too large.\nInteger 1000000000 is too large.\nInteger 1000000000 is too large.\nInteger 1000000000 is too large.\nInteger 1000000000 is too large.\nInteger 1000000000 is too large.\nInteger 1000000000 is too large.\nInteger 1000000000 is too large.\nInteger 1000000000 is too large.\nInteger 1000000000 is too large.\nInteger 1000000000 is too large.\nInteger 1000000000 is too large.");
      
      
   }
}