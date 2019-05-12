import drones.*;
import menus.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.io.*;

/**
 * Master class for Droneer, combines all other packages for a
 * hopefully functioning application.
 * @author Ege Kaan Gurkan, Alp Uneri
 * @version 11.5.19
 */
public class DroneerMaster extends JFrame
{
	// properties

	static Timer timer;

	//ArrayList to easily make changes
	static ArrayList<JFrame> frames = new ArrayList<JFrame>();

	//all frames
	static JFrame mainMenuFrame = new JFrame();
	static JFrame playMenuFrame = new JFrame();
	static JFrame designMenuFrame = new JFrame();
	static JFrame arenaMenuFrame = new JFrame();
	static JFrame settingsFrame = new JFrame();
	static JFrame creditsMenuFrame = new JFrame();
	static JFrame helpMenuFrame = new JFrame();
	static JFrame escapeMenuFrame = new JFrame();
	static JFrame wonFrame = new JFrame();
	static JFrame lostFrame = new JFrame();
	static Test battleFrame;
	static JFrame droneSelectMenuFrame = new JFrame();

	//all panels
	static MainMenu mainMenuPanel = new MainMenu();
	static DesignMenu designMenuPanel = new DesignMenu();
	static CreditsMenu creditsMenu = new CreditsMenu();
	static HelpMenu helpMenuPanel = new HelpMenu();
	static EscapeMenu escapeMenu = new EscapeMenu();
	static WinMenu winMenu = new WinMenu();
	static LoseMenu loseMenu = new LoseMenu();
	static DroneSelectMenu droneSelectMenu = new DroneSelectMenu();

	// drones to be runned
	static String myDroneName, enemyDroneName;
	static boolean isComingFromEscape;

	// methods

