import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if(hashMap.containsKey(nums[i])){
                if(Math.abs(i - hashMap.get(nums[i])) <= k){
                    return true;
                }
            }
            hashMap.put(nums[i], i);
        }
        return false;
    }
}