public class Main {

    public static void main(String[] args) {
        boolean flag = searchMatrix(new int[][]{{1}}, 1);
        System.out.println(flag);
    }
    public static boolean searchMatrix(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; i++) {
            if(searchInsert(matrix[i], target)){
                return true;
            }
        }
        return false;
    }

    public static boolean searchInsert(int[] nums, int t){
        int high = nums.length - 1;
        int low = 0;
        while(low <= high){
            int mid = (low + high) / 2;
            if(t == nums[mid]){
                return true;
            }
            else if(t < nums[mid]){
                high = mid - 1;
            }else {
                low = mid + 1;
            }
        }
        return false;
    }
}
