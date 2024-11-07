import java.util.ArrayList;
import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        int[] nums = new int[]{0,1,2,2,3,0,4,2};
        removeElement(nums, 2);
        for (int num : nums) {
            System.out.println(num);
        }
    }

    public static int removeElement(int[] nums, int val) {
        int len = nums.length;
        int index = len - 1;
        int k = 0;
        for (int i = 0; i < len;i++) {
            if(nums[i] == val){
                swap(nums, index--, i);
                k++;
                i--;
            }
            if(i >= index){
                break;
            }
        }
        return len - k;
    }

    public static void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}