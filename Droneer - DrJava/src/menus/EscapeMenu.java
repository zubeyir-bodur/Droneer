package menus;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.util.ArrayList;

/**
 * Panel for the Escape Screen
 * @author Ege Kaan Gurkan, Alp Uneri
 * @version 8.5.19
 */

public class EscapeMenu extends Menu {

   //public MenuTestClass m = new MenuTestClass(this);
   //public ArrayList<Menu> menus;
   private ArrayList<JComponent> components;
   //public boolean focused;
   private JLabel explainLabel;
   private DroneerMenuButton resumeButton;
   private DroneerMenuButton mainMenuButton;
   private DroneerMenuButton helpButton;
   
   public EscapeMenu() {
      
      //this.menus = menus;
      
      components = new ArrayList<JComponent>();
      
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
      
      // Add the components to an arraylist to quickly set the center alignment
      components.add(explainLabel);
      components.add( resumeButton);
      components.add(mainMenuButton);
      components.add(helpButton);
      
      explainLabel.setHorizontalAlignment( JLabel.CENTER);
      
      for(JComponent c: components) {
         c.setAlignmentX(Component.CENTER_ALIGNMENT);
      }
      
      focused = false;
      
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
   
   /**
    * Sets the focused variable to a given value
    * @param a The boolean value to set focused to 
    */
   
   public void setFocused(boolean a) {
      focused = a;
   }
   
   /**
    * Returns whether the panel is focused or not
    */
   
   public boolean getFocused() {
      return focused;
   }
   
}

