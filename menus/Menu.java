package menus;

import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;
import java.util.ArrayList;

public abstract class Menu extends JPanel{

   boolean focused = false;
   
   public Menu() {
      setPreferredSize(new Dimension(700, 700));
   }
   
   abstract void setFocused(boolean foc);
   abstract boolean getFocused();

}