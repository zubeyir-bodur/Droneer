package menus;
import drones.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

/**
 * Panel for the Lose Screen
 * @author Ege Kaan Gurkan, Alp Uneri
 * @version 11.5.19
 */

public class LoseMenu extends JPanel {

   private JLabel explainLabel;
   private DroneerMenuButton mainMenuButton;
   
   public LoseMenu() {
      
      setLayout(new GridLayout( 2, 1));
      
      // Block to set the label style
      explainLabel = new JLabel("YOU LOST!");
      explainLabel.setForeground(Color.BLACK);
      explainLabel.setFont(new Font("Monospaced", Font.PLAIN, 35));
      explainLabel.setBorder(new EmptyBorder(50,0,70,0));
      
      // Create the initialised buttons
      mainMenuButton = new DroneerMenuButton("Main Menu");

      explainLabel.setHorizontalAlignment( JLabel.CENTER);
      
      add( explainLabel);
      add( mainMenuButton);
   }
   
   public JButton getMainMenuButton() {
      return mainMenuButton;
   }
}