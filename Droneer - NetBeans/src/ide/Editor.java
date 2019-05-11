package ide;

import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.*;
import java.io.*;
import javax.swing.undo.UndoManager;

/*
 * Simple Editor class for writing code with several features
 * @author - Uğur Erdem Seyfi, Zübeyir Bodur
 * @version - 11.05.2019
 */
@SuppressWarnings("serial")
public class Editor extends JPanel
{
	//JMenuBar menuBar; // might be added
	JToolBar toolBar;
	JButton save, saveAs, open, compile, run, undo, redo, help;
	String filename, dir;

	JScrollPane textPane;
	JTextArea text;

	InteractionsPanel interactionsPanel;

	UndoManager editManager;

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
		
		filename = "";
		dir = "src\\examples";
		hasChanged = false;
		dontShow = Boolean.parseBoolean( getData("src\\ide\\dontshow.txt") );

		fileChooser = new JFileChooser();
		fileChooser.setCurrentDirectory( new File("src\\examples") );
		fileNameFilter = new FileNameExtensionFilter("Java files", "java");
		fileChooser.setFileFilter( fileNameFilter);

		editManager = new UndoManager();

		// creating tool bar
		toolBar = new JToolBar();
		toolBar.setFloatable( false);
		save    = new JButton("Save");
		saveAs  = new JButton("Save As");
		open    = new JButton("Open");
		compile = new JButton("Compile");
		//run = new JButton("Run");
		undo    = new JButton("Undo");
		redo    = new JButton("Redo");
		help    = new JButton("Help");

		// adding buttons to toolbar
		toolBar.add( save);
		toolBar.add( saveAs);
		toolBar.add( open);
		toolBar.add( compile);
		//toolBar.add( run);
		toolBar.add( undo);
		toolBar.add( redo);
		toolBar.add( help);
		
		
		/*************************************************
		 **ADD HOTKEY AND ACTION LISTENER TO SAVE BUTTON**
		 *************************************************/
		Action saveAct = new AbstractAction("Save") {

		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	// If a file has not been selected yet, then call saveAs action listener
				if( filename.equals("") )
					saveAs.doClick();
				else
				{   
					// Save the file to the current directory
					saveDataAs(text.getText(), dir + "\\" + filename);
					hasChanged = false;
					save.setEnabled(false);
				}
		    }

		};
		saveAct.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
		save.setAction(saveAct);
		save.getActionMap().put("saveAction", saveAct);
		save.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
		        (KeyStroke) saveAct.getValue(Action.ACCELERATOR_KEY), "saveAction");
		
		/*************************************************
		 **ADD HOTKEY AND ACTION LISTENER TO UNDO BUTTON**
		 *************************************************/
		Action undoAct = new AbstractAction("Undo") {

		    @Override
		    public void actionPerformed( ActionEvent e)
			{
				if ( editManager.canUndo() )
					editManager.undo();
				updateURButtons();
			}

		};
		undoAct.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_Z, InputEvent.CTRL_MASK));
		undo.setAction(undoAct);
		undo.getActionMap().put("undoAction", undoAct);
		undo.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
		        (KeyStroke) undoAct.getValue(Action.ACCELERATOR_KEY), "undoAction");
		
		/*************************************************
		 **ADD HOTKEY AND ACTION LISTENER TO REDO BUTTON**
		 *************************************************/
		Action redoAct = new AbstractAction("Redo") {

		    @Override
		    public void actionPerformed( ActionEvent e)
			{
				if ( editManager.canRedo() )
					editManager.redo();
				updateURButtons();
			}

		};
		redoAct.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_Y, InputEvent.CTRL_MASK));
		redo.setAction(redoAct);
		redo.getActionMap().put("redoAction", redoAct);
		redo.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
		        (KeyStroke) redoAct.getValue(Action.ACCELERATOR_KEY), "redoAction");
		
		/*************************************************
		 **ADD HOTKEY AND ACTION LISTENER TO OPEN BUTTON**
		 *************************************************/
		Action openAct = new AbstractAction("Open") {

		    @Override
		    public void actionPerformed( ActionEvent e)
			{
		    	// Demonstrate "Open" dialog:
				int response = fileChooser.showOpenDialog(null);
				if (response == JFileChooser.APPROVE_OPTION) 
				{
					// Set the text to what is read from the file and update info
					text.setText( getData( fileChooser.getSelectedFile().getAbsolutePath() ) );
					filename = fileChooser.getSelectedFile().getName();
					dir = fileChooser.getCurrentDirectory() + "";
					fileChooser.setCurrentDirectory( new File(dir) );
					hasChanged = false;
					interactionsPanel.update("Welcome to Droneer. Current file directory is: " + System.getProperty("user.dir") + "\\" +  dir );
				}
				
				// bug fix, discard all edits in UndoManager, have the scroll pane go to top.
				editManager.discardAllEdits();
				updateURButtons();
				text.setCaretPosition(0);
			}

		};
		openAct.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_MASK));
		open.setAction(openAct);
		open.getActionMap().put("openAction", openAct);
		open.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
		        (KeyStroke) openAct.getValue(Action.ACCELERATOR_KEY), "openAction");
		
		/****************************************************
		 **ADD HOTKEY AND ACTION LISTENER TO COMPILE BUTTON**
		 ****************************************************/
		Action compileAct = new AbstractAction("Compile") {

		    @Override
		    public void actionPerformed( ActionEvent e)
			{
		    	if ( filename.equals("") )
					JOptionPane.showMessageDialog(null, "You must first open a java file in order to compile it.");

				else if ( !hasChanged )
				{
					DroneCompiler compiler = new DroneCompiler();
					try {
						if( compiler.compile( dir + "\\" + filename) )
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

					// Update the dontShow data in Droneer\dontshow.txt
					dontShow = checkbox.isSelected();
					saveDataAs(dontShow + "", "src\\ide\\dontshow.txt");
					if ( desire == JOptionPane.OK_OPTION)
					{
						save.doClick();
						compile.doClick();
					}
				}
			}

		};
		// Uncomment the following and comment the uncommented ones to make the hotkey (currently F5) Ctrl + B
//		compileAct.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_B, InputEvent.CTRL_MASK));
		compileAct.putValue(Action.MNEMONIC_KEY, KeyEvent.VK_R);
		compile.setAction(compileAct);
		compile.getActionMap().put("compileAction", compileAct);
		compile.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
				KeyStroke.getKeyStroke(KeyEvent.VK_F5, 0), "compileAction");
