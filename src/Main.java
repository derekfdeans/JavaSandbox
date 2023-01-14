import java.io.Console;
import java.io.PrintWriter;

public class Main {
    public static void main(String[] args) {
        Console console = System.console();
        if (console == null) {
            System.err.println("no console.");
            System.exit(1);
        }

        try (PrintWriter writer = console.writer()) {
            writer.println("heyy");
        }

        char [] password = console.readPassword("what's your passowrd?");
        for (char c : password) {
            console.format(String.valueOf(c));
        }
    }
}