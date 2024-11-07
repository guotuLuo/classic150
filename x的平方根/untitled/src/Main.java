public class Main {
    public static void main(String[] args) {
        mySqrt(1);
    }

    public static int mySqrt(int x) {
        int low = 0;
        int high = x;
        int ans = 0;
        while(low <= high){
            int mid = (low + high) / 2;
            if((long) mid * mid <= x){
                ans = mid;
                low = mid + 1;
            }else {
                high = mid - 1;
            }
        }
        return ans;
    }

    public static int sqrt(int C){
        double t = C;
        double nextT = t / 2 + C / (2 * t);
        while(t - nextT >= 1e-5){
            t = nextT;
            nextT = t / 2 + C / (2 * t);
        }
        return (int) t;
    }
}
