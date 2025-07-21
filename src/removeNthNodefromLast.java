class Solution2 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode fast = dummy, slow = dummy;

        for (int i = 0; i <= n; i++) fast = fast.next;
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }
}

public class removeNthNodefromLast {
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + (head.next != null ? " -> " : ""));
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Sample List: 1 -> 2 -> 3 -> 4 -> 5, remove 2nd from end => 1 -> 2 -> 3 -> 5
        ListNode head = new ListNode(1, new ListNode(2,
                new ListNode(3, new ListNode(4,
                        new ListNode(5)))));

        System.out.println("Original:");
        printList(head);

        Solution2 sol = new Solution2();
        ListNode updated = sol.removeNthFromEnd(head, 2);

        System.out.println("After removing 2nd from end:");
        printList(updated);
    }
}
