import java.awt.*;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.tools.*;
import java.awt.event.*;
import java.io.*;

/*
 * Simle Editor class for writing code with several features
 * @author - Uður Erdem Seyfi
 * @version - 04.05.2019
 */
public class Editor extends JFrame{
    JMenuBar menuBar;
    JToolBar toolBar;
    JButton save, saveAs, open, compile, run, undo, redo, help;
    String filename, dir;
    
    JScrollPane textPane;
    JTextArea text;
    
    InteractionsPanel interactionsPanel;
    
    JFileChooser fileChooser;
    FileNameExtensionFilter fileNameFilter;
    
    boolean hasChanged; // states that whether the user implemented anything since the last change or not
    
    /*
     * Default constructor
     */
    public Editor(){
        setPreferredSize( new Dimension(800,600) );
        setLayout( new BorderLayout() );
        
        filename = "";
        dir = "";
        
        hasChanged = false;
        
        fileChooser = new JFileChooser();
        fileNameFilter = new FileNameExtensionFilter("Java files", "java");
        fileChooser.setFileFilter( fileNameFilter);
        
        // creating menu bar
        menuBar = new JMenuBar();
        toolBar = new JToolBar();
        toolBar.setFloatable( false);
        
        // creating menus for menu bar
        save = new JButton("Save");
        saveAs = new JButton("Save as");
        open = new JButton("Open");
        compile = new JButton("Compile");
        run = new JButton("Run");
        undo = new JButton("Undo");
        redo = new JButton("Redo");
        help = new JButton("Help");
        
        // adding buttons to toolbar
        toolBar.add( save);
        toolBar.add( saveAs);
        toolBar.add( open);
        toolBar.add( compile);
        toolBar.add( run);
        toolBar.add( undo);
        toolBar.add( redo);
        toolBar.add( help);
        
        // adding listeners to buttons
        open.addActionListener( new OpenListener() );
        save.addActionListener( new SaveListener() );
        saveAs.addActionListener( new SaveAsListener() );
        compile.addActionListener( new CompileListener() );
        
        this.add(BorderLayout.NORTH , toolBar);
        
        text = new JTextArea(20, 30);
        text.setFont( new Font( Font.MONOSPACED, Font.PLAIN, 14 ));
        textPane = new JScrollPane(text);
        
        textPane.setPreferredSize( new Dimension(400,200) );
        this.add(BorderLayout.CENTER ,textPane);
        
        interactionsPanel = new InteractionsPanel( "Welcome to Droneer. Current file directory is : " + dir + "\\" + filename);
        this.add(BorderLayout.SOUTH, interactionsPanel);
        
        
        
    }
    
    /*
     * Second constructor : supposed to create a coding template with given droneNome
     * @param droneName - droneName
     */
    public Editor(String droneName){
        this();
        this.filename = droneName;
        // this.dir = "";
    }
    
    
    
    /*
     * Action listener for open button
     * Opens a file
     */
    class OpenListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            
            // Demonstrate "Open" dialog:
            int response = fileChooser.showOpenDialog( Editor.this);
            if (response == JFileChooser.APPROVE_OPTION) {
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                
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
                    
                    // Set the text 
                    text.setText(fileText); 
                    
                    filename = fileChooser.getSelectedFile().getName();
                    dir = fileChooser.getCurrentDirectory().toString();
                    
                    setTitle( dir + "\\" + filename);
                } catch (Exception evt){
                    JOptionPane.showMessageDialog(null, evt.getMessage());
                }
            }
            if (response == JFileChooser.CANCEL_OPTION) {
                filename = "You pressed cancel";
                dir = "";
            }
        }
    }
    
    /*
     * Action listener for save button
     * writes the text info to the saved file
     */
    class SaveListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            // If a file has not been selected yet, then call saveAs action listener
            if( filename.equals("") ){
                saveAs.doClick();
            } else{
                // Create a file writer 
                File file = new File(dir + "\\" + filename);
                
                try { 
                    // Create a file writer 
                    FileWriter writer = new FileWriter(file, false); 
                    
                    // Create buffered writer to write 
                    BufferedWriter bWriter = new BufferedWriter(writer); 
                    
                    // Write the text
                    bWriter.write(text.getText()); 
                    
                    bWriter.flush(); 
                    bWriter.close(); 
                    
                    JOptionPane.showMessageDialog(null, "File saved!");
                } 
                catch (Exception evt) { 
                    JOptionPane.showMessageDialog(null, evt.getMessage()); 
                }
                
                setTitle( dir + "\\" + filename);
            }
        }
    }
    
    /*
     * Action listener for saveAs button
     * writes the text info to the saved file
     */
    class SaveAsListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            int response = fileChooser.showSaveDialog(null); 
            
            if (response == JFileChooser.APPROVE_OPTION) { 
                
                // Set the label to the path of the selected directory 
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                
                // Get the choosen filename and the direction of it
                filename = fileChooser.getSelectedFile().getName();
                dir = fileChooser.getCurrentDirectory().toString();
                
                setTitle( dir + "\\" + filename);
                
                try { 
                    // Create a file writer 
                    FileWriter writer = new FileWriter(file, false); 
                    
                    // Create buffered writer to write 
                    BufferedWriter bWriter = new BufferedWriter(writer); 
                    
                    // Write the text
                    bWriter.write(text.getText()); 
                    
                    bWriter.flush(); 
                    bWriter.close(); 
                    
                    JOptionPane.showMessageDialog(null, "File saved!");
                } 
                catch (Exception evt) { 
                    JOptionPane.showMessageDialog(null, evt.getMessage()); 
                }
            } 
        }
    }
    
    /*
     * Action listener for the compile button
     * Compiles the current file
     */
    class CompileListener implements ActionListener{
         public void actionPerformed(ActionEvent e){
             if( !dir.equals("") ){
                 DroneCompiler compiler = new DroneCompiler();
                 try{
                     boolean success = compiler.compile( dir+"\\"+filename);
                     if( success){
                         interactionsPanel.update("Compilation successfull!");
                     } else{
                         interactionsPanel.update("Compilation errors found : \n" + compiler.getDiagnosticsInfo() );
                     }
                 } catch(Exception evt){
                     
                 }
             } else{
                 JOptionPane.showMessageDialog(null, "You must first open a java file in order to compile it.");
             }
        }
    }
}