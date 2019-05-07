package ide;

import java.io.IOException;

public class TextToJavaTest
{
   public static void main( String[] args) throws IOException
   {
      String code = "import java.util.Scanner;\n/**\n * Final Deal Calculator\n * @author Zübeyir Bodur\n * @version 28.10.2018\n */\npublic class FinalDeal\n{   public static void main( String[] args)\n      {\n      }\n}";
      TextToJava converter = new TextToJava( code, "FinalDeal");
      converter.convertToMydrones();
   }
}