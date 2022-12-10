package generation;

import fileWork.ReadFileWork;

public class WordsGeneration {
    public String getWord (int n){
        ReadFileWork work = new ReadFileWork();
        String word;
        String[] wordsArray = work.readFile("src/files/fileWithWords.txt");
        word = wordsArray[n];
        return word;
    }
}
