import java.util.ArrayList;
import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
//        int[][] intervals = new int[][]{{1,2},{3,5},{6,7},{8,10},{12,16}};
        int[][] intervals = new int[][]{{1,3},{6,9}};
        int[] newInterval = new int[]{2,5};
        int[][] array = insert(intervals, newInterval);
        for (int[] ints : array) {
            for (int anInt : ints) {
                System.out.print(anInt);
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        int len = intervals.length;
        int[][] arr = new int[len + 1][];


    }
}