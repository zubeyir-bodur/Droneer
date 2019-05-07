package ide;

import java.util.Arrays;
import java.util.List;
import java.io.*;
import javax.tools.*;

public class DroneCompiler{
    
    String diagnosticsInfo;
    
    DroneCompiler(){
        diagnosticsInfo = "";
    }
    
    public boolean compile(String fileName) throws IOException {
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        DiagnosticCollector<JavaFileObject> diagnosticsCollector = new DiagnosticCollector<JavaFileObject>();
        StandardJavaFileManager fileManager = compiler.getStandardFileManager(diagnosticsCollector, null, null);
        Iterable<? extends JavaFileObject> compilationUnits = fileManager
            .getJavaFileObjectsFromStrings(Arrays.asList(fileName));
        JavaCompiler.CompilationTask task = compiler.getTask(null, fileManager, diagnosticsCollector, null,
                                                             null, compilationUnits);
        boolean success = task.call();
        
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
    
    public String getDiagnosticsInfo(){
        return this.diagnosticsInfo;
    }
    
}