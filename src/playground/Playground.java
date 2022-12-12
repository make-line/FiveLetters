package playground;

import java.util.List;

public class Playground {
    public String[] play(String generatedWord, String userWord){
        List<String> generatedLetter = List.of(generatedWord.split(""));
        String[] userLetter = userWord.split("");
        String[] word = new String[5];
        for (int i = 0; i < userLetter.length; i++) {
            String letter = userLetter[i];
            if (generatedLetter.contains(letter)
                    && !generatedLetter.get(i).equals(letter)) {
                word[i] = letter.toLowerCase() + " ";
            } else if (generatedLetter.contains(letter)
                    && generatedLetter.get(i).equals(letter)) {
                word[i] = letter.toUpperCase() + " ";
            } else
                word[i] = "_ ";
        }
        return word;
    }
}
