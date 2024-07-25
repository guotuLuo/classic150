import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

    }

    public static int minimumArea(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        List<Integer> x = new ArrayList<>();
        List<Integer> y = new ArrayList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(grid[i][j] == 1){
                    x.add(j);
                    y.add(i);
                }
            }
        }
        x.sort((o1, o2) -> o1 - o2);
        y.sort((o1, o2) -> o1 - o2);
        int xlen = x.get(x.size() - 1) - x.get(0) + 1;
        int ylen = y.get(x.size() - 1) - y.get(0) + 1;
        return xlen * ylen;
    }
}