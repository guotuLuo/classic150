import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] data = new int[n];
        for (int i = 0; i < n; i++) {
            data[i] = in.nextInt();
        }
        int totalTrips = in.nextInt();
        long res = minimumTime(data, totalTrips);
        System.out.println(res);
    }

    public static long minimumTime(int[] time, int totalTrips) {
        int[] array = Arrays.stream(time).sorted().toArray();

    }
}