//		compile.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
//		        (KeyStroke) compileAct.getValue(Action.ACCELERATOR_KEY), "compileAction");
		
		
		
		// adding listeners to buttons
		saveAs.addActionListener( new SaveAsListener() );
		// undo & redo is initially disabled
		undo.setEnabled(false);
		redo.setEnabled(false);

		text = new JTextArea(20, 30);
		text.setFont( new Font( Font.MONOSPACED, Font.PLAIN, 14 ));
		text.setTabSize(4);
		text.setText( getData("src\\ide\\template.txt"));
		textPane = new JScrollPane(text);
		TextLineNumber textLineNumber = new TextLineNumber( text);
		textPane.setRowHeaderView( textLineNumber);
		textPane.setPreferredSize( new Dimension(400,200) );		
		text.getDocument().addDocumentListener(new ChangeListener() );
		text.getDocument().addUndoableEditListener(new DocumentComingUndone() );
		
		
		interactionsPanel = new InteractionsPanel( "Welcome to Droneer. Current file directory is : " + System.getProperty("user.dir") + "\\" + dir );
		
		add(BorderLayout.SOUTH, interactionsPanel);
		add(BorderLayout.NORTH , toolBar);
		add(BorderLayout.CENTER ,textPane);
	}

	private void updateURButtons()
	{
		undo.setEnabled( editManager.canUndo() );
		redo.setEnabled( editManager.canUndo() );
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
				else if ( lineCount == 2 )
					soFar = soFar + "\n" + line + "\n";
				else
					soFar = soFar + line + "\n";
			}
			if ( lineCount > 1)
				soFar = soFar.substring( 0, soFar.length() - 1);

			bufferedReader.close();
			return soFar;
		} catch (Exception exc) {
			JOptionPane.showMessageDialog(null, exc.getMessage() );
			return null;
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
			} 
		}
	}

	class ChangeListener implements DocumentListener 
	{
		public void removeUpdate(DocumentEvent e) 
		{
			hasChanged = true;
			save.setEnabled(true);
		}
		
		public void insertUpdate(DocumentEvent e) 
		{
			hasChanged = true;
			save.setEnabled(true);
		}
		public void changedUpdate(DocumentEvent e) {}
	}

	class DocumentComingUndone implements UndoableEditListener 
	{
		public void undoableEditHappened( UndoableEditEvent e) 
		{
			editManager.addEdit(e.getEdit() );
			updateURButtons();
		}
	}
}