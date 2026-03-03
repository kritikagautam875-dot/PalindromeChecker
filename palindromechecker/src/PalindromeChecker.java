import java.util.ArrayList;
import java.util.List;

public class PalindromeChecker {

    public static void main(String[] args) {

        String testInput = "A man a plan a canal Panama".repeat(100);

        List<PalindromeStrategy> strategies = new ArrayList<>();
        strategies.add(new StackStrategy());
        strategies.add(new DequeStrategy());

        System.out.println("--- Palindrome Performance Benchmark ---");

        for (PalindromeStrategy strategy : strategies) {

            // Warm-up
            for (int i = 0; i < 1000; i++)
                strategy.isPalindrome(testInput);

            long startTime = System.nanoTime();
            boolean result = strategy.isPalindrome(testInput);
            long endTime = System.nanoTime();

            long duration = endTime - startTime;

            System.out.printf(
                "Strategy: %-15s | Time: %10d ns | Result: %b%n",
                strategy.getClass().getSimpleName(),
                duration,
                result
            );
        }
    }
}

