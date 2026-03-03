import java.util.ArrayDeque;
import java.util.Deque;
    public class PalindromeChecker {

        public static boolean isPalindrome(String str) {
            // 1. Insert characters into deque
            Deque<Character> deque = new ArrayDeque<>();
            for (char c : str.toCharArray()) {

                if (Character.isLetterOrDigit(c)) {
                    deque.addLast(Character.toLowerCase(c));
                }
            }
            // 2. Remove first & last and compare until empty or one element left
            while (deque.size() > 1) {
                Character first = deque.pollFirst(); // Removes and returns the first element
                Character last = deque.pollLast();   // Removes and returns the last element

                // 3. Compare
                if (!first.equals(last)) {
                    return false; // Not a palindrome if characters don't match
                }
            }
            // If the loop completes (deque is empty or has one element), it's a palindrome
            return true;
        }
        public static void main(String[] args) {
            String testString1 = "radar";
            String testString2 = "hello";
            String testString3 = "Deed"; // will be treated as "deed" due to case handling

            System.out.println("Is \"" + testString1 + "\" a palindrome? " + isPalindrome(testString1));
            System.out.println("Is \"" + testString2 + "\" a palindrome? " + isPalindrome(testString2));
            System.out.println("Is \"" + testString3 + "\" a palindrome? " + isPalindrome(testString3));
        }
    }
