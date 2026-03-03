public class PalindromeChecker {
    public static void main(String[] args) {
        String input = "madam";
        boolean result = isPalindrome(input);
        System.out.println("Is '" + input + "' a palindrome? " + result);
    }
    public static boolean isPalindrome(String str) {
        // Base Case: empty string or single character is a palindrome
        if (str.length() <= 1) {
            return true;
        }

        // Check first and last characters
        if (str.charAt(0) == str.charAt(str.length() - 1)) {
            // Recursive Call: focus on the inner substring
            return isPalindrome(str.substring(1, str.length() - 1));
        }

        // If characters don't match, it's not a palindrome
        return false;
    }
}

