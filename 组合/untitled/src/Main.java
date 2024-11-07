import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<List<Integer>> combine = combine(3, 3);
        for (List<Integer> list : combine) {
            System.out.println(Arrays.toString(list.toArray()));
        }
    }


    public static List<List<Integer>> combine(int n, int k) {
        boolean[] visited = new boolean[n + 1];
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 1; i <= n - k + 1; i++) {
            List<Integer> list = new ArrayList<>();
            visited[i] = true;
            list.add(i);
            dfs(i + 1, n, k, list, visited, res);
        }
        return res;
    }

    public static void dfs(int i, int n, int k, List<Integer> list, boolean[] visited, List<List<Integer>> res){
        if(list.size() == k){
            res.add(new ArrayList<>(list));
            return;
        }
        if(i > n){
            return;
        }
        if(!visited[i]){
            for (int j = i; j <= n; j++) {
                visited[i] = true;
                list.add(j);
                dfs(j + 1, n, k, list, visited, res);
                list.remove(list.size() - 1);
                visited[i] = false;
            }
        }
    }
}
