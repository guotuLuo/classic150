// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

    }

    public static int maxArea(int[] height){
        int low = 0;
        int high = height.length - 1;
        int maxArea = 0;
        while(low < high){
            int curArea = Math.min(height[low], height[high]) * (high - low);
            maxArea = Math.max(maxArea, curArea);
            if(height[low] < height[high]){
                low++;
            }else{
                high--;
            }
        }
        return maxArea;
    }
}