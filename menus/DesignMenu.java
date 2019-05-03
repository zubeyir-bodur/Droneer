package menus;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.beans.*;
import java.util.ArrayList;

public class DesignMenu extends Menu {
   
   JFileChooser fileChooser = new JFileChooser("/Users/egekaangurkan/Desktop/DRONEER");
   private MenuTestClass m = new MenuTestClass(this);
   private boolean focused;
   DroneerMenuButton backButton;
   private JLabel explainLabel;
   private ArrayList<JComponent> components;
   
   public DesignMenu() {
      
      setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
      
      focused = false;
      setVisible(true);
      backButton = new DroneerMenuButton("Back");
      
      explainLabel = new JLabel("Choose the drone you want to edit");
      explainLabel.setForeground(Color.WHITE);
      explainLabel.setFont(new Font("Monospaced", Font.PLAIN, 30));
      explainLabel.setBorder(new EmptyBorder(10,0,10,0));
      
      components = new ArrayList<JComponent>();
      components.add(explainLabel);
      
      for(JComponent c: components) {
         c.setAlignmentX(Component.CENTER_ALIGNMENT);
      }
      
      add(explainLabel);
      add(backButton);
      
   }
   
   public void setFocused(boolean a) {
      focused = a;
   }
   
   public boolean getFocused() {
      return focused;
   }
   
}