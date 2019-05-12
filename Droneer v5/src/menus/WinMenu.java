package menus;
import drones.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

/**
 * Panel for the Win Screen
 * @author Ege Kaan Gurkan, Alp Uneri
 * @version 11.5.19
 */

public class WinMenu extends JPanel {

   private JLabel explainLabel;
   private DroneerMenuButton mainMenuButton;
   
   public WinMenu() {
      
      setLayout(new BoxLayout( this, BoxLayout.Y_AXIS));
      
      // Block to set the label style
      explainLabel = new JLabel("YOU WON!");
      explainLabel.setForeground(Color.GREEN);
      explainLabel.setFont(new Font("Monospaced", Font.BOLD, 100));
      explainLabel.setBorder(new EmptyBorder(50,0,70,0));
      
      // Create the initialised buttons
      mainMenuButton = new DroneerMenuButton("Main Menu");
      
      // add empty labels :/
      JLabel empty = new JLabel(" ");
      empty.setFont(new Font("Monospaced", Font.BOLD, 100));
      
      mainMenuButton.setAlignmentX(Component.CENTER_ALIGNMENT);
      explainLabel.setAlignmentX(Component.CENTER_ALIGNMENT);      
      add( explainLabel);
      add(empty);
      add( mainMenuButton);
   }
   
   public JButton getMainMenuButton() {
      return mainMenuButton;
   }
}