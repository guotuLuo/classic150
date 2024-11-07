import java.util.Arrays;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
        int[] nums2 = new int[]{2, 5, 6};
        merge(nums1, 3, nums2, 3);
        for (int i : nums1) {
            System.out.println(i);
        }
    }
    // [1 2 3 5 9 10 12 13]  [4 7 8 11]   [1 2 3 5 9 10 12 13]
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;
        int p2 = n - 1;
        int tail = m + n - 1;
        int cur = 0;

        while(p1 >= 0|| p2 >= 0){
            if(p1 == -1){
                cur = nums2[p2--];
            }else if(p2 == -1){
                cur = nums1[p1--];
            }else if(nums1[p1] < nums2[p2]){
                cur = nums2[p2--];
            }else if(nums1[p1] >= nums2[p2]){
                cur = nums1[p1--];
            }
            nums1[tail--] = cur;
        }
    }
}