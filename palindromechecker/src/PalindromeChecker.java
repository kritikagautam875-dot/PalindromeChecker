public class PalindromeChecker {
        public static boolean isPalindrome(String str) {
            // Convert string to character array
            char[] charArray = str.toCharArray();

            // Initialize two pointers
            int left = 0;
            int right = charArray.length - 1;

            // Use two-pointer approach to compare characters
            while (left < right) {
                // Compare characters at the current pointers
                if (charArray[left] != charArray[right]) {
                    return false; // Characters do not match, not a palindrome
                }

                // Move pointers towards each other
                left++;
                right--;
            }

            return true; // All characters matched, it is a palindrome
        }

        public static void main(String[] args) {
            String word1 = "madam";
            String word2 = "hello";

            System.out.println(word1 + " is a palindrome: " + isPalindrome(word1));
            System.out.println(word2 + " is a palindrome: " + isPalindrome(word2));
        }
    }
