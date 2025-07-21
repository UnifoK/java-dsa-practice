// Solution class containing the merge logic
class Solution1 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode();
        ListNode curr1 = list1, curr2 = list2, tail = dummy;

        while (curr1 != null && curr2 != null) {
            if (curr1.val < curr2.val) {
                tail.next = curr1;
                curr1 = curr1.next;
            } else {
                tail.next = curr2;
                curr2 = curr2.next;
            }
            tail = tail.next;
        }

        // Append remaining nodes
        tail.next = (curr1 != null) ? curr1 : curr2;

        return dummy.next; // Head of the merged list
    }
}

public class MergeTwoSortedLL{
    public static void printList(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + (curr.next != null ? " -> " : ""));
            curr = curr.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode list1 = new ListNode(1, new ListNode(3, new ListNode(5)));
        ListNode list2 = new ListNode(2, new ListNode(4, new ListNode(6)));

        System.out.println("List 1:");
        printList(list1);

        System.out.println("List 2:");
        printList(list2);

        // Merge the lists
        Solution1 solution = new Solution1();
        ListNode merged = solution.mergeTwoLists(list1, list2);

        System.out.println("Merged List:");
        printList(merged);
    }
}
