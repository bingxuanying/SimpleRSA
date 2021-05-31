import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class RSAUtils {
    private int n = 1;
    private int e = 1;
    private int d = 1;
    private int offset = 97; // make sure numerics are smaller than n (n >= 33)

    public RSAUtils() {
        this.init();
    }

    private void init() {
        Scanner userInput = new Scanner(System.in);

        System.out.println("Start SimpleRSA...");

        System.out.println("Please give value to p: ");
        this.n *= userInput.nextInt();

        System.out.println("Please give value to q: ");
        this.n *= userInput.nextInt();

        System.out.println("Please give value to e: ");
        this.e = userInput.nextInt();

        System.out.println("Please give value to d: ");
        this.d = userInput.nextInt();

        userInput.close();
    }

    public List<Integer> convertMessage2ASCII(String message) {
        // Convert each character to ascii
        return message

                // Get intStream
                .chars()

                // Map to Integer
                .mapToObj(Integer::valueOf)

                // Take offset
                .map(c -> c - offset)

                // Collect List
                .collect(Collectors.toList());
    }

    public String convertASCII2Message(List<Integer> ascii) {
        // Convert each character to ascii
        return ascii

                // Stream
                .stream()

                // Map to String
                .map(c -> (char) (c.intValue() + offset))

                .map(String::valueOf)

                .collect(Collectors.joining());
    }

    public List<Integer> encrypt(List<Integer> message) {
        return message

                // Stream
                .stream()

                // Apply RSA math algorithm
                .map(c -> Math.floorMod(((long) Math.pow(c, e)), n))

                // Collect List
                .collect(Collectors.toList());
    }

    public List<Integer> decrypt(List<Integer> message) {
        return message

                // Stream
                .stream()

                // Apply RSA math algorithm
                .map(c -> Math.floorMod(((long) Math.pow(c, d)), n))

                // Collect List
                .collect(Collectors.toList());
    }

    public String toString(List<Integer> message) {
        return message

                // Stream
                .stream()

                // Map each integer to string
                .map(String::valueOf)

                // Join space in between
                .reduce((a, b) -> a.concat(" ").concat(b))

                // Take value
                .get();
    }
}
