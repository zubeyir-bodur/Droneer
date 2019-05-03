package menus;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.beans.*;
import java.util.ArrayList;

public class DroneerMenuButton extends JButton {

   public DroneerMenuButton(String name) {
      
      super(name);
      
      setForeground(Color.BLACK);
      setBackground(Color.WHITE);
      setMargin(new Insets(30,70,30,70));
      setFont(new Font("Monospaced", Font.PLAIN, 20));
      setText(getText().toUpperCase());
   
   }

}