import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/*
 * Vanderbilt University CS 6387 Assignment:RSA
 * Professor: Dr. Derek Riley
 * Author: Bingxuan Ying
 *
 * Simple RSA Encryption
 * Only work for 26 lowercase alphabet characters
 */

public class SimpleRSA {
    public static void main(String[] args) {
        String defaultMessage = "vanderbilt";
        RSAUtils RSAUtils = new RSAUtils();

        System.out.println("Default message: " + defaultMessage);

        // Convert to numerical representation
        List<Integer> numericalMessage = RSAUtils.convertMessage2ASCII(defaultMessage);
        System.out.println("Represent the message in numerics: " + RSAUtils.toString(numericalMessage));

        // Encrypt message
        List<Integer> encryptedMessage = RSAUtils.encrypt(numericalMessage);
        System.out.println("Encrypted numerics: " + RSAUtils.toString(encryptedMessage));
        System.out.println("Encrypted message: " + RSAUtils.convertASCII2Message(encryptedMessage));

        // Decrypt message
        List<Integer> decryptedMessage = RSAUtils.decrypt(encryptedMessage);
        System.out.println("Decrypted numerics: " + RSAUtils.toString(decryptedMessage));
        System.out.println("Decrypted message: " + RSAUtils.convertASCII2Message(decryptedMessage));

    }
}
