package cipher;

import java.util.Arrays;
import java.util.Scanner;

public class MagicSquare {
    static int square[][] = {
            {7, 12, 1, 14},
            {2, 13, 8, 11},
            {16, 3, 10, 5},
            {9, 6, 15, 4}
    };
    static char cipher[][] = {
            {'a', 'a', 'a', 'a'},
            {'a', 'a', 'a', 'a'},
            {'a', 'a', 'a', 'a'},
            {'a', 'a', 'a', 'a'}
    };


    public static void main(String[] args) {

        System.out.println("Введите слово для шифрования:");
        Scanner scanner = new Scanner(System.in);
        String word = scanner.next();
        char msg[] = word.toCharArray();

        for (int i = 0; i <= msg.length - 1; i++)
            addChar(i + 1, msg[i]);

        StringBuilder builder = new StringBuilder();

        for (int q = 0; q < cipher.length - 1; q++)
            builder.append(cipher[q]);

        System.out.println("Зашифрованное сообщение: " + builder.toString());
    }

    static void addChar(int index, char ch) {
        boolean found = false;

        for (int i = 0; i <= square.length - 1; i++) {
            for (int j = 0; j <= square[i].length - 1; j++) {
                if (square[i][j] == index) {
                    cipher[i][j] = ch;
                    found = true;
                    break;
                }
            }
            if (found) break;
        }
    }

}
