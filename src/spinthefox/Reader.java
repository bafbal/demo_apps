package spinthefox;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Reader {

    public static List<String> read(String file) {
        Path filePath = Paths.get(file);
        List<String> lines = new ArrayList<>();
        try {
            lines = Files.readAllLines(filePath);
        } catch (IOException e) {
            System.out.println("Uh-oh, could not read the file!");
        }
        return lines;
    }
}
