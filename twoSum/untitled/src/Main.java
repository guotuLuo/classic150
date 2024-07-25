// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

    }

    // 2,7,11,15
    public int[] twoSum(int[] numbers, int target) {
        int len = numbers.length;
        for (int i = 0; i < len; i++) {
            int res = binartSerach(numbers, target - numbers[i], i + 1);
            if(res != -1){
                return new int[]{i + 1, res + 1};
            }
        }
        return new int[]{};
    }

    public static int binartSerach(int[] nums, int k, int low){
        int high = nums.length - 1;
        int mid;
        while(low <= high){
            mid = (low + high) / 2;
            if(nums[mid] == k){
                return mid;
            } else if(nums[mid] < k){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return -1;
    }

    public int[] twoSum(int[] numbers, int target) {
       int low = 0;
       int high = numbers.length - 1;
       while(low < high){
           if(numbers[low] + numbers[high] == target){
               return new int[]{low + 1, high + 1};
           }else if (numbers[low] + numbers[high] < target){
               low++;
           }else if(numbers[low] + numbers[high] > target){
               high--;
           }
       }
       return null;
    }
}