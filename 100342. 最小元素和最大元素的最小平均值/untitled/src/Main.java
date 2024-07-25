import java.util.Arrays;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        int[] nums = new int[]{7,8,3,4,15,13,4,1};
        int minimumAverage(nums);
    }

    public static double minimumAverage(int[] nums) {
        nums = Arrays.stream(nums).sorted().toArray();
        int len = nums.length;
        double[] average = new double[len / 2];
        int begin = 0;
        int end = len - 1;
        while(begin < end){
            average[begin] = (double) (nums[begin] + nums[end]) / 2;
            begin++;
            end--;
        }
        double[] array = Arrays.stream(average).sorted().toArray();
        return array[0];
    }
}