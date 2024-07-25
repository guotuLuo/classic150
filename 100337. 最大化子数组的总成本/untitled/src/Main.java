// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

    }
    // 1 -2 -5 -9 -15 6
    // 3 + 4 -15  = -8
    // 1 + 5 + 15 - 11 = 10
    public long maximumTotalCost(int[] nums) {
        int len = nums.length;
        int cur = 0;
        int res = 0;
        while(cur < len){
            if( cur + 1 < len){
                if(nums[cur] > 0 && nums[cur + 1] > 0){
                    res += nums[cur];
                    cur++;
                }else if(nums[cur] > 0 && nums[cur + 1] < 0){
                    int next = cur + 1;
                    while(next < len && nums[next] < 0){
                        next++;
                    }
                    next--;

                }
            }
        }
    }
}