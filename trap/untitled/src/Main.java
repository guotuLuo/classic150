public class Main {
    public int trap(int[] height) {
        int n = height.length;
        int[] leftMax = new int[n + 1];
        leftMax[0] = height[0];
        int[] rightMax = new int[n + 1];
        rightMax[n] = height[n - 1];

    }
}
