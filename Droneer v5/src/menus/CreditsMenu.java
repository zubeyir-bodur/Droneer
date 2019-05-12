package menus;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

/**
 * Panel for the Credits Screen
 * @author Alp Uneri
 * @version 8.5.19
 */

public class CreditsMenu extends JPanel
{
   // properties
   private DroneerMenuButton backButton;
   private JLabel creditsLabel;
   private JPanel backPanel;
   
   // constructors
   public CreditsMenu() 
   {   
      setLayout( new GridLayout( 7, 3));

      backButton = new DroneerMenuButton("< Back");
      
      add( new JLabel());

      creditsLabel = new JLabel( "<html><font color=\"red\">B</font>aykam Say</html>");
      creditsLabel.setForeground( Color.BLACK);
      creditsLabel.setFont( new Font( "Monospaced", Font.PLAIN, 40));
      creditsLabel.setBorder( new EmptyBorder(10, 0, 10, 0));
      creditsLabel.setAlignmentX( Component.CENTER_ALIGNMENT);
      
      add( creditsLabel);
      
      add( new JLabel());
      add( new JLabel());
      
      creditsLabel = new JLabel( "<html><font color=\"red\">A</font>lp Uneri</html>");
      creditsLabel.setForeground( Color.BLACK);
      creditsLabel.setFont( new Font( "Monospaced", Font.PLAIN, 40));
      creditsLabel.setBorder( new EmptyBorder(10, 0, 10, 0));
      creditsLabel.setAlignmentX( Component.CENTER_ALIGNMENT);
      
      add( creditsLabel);
      
      add( new JLabel());
      add( new JLabel());
      
      creditsLabel = new JLabel( "<html><font color=\"red\">Z</font>ubeyir Bodur</html>");
      creditsLabel.setForeground( Color.BLACK);
      creditsLabel.setFont( new Font( "Monospaced", Font.PLAIN, 40));
      creditsLabel.setBorder( new EmptyBorder(10, 0, 10, 0));
      creditsLabel.setAlignmentX( Component.CENTER_ALIGNMENT);
      
      add( creditsLabel);
      
      add( new JLabel());
      add( new JLabel());
      
      creditsLabel = new JLabel( "<html><font color=\"red\">U</font>gur Erdem Seyfi</html>");
      creditsLabel.setForeground( Color.BLACK);
      creditsLabel.setFont( new Font( "Monospaced", Font.PLAIN, 40));
      creditsLabel.setBorder( new EmptyBorder(10, 0, 10, 0));
      creditsLabel.setAlignmentX( Component.CENTER_ALIGNMENT);
      
      add( creditsLabel);
      
      add( new JLabel());
      add( new JLabel());
      
      creditsLabel = new JLabel( "<html>Ege <font color=\"red\">K</font>aan Gurkan</html>");
      creditsLabel.setForeground( Color.BLACK);
      creditsLabel.setFont( new Font( "Monospaced", Font.PLAIN, 40));
      creditsLabel.setBorder( new EmptyBorder(10, 0, 10, 0));
      creditsLabel.setAlignmentX( Component.CENTER_ALIGNMENT);
      
      add( creditsLabel);
      
      add( new JLabel());
      add( new JLabel());
      
      creditsLabel = new JLabel( "<html><font color=\"red\">A</font>gil Aliyev</html>");
      creditsLabel.setForeground( Color.BLACK);
      creditsLabel.setFont( new Font( "Monospaced", Font.PLAIN, 40));
      creditsLabel.setBorder( new EmptyBorder(10, 0, 10, 0));
      creditsLabel.setAlignmentX( Component.CENTER_ALIGNMENT);
      
      add( creditsLabel);
      
      backButton.setMargin( new Insets( 20, 30, 20, 30));
      
      backPanel = new JPanel();
      backPanel.setLayout( new GridLayout( 3, 3));
      for ( int i = 0; i < 6; i++)
      {
         backPanel.add( new JLabel());
      }
      backPanel.add( backButton);
      backPanel.add( new JLabel());
      backPanel.add( new JLabel());
      
      add( new JLabel());
      add( backPanel);
   }
   
   public JButton getBackButton() {
      return backButton;
   }
}