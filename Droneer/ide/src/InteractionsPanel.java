import java.awt.Dimension;
import javax.swing.*;

public class InteractionsPanel extends JPanel
{
   private JLabel information;
   
   public InteractionsPanel( String info)
   {
      information = new JLabel(info);
      information.setPreferredSize( new Dimension(info.length() * 10, info.length() / 10));
   }
   
   public void update( String info)
   {
      information.setText(info);
      information.setPreferredSize( new Dimension(info.length() * 10, info.length() / 10));
   }
}