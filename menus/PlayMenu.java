package menus;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.beans.*;
import java.util.ArrayList;

public class PlayMenu extends Menu {

   private MenuTestClass m = new MenuTestClass(this);
   private ArrayList<Menu> menus;
   private ArrayList<JComponent> components;
   private boolean focused;
   private JLabel selectLabel;
   DroneerMenuButton storyButton;
   DroneerMenuButton arenaButton;
   
   public PlayMenu(ArrayList<Menu> menus) {
      
      this.menus = menus;
      components = new ArrayList<JComponent>();
      
      setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
      
      selectLabel = new JLabel("Select a game mode");
      selectLabel.setForeground(Color.WHITE);
      selectLabel.setFont(new Font("Sans Serif", Font.PLAIN, 50));
      selectLabel.setBorder(new EmptyBorder(70,0,70,0));
      
      storyButton = new DroneerMenuButton("Story");
      arenaButton = new DroneerMenuButton("Arena");
      
      components.add(selectLabel);
      components.add(storyButton);
      components.add(arenaButton);
      
      for(JComponent c: components) {
         c.setAlignmentX(Component.CENTER_ALIGNMENT);
      }
      
      focused = false;
      
      storyButton.addActionListener(new ActionListener() {
         
         public void actionPerformed(ActionEvent e) {
            focused = true;
         }
         
      });
      add(selectLabel);
      add(storyButton);
      add(arenaButton);
   }
   
   public void setFocused(boolean foc) {
      focused = foc;
   }
   
   public boolean getFocused() {
      return focused;
   }
   
}