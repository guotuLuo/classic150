import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        //int[] citations = new int[]{0,0,0,1,2,3,3,3,3,4,6,9,9};
        // 2 2     3 3           1 1
        int[] citations = new int[]{1, 2, 3};
        int h = hIndex(citations);
        System.out.println(h);
    }

    public static int hIndex(int[] citations) {
        int len = citations.length;
        citations = Arrays.stream(citations).sorted().toArray();
        int h = 0;
        int curlen = 1;
        for (int i = len - 1; i >= 0; i--) {
            if(citations[i] >= curlen){
                h = Math.max(h, curlen++);
            }
        }
        return h;
    }
}