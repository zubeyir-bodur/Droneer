package menus;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.util.ArrayList;

/**
 * Panel for the Arena Screen
 * @author Ege Kaan Gurkan, Alp Uneri
 * @version 8.5.19
 */

public class ArenaMenu extends Menu {

   private MenuTestClass m = new MenuTestClass(this);
   private ArrayList<Menu> menus;
   private ArrayList<JComponent> components;
   private boolean focused;
   private JLabel explainLabel;
   private DroneerMenuButton beginnerButton;
   private DroneerMenuButton interButton;
   private DroneerMenuButton advancedButton;
   private DroneerMenuButton sandboxButton;
   private DroneerMenuButton backButton;
   
   public ArenaMenu() {
      
      this.menus = menus;
      
      components = new ArrayList<JComponent>();
      
      setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
      
      // Block to set the label style
      explainLabel = new JLabel("Select an arena type");
      explainLabel.setForeground(Color.BLACK);
      explainLabel.setFont(new Font("Monospaced", Font.PLAIN, 35));
      explainLabel.setBorder(new EmptyBorder(50,0,70,0));
      
      // Create the initialised buttons
      beginnerButton = new DroneerMenuButton("Beginner Cup");
      interButton = new DroneerMenuButton("Intermediate Cup");
      interButton.setEnabled( false);
      advancedButton = new DroneerMenuButton("Advanced Cup");
      advancedButton.setEnabled( false);
      sandboxButton = new DroneerMenuButton("Sandbox");
      sandboxButton.setEnabled( false);
      backButton = new DroneerMenuButton("< Back");
      
      // Add the components to an arraylist to quickly set the center alignment
      components.add(explainLabel);
      components.add(beginnerButton);
      components.add(interButton);
      components.add(advancedButton);
      components.add(sandboxButton);
      components.add(backButton);
      
      backButton.setMargin(new Insets(20,30,20,30));
      
      for(JComponent c: components) {
         c.setAlignmentX(Component.CENTER_ALIGNMENT);
      }
      
      focused = false;
      
      add(explainLabel);
      add(beginnerButton);
      add(interButton);
      add(advancedButton);
      add(sandboxButton);
      add(backButton);
   }
   
   public JButton getBeginnerButton() {
      return beginnerButton;
   }
   
   public JButton getBackButton() {
      return backButton;
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

