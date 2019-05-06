package menus;

import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.beans.*;
import java.util.ArrayList;
import javax.swing.UIManager.*;
import java.io.*;
import java.util.Arrays;

/**
 * Class that creates the drone selection panel
 * @author Ege Kaan Gürkan
 * @version 03/05/2019
 */

public class DroneSelectMenu extends Menu {
   
   JFileChooser fileChooser = new JFileChooser("/Users/egekaangurkan/Desktop/DRONEER");
   private MenuTestClass m = new MenuTestClass(this);
   DroneerMenuButton backButton;
   private JLabel explainLabel;
   private ArrayList<JComponent> components;
   private JList dronesListLeft;
   private JList dronesListSpecific;
   private JPanel textPanel;
   private File aDirectory;
   private File aDirectory2;
   private String[] filesInDir;
   private String[] filesInDir2;
   private JSplitPane jSplitPane;
   private String newDir;
   
   /**
    * Creates a JFileChooser and displays it with the given directory
    */
   public DroneSelectMenu() {
      
//      setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
//      setLayout(new BorderLayout());
      setLayout(new BorderLayout(2,1));
      
//      jSplitPane = new JSplitPane();
      
      focused = false;
      backButton = new DroneerMenuButton("< Back");
      textPanel = new JPanel();
      
      aDirectory = new File("/Users/egekaangurkan/Desktop/DRONEER");
      filesInDir = aDirectory.list();
      dronesListLeft = new JList(filesInDir);
      
//      String newDirectory = "/Users/egekaangurkan/Desktop/DRONEER" + dronesListLeft.getSelectedValue();
      aDirectory2 = new File("/Users/egekaangurkan/Desktop/DRONEER");
      filesInDir2 = aDirectory2.list();
      dronesListSpecific = new JList(filesInDir2);
      add(dronesListSpecific, BorderLayout.EAST);
      
      dronesListLeft.addListSelectionListener(new ListSelectionListener() {
         
         @Override
         public void valueChanged(ListSelectionEvent e) {
            
            System.out.println(dronesListLeft.getSelectedValue());
            DefaultListModel dlm = new DefaultListModel();
            newDir = "/Users/egekaangurkan/Desktop/DRONEER" + dronesListLeft.getSelectedValue();
            aDirectory2 = new File(newDir);
            filesInDir2 = aDirectory2.list();
            for(int i = 0; i < filesInDir.length; i++) {
               dlm.add(i,filesInDir[i]);
            }
            dronesListSpecific = new JList(dlm);
            dronesListSpecific.updateUI();
         }
         
      });
      
      dronesListLeft.setListData(filesInDir2);
      
      explainLabel = new JLabel("Choose the drone you want to edit");
      explainLabel.setForeground(Color.WHITE);
      explainLabel.setFont(new Font("Monospaced", Font.PLAIN, 20));
      explainLabel.setBorder(new EmptyBorder(10,10,10,0));
      explainLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
      
      textPanel.setLayout(new BorderLayout());
      textPanel.add(explainLabel, BorderLayout.NORTH);
      
//      jSplitPane.setBottomComponent(dronesList);
      
      components = new ArrayList<JComponent>();
      components.add(explainLabel);
      
      for(JComponent c: components) {
         c.setAlignmentX(Component.CENTER_ALIGNMENT);
      }
      
      add(textPanel, BorderLayout.NORTH);
      add(dronesListLeft, BorderLayout.WEST);
//      add(dronesListSpecific, BorderLayout.WEST);
      
//      add(jSplitPane, BorderLayout.EAST);
     
      
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