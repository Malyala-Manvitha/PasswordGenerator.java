import java.util.Random;
import java.util.Scanner;

public class PasswordGenerator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the desired password length: ");
        int length = scanner.nextInt();
        String password = generatePassword(length);
        System.out.println("Generated Password: " + password);
        scanner.close();
    }

    public static String generatePassword(int length) {
        String upperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowerCase = "abcdefghijklmnopqrstuvwxyz";
        String digits = "0123456789";
        String specialCharacters = "!@#$%^&*()-_=+<>?/";
        String allCharacters = upperCase + lowerCase + digits + specialCharacters;
        Random random = new Random();
        StringBuilder password = new StringBuilder();
        password.append(upperCase.charAt(random.nextInt(upperCase.length())));
        password.append(lowerCase.charAt(random.nextInt(lowerCase.length())));
        password.append(digits.charAt(random.nextInt(digits.length())));
        password.append(specialCharacters.charAt(random.nextInt(specialCharacters.length())));
        for (int i = 4; i < length; i++) {
            password.append(allCharacters.charAt(random.nextInt(allCharacters.length())));
        }
        return shuffleString(password.toString());
    }

    public static String shuffleString(String input) {
        char[] characters = input.toCharArray();
        Random random = new Random();

        for (int i = 0; i < characters.length; i++) {
            int randomIndex = random.nextInt(characters.length);
            // Swap characters
            char temp = characters[i];
            characters[i] = characters[randomIndex];
            characters[randomIndex] = temp;
        }

        return new String(characters);
    }
}