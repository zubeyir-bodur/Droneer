package menus;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

/**
 * Panel for the Escape Screen
 * @author Ege Kaan Gurkan, Alp Uneri
 * @version 11.5.19
 */

public class EscapeMenu extends JPanel {

   private JLabel explainLabel;
   private DroneerMenuButton resumeButton;
   private DroneerMenuButton mainMenuButton;
   private DroneerMenuButton helpButton;
   
   public EscapeMenu() {
      
      setLayout(new GridLayout( 4, 1));
      
      // Block to set the label style
      explainLabel = new JLabel("PAUSED");
      explainLabel.setForeground(Color.BLACK);
      explainLabel.setFont(new Font("Monospaced", Font.PLAIN, 35));
      explainLabel.setBorder(new EmptyBorder(50,0,70,0));
      
      // Create the initialised buttons
      resumeButton = new DroneerMenuButton("Resume");
      helpButton = new DroneerMenuButton("Help");
      mainMenuButton = new DroneerMenuButton("Main Menu");

      explainLabel.setHorizontalAlignment( JLabel.CENTER);
      
      add(explainLabel);
      add( resumeButton);
      add( helpButton);
      add( mainMenuButton);
   }
   
   public JButton getResumeButton() {
      return resumeButton;
   }
   
   public JButton getMainMenuButton() {
      return mainMenuButton;
   }
   
   public JButton getHelpButton() {
      return helpButton;
   }
}