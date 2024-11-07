public class Main {
    public int findPeakElement(int[] nums) {
        if(nums.length == 1){
            return 0;
        }
        // 如果找峰值，必定是 nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]
        // 1. nums[mid - 1] < nums[mid] < nums[mid + 1]   ->
        // 2. nums[mid - 1] > nums[mid] > nums[mid + 1]   <-
        // 3. nums[mid - 1] > nums[mid] < nums[mid + 1]   任意方向峰值
        // 4. nums[mid - 1] < nums[mid] > nums[mid + 1]   返回mid


        // 归纳一下
        // nums[mid - 1] < nums[mid] > nums[mid + 1] 返回mid
        // nums[mid - 1] > nums[mid] 峰值在左
        // nums[mid] < nums[mid + 1] 峰值在右
        int left = 0;
        int right = nums.length - 1;
        while(left < right){
            int mid = left + (right - left) / 2;
            if(nums[mid] > nums[mid + 1]){
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        return left;
    }
}
