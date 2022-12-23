package fileWork;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Stream;

public class ReadFileWork {
    public String[] readFile(String path) {
        StringBuilder str = new StringBuilder();
        try {
            try (Stream<String> stream = Files.lines(Paths.get(path))) {
                stream.forEach(line -> {
                    str.append(line);
                    str.append(" ");
                });
            }
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        return str.toString().split(" ");
    }
    public List<String> allWordsMap (String path){
        List<String> words = new ArrayList<>();
        try {
            try (Stream<String> stream = Files.lines(Paths.get(path))) {
                stream.forEach(line -> {
                    words.add(line);
                    words.add(" ");
                });
            }
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        return words;
    }
}
