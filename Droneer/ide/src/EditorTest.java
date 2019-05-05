import java.awt.*;
import javax.swing.*;

public class EditorTest{
    public static void main(String[] args){

        JFrame editor = new Editor();
        editor.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE);
        editor.pack();
        editor.setVisible(true);
    }  
}