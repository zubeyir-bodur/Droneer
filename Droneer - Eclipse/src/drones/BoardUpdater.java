package drones;

import java.io.*;
import java.util.Scanner;
import ide.DroneCompiler;


/*
 * @author - Uður Erdem Seyfi
 * @version - 11.05.2019
 */

public class BoardUpdater{
    /*
     * Method that updates the Board.java code itself
     * @param droneName1 - name of the player's drone
     * @param droneName2 - name of the enemy's drone
     */
    public static void update(String droneName1, String droneName2){
        String updatabeBoardPath = System.getProperty("user.dir")+"\\src\\drones\\UpdatableBoard.java";
        File data = new File( updatabeBoardPath);
        try { 
            System.out.println( data.getCanonicalPath() );
            FileWriter writer = new FileWriter( data, false); 
            BufferedWriter bWriter = new BufferedWriter( writer); 
            String codeString = readFile(System.getProperty("user.dir")+"\\src\\drones\\"+"UpdatableBoardCode.txt");
            codeString = codeString.replace("super(...)", "super(new "+droneName1+"(100,100), new " +droneName2+"(100,100))");
            bWriter.write( codeString); 
            bWriter.flush(); 
            bWriter.close();
            
            System.out.println( codeString);
            DroneCompiler compiler = new DroneCompiler();
            String dronesClassesPath = new File(System.getProperty("user.dir")+"\\bin\\drones\\").getCanonicalPath();
            System.out.println(dronesClassesPath);
            
            compiler.compile(updatabeBoardPath, dronesClassesPath);
            System.out.println( compiler.getDiagnosticsInfo() );
        } catch (Exception exc) {
            System.out.println( exc.toString() );
        }   
    }
    
    /*
     * Method that 
     * 
     */
    private static String readFile(String pathname) throws IOException {
        File file = new File(pathname);
        try{
            // String 
            String fileText = "", line = ""; 
            
            // File reader 
            FileReader fileReader = new FileReader(file); 
            // Buffered reader 
            BufferedReader bufferedReader = new BufferedReader(fileReader); 
            
            // Initilize line
            line = bufferedReader.readLine(); 
            // Take the input from the file 
            while (line != null) { 
                fileText = fileText + line + "\n"; 
                line = bufferedReader.readLine(); 
            } 
            
            return fileText;
        } catch (Exception exc){
            System.out.println(exc.getMessage());
            return null;
        }
       
    }
}