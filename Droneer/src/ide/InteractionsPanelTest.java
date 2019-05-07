package ide;

import javax.swing.*;
import java.awt.*;

/**
 * BU CLASS TEST AMAÇLIDIR. ÝÞÝMÝZ BÝTÝNCE KURTULACAZ BUNDAN 
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
      
      for ( int i = 0; i < 200; i++)
         System.out.println(":D");
      
      test.update("36 error found:\nInteger 1000000000 is too large.\nInteger 1000000000 is too large.\nInteger 1000000000 is too large.\nInteger 1000000000 is too large.\nInteger 1000000000 is too large.\nInteger 1000000000 is too large.\nInteger 1000000000 is too large.\nInteger 1000000000 is too large.\nInteger 1000000000 is too large.\nInteger 1000000000 is too large.\nInteger 1000000000 is too large.\nInteger 1000000000 is too large.\nInteger 1000000000 is too large.\nInteger 1000000000 is too large.\nInteger 1000000000 is too large.\nInteger 1000000000 is too large.\nInteger 1000000000 is too large.\nInteger 1000000000 is too large.\nInteger 1000000000 is too large.\nInteger 1000000000 is too large.\nInteger 1000000000 is too large.\nInteger 1000000000 is too large.\nInteger 1000000000 is too large.\nInteger 1000000000 is too large.\nInteger 1000000000 is too large.\nInteger 1000000000 is too large.\nInteger 1000000000 is too large.\nInteger 1000000000 is too large.\nInteger 1000000000 is too large.\nInteger 1000000000 is too large.\nInteger 1000000000 is too large.\nInteger 1000000000 is too large.\nInteger 1000000000 is too large.\nInteger 1000000000 is too large.\nInteger 1000000000 is too large.\nInteger 1000000000 is too large.\nInteger 1000000000 is too large.\nInteger 1000000000 is too large.\nInteger 1000000000 is too large.\nInteger 1000000000 is too large.\nInteger 1000000000 is too large.\nInteger 1000000000 is too large.\nInteger 1000000000 is too large.\nInteger 1000000000 is too large.");
      
      
   }
}