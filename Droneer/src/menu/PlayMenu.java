package menu;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.beans.*;
import java.util.ArrayList;

/**
 * The play menu panel
 * @author Ege Kaan Gürkan
 * @version 03/05/2019
 */

public class PlayMenu extends Menu {

   private MenuTestClass m = new MenuTestClass(this);
   private ArrayList<Menu> menus;
   private ArrayList<JComponent> components;
   private boolean focused;
   private JLabel selectLabel;
   DroneerMenuButton storyButton;
   DroneerMenuButton arenaButton;
   DroneerMenuButton backButton;
   
   public PlayMenu() {
      
      this.menus = menus;
      components = new ArrayList<JComponent>();
      
      setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
      
      // Block to set the style of the label
      selectLabel = new JLabel("Select a game mode");
      selectLabel.setForeground(Color.WHITE);
      selectLabel.setFont(new Font("Sans Serif", Font.PLAIN, 50));
      selectLabel.setBorder(new EmptyBorder(70,0,70,0));
      
      storyButton = new DroneerMenuButton("Story");
      arenaButton = new DroneerMenuButton("Arena");
      backButton = new DroneerMenuButton("Back");
      
      components.add(selectLabel);
      components.add(storyButton);
      components.add(arenaButton);
      components.add(backButton);
      
      for(JComponent c: components) {
         c.setAlignmentX(Component.CENTER_ALIGNMENT);
      }
      
      focused = false;
      
      storyButton.addActionListener(new ActionListener() {
         
         public void actionPerformed(ActionEvent e) {
            focused = true;
         }
         
      });
      
      backButton.setMargin(new Insets(20,30,20,30));
      
      add(selectLabel);
      add(storyButton);
      add(arenaButton);
      add(backButton);
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