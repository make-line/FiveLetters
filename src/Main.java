import fileWork.ReadFile;
import generation.WordsGeneration;

import java.util.Objects;
import java.util.Scanner;
import java.util.WeakHashMap;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ReadFile work = new ReadFile();
        WordsGeneration generate = new WordsGeneration();
        String[] letters;
        String[] userLetters;
        System.out.println("Добро пожаловать в игру 5 букв!");
        while (true) {
            System.out.println("""
                    1-Начать игру
                    2-Выйти из игры
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
                    System.out.println("Давайте начнем! У вас 6 попыток.");
                    while ((lives > 0) && (!play)){
                        System.out.print("Введите слово: ");
                        String word = scanner.next();
                        userLetters = word.split("");
                        boolean[] corLet = new boolean[5];
                        for (int i = 0; i < letters.length; i++){
                            if (corLet[i] || Objects.equals(userLetters[i], letters[i])){
                                System.out.print(letters[i] + " ");
                                corLet[i] = true;
                            }
                            else {
                                System.out.print("_ ");
                            }
                            if (word.equals(newWord)){
                                play = true;
                            }
                        }
                        System.out.println("");
                        if (word.equals(newWord)){
                            System.out.println("Вы выиграли!");
                        }
                        lives--;
                    }
                    if (!play) System.out.println("Попробуйте в следующий раз, а слово было " + newWord);
                }
                default -> System.exit(1);
            }
        }
    }
}