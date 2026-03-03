import java.util.Stack;
import java.util.ArrayDeque;
import java.util.Deque;
interface PalindromeStrategy {
    boolean isPalindrome(String input);
}
class StackStrategy implements PalindromeStrategy {
    @Override
    public boolean isPalindrome(String input) {
        String cleanInput = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        Stack<Character> stack = new Stack<>();

        for (char c : cleanInput.toCharArray()) {
            stack.push(c);
        }

        StringBuilder reversed = new StringBuilder();
        while (!stack.isEmpty()) {
            reversed.append(stack.pop());
        }

        return cleanInput.equals(reversed.toString());
    }
}
class DequeStrategy implements PalindromeStrategy {
    @Override
    public boolean isPalindrome(String input) {
        String cleanInput = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        Deque<Character> deque = new ArrayDeque<>();

        for (char c : cleanInput.toCharArray()) {
            deque.addLast(c);
        }

        while (deque.size() > 1) {
            if (!deque.removeFirst().equals(deque.removeLast())) {
                return false;
            }
        }
        return true;
    }
}
public class PalindromeChecker {
    private PalindromeStrategy strategy;

    // Inject strategy via constructor or setter
    public void setStrategy(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean check(String text) {
        if (strategy == null) {
            throw new IllegalStateException("Strategy not set!");
        }
        return strategy.isPalindrome(text);
    }
}
 class Main {
    public static void main(String[] args) {
        PalindromeChecker checker = new PalindromeChecker();
        String testWord = "Racecar";

        // Dynamic Injection 1: Stack
        checker.setStrategy(new StackStrategy());
        System.out.println("Stack Result: " + checker.check(testWord));

        // Dynamic Injection 2: Deque
        checker.setStrategy(new DequeStrategy());
        System.out.println("Deque Result: " + checker.check(testWord));
    }
}
