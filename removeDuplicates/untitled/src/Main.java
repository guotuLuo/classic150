import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        int[] nums = new int[]{0,0,1,1,1,1,2,3,3};
        int k = removeDuplicates(nums);
        System.out.println(k);
    }

//    public static int removeDuplicates(int[] nums) {
//        int len = nums.length;
//        List<Integer> list = new ArrayList<>();
//        for (int i = 0; i < len; i++) {
//            if(!list.contains(nums[i])){
//                list.add(nums[i]);
//            }
//        }
//        int size = list.size();
//        for (int i = 0; i < size; i++) {
//            nums[i] = list.get(i);
//        }
//        return size;
//    }

//    public static int removeDuplicates(int[] nums) {
//        int len = nums.length;
//        int temp = nums[0];
//        int index = 1;
//        for (int i = 1; i < len; i++) {
//            if(nums[i] != temp){
//                temp = nums[i];
//                nums[index++] = temp;
//            }
//        }
//        return index;
//    }
    public static int removeDuplicates(int[] nums) {
        int len = nums.length;
        int temp = nums[0];
        int index = 1;
        int count = 1;
        for (int i = 1; i < len; i++) {
            if(nums[i] == temp && count == 1){
                count = 0;
                nums[index++] = temp;
            }
            else if(nums[i] != temp){
                count = 1;
                temp = nums[i];
                nums[index++] = temp;
            }
        }
        return index;
    }
}