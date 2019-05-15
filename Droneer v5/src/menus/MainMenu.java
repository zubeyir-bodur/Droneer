package menus;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.util.ArrayList;

/**
 * Panel for the Main Menu Screen
 * 
 * @author Ege Kaan Gurkan, Alp Uneri
 * @version 8.5.19
 */
public class MainMenu extends JPanel {

//   private static final Color BACKGROUND= new Color(255, 240, 216);
   
   private ArrayList<JComponent> components;
   private JLabel droneerLabel;
   private DroneerMenuButton playButton;
   private DroneerMenuButton designButton;
   private DroneerMenuButton helpButton;
   private DroneerMenuButton creditsButton;
   private DroneerMenuButton exitButton;

   public MainMenu() {

      components = new ArrayList<JComponent>();

      setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
      
//      setBackground(BACKGROUND);

      // Block to set the label style
      droneerLabel = new JLabel("DRONEER");
      droneerLabel.setForeground(Color.BLACK);
      droneerLabel.setFont(new Font("Monospaced", Font.BOLD, 75));
      droneerLabel.setBorder(new EmptyBorder(30, 0, 30, 0));

      // Create the initialised buttons
      playButton = new DroneerMenuButton("  PLAY ");
      designButton = new DroneerMenuButton(" DESIGN");
      helpButton = new DroneerMenuButton("  HELP ");
      creditsButton = new DroneerMenuButton("CREDITS");
      exitButton = new DroneerMenuButton(" EXIT  ");

      // Add the components to an arraylist to quickly set the center alignment
      components.add(droneerLabel);
      components.add(playButton);
      components.add(designButton);
      components.add(helpButton);
      components.add(creditsButton);
      components.add(exitButton);

      for (JComponent c : components) {
         c.setAlignmentX(Component.CENTER_ALIGNMENT);
         if (c instanceof JButton) {
            ((JButton) c).setFont(new Font("Monospaced", Font.BOLD, 20));
         }
      }

      add(droneerLabel);
      add(playButton);
      add(designButton);
      add(helpButton);
      add(creditsButton);
      add(exitButton);
   }

   public JButton getPlayButton() {
      return playButton;
   }

   public JButton getDesignButton() {
      return designButton;
   }

   public JButton getHelpButton() {
      return helpButton;
   }

//   public JButton getSettingsButton() {
//      return settingsButton;
//   }

   public JButton getCreditsButton() {
      return creditsButton;
   }

   public JButton getExitButton() {
      return exitButton;
   }
}