package menus;

import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;
import java.beans.*;
import java.util.ArrayList;
import javax.swing.UIManager.*;
import java.io.*;

public class MenuTestClass {
   
   
   static ArrayList<Menu> menus = new ArrayList<Menu>();
   static ArrayList<JFrame> frames = new ArrayList<JFrame>();
   
   static JFrame mainMenuFrame = new JFrame("Main Menu");
   static JFrame playMenuFrame = new JFrame("Play Menu");
   static JFrame designMenuFrame = new JFrame("Design Menu");
   static JFrame arenaMenuFrame = new JFrame("Arena Menu");
      
   static MainMenu mainMenuPanel = new MainMenu();
   static PlayMenu playMenuPanel = new PlayMenu();
   static DesignMenu designMenuPanel = new DesignMenu();
   static ArenaMenu arenaMenuPanel = new ArenaMenu();
   
   public void testForFocus() {
      
   }
   public MenuTestClass() {
   }
   public MenuTestClass(MainMenu mainMenu) {
      mainMenuPanel = mainMenu;
   }
   public MenuTestClass(PlayMenu playMenu) {
      playMenuPanel = playMenu;
   }
   public MenuTestClass(DesignMenu designMenu) {
      designMenuPanel = designMenu;
   }
   public MenuTestClass(ArenaMenu arenaMenu) {
      arenaMenuPanel = arenaMenu;
   }
   
   public static void main(String[] args) {
      
      //************************************************
      //******** MAIN MENU PANEL BUTTON ACTIONS ********
      //************************************************
      
      // If clicked on the PLAY BUTTON in MAIN MENU
      mainMenuPanel.playButton.addActionListener(new ActionListener(){
         
         public void actionPerformed(ActionEvent e) {
            // Set the mainMenuFrame to be invisible and make playMenuFrame visible
            mainMenuFrame.setVisible(false);
            playMenuFrame.setVisible(true);
         }
         
      });
      
      // If clicked on the DESIGN BUTTON in MAIN MENU
      mainMenuPanel.designButton.addActionListener(new ActionListener(){
         
         public void actionPerformed(ActionEvent e) {
            
            mainMenuFrame.setVisible(false);
            designMenuFrame.setVisible(true);
            
            designMenuPanel.fileChooser.showOpenDialog(designMenuPanel);
            int returnVal = designMenuPanel.fileChooser.showOpenDialog(designMenuPanel);
            if (returnVal == JFileChooser.APPROVE_OPTION){
               File f = designMenuPanel.fileChooser.getSelectedFile();
               Idk c = new Idk(f); // "Idk" To be replaced by the class accepting the file
               c.processFile();
            }
            
         }
         
      });
      
      // If clicked on the EXIT BUTTON in MAIN MENU
      mainMenuPanel.exitButton.addActionListener(new ActionListener(){
         
         public void actionPerformed(ActionEvent e) {
            System.exit(0);
         }
         
      });
      
      //************************************************
      //******** PLAY MENU PANEL BUTTON ACTIONS ********
      //************************************************
      
      // If clicked on the STORY BUTTON in PLAY MENU
      playMenuPanel.storyButton.addActionListener(new ActionListener(){
         
         public void actionPerformed(ActionEvent e) {
            //ig do smth here idk
         }
         
      });
      
      // If clicked on the ARENA BUTTON in PLAY MENU
      playMenuPanel.arenaButton.addActionListener(new ActionListener(){
         
         public void actionPerformed(ActionEvent e) {
            arenaMenuFrame.setVisible(true);
            playMenuFrame.setVisible(false);
         }
         
      });
      
      // If clicked on the BACK BUTTON in PLAY MENU
      playMenuPanel.backButton.addActionListener(new ActionListener(){
         
         public void actionPerformed(ActionEvent e) {
            mainMenuFrame.setVisible(true);
            playMenuFrame.setVisible(false);
         }
         
      });
      
      //**************************************************
      //******** DESIGN MENU PANEL BUTTON ACTIONS ********
      //**************************************************
      
      designMenuPanel.backButton.addActionListener(new ActionListener(){
         
         public void actionPerformed(ActionEvent e) {
            mainMenuFrame.setVisible(true);
            designMenuFrame.setVisible(false);
         }
         
      });
      
      //**************************************************
      //******** ARENA MENU PANEL BUTTON ACTIONS *********
      //**************************************************
      
      // If clicked on the BACK BUTTON in ARENA MENU
      arenaMenuPanel.backButton.addActionListener(new ActionListener(){
         
         public void actionPerformed(ActionEvent e) {
            playMenuFrame.setVisible(true);
            arenaMenuFrame.setVisible(false);
         }
         
      });
      
      //******** UNCOMMENT IF NIMBUS IS WANTED TO BE USED ********
      
//      try {
//         for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
//            if ("Nimbus".equals(info.getName())) {
//               UIManager.setLookAndFeel(info.getClassName());
//               break;
//            }
//         }
//      } catch (Exception e) {
//         // If Nimbus is not available, you can set the GUI to another look and feel.
//      }
      
      
      //******** ADD PANELS TO AN ARRAYLIST ********
      menus.add(mainMenuPanel);
      menus.add(playMenuPanel);
      menus.add(arenaMenuPanel);
      
      
      //******** ADD THE PANELS TO INDIVIDUAL FRAMES ********
      mainMenuFrame.add(mainMenuPanel);
      playMenuFrame.add(playMenuPanel);
      designMenuFrame.add(designMenuPanel);
      arenaMenuFrame.add(arenaMenuPanel);
      
      //******** ADD FRAMES TO ARRAYLIST ********
      frames.add(mainMenuFrame);
      frames.add(playMenuFrame);
      frames.add(designMenuFrame);
      frames.add(arenaMenuFrame);
      
      for(JFrame f: frames) {
         f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         f.pack();
      }
      
      mainMenuFrame.setVisible(true);
      
   }

}