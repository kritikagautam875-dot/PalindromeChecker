import java.util.Scanner;
public class PalindromeChecker {
    public static void main(String[] args) {
        String original = "madam"; // Example string
        String reversed = "";

        for (int i = original.length() - 1; i >= 0; i--) {
            reversed += original.charAt(i);
        }
        if (original.equals(reversed)) {
            System.out.println("The string \"" + original + "\" is a palindrome.");
        } else {
            System.out.println("The string \"" + original + "\" is not a palindrome.");
        }
    }
}