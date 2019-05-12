package ide;
import java.util.Arrays;
import java.util.List;
import java.io.*;
import javax.tools.*;

/*
 * DroneCompiler class that makes compiling the file easier.
 * @author - Ugur Erdem Seyfi, Zubeyir Bodur
 * @version - 11.05.2019
 */

public class DroneCompiler{
    // properties
    String diagnosticsInfo;
    
    /*
     * Default constructor
     */
    public DroneCompiler(){
        diagnosticsInfo = "";
    }
    
    /*
     * Method that compiles the java file at given directory
     * @param directory - path of the java file that is wanted to be compiled ( e.g : "C:\Users\Name\Desktop\Test.java" )
     * @return - true if the compilation was succesfull, false if there was a problem
     */
    public boolean compile(String directory) throws IOException{
        return compile(directory, null);
    }
    
    /*
     * Method that compiles the java file at given directory, and puts the result of compilation to the wanted path
     * @param directory - path of the java file that is wanted to be compiled ( e.g : "C:\Users\Name\Desktop\Test.java" )
     * @param pathToSave - compiled .class file will be saved at this path
     * @return - true if the compilation was succesfull, false if there was a problem
     */
    public boolean compile(String directory, String pathToSave) throws IOException {
        // Our compiler
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        // Collection of diagnostics
        DiagnosticCollector<JavaFileObject> diagnosticsCollector = new DiagnosticCollector<JavaFileObject>();
        // FileManager for compiler
        StandardJavaFileManager fileManager = compiler.getStandardFileManager(diagnosticsCollector, null, null);
        // Options
        Iterable<String> options = pathToSave == null ? null : Arrays.asList( new String[] { "-d", pathToSave} );;
        // JavaFiles that are going to be compiled
        Iterable<? extends JavaFileObject> compilationUnits = fileManager
            .getJavaFileObjectsFromStrings(Arrays.asList(directory));
        // Defining the compilation task
        JavaCompiler.CompilationTask task = compiler.getTask(null, fileManager, diagnosticsCollector, options,
                                                             null, compilationUnits);
        boolean success = task.call();
        
        // Updating the diagnosticsInfo
        this.diagnosticsInfo = "";
        if (!success) {
            List<Diagnostic<? extends JavaFileObject>> diagnostics = diagnosticsCollector.getDiagnostics();
            for (Diagnostic<? extends JavaFileObject> diagnostic : diagnostics) {
                // read error dertails from the diagnostic object
                this.diagnosticsInfo = this.diagnosticsInfo + "\n line " + diagnostic.getLineNumber() + " : " + diagnostic.getMessage(null);
            }
        }
        
        fileManager.close();
        return success;
    }
    
    
    
    /*
     * Getter for diagnosticsInfo
     * @return - diagnosticsInfo
     */
    public String getDiagnosticsInfo(){
        return this.diagnosticsInfo;
    }
    
}