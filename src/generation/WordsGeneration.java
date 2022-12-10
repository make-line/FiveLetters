package generation;

import fileWork.ReadFile;

public class WordsGeneration {
    public String getWord (int n){
        ReadFile work = new ReadFile();
        String word;
        String[] wordsArray = work.readFile("src/files/fileWithWords.txt");
        word = wordsArray[n];
        return word;
    }
}
