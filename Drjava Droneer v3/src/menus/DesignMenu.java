package menus;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.util.ArrayList;
import ide.*;

/**
 * Panel for the Design Screenç
 * @author Ege Kaan Gürkan, Alp Üneri
 * @version 8.5.19
 */

public class DesignMenu extends Menu {
   
   public JFileChooser fileChooser = new JFileChooser("/Users/egekaangurkan/Desktop/DRONEER");
   public MenuTestClass m = new MenuTestClass(this);
   public boolean focused;
   public DroneerMenuButton backButton;
   public JLabel explainLabel;
   public ArrayList<JComponent> components;
   public JPanel textPanel;
   public JPanel backPanel;
   public Editor editor;
   public JLabel explainLabel2;
   
   /**
    * Creates a JFileChooser and displays it with the given directory
    */
   public DesignMenu() {
      
//      setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
//      setLayout(new BorderLayout());
      //setLayout(new GridLayout(3,1));
      setLayout( new BorderLayout());
      
      focused = false;
      setVisible(true);
      backButton = new DroneerMenuButton("< Back");
      textPanel = new JPanel();
      backPanel = new JPanel();
      editor = new Editor();
      
      explainLabel2 = new JLabel( "Open the drone you'd like to edit or start from scratch.");
      explainLabel2.setForeground(Color.BLACK);
      explainLabel2.setFont(new Font("Monospaced", Font.PLAIN, 30));
      explainLabel2.setBorder(new EmptyBorder(10,0,10,0));
      explainLabel2.setAlignmentX(Component.CENTER_ALIGNMENT);
      
      textPanel.setLayout(new BorderLayout());
      textPanel.add(explainLabel2, BorderLayout.NORTH);
      
      backPanel.setLayout(new GridLayout(3,3));
      for(int i = 0; i < 6; i++) {
         backPanel.add(new JLabel());
      }
      backButton.setMargin(new Insets(20,30,20,30));
      backPanel.add(backButton);
      
      components = new ArrayList<JComponent>();
      components.add( textPanel);
      components.add(explainLabel2);
      components.add( editor);
      
      for(JComponent c: components) {
         c.setAlignmentX(Component.CENTER_ALIGNMENT);
      }
      
      add(textPanel, BorderLayout.NORTH);
      add( editor, BorderLayout.CENTER);
      add(backPanel, BorderLayout.SOUTH);
      
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