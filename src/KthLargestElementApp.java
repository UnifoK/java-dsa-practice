import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargestElementApp {

    // Original Solution class (unchanged)
    static class Solution {
        public int findKthLargest(int[] nums, int k) {
            Queue<Integer> minHeap = new PriorityQueue<>();

            for (int i = 0; i < nums.length; i++) {
                minHeap.add(nums[i]);
                if (minHeap.size() > k)
                    minHeap.poll();  // Remove smallest to keep k largest in heap
            }
            return minHeap.peek(); // k-th largest will be at the top
        }
    }

    // Main method to test the function
    public static void main(String[] args) {
        int[] nums = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        int k = 4;

        Solution sol = new Solution();
        int kthLargest = sol.findKthLargest(nums, k);

        System.out.println("The " + k + "th largest element is: " + kthLargest);
    }
}
