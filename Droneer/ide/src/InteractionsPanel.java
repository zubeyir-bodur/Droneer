import java.awt.*;
import javax.swing.*;

public class InteractionsPanel extends JPanel
{
   private JTextArea information;
   
   public InteractionsPanel( String info)
   {
      setPreferredSize( new Dimension(800, 313) );
      information = new JTextArea(info, 12, 70);
      information.setEditable(false);
      JScrollPane infoPane = new JScrollPane(information);
      add(infoPane);
      Font f = new Font(Font.MONOSPACED, Font.PLAIN, 18 );
      information.setFont(f);
   }
   
   public void update( String info)
   {
      information.setText(info);
   }
}