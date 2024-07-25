import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        int[][] arr = new int[][]{{3,9}, {7,12}, {3, 8}, {9,10}, {2, 9}, {0, 9}, {3, 9}, {0, 6}, {2, 8}};
        int k = findMinArrowShots(arr);
        System.out.println(k);
    }

    public static int findMinArrowShots(int[][] points) {
        // 找到最大公共子区间
        int len = points.length;
        if(len == 1){
            return 1;
        }
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            list.add(points[i]);
        }
        list.sort((o1, o2) -> Integer.compare(o1[0], o2[0]));
        int count = 0;
        for (int i = 0; i < len; ) {
            int end = list.get(i)[1];
            int index = i + 1;
            while(index < len && list.get(index)[0] <= end){
                end = Math.min(end, list.get(index)[1]);
                index++;
            }
            count++;
            i = index;
        }
       return count;
    }
}