
import java.util.Scanner;

public class HangmanMain {
    public static void main(String[] args) {
        Dictionary dictionary = new Dictionary();
        String randomWord = dictionary.getRandomWord();

        Session game = new Session(randomWord, 1 );
        game.startGame();

        Scanner scanner = new Scanner(System.in);

        while (!game.isGameOver()){
            game.currentWord();
            System.out.println("Введите букву, слово или команду для выхода:");
            String input = scanner.nextLine();

            if (input.equals("Exit") || input.equals("Выход")){
                game.endGame();
            }

            if (input.equals(randomWord) || game.isGameWon()){
                System.out.println("\nПоздравляю, Вы выиграли! Загаданное слово было: " + randomWord);
                break;
            }

            char letter = input.toLowerCase().charAt(0);
            game.usedLetter(letter);
        }
        if (game.isGameOver()) {
            System.out.println("Вы проиграли, попробуйте ещё раз :(");
        }
    }
}