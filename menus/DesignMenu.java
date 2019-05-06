package menus;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.beans.*;
import java.util.ArrayList;

/**
 * Class that generates the design menu panel
 * @author Ege Kaan Gürkan
 * @version 03/05/2019
 */

public class DesignMenu extends Menu {
   
   JFileChooser fileChooser = new JFileChooser("/Users/egekaangurkan/Desktop/DRONEER");
   private MenuTestClass m = new MenuTestClass(this);
   private boolean focused;
   DroneerMenuButton backButton;
   private JLabel explainLabel;
   private ArrayList<JComponent> components;
   private JPanel textPanel;
   private JPanel backPanel;
   
   /**
    * Creates a JFileChooser and displays it with the given directory
    */
   public DesignMenu() {
      
//      setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
//      setLayout(new BorderLayout());
      setLayout(new GridLayout(2,1));
      
      focused = false;
      setVisible(true);
      backButton = new DroneerMenuButton("< Back");
      textPanel = new JPanel();
      backPanel = new JPanel();
      
      explainLabel = new JLabel("Choose the drone you want to edit");
      explainLabel.setForeground(Color.WHITE);
      explainLabel.setFont(new Font("Monospaced", Font.PLAIN, 30));
      explainLabel.setBorder(new EmptyBorder(10,0,10,0));
      explainLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
      
      textPanel.setLayout(new BorderLayout());
      textPanel.add(explainLabel, BorderLayout.NORTH);
      
      backPanel.setLayout(new GridLayout(3,3));
      for(int i = 0; i < 6; i++) {
         backPanel.add(new JLabel());
      }
      backButton.setMargin(new Insets(20,30,20,30));
      backPanel.add(backButton);
      
      components = new ArrayList<JComponent>();
      components.add(explainLabel);
      
      for(JComponent c: components) {
         c.setAlignmentX(Component.CENTER_ALIGNMENT);
      }
      
      add(textPanel);
      add(backPanel);
      
//      add(new JLabel());
//      add(explainLabel, BorderLayout.NORTH);
//      add(new JLabel());
//      add(backButton, BorderLayout.WEST);
      
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