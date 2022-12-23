package playground;

import fileWork.ReadFileWork;
import generation.WordsGeneration;

import java.util.List;
import java.util.Scanner;

public class GameWinning {
    public Boolean winGame() {
        Scanner scanner = new Scanner(System.in);
        WordsGeneration generate = new WordsGeneration();
        Playground playground = new Playground();
        CheckingWord checkingWord = new CheckingWord();
        ReadFileWork file = new ReadFileWork();
        List<String> listOfWords = file.allWordsMap("src/files/fileWithWords.txt");
        String generatedWord = generate.getWord();
        boolean win = false;
        int lives = 6;
        while (lives > 0) {
            System.out.print("Введите слово: ");
            String userWord = scanner.next();
            while (!listOfWords.contains(userWord)) {
                System.out.println("Введите существующее слово до 5 букв!");
                userWord = scanner.next();
            }
            String[] gameLetter = playground.play(generatedWord, userWord);
            String[] checkedWord = checkingWord.check(gameLetter, generatedWord);
            for (int i = 0; i < 5; i++) {
                if (checkedWord[i] == null) {
                    System.out.print("_ ");
                } else {
                    System.out.print(checkedWord[i] + " ");
                }
            }
            System.out.println();
            if (userWord.equals(generatedWord)) {
                win = true;
                break;
            }
            lives--;
        }
        return win;
    }
}
