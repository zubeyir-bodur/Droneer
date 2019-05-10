import drones.*;
import menus.*;
import settings.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

/**
 * Master class for Droneer, combines all other packages for a
 * hopefully functioning application.
 * @author Alp uneri
 * @version 8.5.19
 */
public class DroneerMaster extends JFrame
{
   // properties
   
   //ArrayList to easily make changes to panels and frames
   static ArrayList<menus.Menu> menus = new ArrayList<menus.Menu>();
   static ArrayList<JFrame> frames = new ArrayList<JFrame>();
   
   //all frames
   static JFrame mainMenuFrame = new JFrame("Main Menu");
   static JFrame playMenuFrame = new JFrame("Play Menu");
   static JFrame designMenuFrame = new JFrame("Design Menu");
   static JFrame arenaMenuFrame = new JFrame("Arena Menu");
   static JFrame droneSelectMenuFrame = new JFrame("Select Drones");
   static Test battleFrame = new Test();
   static JFrame settingsFrame = new JFrame();
   static JFrame creditsMenuFrame = new JFrame();
   static JFrame helpMenuFrame = new JFrame();

   //all panels
   static MainMenu mainMenuPanel = new MainMenu();
   static PlayMenu playMenuPanel = new PlayMenu();
   static DesignMenu designMenuPanel = new DesignMenu();
   static ArenaMenu arenaMenuPanel = new ArenaMenu();
   static Settings settingsMenu = new Settings();
   static CreditsMenu creditsMenu = new CreditsMenu();
   static HelpMenu helpMenuPanel = new HelpMenu();
   
   // methods
   
