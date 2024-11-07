import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
        int[] hours = new int[]{72,48,24,3};
        System.out.println(countCompleteDayPairs(hours));
    }

    public static long countCompleteDayPairs(int[] hours) {
        int n = hours.length;
        long ans = 0;
        int[] data = new int[24];
        for (int i = 0; i < n; i++) {
            data[hours[i] % 24]++;
        }
        for (int i = 1; i < 12; i++) {
            ans += (long) data[i] * data[(24 - i) % 24];
        }
        ans += (long) data[0] * (data[0] - 1) / 2;
        ans += (long) data[12] * (data[12] - 1) / 2;
        return ans;
    }
}
