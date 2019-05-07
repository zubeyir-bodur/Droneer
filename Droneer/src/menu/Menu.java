package menu;

import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;
import java.util.ArrayList;

/**
 * Abstract class to standardize the menus used in the application
 * @author Ege Kaan Gürkan
 * @version 03/05/2019
 */

public abstract class Menu extends JPanel{

   boolean focused = false;
   
   public Menu() {
      setPreferredSize(new Dimension(700, 700));
   }
   
   abstract void setFocused(boolean foc);
   abstract boolean getFocused();

}