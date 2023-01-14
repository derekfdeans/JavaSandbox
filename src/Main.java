import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        ArrayList<String> list = new ArrayList<>();
        list.add("Hello");
        list.add("Oh my god");
        list.add("jkdshgkjahgkjhaskjghkjadshg!!!");

        System.out.println("starting serialization..");
        try (FileOutputStream fileOutput = new FileOutputStream("text.txt");
             ObjectOutputStream output = new ObjectOutputStream(fileOutput)) {
            output.writeObject(list);
        }
        System.out.println("end serialization!\n");

        System.out.println("start deserialization...");
        try (FileInputStream fileInput = new FileInputStream("text.txt");
             ObjectInputStream objectInput = new ObjectInputStream(fileInput)) {
            for (String string : (ArrayList<String>) objectInput.readObject()) {
                System.out.println(string);
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        System.out.println("end deserialzation!");
    }
}