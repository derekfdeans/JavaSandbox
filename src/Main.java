import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.nio.file.StandardOpenOption.*;

public class Main {
    public static void main(String[] args) {
        Path path = Paths.get("C:\\Users\\kimde\\IdeaProjects\\Java Sandbox\\src\\text.txt");
        Charset charset = StandardCharsets.UTF_8;
        List<String> fileText = new ArrayList<>();

        System.out.println("first read..");
        try (BufferedReader reader = Files.newBufferedReader(path, charset)) {
            String currentLine;
            while ((currentLine = reader.readLine()) != null) {
                fileText.add(currentLine);
                System.out.println(currentLine);
            }
        } catch (IOException exception) {
            System.err.println(exception.getMessage());
        }
        System.out.println("stop read..\n");

         System.out.println("doubling file text...");
         try (BufferedWriter writer = Files.newBufferedWriter(path, charset, CREATE, APPEND)) {
             for (String string: fileText) {
                 writer.write("\n" + string);
             }
         } catch (IOException exception) {
             System.err.println(exception.getMessage());
         }
         System.out.println("file text doubled..\n");

         System.out.println("read AGAIN");
         try (BufferedReader reader = Files.newBufferedReader(path, charset)) {
             String currentLine;
             while ((currentLine = reader.readLine()) != null) {
                 fileText.add(currentLine);
                 System.out.println(currentLine);
             }
         } catch (IOException exception){
             System.err.println(Arrays.toString(exception.getStackTrace()) + exception.getMessage());
         }
         System.out.println("file reading done!\n");
    }
}