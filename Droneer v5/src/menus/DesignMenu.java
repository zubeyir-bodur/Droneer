package menus;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.util.ArrayList;
import ide.*;

/**
 * Panel for the Design Screen
 * 
 * @author Ege Kaan Gurkan, Alp Uneri
 * @version 11.5.19
 */

public class DesignMenu extends JPanel {

   private DroneerMenuButton backButton;
   private ArrayList<JComponent> components;
   private JPanel textPanel;
   private JPanel backPanel;
   private Editor editor;
   private JLabel explainLabel2;

   /**
    * Creates a JFileChooser and displays it with the given directory
    */
   public DesignMenu() {

      setLayout(new BorderLayout());

      setVisible(true);
      backButton = new DroneerMenuButton("< Back");
      textPanel = new JPanel();
      backPanel = new JPanel();
      editor = new Editor();

      explainLabel2 = new JLabel("Open the drone you'd like to edit or start from scratch.");
      explainLabel2.setForeground(Color.BLACK);
      explainLabel2.setFont(new Font("Monospaced", Font.PLAIN, 30));
      explainLabel2.setBorder(new EmptyBorder(10, 0, 10, 0));
      explainLabel2.setAlignmentX(Component.CENTER_ALIGNMENT);

      textPanel.setLayout(new BorderLayout());
      backPanel.setLayout(new BorderLayout());
      textPanel.add(explainLabel2, BorderLayout.NORTH);

//      backPanel.setLayout(new GridLayout(3,3));
//      for(int i = 0; i < 6; i++) {
//         backPanel.add(new JLabel());
//      }
//      backButton.setMargin(new Insets(20,30,20,30));

      components = new ArrayList<JComponent>();
      components.add(textPanel);
      components.add(explainLabel2);
      components.add(editor);

//      for(JComponent c: components) {
//         c.setAlignmentX(Component.CENTER_ALIGNMENT);
//      }

      add(textPanel, BorderLayout.NORTH);
      add(editor, BorderLayout.CENTER);
      backPanel.add(backButton, BorderLayout.WEST);
      add(backPanel, BorderLayout.SOUTH);

//      add(new JLabel());
//      add(explainLabel, BorderLayout.NORTH);
//      add(new JLabel());
//      add(backButton, BorderLayout.WEST);

   }

   public JButton getBackButton() {
      return backButton;
   }

   public Editor getEditor() {
      return editor;
   }
}