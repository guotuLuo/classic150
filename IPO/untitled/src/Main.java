import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.function.IntFunction;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        int k = 2;
        int w = 0;
        int[] profits = new int[]{1, 2, 3};
        int[] capital = new int[]{0, 1, 1};
        int maximizedCapital = findMaximizedCapital(k, w, profits, capital);
        System.out.println(maximizedCapital);
    }


    public static class node{
        public node(int capital, int profit){
            this.capital = capital;
            this.profit = profit;
        }

        int capital;
        int profit;
        public static Comparator<node> capitalComparator = new Comparator<node>() {
            public int compare(node n1, node n2) {
                return Integer.compare(n1.capital, n2.capital);
            }
        };
    }
    public static int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = capital.length;
        node[] data = new node[n];
        for (int i = 0; i < n; i++) {
            data[i] = new node(capital[i], profits[i]);
        }
        Arrays.sort(data, node.capitalComparator);
        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b)->b[1]-a[1]);
        int index = 0;
        while(k-- > 0){
            for (;index < n && w >= data[index].capital; index++) {
                node temp = data[index];
                int p = temp.profit;
                int c = temp.capital;
                queue.add(new int[]{c, p});
            }
            int[] poll = queue.poll();
            if(poll != null){
                w += poll[1];
            }
        }
        return w;
    }
}
