import java.util.*;

public class Main {
    public static void main(String[] args) {

    }

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
        List<List<Integer>> res = new ArrayList<>();
        int m = nums1.length;
        int n = nums2.length;
        for (int i = 0; i < m && i < k; i++) {
            queue.add(new int[]{nums1[i] + nums2[0], i, 0});
        }
        while (res.size() < k) {
            int[] poll = queue.poll();
            int i = poll[1];
            int j = poll[2];
            List<Integer> temp = new ArrayList<>();
            temp.add(nums1[i]);
            temp.add(nums2[j]);
            res.add(temp);
            if(j + 1 < nums2.length) {
                queue.add(new int[]{nums1[i] + nums2[j + 1], i, j + 1});
            }
        }
        return res;
    }
}
