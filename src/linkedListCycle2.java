class Solution5 {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head, fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                slow = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return fast; // Starting node of the cycle
            }
        }
        return null; // No cycle
    }
}

public class linkedListCycle2 {
    public static void main(String[] args) {
        // Creating a list: 3 -> 2 -> 0 -> -4 -> back to node 2 (cycle)
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(-4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2; // Cycle starts at node2

        Solution5 sol = new Solution5();
        ListNode startNode = sol.detectCycle(node1);

        if (startNode != null)
            System.out.println("Cycle starts at node with value: " + startNode.val);
        else
            System.out.println("No cycle detected.");
    }
}
