import java.util.ArrayList;
import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        int[] nums = new int[]{0,2,3,4,6,8,9};
        List<String> list = summaryRanges(nums);
        for (String s : list) {
            System.out.print(s);
            System.out.print(" ");
        }
    }

    public static List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>();
        int len = nums.length;
        int start = 0;
        int end = 0;
        while (start < len && end < len){
            if(nums[end] - nums[start] == end - start){
                end++;
            }else{
                if(end - start == 1){
                    String temp = "" + nums[start];
                    list.add(temp);
                }else{
                    String temp = "" + nums[start] + "->" + nums[end - 1];
                    list.add(temp);
                }
                start = end;
            }
        }
        end--;
        if (start < len){
            if(end - start == 0){
                String temp = "" + nums[start];
                list.add(temp);
            }else{
                String temp = "" + nums[start] + "->" + nums[end];
                list.add(temp);
            }
        }
        return list;
    }
}