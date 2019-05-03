package menus;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.beans.*;
import java.util.ArrayList;

public class MainMenu extends Menu {

   private MenuTestClass m = new MenuTestClass(this);
   private ArrayList<Menu> menus;
   private ArrayList<JComponent> components;
   private boolean focused;
   private JLabel droneerLabel;
   DroneerMenuButton playButton;
   DroneerMenuButton designButton;
   DroneerMenuButton helpButton;
   DroneerMenuButton settingsButton;
   DroneerMenuButton creditsButton;
   DroneerMenuButton exitButton;
   
   public MainMenu(ArrayList<Menu> menus) {
      
      this.menus = menus;
      components = new ArrayList<JComponent>();
      
      setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
      
      droneerLabel = new JLabel("DRONEER");
      droneerLabel.setForeground(Color.WHITE);
      droneerLabel.setFont(new Font("Monospaced", Font.PLAIN, 50));
      droneerLabel.setBorder(new EmptyBorder(10,0,10,0));
      
      playButton = new DroneerMenuButton("Play");
      designButton = new DroneerMenuButton("Design");
      helpButton = new DroneerMenuButton("Help");
      settingsButton = new DroneerMenuButton("Settings");
      creditsButton = new DroneerMenuButton("Credits");
      exitButton = new DroneerMenuButton("Exit");
      
      components.add(droneerLabel);
      components.add(playButton);
      components.add(designButton);
      components.add(helpButton);
      components.add(settingsButton);
      components.add(creditsButton);
      components.add(exitButton);
      
      exitButton.setMargin(new Insets(20,30,20,30));
      
      for(JComponent c: components) {
         c.setAlignmentX(Component.CENTER_ALIGNMENT);
      }
      
      focused = false;
      
      playButton.addActionListener(new ActionListener() {
         
         public void actionPerformed(ActionEvent e) {
            focused = true;
         }
         
      });
      add(droneerLabel);
      add(playButton);
      add(designButton);
      add(helpButton);
      add(settingsButton);
      add(creditsButton);
      add(exitButton);
   }
   
   public void setFocused(boolean foc) {
      focused = foc;
   }
   
   public boolean getFocused() {
      return focused;
   }
   
}

