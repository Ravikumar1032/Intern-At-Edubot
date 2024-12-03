import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FileHandler {

    public void savePasswordsToFile(List<String> passwords, String fileName) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (String password : passwords) {
                writer.write(password);
                writer.newLine();
            }
        }
    }
}
