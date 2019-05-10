package settings;
import javax.swing.*;
import java.awt.*;

/*
 * @author Agil Aliyev, Alp Üneri
 * @version 8.5.19
 */
public class Settings extends JPanel{
   
   // properties
   JSpinner spinForResolution;
   String[] res;
   int screenHeight, screenWidth;
   JPanel panelForSettingsLabel, panelForResolution;
   JLabel settingsLabel, resolution;
   Color myColor;
   public JButton backButton;
   
   // constructors
   public Settings(){
      
      backButton = new JButton( "Back");
      
      // getting screen size
      screenHeight = (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight();
      screenWidth = (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth();
      //imageicon

      // panels
      panelForSettingsLabel = new JPanel();
      panelForResolution = new JPanel();
      //label settings
      //myColor= new Color(0,0,0, 100);
      settingsLabel = new JLabel("Settings");
      //settingsLabel.setForeground(Color.WHITE);
      //settingsLabel.setBackground(myColor);
      settingsLabel.setOpaque(true);
      // label resolution
      resolution = new JLabel("Resolution:");
      //resolution.setForeground(Color.WHITE);
      //resolution.setBackground(myColor);
      resolution.setOpaque(true);
      // background for  panels etc
      //setBackground(new Color(0,0,0, 0));
      //panelForResolution.setBackground(new Color(0,0,0, 0));
      //panelForSettingsLabel.setBackground(new Color(0,0,0, 0));
      //setBackground(Color.blue);
      
      // layouts
      panelForSettingsLabel.setLayout(new FlowLayout());
      setLayout( new GridLayout( 7, 2));
      // font sizes
      settingsLabel.setFont(new Font("Serif", Font.PLAIN, screenWidth/25));
      resolution.setFont(new Font("Serif", Font.PLAIN, screenWidth/50));
      // resolution string and other stuff
      String[] tmp = {"1280×720","1366×768","1600×900","1920×1080", "2560×1440", "3840×2160"};
      res = tmp;
      spinForResolution = new JSpinner(new SpinnerListModel(res));
      spinForResolution.setPreferredSize(new Dimension(screenWidth/8, screenHeight/25));
      spinForResolution.setBackground(Color.red);
      spinForResolution.setFont(new Font("Serif", Font.PLAIN, screenWidth/50));
      
      // adding 
      panelForSettingsLabel.add(settingsLabel);
      panelForResolution.add(resolution);
      //panelForResolution.setPreferredSize( new Dimension( 200,200));
      panelForResolution.add(spinForResolution);
      add(panelForSettingsLabel);
      add(panelForResolution);
      add( backButton, BorderLayout.SOUTH);
      
      //setPreferredSize( new Dimension( 2000, 2000));
   }
}