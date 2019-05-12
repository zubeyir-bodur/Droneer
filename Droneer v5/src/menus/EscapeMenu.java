package menus;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

/**
 * Panel for the Escape Screen
 * 
 * @author Ege Kaan Gurkan, Alp Uneri, Zubeyir Bodur
 * @version 11.5.19
 */

public class EscapeMenu extends JPanel {

   private JLabel explainLabel;
   private DroneerMenuButton resumeButton;
   private DroneerMenuButton mainMenuButton;
   private DroneerMenuButton helpButton;

   public EscapeMenu() {

      setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

      // Block to set the label style
      explainLabel = new JLabel("PAUSED");
      explainLabel.setForeground(Color.BLACK);
      explainLabel.setFont(new Font("Monospaced", Font.BOLD, 75));
      explainLabel.setBorder(new EmptyBorder(50, 0, 70, 0));
      JLabel empty = new JLabel(" ");
      empty.setFont(new Font("Monospaced", Font.BOLD, 50));

      // Create the initialised buttons
      resumeButton = new DroneerMenuButton("Resume");
      helpButton = new DroneerMenuButton("Help");
      mainMenuButton = new DroneerMenuButton("Main Menu");

      explainLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
      empty.setAlignmentX(Component.CENTER_ALIGNMENT);
      resumeButton.setAlignmentX(Component.CENTER_ALIGNMENT);
      helpButton.setAlignmentX(Component.CENTER_ALIGNMENT);
      mainMenuButton.setAlignmentX(Component.CENTER_ALIGNMENT);

      add(explainLabel);
      add(empty);
      add(resumeButton);
      add(helpButton);
      add(mainMenuButton);
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