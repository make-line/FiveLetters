import fileWork.ReadFileWork;
import generation.WordsGeneration;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ReadFileWork work = new ReadFileWork();
        WordsGeneration generate = new WordsGeneration();
        String[] letters;
        String[] userLetters;
        int victoryNum = 0;
        int loseNum = 0;
        System.out.println("Добро пожаловать в игру 5 букв!");
        while (true) {
            System.out.println("""
                    1-Начать игру
                    2-Показать статистику
                    3-Выйти из игры
                    """);
            int menu = scanner.nextInt();
            String[] generatedWord = work.readFile("src/files/fileWIthWords.txt");
            int num = generatedWord.length;
            switch (menu) {
                case 1 -> {
                    int ranNum = (int) (Math.random() * num);
                    String newWord = generate.getWord(ranNum);
                    letters = newWord.split("");
                    int lives = 6;
                    boolean play = false;
                    boolean happy = false;
                    System.out.println("Давайте начнем! У вас 6 попыток.");
                    while ((lives > 0) && (!play)){
                        System.out.print("Введите слово: ");
                        String word = scanner.next();
                        userLetters = word.split("");
                        for (int i = 0; i < letters.length; i++){
                            happy = false;
                            for (int j = 0; j < letters.length; j++) {
                                if (userLetters[i].equals(letters[j]) && i == j) {
                                    System.out.print(userLetters[i].toUpperCase() + " ");
                                    happy = true;
                                    break;
                                } else if (letters[i].equals(userLetters[j]) && i != j) {
                                    System.out.print(userLetters[i].toLowerCase() + " ");
                                    happy = true;
                                    break;
                                }
                                if (word.equals(newWord)) {
                                    play = true;
                                }
                            }
                            if (!happy) {
                                System.out.print("_ ");
                            }
                        }
                        System.out.print("\n");
                        if (word.equals(newWord)){
                            System.out.println("Вы выиграли!");
                            victoryNum++;
                        }
                        lives--;
                    }
                    if (!play) {
                        System.out.println("Попробуйте в следующий раз, а слово было " + newWord);
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