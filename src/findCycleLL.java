class Solution4 {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast)
                return true;
        }
        return false;
    }
}

public class findCycleLL {
    public static void main(String[] args) {
        // Creating a list: 1 -> 2 -> 3 -> 4 -> 5 -> back to node 2 (cycle)
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node2; // Cycle here

        Solution4 sol = new Solution4();
        boolean hasCycle = sol.hasCycle(node1);

        System.out.println("Has Cycle? " + hasCycle); // Expected: true
    }
}
