import java.util.Stack;
public class PalindromeChecker {
        public static boolean isPalindrome(String input) {
            Stack<Character> stack = new Stack<>();
            for (char c : input.toCharArray()) {
                stack.push(c);
            }

            StringBuilder reversed = new StringBuilder();
            while (!stack.isEmpty()) {
                reversed.append(stack.pop());
            }
            return input.equals(reversed.toString());
        }

        public static void main(String[] args) {
            String text = "radar";
            System.out.println("Is '" + text + "' a palindrome? " + isPalindrome(text));
        }
    }
