package cipher;

import java.util.Scanner;

public class Vijiner {
    public static void main(String... s) {

        System.out.println("Введите слово для шифрования:");
        Scanner scanner = new Scanner(System.in);
        String word = scanner.next();
        System.out.println("Введите ключ:");
        String keys = scanner.next();

        char msg[] = word.toCharArray();

        char key[] = keys.toCharArray();
        int msgLen = msg.length, i, j;

        char newKey[] = new char[msgLen];
        char encryptedMsg[] = new char[msgLen];
        char decryptedMsg[] = new char[msgLen];

        //generate new key in cyclic manner equal to the length of original message
        for (i = 0, j = 0; i < msgLen; ++i, ++j) {
            if (j == key.length)
                j = 0;

            newKey[i] = key[j];
        }

        //encryption
        for (i = 0; i < msgLen; ++i)
            encryptedMsg[i] = (char) (((msg[i] + newKey[i]) % 32) + 'А');

        //decryption
        for (i = 0; i < msgLen; ++i)
            decryptedMsg[i] = (char) ((((encryptedMsg[i] - newKey[i]) + 32) % 32) + 'А');

        System.out.println("Original Message: " + String.valueOf(msg));     //String.valueOf() converts character array to String
        System.out.println("Key: " + String.valueOf(key));
        System.out.println("Generated Key: " + String.valueOf(newKey));
        System.out.println("Encrypted Message: " + String.valueOf(encryptedMsg));
        System.out.println("Decrypted Message: " + String.valueOf(decryptedMsg));
    }
}
