package drones;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;

public class HealthPanel extends JPanel {

   private Drone myDrone;
   private Drone enemyDrone;
   private JProgressBar myHealth;
   private JProgressBar enemyHealth;
   private JLabel myHealthLabel;
   private JLabel enemyHealthLabel;

   public HealthPanel(Drone myDrone, Drone enemyDrone) {

      UIManager.put("ProgressBar.selectionForeground", Color.BLACK); // colour of precentage counter on red background
      UIManager.put("ProgressBar.selectionBackground", Color.YELLOW); // colour of percentage counter on black
                                                                      // background
      this.myDrone = myDrone;
      this.enemyDrone = enemyDrone;

      myHealthLabel = new JLabel("My Health: 100", SwingConstants.CENTER);
      enemyHealthLabel = new JLabel("Enemy Health: 100", SwingConstants.CENTER);

      setLayout(new GridLayout(2, 2));

      myHealth = new JProgressBar(0, 100);
      enemyHealth = new JProgressBar(0, 100);

      add(myHealthLabel);
      add(enemyHealthLabel);
      add(myHealth);
      add(enemyHealth);

      updateHealth();
      System.out.println(myHealth.getString());
      myHealth.setForeground(Color.yellow);

      updateHealth();

      setPreferredSize(new Dimension(300, 100));

   }

   public void updateHealth() {

      myHealth.setValue(myDrone.getHealth());
      myHealthLabel.setText("My Health: " + myHealth.getValue());

      enemyHealth.setValue(enemyDrone.getHealth());
      enemyHealthLabel.setText("Enemy Health: " + enemyHealth.getValue());

   }

}