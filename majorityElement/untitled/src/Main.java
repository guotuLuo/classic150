import java.util.Arrays;

import static java.util.Arrays.sort;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        int[] nums = new int[]{2,2,1,1,1,2,2};
        System.out.println(majorityElement(nums));
    }

    public static int majorityElement(int[] nums){
        int l = nums.length;
        nums = Arrays.stream(nums).sorted().toArray();
        int begin = 0;
        int maxlen = 1;
        int majority = nums[0];
        int temp;
        int i = 1;
        for (; i < l; i++) {
            if(nums[i] != nums[begin]){
                temp = maxlen;
                maxlen = Math.max(i - begin, maxlen);
                if(maxlen > temp){
                    majority = nums[begin];
                }
                begin = i;
            }
        }
        temp = maxlen;
        maxlen = Math.max(i - begin, maxlen);
        if(maxlen > temp){
            majority = nums[begin];
        }
        return majority;
    }
}