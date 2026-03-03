public class PalindromeChecker {

    // Node class for the Singly Linked List
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        // 1. Find the middle of the linked list
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 2. Reverse the second half of the list
        ListNode secondHalfHead = reverseList(slow.next);
        ListNode firstHalfHead = head;

        // 3. Compare the first and reversed second halves
        ListNode currentSecond = secondHalfHead;
        while (currentSecond != null) {
            if (firstHalfHead.val != currentSecond.val) {
                return false;
            }
            firstHalfHead = firstHalfHead.next;
            currentSecond = currentSecond.next;
        }

        // Optional: Restore the original list (good practice for general use)
        // reverseList(secondHalfHead); // Reverse back
        // slow.next = secondHalfHead;  // Re-attach

        return true;
    }
    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next; // Save next node
            curr.next = prev;              // Reverse pointer
            prev = curr;                   // Move prev to current
            curr = nextTemp;               // Move curr to next
        }
        return prev; // prev is the new head of the reversed list
    }

    // Example Usage (to be run in a main method or an online editor like [LeetCode](https://leetcode.com))
    public static void main(String[] args) {
        PalindromeChecker solution = new PalindromeChecker();

        // Example 1: Palindrome (1 -> 2 -> 3 -> 2 -> 1)
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(2);
        head1.next.next.next.next = new ListNode(1);
        System.out.println("List 1 is palindrome: " + solution.isPalindrome(head1)); // Output: true

        // Example 2: Not a Palindrome (1 -> 2 -> 3 -> 4)
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        head2.next.next = new ListNode(3);
        head2.next.next.next = new ListNode(4);
        System.out.println("List 2 is palindrome: " + solution.isPalindrome(head2)); // Output: false
    }
}
