import playground.GameWinning;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GameWinning victoryCheck = new GameWinning();
        int victoryNum = 0;
        int loseNum = 0;
        System.out.println("Добро пожаловать в игру 5 букв!");
        while (true) {
            System.out.println("""
                    1 - Начать игру
                    2 - Показать статистику
                    3 - Выйти из игры
                    """);
            int menu = scanner.nextInt();
            switch (menu) {
                case 1 -> {
                    System.out.println("Давайте начнем! У вас 6 попыток.");
                    boolean win = victoryCheck.winGame();
                    if (win) {
                        System.out.println("Вы выиграли!");
                        victoryNum++;
                    } else {
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