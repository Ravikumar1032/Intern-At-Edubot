import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FileHandler {
    public static void savePasswordsToFile(List<String> passwords, String filename) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (String password : passwords) {
                writer.write(password);
                writer.newLine();
            }
        }
    }
}
