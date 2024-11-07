import java.util.Arrays;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        int[] hours = new int[]{72,48,24,3};
        int temp = countCompleteDayPairs(hours);
        System.out.println(temp);
    }

    public static int countCompleteDayPairs(int[] hours) {
        int len = hours.length;
        hours = Arrays.stream(hours).sorted().toArray();
        int count = 0;
        for (int i = 0; i < len; i++) {
            int res = binartSerach(hours, hours[i], i + 1);
            if(res != -1){
                count++;
            }
        }
        return count;
    }

    public static int binartSerach(int[] nums, int k, int low){
        int high = nums.length - 1;
        int mid;
        while(low <= high){
            mid = (low + high) / 2;
            if((nums[mid] + k) % 24 == 0){
                return mid;
            } else if(nums[mid] < k){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return -1;
    }
}