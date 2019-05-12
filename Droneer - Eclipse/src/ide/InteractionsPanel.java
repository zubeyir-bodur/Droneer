package ide;
import java.awt.*;
import javax.swing.*;

/**
 * Interaction Panel that shows given information
 * @author Zubeyir Bodur
 * @version 1.5.2019
 */
public class InteractionsPanel extends JPanel
{
   private JTextArea information;
   
   /**
    * Creates an uneditable InteractionsPanel containing given info
    * , with size 800 to 313, with font 18 monospaced.
    * @param info initial info about compiler, e.g. Compiler JDK 8.0_191 ready.
    */
   public InteractionsPanel( String info)
   {
      setPreferredSize( new Dimension(400, 200) );
      setLayout( new BorderLayout() );
      information = new JTextArea(info, 20, 30);
      information.setEditable(false);
      JScrollPane infoPane = new JScrollPane(information);
      // infoPane.setPreferredSize( new Dimension(400, 200) );
      add(infoPane, BorderLayout.CENTER);
      information.setFont( new Font( Font.MONOSPACED, Font.PLAIN, 14 ));
   }
   
   /**
    * Updates the current info in the panel
    * @param info to be replaced
    */
   public void update( String info)
   {
      information.setText(info);
   }
}