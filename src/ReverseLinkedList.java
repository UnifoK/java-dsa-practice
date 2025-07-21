class ListNode {
    int val;
    ListNode next;

    ListNode() {}

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode curr = head, prev = null, temp;

        while (curr != null) {
            temp = curr.next;   // Store next node
            curr.next = prev;   // Reverse current node's pointer
            prev = curr;        // Move prev to current
            curr = temp;        // Move to next node
        }

        return prev; // New head of reversed list
    }
}

// Main class with the main method
public class ReverseLinkedList {
    // Helper method to print linked list
    public static void printList(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + (curr.next != null ? " -> " : ""));
            curr = curr.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Create sample linked list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1,
                new ListNode(2,
                        new ListNode(3,
                                new ListNode(4,
                                        new ListNode(5)))));

        System.out.println("Original List:");
        printList(head);

        // Reverse the linked list
        Solution solution = new Solution();
        ListNode reversedHead = solution.reverseList(head);

        System.out.println("Reversed List:");
        printList(reversedHead);
    }
}
