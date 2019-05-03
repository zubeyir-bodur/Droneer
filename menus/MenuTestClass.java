package menus;

import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;
import java.beans.*;
import java.util.ArrayList;
import javax.swing.UIManager.*;

public class MenuTestClass {
   
   
   static JFrame mainMenuFrame = new JFrame("Main Menu");
   static ArrayList<Menu> menus = new ArrayList<Menu>();
   static ArrayList<JFrame> frames = new ArrayList<JFrame>();
   static JPanel mainPanel = new JPanel();
   static JFrame playMenuFrame = new JFrame("Play Menu");
   static JFrame designMenuFrame = new JFrame("Design Menu");
   static MainMenu mainMenuPanel = new MainMenu(menus);
   static PlayMenu playMenuPanel = new PlayMenu(menus);
   static DesignMenu designMenuPanel = new DesignMenu();
   
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
   
   public static void main(String[] args) {
      
      //******** MAIN MENU PANEL BUTTON ACTIONS
      
      mainMenuPanel.playButton.addActionListener(new ActionListener(){
         
         public void actionPerformed(ActionEvent e) {
            mainMenuFrame.setVisible(false);
            playMenuFrame.setVisible(true);
         }
         
      });
      
      mainMenuPanel.designButton.addActionListener(new ActionListener(){
         
         public void actionPerformed(ActionEvent e) {
            mainMenuFrame.setVisible(false);
            designMenuFrame.setVisible(true);
            designMenuPanel.fileChooser.showOpenDialog(designMenuPanel);
         }
         
      });
      
      mainMenuPanel.exitButton.addActionListener(new ActionListener(){
         
         public void actionPerformed(ActionEvent e) {
            System.exit(0);
         }
         
      });
      
      //******** PLAY MENU PANEL BUTTON ACTIONS
      
      playMenuPanel.storyButton.addActionListener(new ActionListener(){
         
         public void actionPerformed(ActionEvent e) {
            mainMenuFrame.setVisible(true);
            playMenuFrame.setVisible(false);
         }
         
      });
      
      //******** DESIGN MENU PANEL BUTTON ACTIONS
      
      designMenuPanel.backButton.addActionListener(new ActionListener(){
         
         public void actionPerformed(ActionEvent e) {
            mainMenuFrame.setVisible(true);
            designMenuFrame.setVisible(false);
         }
         
      });
      
      frames.add(mainMenuFrame);
      frames.add(playMenuFrame);
      frames.add(designMenuFrame);
      
      for(JFrame f: frames) {
         f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      }
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
      
      
      menus.add(mainMenuPanel);
      menus.add(playMenuPanel);
      
      mainMenuFrame.add(mainPanel);
      
      mainMenuFrame.add(mainMenuPanel);
      playMenuFrame.add(playMenuPanel);
      designMenuFrame.add(designMenuPanel);
      
      for(JFrame f: frames) {
         f.pack();
      }
      
      mainMenuFrame.setVisible(true);
      
   }

}