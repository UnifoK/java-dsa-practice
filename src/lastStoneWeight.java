import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class lastStoneWeight {

    // Original Solution class without changes
    static class Solution {
        public int lastStoneWeight(int[] stones) {
            Queue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
            for (int i = 0; i < stones.length; i++) {
                maxHeap.add(stones[i]);
            }
            while (maxHeap.size() > 1) {
                int temp1 = maxHeap.poll();
                int temp2 = maxHeap.poll();
                maxHeap.add((temp1 < temp2) ? (temp2 - temp1) : (temp1 - temp2));
            }
            return maxHeap.peek();
        }
    }

    // Main method to test the function
    public static void main(String[] args) {
        int[] stones = {2, 7, 4, 1, 8, 1};
        Solution sol = new Solution();
        int result = sol.lastStoneWeight(stones);
        System.out.println("Last stone weight: " + result);
    }
}
