package drones;

import java.awt.*;
import javax.swing.JFrame;
import examples.*;

/**
 * A JFrame for testing purposes
 * 
 * @author Baykam Say, Alp Uneri
 * @version 11.5.19
 */
public class Battle extends JFrame {

   Board board;
   HealthPanel healthPanel;

   /**
    * Create the JFrame.
    * 
    * @param drone_1 The player drone
    * @param drone_2 The enemy drone
    */
   public Battle(Drone drone_1, Drone drone_2) {

      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setTitle("Droneer");
      board = new Board(drone_1, drone_2);
      healthPanel = new HealthPanel(board.getMyDrone(), board.getEnemyDrone());
      setLayout(new BorderLayout());
      add(healthPanel, BorderLayout.NORTH);
      add(board);

      // pack();
      setExtendedState(JFrame.MAXIMIZED_BOTH);
      setUndecorated(true);

      setLocationRelativeTo(null);
   }

   public Board getBoard() {
      return board;
   }

   public HealthPanel getHealthPanel() {
      return healthPanel;
   }

   /**
    * Create an instance of the Test.
    * 
    * @param args The command line arguments
    */
   public static void main(String[] args) {

      EventQueue.invokeLater(new Runnable() {

         @Override
         public void run() {
            // new Test().setVisible(true);
         }
      });
   }
}
