package menus;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import javax.swing.event.*;
import java.beans.*;
import javax.swing.tree.*;
import java.util.ArrayList;
import java.io.*;

/**
 * The main menu panel
 * @author Ege Kaan Gürkan, Agil Aliyev
 * @version 03/05/2019
 */

public class HelpMenu extends Menu {
   
   private ArrayList<Menu> menus;
   private ArrayList<JComponent> components;
   private boolean focused;
   private JLabel droneerLabel;
   private JTree selectionTree;
   private JTextPane editorPane;
   private JPanel backButtonPanel;
   DroneerMenuButton backButton;
   
   public HelpMenu() {
      
      this.menus = menus;
      
      setLayout(new BorderLayout());
      
      components = new ArrayList<JComponent>();
      
      backButtonPanel = new JPanel();
      backButtonPanel.setLayout(new BorderLayout());
      
      
      // Initialize the Tree structure
      DefaultMutableTreeNode top = new DefaultMutableTreeNode("Java Help");
      createNodes(top);
      selectionTree = new JTree(top);
      
      selectionTree.addTreeSelectionListener(new TreeSelectionListener() {
         public void valueChanged(TreeSelectionEvent e) {
            
            DefaultMutableTreeNode node = (DefaultMutableTreeNode)
               selectionTree.getLastSelectedPathComponent();
            
            File f = new File("src/menus/helpMenuTexts/" + node.getUserObject() + ".html");
            if (f.exists()) {
            }
            try{
               editorPane.setPage(f.toURI().toURL());
            } catch(IOException a) {
               System.err.println("couldnt find file");
            }
            
            /* if nothing is selected */ 
            if (node == null) return;
            
            /* retrieve the node that was selected */ 
            Object nodeInfo = node.getUserObject();
            
               /* React to the node selection. */
               
         }
      });
      
      // Editor Panel initialization
      editorPane = new JTextPane();
      editorPane.setEditable(false);
      
      
      // Block to set the label style
      droneerLabel = new JLabel("DRONEER");
      droneerLabel.setForeground(Color.WHITE);
      droneerLabel.setFont(new Font("Monospaced", Font.PLAIN, 50));
      droneerLabel.setBorder(new EmptyBorder(30,0,30,0));
      
      // Create the initialised buttons
      backButton = new DroneerMenuButton("< Back");
      backButtonPanel.add(backButton, BorderLayout.WEST);
      
      // Add the components to an arraylist to quickly set the center alignment
      components.add(droneerLabel);
      components.add(backButton);
      
      
      add(selectionTree, BorderLayout.WEST);
      add(new JScrollPane(editorPane), BorderLayout.CENTER);
      add(backButtonPanel, BorderLayout.SOUTH);
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
   
   /**
    * Creates a tree structure
    * 
    * @param top The tree structure
    */
   
   public void createNodes(DefaultMutableTreeNode top) {
      
      DefaultMutableTreeNode category = null;
      DefaultMutableTreeNode subCategoryOneLevel = null;
      DefaultMutableTreeNode subCategoryTwoLevels = null;
      
      category = new DefaultMutableTreeNode("General Java Help");
      top.add(category);
      
      //original Tutorial
      subCategoryOneLevel = new DefaultMutableTreeNode("Repetition");
      category.add(subCategoryOneLevel);
      
      subCategoryTwoLevels = new DefaultMutableTreeNode("While Loop");
      subCategoryOneLevel.add(subCategoryTwoLevels);
      
      subCategoryTwoLevels = new DefaultMutableTreeNode("For Loop");
      subCategoryOneLevel.add(subCategoryTwoLevels);
      
      subCategoryTwoLevels = new DefaultMutableTreeNode("For Each Loop");
      subCategoryOneLevel.add(subCategoryTwoLevels);
      
      //Tutorial Continued
      subCategoryOneLevel = new DefaultMutableTreeNode("Decision");
      category.add(subCategoryOneLevel);
      
      subCategoryTwoLevels = new DefaultMutableTreeNode("If Statements");
      subCategoryOneLevel.add(subCategoryTwoLevels);
      
      subCategoryOneLevel = new DefaultMutableTreeNode("Elements");
      category.add(subCategoryOneLevel);
      
      subCategoryTwoLevels = new DefaultMutableTreeNode("ArrayLists");
      subCategoryOneLevel.add(subCategoryTwoLevels);
      
      //Swing Tutorial
//      subCategoryOneLevel = new DefaultMutableTreeNode("asd");
//      category.add(subCategoryOneLevel);
      
      //...add more subCategoryOneLevels for programmers...
      
      category = new DefaultMutableTreeNode("DRONEER Methods Help");
      top.add(category);
      
      subCategoryOneLevel = new DefaultMutableTreeNode("move() Method");
      category.add(subCategoryOneLevel);
      
      subCategoryOneLevel = new DefaultMutableTreeNode("turn() Method");
      category.add(subCategoryOneLevel);
      
      subCategoryOneLevel = new DefaultMutableTreeNode("fire() Method");
      category.add(subCategoryOneLevel);
      
      subCategoryOneLevel = new DefaultMutableTreeNode("getHealth() Method");
      category.add(subCategoryOneLevel);
      
      subCategoryOneLevel = new DefaultMutableTreeNode("onScannedDrone() Method");
      category.add(subCategoryOneLevel);
      
      subCategoryOneLevel = new DefaultMutableTreeNode("onHitBorder() Method");
      category.add(subCategoryOneLevel);
      
      subCategoryOneLevel = new DefaultMutableTreeNode("run() Method");
      category.add(subCategoryOneLevel);
   }
   
   public JButton getBackButton() {
      return backButton;
   }
   
}

