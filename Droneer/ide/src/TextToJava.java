package src;

import java.io.*;

/**
 * A text to java converter
 * @author Zübeyir Bodur
 * @version 1.5.2019
 */
public class TextToJava
{
   String code;
   String name;
   
   /**
    * Creates a converter with given source code that player wrote and name that player decided
    * @param code code as a String
    * @param className name of the drone class
    */
   public TextToJava( String code, String className)
   {
      this.code = code;
      name = className;
   }
   
   /**
    * Returns the source code as a string
    * @return code source code
    */
   public String getSourceCode()
   {
      return code;
   }
   
   /**
    * Converts the code string to a java file at /drone/mydrones package
    */
   public void convertToMydrones()
   {
      try
      {
         // Create the drone class to ide directory
         BufferedWriter writer = new BufferedWriter( new FileWriter(".\\" + name + ".java" ) );
         writer.write(code);
         writer.close();
         try
         {
            // Move it to the drone/mydrones directory
            String currentDir = System.getProperty("user.dir" );
            File afile = new File(currentDir + "\\" +  name + ".java" );
            String targetDir = currentDir.substring( 0, currentDir.length() - 4) + "\\drone\\mydrones\\" + afile.getName();
            File actualFile = new File( targetDir);
            
            if ( actualFile.exists() )
               actualFile.delete();
            
            if( afile.renameTo(actualFile) )
               System.out.println("File is moved successful!");
            else
               System.out.println("File is failed to move!");
         } 
         catch ( Exception e)
         {
            e.printStackTrace();
         }
      }
      catch( IOException e)
      {
         e.printStackTrace();
      }
   }
}
