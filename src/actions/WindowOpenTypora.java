package actions;

import java.io.IOException;

/**
 * @author Lee
 */
public class WindowOpenTypora {
    public static void main(String[] args) {
        String filePath = "C:/Users/Lee/IdeaProjects/untitled/test.md";
        String typoraPath = "typora";
        // String typoraPath = "c:\\Program Files\\Typora\\Typora.exe";
        try {
            Runtime.getRuntime().exec(new String[]{typoraPath, filePath});
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
