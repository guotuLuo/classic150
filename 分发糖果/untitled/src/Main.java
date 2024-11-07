import java.util.Arrays;

public class Main {

    // 1 3 4 5 2
    // 1 1 1 1 1
    public static void main(String[] args) {
        int[] ratings = new int[]{1, 3, 4, 5, 2};
        System.out.println(candy(ratings));
    }
    public static int candy(int[] ratings) {
        int n = ratings.length;
        if(n == 1){
            return 1;
        }
        int[] data = new int[n];
        int res = 0;
        Arrays.fill(data, 1);
        data[0] = ratings[0] > ratings[1] ? 2 : 1;
        for (int i = 1; i < n - 1; i++) {
            if(ratings[i] > ratings[i - 1]){
                data[i] = data[i - 1] + 1;
            }
        }
        data[n - 1] = ratings[n - 1] > ratings[n - 2] ? data[n - 2] + 1 : 1;
        for (int i = n - 2; i >= 0; i--) {
            if(ratings[i] > ratings[i + 1] && data[i] <= data[i + 1]){
                data[i] = data[i + 1] + 1;
            }
        }
        for (int i = 0; i < n; i++) {
            res += data[i];
        }
        return res;
    }
}
