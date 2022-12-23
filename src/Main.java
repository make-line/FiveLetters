import fileWork.ReadFileWork;
import generation.WordsGeneration;
import playground.CheckingWord;
import playground.Playground;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        WordsGeneration generate = new WordsGeneration();
        Playground playground = new Playground();
        CheckingWord checkingWord = new CheckingWord();
        ReadFileWork file = new ReadFileWork();
        int victoryNum = 0;
        int loseNum = 0;
        List<String> listOfWords = file.allWordsMap("src/files/fileWithWords.txt");
        System.out.println("Добро пожаловать в игру 5 букв!");
        while (true) {
            System.out.println("""
                    1-Начать игру
                    2-Показать статистику
                    3-Выйти из игры
                    """);
            int menu = scanner.nextInt();
            switch (menu) {
                case 1 -> {
                    String generatedWord = generate.getWord();
                    int lives = 6;
                    boolean play = false;
                    System.out.println("Давайте начнем! У вас 6 попыток.");
                    while ((lives > 0) && (!play)) {
                        System.out.print("Введите слово: ");
                        String userWord = scanner.next();
                        while (!listOfWords.contains(userWord)){
                            System.out.println("Введите существующее слово до 5 букв!");
                            userWord = scanner.next();
                        }
                        String[] gameLetter = playground.play(generatedWord, userWord);
                        String[] checkedWord = checkingWord.check(gameLetter, generatedWord);
                        for (int i = 0; i < 5; i++) {
                            if (checkedWord[i] == null){
                                System.out.print("_ ");
                            }
                            else {
                                System.out.print(checkedWord[i] + " ");
                            }
                        }
                        System.out.println();
                        if (userWord.equals(generatedWord)) {
                            System.out.println("Вы выиграли!");
                            victoryNum++;
                            play = true;
                        }
                        lives--;
                    }
                    if (!play) {
                        System.out.println("Попробуйте в следующий раз, а слово было " + generatedWord);
                        loseNum++;
                    }
                }
                case 2 -> {
                    System.out.println("Вы выиграли " + victoryNum + " раз!");
                    System.out.println("Вы проиграли " + loseNum + " раз!");
                }
                default -> System.exit(1);
            }
        }
    }
}