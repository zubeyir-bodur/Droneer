package menus;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.util.ArrayList;
import drones.*;

/**
 * Panel for the Drone Selector Screen
 * @author Ege Kaan Gurkan, Alp Uneri
 * @version 11.5.19
 */

public class DroneSelectMenu extends JPanel {

	//public MenuTestClass m = new MenuTestClass(this);
	//public ArrayList<Menu> menus;
	//public ArrayList<JComponent> components;
	//public boolean focused;
	private DroneerMenuButton myDroneSelectButton;
	private DroneerMenuButton enemyDroneSelectButton;
	private DroneerMenuButton backButton;
	private DroneerMenuButton playButton;
	private JPanel[] phrases;

	public DroneSelectMenu() {

		//this.menus = menus;

		//components = new ArrayList<JComponent>();
		setLayout( new BoxLayout(this, BoxLayout.Y_AXIS));
//		setLayout(new BorderLayout());

		// Block to set the label style
		JLabel myDroneSelectLabel = new JLabel();
		initLabel("Choose Your Drone : ", myDroneSelectLabel, 20);
		JLabel enemyDroneSelectLabel = new JLabel();
		initLabel("Choose Enemy Drone : ", enemyDroneSelectLabel, 20);
		JLabel title = new JLabel();
		initLabel("QUICK BATTLE", title, 35);
		title.setForeground(Color.RED);
		title.setFont(new Font("Monospaced", Font.BOLD, 35));
		JLabel empty = new JLabel();
		initLabel("", empty, 35);

		// Create the initialised buttons
		myDroneSelectButton = new DroneerMenuButton("Open");
		enemyDroneSelectButton = new DroneerMenuButton("Open");
		playButton = new DroneerMenuButton( "Play");
		backButton = new DroneerMenuButton( "< Back");
		
		// Organise the components
		phrases = new JPanel[5];
		for ( int i = 0; i < 5; i++)
		{
			phrases[i] = new JPanel();
		}
		phrases[0].add(title);
		phrases[1].add(myDroneSelectLabel);
		phrases[1].add(myDroneSelectButton);
		phrases[2].setLayout(new FlowLayout() );
		phrases[2].add(enemyDroneSelectLabel);
		phrases[2].add(enemyDroneSelectButton);
		phrases[3].add(empty);
		phrases[4].setLayout(new BorderLayout() );
		phrases[4].add(backButton, BorderLayout.WEST);
		phrases[4].add(playButton, BorderLayout.EAST);
		for ( JPanel p : phrases)
		{
			p.setAlignmentX(Component.CENTER_ALIGNMENT);
			add(p);
		}
//		add( myDroneSelectLabel);
//		add( enemyDroneSelectLabel);
//		add( myDroneSelectButton);
//		add( enemyDroneSelectButton);
		//      add( backButton);
//		add( new JLabel());
//		add( playButton);
	}

	public DroneerMenuButton getPlayButton()
	{
		return playButton;
	}
	
	public DroneerMenuButton getBackButton()
	{
		return backButton;
	}
	//   /**
	//    * Sets the focused variable to a given value
	//    * @param a The boolean value to set focused to 
	//    */
	//   
	//   public void setFocused(boolean a) {
	//      focused = a;
	//   }
	//   
	//   /**
	//    * Returns whether the panel is focused or not
	//    */
	//   
	//   public boolean getFocused() {
	//      return focused;
	//   }

	public DroneerMenuButton getMyDroneSelectButton()
	{
		return myDroneSelectButton;
	}

	public DroneerMenuButton getEnemyDroneSelectButton()
	{
		return enemyDroneSelectButton;
	}
	
	public void setMyDroneSelectButton(String s)
	{
		myDroneSelectButton.setText(s);
	}

	public void setEnemyDroneSelectButton(String s)
	{
		enemyDroneSelectButton.setText(s);
	}
	
	private void initLabel(String s, JLabel l, int fontSize)
	{
		l.setText(s);
		l.setForeground(Color.BLACK);
		l.setFont(new Font("Monospaced", Font.PLAIN, fontSize));
		l.setBorder(new EmptyBorder(50,0,70,0));
	}
	
	public void printComponents()
	{
		for ( JPanel p : phrases)
			{
				for ( Component c : p.getComponents() )
				{
					System.out.println(c.getHeight());
				}
			}
	}
}

