class Solution3 {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;

        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode prev = null, nextN = null, curr = slow.next;
        slow.next = null;
        while (curr != null) {
            nextN = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextN;
        }

        ListNode first = head, second = prev;
        while (second != null) {
            ListNode temp1 = first.next, temp2 = second.next;
            first.next = second;
            second.next = temp1;
            first = temp1;
            second = temp2;
        }
    }
}

public class reorderLL {
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + (head.next != null ? " -> " : ""));
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Input: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1, new ListNode(2,
                new ListNode(3, new ListNode(4,
                        new ListNode(5)))));

        System.out.println("Original List:");
        printList(head);

        new Solution3().reorderList(head);

        System.out.println("Reordered List:");
        printList(head);
    }
}
