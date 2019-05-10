package settings;
import javax.swing.*;

public class SettingsTest {
   
   public static void main(String[] args) { 
      JFrame frm = new JFrame();
      frm.setVisible(true);
      Settings stg = new Settings();
      
//      try{
//      BufferedImage img = ImageIO.read(new File("C:\\Users\\aqila\\OneDrive\\Desktop\\droneer\\icons\\icon.jpeg"));
////      ImageIcon icon = new ImageIcon(imgURL); 
////      setIcon(icon);
//      //
//      JLabel background = new JLabel(new ImageIcon(img));
//      frm.setContentPane(background);
//      }catch (IOException exp) {
//                    exp.printStackTrace();
//                }
      frm.add(stg);
      frm.pack();
   }
   
   /* ADD YOUR CODE HERE */
   
}
