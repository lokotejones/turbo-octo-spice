/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rpgmanager;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author aaron
 */
public class WriteFile {

    public void SaveData() {
        try { 
            String content = "This is the content to write into file";
            File file = new File("/Users/Aaron/Dropbox/Apps/RpgGenerator/RpgManager/src/saves/save.txt");
            // if file does not exist, then create it
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            try (BufferedWriter bw = new BufferedWriter(fw)) {
                bw.write(content);
            }
            System.out.println("The file has been saved.");
        } catch (IOException e) {
            System.out.println("Failed");
            System.out.println(e);
        }
    }
}