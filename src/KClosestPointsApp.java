import java.util.PriorityQueue;
import java.util.Queue;

public class KClosestPointsApp {

    // Original Solution class (unchanged)
    static class Solution {
        public int[][] kClosest(int[][] points, int k) {
            Queue<int[]> maxHeap = new PriorityQueue<>(
                    (a, b) -> (b[0] * b[0] + b[1] * b[1]) - (a[0] * a[0] + a[1] * a[1])
            );
            for (int[] point : points) {
                maxHeap.add(point);
                if (maxHeap.size() > k)
                    maxHeap.poll();
            }
            int[][] result = new int[k][2];
            for (int i = 0; i < k; i++)
                result[i] = maxHeap.poll();
            return result;
        }
    }

    // Main method to test the function
    public static void main(String[] args) {
        int[][] points = {{1, 3}, {-2, 2}, {5, 8}, {0, 1}};
        int k = 2;

        Solution sol = new Solution();
        int[][] closest = sol.kClosest(points, k);

        System.out.println("The " + k + " closest points to the origin are:");
        for (int[] point : closest) {
            System.out.println("[" + point[0] + ", " + point[1] + "]");
        }
    }
}
