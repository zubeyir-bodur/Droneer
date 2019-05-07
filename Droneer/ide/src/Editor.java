package src.ide;

import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.*;
import java.io.*;

/*
 * Simple Editor class for writing code with several features
 * @author - Uğur Erdem Seyfi, Zübeyir Bodur
 * @version - 07.05.2019
 */
public class Editor extends JFrame
{
    JMenuBar menuBar; // will be added
    JToolBar toolBar;
    JButton save, saveAs, open, compile, run, undo, redo, help;
    String filename, dir;
    
    JScrollPane textPane;
    JTextArea text;
    
    InteractionsPanel interactionsPanel;
    
    JFileChooser fileChooser;
    FileNameExtensionFilter fileNameFilter;
    
    boolean hasChanged, dontShow; // states if the user implemented something but did not save it
                                  // states whether user wants to see the unsaved message warning again 
    
    /*
     * Default constructor
     */
    public Editor()
    {
        setPreferredSize( new Dimension(800,600) );
        setLayout( new BorderLayout() );
        setTitle( "(Untitled)" );
        
        filename = "";
        dir = "";
        hasChanged = false;
        dontShow = Boolean.parseBoolean( getData("dontshow.txt") );
        
        fileChooser = new JFileChooser();
        // Set the default directory, as where user left
        if ( !getData("directory.txt").equals("") )
            fileChooser.setCurrentDirectory( new File(getData("directory.txt") ) );
        
        fileNameFilter = new FileNameExtensionFilter("Java files", "java");
        fileChooser.setFileFilter( fileNameFilter);
        
        // creating menu bar
        menuBar = new JMenuBar();
        toolBar = new JToolBar();
        toolBar.setFloatable( false);
        
        // creating menus for menu bar
        save    = new JButton("Save");
        saveAs  = new JButton("Save as");
        open    = new JButton("Open");
        compile = new JButton("Compile");
        run     = new JButton("Run");
        undo    = new JButton("Undo");
        redo    = new JButton("Redo");
        help    = new JButton("Help");
        
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
        TextLineNumber textLineNumber = new TextLineNumber( text);
        textPane.setRowHeaderView( textLineNumber);
        
        textPane.setPreferredSize( new Dimension(400,200) );
        this.add(BorderLayout.CENTER ,textPane);
        
        text.getDocument().addDocumentListener(new ChangeListener() );
        interactionsPanel = new InteractionsPanel( "Welcome to Droneer. Current file directory is : " 
                                                      + dir + "\\" + filename);
        this.add(BorderLayout.SOUTH, interactionsPanel);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    /*
     * Second constructor : supposed to create a coding template with given droneNome
     * @param droneName - droneName
     */
    public Editor(String droneName)
    {
        this();
        this.filename = droneName;
        // this.dir = "";
    }
    
    private String getData( String filename) 
    {
        try {
            // Check the file in the specified root and read it.
            FileReader fileReader =  new FileReader(filename);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String soFar = "", line;
            int lineCount = 0;
            while( ( line = bufferedReader.readLine() ) != null)
            {
            	lineCount++;
            	if ( lineCount == 1 )
            		soFar = soFar + line;
            	else
            		soFar = soFar + line + "\n";
            }
            if ( lineCount > 1)
            	soFar = soFar.substring( soFar.length() - 2);
            
            bufferedReader.close();
            return soFar;
        } catch (Exception exc) {
        	JOptionPane.showMessageDialog(null, exc.getMessage());
            return "";
        }
    }
    
    private void saveDataAs( String dataS, String filename) 
    {
        File data = new File( filename);
        try { 
            FileWriter writer = new FileWriter( data, false); 
            BufferedWriter bWriter = new BufferedWriter( writer); 
            bWriter.write( dataS); 
            bWriter.flush(); 
            bWriter.close(); 
        } catch (Exception exc) {
        	JOptionPane.showMessageDialog(null, exc.getMessage());
        }
    }
    
    
    /*
     * Action listener for open button
     * Opens a file
     */
    class OpenListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            // Demonstrate "Open" dialog:
            int response = fileChooser.showOpenDialog( Editor.this);
            if (response == JFileChooser.APPROVE_OPTION) 
            {
                saveDataAs(fileChooser.getCurrentDirectory() + "", "directory.txt");
                text.setText( getData( fileChooser.getSelectedFile().getAbsolutePath() ) );

                // Set the text to what is read from the file and update info
                filename = fileChooser.getSelectedFile().getName();
                dir = fileChooser.getCurrentDirectory() + "";
                setTitle( dir + "\\" + filename); 
                hasChanged = false;
            }
            else if ( response == JFileChooser.CANCEL_OPTION )
            {
                filename = "";
                dir = "";
            }
        }
    }
    
    /*
     * Action listener for save button
     * writes the text info to the saved file
     */
    class SaveListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            // If a file has not been selected yet, then call saveAs action listener
            if( filename.equals("") )
                saveAs.doClick();
            
            else
            {   // Create a file writer
            	saveDataAs(text.getText(), dir + "\\" + filename);
            	hasChanged = false;
            	save.setEnabled(false);
            	setTitle( dir + "\\" + filename);
            }
        }
    }
    
    /*
     * Action listener for saveAs button
     * writes the text info to the saved file
     */
    class SaveAsListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            int response = fileChooser.showSaveDialog(null); 
            if ( response == JFileChooser.APPROVE_OPTION ) 
            {
                // Set the label, file name and directory properties, then save the data at those properties
                filename = fileChooser.getSelectedFile().getName();
                dir = fileChooser.getCurrentDirectory() + "";
                saveDataAs(text.getText(), dir + "\\" + filename);
                hasChanged = false;
            	save.setEnabled(false);
            	setTitle( dir + "\\" + filename);
            } 
        }
    }
    
    /*
     * Action listener for the compile button
     * Compiles the current file
     */
    class CompileListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            if ( dir.equals("") )
                JOptionPane.showMessageDialog(null, "You must first open a java file in order to compile it.");
            
            else if ( !hasChanged )
            {
                DroneCompiler compiler = new DroneCompiler();
                    try {
                        boolean success = compiler.compile( dir + "\\" + filename);
                        if( success)
                            interactionsPanel.update("Compilation successful!");
                         
                        else
                            interactionsPanel.update("Compile errors found in : \n" + compiler.getDiagnosticsInfo() );
                    } catch ( Exception exc ) {
                    	JOptionPane.showMessageDialog(null, exc.getMessage()); 
                    }    
            }
            else if ( dontShow )
            {
                save.doClick();
                compile.doClick();
            }
            else
            {
                JCheckBox checkbox = new JCheckBox("Don't show this message again.");
                Object[] params = { "Current file is not saved."
                    + " You need to save it before compiling."
                    + " Click OK to save&compile the file.", checkbox};
                int desire = JOptionPane.showConfirmDialog( null, params, "Unsaved File",
                                                           JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);

                 // Update the dontShow data in Droneer/dontshow.txt
                dontShow = checkbox.isSelected();
                saveDataAs(dontShow + "", "dontshow.txt");
                if ( desire == JOptionPane.OK_OPTION)
                {
                    save.doClick();
                    compile.doClick();
                }
            }
        }
    }
    
    class ChangeListener implements DocumentListener {
        public void removeUpdate(DocumentEvent e) {
            hasChanged = true;
            setTitle( dir + "\\" + filename + " *");
            save.setEnabled(true);
        }
        public void insertUpdate(DocumentEvent e) {
            hasChanged = true;
            setTitle( dir + "\\" + filename + " *");
            save.setEnabled(true);
        }
        public void changedUpdate(DocumentEvent e) {
            hasChanged = true;
            setTitle( dir + "\\" + filename + " *");
            save.setEnabled(true);
        }
    }
}
