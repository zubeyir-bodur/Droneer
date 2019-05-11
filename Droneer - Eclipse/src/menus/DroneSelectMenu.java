//package menus;
//import java.awt.*;
//import javax.swing.*;
//import javax.swing.border.*;
//import java.util.ArrayList;
//import drones.*;
//
///**
// * Panel for the Drone Selector Screen
// * @author Ege Kaan Gurkan, Alp Uneri
// * @version 11.5.19
// */
//
//public class DroneSelectMenu extends JPanel {
//
//   //public MenuTestClass m = new MenuTestClass(this);
//   //public ArrayList<Menu> menus;
//   //public ArrayList<JComponent> components;
//   //public boolean focused;
//   Drone myDrone;
//   Drone enemyDrone;
//   private JLabel myDroneSelectLabel;
//   private JLabel enemyDroneSelectLabel;
//   private DroneerMenuButton myDroneSelectButton;
//   private DroneerMenuButton enemyDroneSelectButton;
//   private DroneerMenuButton backButton;
//   private DroneerMenuButton playButton;
//   private JFileChooser chooser;
//   
//   public DroneSelectMenu() {
//      
//      //this.menus = menus;
//      
//      //components = new ArrayList<JComponent>();
//      
//      setLayout(new GridLayout( 3, 2));
//      
//      // Block to set the label style
//      myDroneSelectLabel = new JLabel("Choose your drone");
//      myDroneSelectLabel.setForeground(Color.BLACK);
//      myDroneSelectLabel.setFont(new Font("Monospaced", Font.PLAIN, 35));
//      myDroneSelectLabel.setBorder(new EmptyBorder(50,0,70,0));
//      
//      // Block to set the label style
//      enemyDroneSelectLabel = new JLabel("Choose enemy drone");
//      enemyDroneSelectLabel.setForeground(Color.BLACK);
//      enemyDroneSelectLabel.setFont(new Font("Monospaced", Font.PLAIN, 35));
//      enemyDroneSelectLabel.setBorder(new EmptyBorder(50,0,70,0));
//      
//      // Create the initialised buttons
//      myDroneSelectButton = new DroneerMenuButton("Open");
//      enemyDroneSelectButton = new DroneerMenuButton("Open");
//      playButton = new DroneerMenuButton( "Play");
//      
//      myDroneSelectButton.addActionListener( new ActionListener() {
//      
//         public void actionPerformed( ActionEvent e)
//         {
//            int response = chooser.showOpenDialog( null);
//            if ( response == JFileChooser.APPROVE_OPTION)
//            {
//               
//            }
//         }
//      });
//      
//      add( myDroneSelectLabel);
//      add( enemyDroneSelectLabel);
//      add( myDroneSelectButton);
//      add( enemyDroneSelectButton);
//      add( new JLabel());
//      add( playButton);
//   }
//   
//   public DroneerMenuButton getPlayButton()
//   {
//      return playButton;
//   }
//   
////   public Drone getMyDrone() {
////      return myDrone;
////   }
////   
////   public Drone getEnemyDrone() {
////      return enemyDrone;
////   }
//   
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
//   
//}
//
