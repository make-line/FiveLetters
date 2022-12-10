import fileWork.ReadFileWork;
import generation.WordsGeneration;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ReadFileWork work = new ReadFileWork();
        WordsGeneration generate = new WordsGeneration();
        List<String> generatedLetter;
        String[] userLetter;
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
            String[] arrayWords = work.readFile("src/files/fileWIthWords.txt");
            int num = arrayWords.length;
            switch (menu) {
                case 1 -> {
                    int ranNum = (int) (Math.random() * num);
                    String generatedWord = generate.getWord(ranNum);
                    generatedLetter = List.of(generatedWord.split(""));
                    int lives = 6;
                    boolean play = false;
                    System.out.println("Давайте начнем! У вас 6 попыток.");
                    while ((lives > 0) && (!play)){
                        System.out.print("Введите слово: ");
                        String userWord = scanner.next();
                        userLetter = userWord.split("");
                        for (int i = 0; i < userLetter.length; i++){
                            String letter = userLetter[i];
                            if(generatedLetter.contains(letter)
                                    && !generatedLetter.get(i).equals(letter)){
                                System.out.print(letter.toLowerCase()+" ");
                            }
                            else if(generatedLetter.contains(letter)
                                    && generatedLetter.get(i).equals(letter)){
                                System.out.print(letter.toUpperCase()+" ");
                            }
                            else
                                System.out.print("_ ");
                        }
                        System.out.print("\n");
                        if (userWord.equals(generatedWord)){
                            System.out.println("Вы выиграли!");
                            victoryNum++;
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