   public static void main( String[] args)
   {      
      //************************************************
      //******** MAIN MENU PANEL BUTTON ACTIONS ********
      //************************************************
      
      // If clicked on the PLAY BUTTON in MAIN MENU
      mainMenuPanel.getPlayButton().addActionListener(new ActionListener(){
         
         public void actionPerformed(ActionEvent e) {
            mainMenuFrame.setVisible(false);
            playMenuFrame.setVisible(true);
         }
         
      });
      
      // If clicked on the DESIGN BUTTON in MAIN MENU
      mainMenuPanel.getDesignButton().addActionListener(new ActionListener(){
         
         public void actionPerformed(ActionEvent e) {
            
            mainMenuFrame.setVisible(false);
            designMenuFrame.setVisible(true);
            
            }
            
         });
         
      // If clicked on the EXIT BUTTON in MAIN MENU
      mainMenuPanel.getExitButton().addActionListener(new ActionListener(){
         
         public void actionPerformed(ActionEvent e) {
            System.exit(0);
         }
         
      });
      
      // If clicked on the HELP BUTTON in MAIN MENU
      mainMenuPanel.getHelpButton().addActionListener(new ActionListener(){
         
         public void actionPerformed(ActionEvent e) {
            mainMenuFrame.setVisible( false);
            helpMenuFrame.setVisible( true);
         }
         
      });
      
      // If clicked on the SETTINGS BUTTON in MAIN MENU
      mainMenuPanel.getSettingsButton().addActionListener(new ActionListener(){
         
         public void actionPerformed(ActionEvent e) {
            mainMenuFrame.setVisible( false);
            settingsFrame.setVisible( true);
         }
         
      });
      
      // If clicked on the CREDITS BUTTON in MAIN MENU
      mainMenuPanel.getCreditsButton().addActionListener(new ActionListener(){
         
         public void actionPerformed(ActionEvent e) {

            mainMenuFrame.setVisible(false);
            creditsMenuFrame.setVisible(true);
         }
         
      });
      
      //************************************************
      //******** PLAY MENU PANEL BUTTON ACTIONS ********
      //************************************************
      
      // If clicked on the ARENA BUTTON in PLAY MENU
      playMenuPanel.getArenaButton().addActionListener(new ActionListener(){
         
         public void actionPerformed(ActionEvent e) {
            arenaMenuFrame.setVisible(true);
            playMenuFrame.setVisible(false);
         }
         
      });
      
      // If clicked on the BACK BUTTON in PLAY MENU
      playMenuPanel.getBackButton().addActionListener(new ActionListener(){
         
         public void actionPerformed(ActionEvent e) {
            mainMenuFrame.setVisible(true);
            playMenuFrame.setVisible(false);
         }
         
      });
      
      //**************************************************
      //******** DESIGN MENU PANEL BUTTON ACTIONS ********
      //**************************************************
      
      // If clicked on BACK BUTTON in PLAY MENU
      designMenuPanel.getBackButton().addActionListener(new ActionListener(){
         
         public void actionPerformed(ActionEvent e) {
            mainMenuFrame.setVisible(true);
            designMenuFrame.setVisible(false);
         }
         
      });
      
      //**************************************************
      //******** ARENA MENU PANEL BUTTON ACTIONS *********
      //**************************************************
      
      // If clicked on the BEGINNER BUTTON in PLAY MENU
      arenaMenuPanel.getBeginnerButton().addActionListener(new ActionListener(){
         
         public void actionPerformed(ActionEvent e) {
            battleFrame.setVisible(true);
            arenaMenuFrame.setVisible(false);
         }
         
      });
      
      // If clicked on the BACK BUTTON in ARENA MENU
      arenaMenuPanel.getBackButton().addActionListener(new ActionListener(){
         
         public void actionPerformed(ActionEvent e) {
            playMenuFrame.setVisible(true);
            arenaMenuFrame.setVisible(false);
         }
         
      });
      
      // If clicked on the SANDBOX BUTTON in ARENA MENU
//      arenaMenuPanel.getSandboxButton().addActionListener(new ActionListener(){
//         
//         public void actionPerformed(ActionEvent e) {
//            droneSelectMenuFrame.setVisible(true);
//            arenaMenuFrame.setVisible(false);
//         }
//         
//      });
      
      //**************************************************
      //******** SETTINGS MENU PANEL BUTTON ACTIONS ******
      //**************************************************
      
      // If clicked on the BACK BUTTON in SETTINGS MENU
      settingsMenu.backButton.addActionListener( new ActionListener()
      {
         public void actionPerformed( ActionEvent e)
         {
            mainMenuFrame.setVisible( true);
            settingsFrame.setVisible( false);
         }
      });
      
      //**************************************************
      //******** CREDITS MENU PANEL BUTTON ACTIONS *******
      //**************************************************
      
      // If clicked on the BACK BUTTON in CREDITS MENU
      creditsMenu.backButton.addActionListener( new ActionListener()
      {
         public void actionPerformed( ActionEvent e)
         {
            mainMenuFrame.setVisible( true);
            creditsMenuFrame.setVisible( false);
         }
      });
      
      //**************************************************
      //******** HELP MENU PANEL BUTTON ACTIONS **********
      //**************************************************
      
      // If clicked on the BACK BUTTON in HELP MENU
      helpMenuPanel.getBackButton().addActionListener( new ActionListener()
      {
         public void actionPerformed( ActionEvent e)
         {
            mainMenuFrame.setVisible( true);
            creditsMenuFrame.setVisible( false);
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
      menus.add(designMenuPanel);
      menus.add(arenaMenuPanel);
      
      //******** ADD THE PANELS TO INDIVIDUAL FRAMES ********
      mainMenuFrame.add(mainMenuPanel);
      playMenuFrame.add(playMenuPanel);
      designMenuFrame.add(designMenuPanel);
      arenaMenuFrame.add(arenaMenuPanel);
      settingsFrame.add( settingsMenu);
      creditsMenuFrame.add( creditsMenu);
      helpMenuFrame.add(helpMenuPanel);
      
      //******** ADD FRAMES TO ARRAYLIST ********
      frames.add(mainMenuFrame);
      frames.add(playMenuFrame);
      frames.add(designMenuFrame);
      frames.add(arenaMenuFrame);
      frames.add(droneSelectMenuFrame);
      frames.add( settingsFrame);
      frames.add( creditsMenuFrame);
      frames.add(helpMenuFrame);
      
      // set default states for frames
      for(JFrame f: frames) {
         f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         f.setExtendedState(JFrame.MAXIMIZED_BOTH); 
         f.setUndecorated(true);
      }
      
      // initialize the application by making the main menu visible
      mainMenuFrame.setVisible(true);
   }
}
