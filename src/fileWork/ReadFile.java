package fileWork;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class ReadFile {
    public String[] readFile (String path){
        StringBuilder str = new StringBuilder();

        try {
            try (Stream<String> stream = Files.lines(Paths.get(path))) {
                stream.forEach(str::append);
            }
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        return str.toString().split(" ");
    }
}
