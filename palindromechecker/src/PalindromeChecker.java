import java.util.Stack;

// Encapsulation: Class bundles data (input string) and methods.
public class PalindromeChecker {

    // Single Responsibility: Only responsible for checking palindromes.
    public boolean checkPalindrome(String text) {
        if (text == null) return false;
        
        // Data Structure: Using a Stack (LIFO) to reverse the string.
        Stack<Character> stack = new Stack<>();
        String cleanedText = text.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        // Push characters onto stack
        for (char c : cleanedText.toCharArray()) {
            stack.push(c);
        }

        // Pop and compare
        StringBuilder reversedText = new StringBuilder();
        while (!stack.isEmpty()) {
            reversedText.append(stack.pop());
        }

        return cleanedText.equals(reversedText.toString());
    }

    public static void main(String[] args) {
        PalindromeChecker checker = new PalindromeChecker();
        String testString = "Racecar";
        
        // Exposed Method: User only interacts with this.
        System.out.println(testString + " is palindrome? " + checker.checkPalindrome(testString));
    }
}

