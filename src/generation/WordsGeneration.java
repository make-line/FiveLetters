package generation;

import fileWork.ReadFileWork;

public class WordsGeneration {
    public String getWord() {
        ReadFileWork work = new ReadFileWork();
        String[] wordsArray = work.readFile("src/files/fileWithWords.txt");
        int ranNum = (int) (Math.random() * wordsArray.length);
        return wordsArray[ranNum];
    }
}