import java.util.PriorityQueue;

public class kthLargestPQ {

    // Original KthLargest class without any changes
    static class KthLargest {
        private PriorityQueue<Integer> minHeap;
        private int k;

        public KthLargest(int k, int[] nums) {
            this.k = k;
            minHeap = new PriorityQueue<Integer>();
            for (int i = 0; i < nums.length; i++) {
                minHeap.add(nums[i]);
                if (minHeap.size() > this.k)
                    minHeap.poll();
            }
        }

        public int add(int val) {
            minHeap.add(val);
            if (minHeap.size() > this.k)
                minHeap.poll();
            return minHeap.peek();
        }
    }

    // Main method to test KthLargest
    public static void main(String[] args) {
        int[] nums = {4, 5, 8, 2};
        int k = 3;
        KthLargest obj = new KthLargest(k, nums);

        System.out.println("Add 3 -> " + obj.add(3));   // returns 4
        System.out.println("Add 5 -> " + obj.add(5));   // returns 5
        System.out.println("Add 10 -> " + obj.add(10)); // returns 5
        System.out.println("Add 9 -> " + obj.add(9));   // returns 8
        System.out.println("Add 4 -> " + obj.add(4));   // returns 8
    }
}
