package Seminar_03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Перепишите код, воспользовавшись механизмом try-with-resources
 */
public class Task0 {

    public void rwLine(Path pathRead, Path pathWrite) throws IOException {
//        BufferedReader in = null;
//        BufferedWriter out = null;
        try (BufferedReader in = Files.newBufferedReader(pathRead);
             BufferedWriter out = Files.newBufferedWriter(pathWrite)){
//            in = Files.newBufferedReader(pathRead);
//            out = Files.newBufferedWriter(pathWrite);
            out.write(in.readLine());
        } /*finally {
            try {
                if (in != null) in.close();
            } catch (IOException e) {}
            try {
                if (out != null) out.close();
            } catch (IOException e){}
        }*/
    }
}