	public static void main( String[] args)
	{      
		timer = new Timer( 150, new ActionListener() {

			public void actionPerformed( ActionEvent e)
			{
				battleFrame.getHealthPanel().updateHealth();
				if ( battleFrame.getBoard().getGameOver())
				{
					if ( battleFrame.getBoard().getLost())
					{
						timer.stop();
						droneSelectMenu.setMyDroneSelectButton("Open");
						droneSelectMenu.setEnemyDroneSelectButton("Open");
						battleFrame.setVisible( false);
						lostFrame.setVisible( true);
					}
					else
					{
						timer.stop();
						droneSelectMenu.setMyDroneSelectButton("Open");
						droneSelectMenu.setEnemyDroneSelectButton("Open");
						battleFrame.setVisible( false);
						wonFrame.setVisible( true);
					}
				}
			}
		});

		//************************************************
		//******** MAIN MENU PANEL BUTTON ACTIONS ********
		//************************************************

		// If clicked on the PLAY BUTTON in MAIN MENU
		mainMenuPanel.getPlayButton().addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				
				mainMenuFrame.setVisible(false);
				droneSelectMenuFrame.setVisible(true);
			}
		});
		
		//**************************************************
		//**** DRONE SELECT MENU PANEL BUTTON ACTIONS ******
		//**************************************************
		
		// If choose my drone is selected, then do these
		droneSelectMenu.getMyDroneSelectButton().addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setCurrentDirectory(new File("src\\examples"));
				int response = fileChooser.showOpenDialog( null);
				if ( response == JFileChooser.APPROVE_OPTION)
				{
					System.out.println(fileChooser.getName(fileChooser.getSelectedFile()));
					myDroneName = fileChooser.getName(fileChooser.getSelectedFile());
					myDroneName = myDroneName.substring(0, myDroneName.length() - 5);
					droneSelectMenu.setMyDroneSelectButton(myDroneName);
					System.out.println(myDroneName);
				}
			}
		});
		
		// If choose enemy drone is selected, then do these
		droneSelectMenu.getEnemyDroneSelectButton().addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setCurrentDirectory(new File("src\\examples"));
				int response = fileChooser.showOpenDialog( null);
				if ( response == JFileChooser.APPROVE_OPTION)
				{
					System.out.println(fileChooser.getName(fileChooser.getSelectedFile()));
					enemyDroneName = fileChooser.getName(fileChooser.getSelectedFile());
					enemyDroneName = enemyDroneName.substring(0, enemyDroneName.length() - 5);
					droneSelectMenu.setEnemyDroneSelectButton(enemyDroneName);
					System.out.println(enemyDroneName);
				}
			}
		});
		
		// If play is selected, then do these
		droneSelectMenu.getPlayButton().addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				System.out.println(myDroneName + " " + enemyDroneName);
				if ( myDroneName == null )
					JOptionPane.showMessageDialog(null, "Please select your drone.",
							"Drone Not Selected", JOptionPane.WARNING_MESSAGE);
				else if ( enemyDroneName == null )
					JOptionPane.showMessageDialog(null, "Please select enemy drone.",
							"Drone Not Selected", JOptionPane.WARNING_MESSAGE);
				else
				{
					BoardUpdater.update(myDroneName, enemyDroneName);
					battleFrame = new Test();
					timer.start();

					battleFrame.getBoard().addKeyListener( new KeyListener() {

						public void keyPressed( KeyEvent e)
						{
							if ( e.getKeyCode() == KeyEvent.VK_ESCAPE)
							{
								System.out.println( "escape pressed");
								battleFrame.getBoard().getMyThread().suspend();
								battleFrame.getBoard().getEnemyThread().suspend();
								battleFrame.getBoard().getTimer().stop();
								battleFrame.setVisible( false);
								escapeMenuFrame.setVisible( true);
							}
						}
						public void keyReleased( KeyEvent e) {}
						public void keyTyped( KeyEvent e) {}
					});

					battleFrame.setVisible(true);
				}
			}
		});
		
		// If back is selected, do these
		droneSelectMenu.getBackButton().addActionListener(new ActionListener() {
			public void actionPerformed( ActionEvent e)
			{
				mainMenuFrame.setVisible(true);
				droneSelectMenuFrame.setVisible(false);
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
				isComingFromEscape = false;
				helpMenuFrame.setVisible( true);
			}

		});

		// If clicked on the CREDITS BUTTON in MAIN MENU
		mainMenuPanel.getCreditsButton().addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {

				mainMenuFrame.setVisible(false);
				creditsMenuFrame.setVisible(true);
			}

		});

		//**************************************************
		//******** DESIGN MENU PANEL BUTTON ACTIONS ********
		//**************************************************

		// If clicked on BACK BUTTON in DESIGN MENU
		designMenuPanel.getBackButton().addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				mainMenuFrame.setVisible(true);
				designMenuFrame.setVisible(false);
			}

		});

		//**************************************************
		//******** CREDITS MENU PANEL BUTTON ACTIONS *******
		//**************************************************

		// If clicked on the BACK BUTTON in CREDITS MENU
		creditsMenu.getBackButton().addActionListener( new ActionListener()
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
				if ( isComingFromEscape)
				{
					helpMenuFrame.setVisible(false);
					escapeMenuFrame.setVisible(true);
				}
				else
				{
					mainMenuFrame.setVisible( true);
					helpMenuFrame.setVisible( false);
				}
			}
		});

		//**************************************************
		//******** ESCAPE MENU PANEL BUTTON ACTIONS **********
		//**************************************************

		// If clicked on the RESUME BUTTON in ESCAPE MENU
		escapeMenu.getResumeButton().addActionListener( new ActionListener()
		{
			public void actionPerformed( ActionEvent e)
			{
				battleFrame.setVisible( true);
				battleFrame.getBoard().getMyThread().resume();
				battleFrame.getBoard().getEnemyThread().resume();
				battleFrame.getBoard().getTimer().start();
				escapeMenuFrame.setVisible( false);
			}
		});

		// If clicked on the HELP BUTTON in ESCAPE MENU
		escapeMenu.getHelpButton().addActionListener( new ActionListener()
		{
			public void actionPerformed( ActionEvent e)
			{
				helpMenuFrame.setVisible( true);
				isComingFromEscape = true;
				escapeMenuFrame.setVisible( false);
			}
		});

		// If clicked on the MAIN MENU BUTTON in ESCAPE MENU
		escapeMenu.getMainMenuButton().addActionListener( new ActionListener()
		{
			public void actionPerformed( ActionEvent e)
			{
				mainMenuFrame.setVisible( true);
				escapeMenuFrame.setVisible( false);
			}
		});

		//**************************************************
		//******** WIN MENU PANEL BUTTON ACTIONS ********
		//**************************************************

		// If clicked on MAIN MENU BUTTON in WIN MENU
		winMenu.getMainMenuButton().addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				mainMenuFrame.setVisible(true);
				wonFrame.setVisible(false);
			}

		});

		//**************************************************
		//******** LOSE MENU PANEL BUTTON ACTIONS ********
		//**************************************************

		// If clicked on MAIN MENU BUTTON in LOSE MENU
		loseMenu.getMainMenuButton().addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				mainMenuFrame.setVisible(true);
				lostFrame.setVisible(false);
			}

		});

		//      
		
		//******** UNCOMMENT IF NIMBUS IS WANTED TO BE USED ********

//		try {
//			for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
//				if ("Nimbus".equals(info.getName())) {
//					UIManager.setLookAndFeel(info.getClassName());
//					break;
//				}
//			}
//		} catch (Exception e) {
//			// If Nimbus is not available, you can set the GUI to another look and feel.
//		}

		//******** ADD THE PANELS TO INDIVIDUAL FRAMES ********
		mainMenuFrame.add(mainMenuPanel);
		designMenuFrame.add(designMenuPanel);
		creditsMenuFrame.add( creditsMenu);
		helpMenuFrame.add(helpMenuPanel);
		escapeMenuFrame.add( escapeMenu);
		wonFrame.add( winMenu);
		lostFrame.add( loseMenu);
		droneSelectMenuFrame.add( droneSelectMenu);

		//******** ADD FRAMES TO ARRAYLIST ********
		frames.add(mainMenuFrame);
		frames.add(designMenuFrame);
		frames.add( creditsMenuFrame);
		frames.add(helpMenuFrame);
		frames.add( escapeMenuFrame);
		frames.add( wonFrame);
		frames.add( lostFrame);
		frames.add( droneSelectMenuFrame);

		// set default states for frames
		for(JFrame f: frames) 
		{
			f.setExtendedState(JFrame.MAXIMIZED_BOTH); 
			f.setUndecorated(true);
		}

		// initialize the application by making the main menu visible
		mainMenuFrame.setVisible(true);
	}
}