import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        int[] nums = new int[]{-1,0,1,2,-1,-4,-2,-3,3,0,4};
        List<List<Integer>> list = threeSum(nums);
        for (List<Integer> integers : list) {
            for (Integer integer : integers) {
                System.out.print(integer);
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> threeSum(int[] nums){
        List<List<Integer>> list = new ArrayList<>();
        int len = nums.length;
        nums = Arrays.stream(nums).sorted().toArray();
        for (int i = 0; i < len; i++) {
            int temp = 0 - nums[i];
            for (int j = i + 1; j < len; j++) {
                int cur = temp - nums[j];
                int res = binarySerach(nums, cur, j + 1);
                if(res != -1){
                    List<Integer> l = new ArrayList<>();
                    l.add(nums[i]);
                    l.add(nums[j]);
                    l.add(nums[res]);
                    if(!list.contains(l)){
                        list.add(l);
                    }
                }
            }
        }
        return list;
    }

    public static int binarySerach(int[] nums, int target, int index){
        int low = index;
        int high = nums.length - 1;
        while(low <= high){
            int mid = (low + high) / 2;
            if(nums[mid] < target){
                low = mid + 1;
            }else if(nums[mid] > target){
                high = mid - 1;
            }else{
                return mid;
            }
        }
        return -1;
    }
}