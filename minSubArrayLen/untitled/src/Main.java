import java.util.Arrays;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        int target = 15;
        int[] nums = new int[]{1,2,3,4,5};
        int res = minSubArrayLen(target, nums);
        System.out.println(res);
    }

    public static int minSubArrayLen(int target, int[] nums) {
        int len = nums.length;
        int begin = 0;
        int end = 1;
        int minLen = len;
        int res = nums[0];
        boolean flag = false;
        while(end <= len){
            if(res >= target){
                minLen = Math.min(minLen, end - begin);
                flag = true;
                if(res - nums[begin] >= target){
                    res -= nums[begin];
                    begin++;
                }else{
                    res -= nums[begin];
                    begin++;
                    end++;
                    if(end <= len){
                        res += nums[end - 1];
                    }
                }
            }else{
                end++;
                if(end <= len){
                    res += nums[end - 1];
                }
            }
        }
        if (flag){
            return minLen;
        }else{
            return 0;
        }
    }
}