import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {
    private int[] parent;
    private double[] weight;
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        double[] res = new double[queries.size()];
        init(2 * equations.size());
        HashMap<String, Integer> map = new HashMap<>();
        int index = 0;
        for (int i = 0; i < equations.size(); i++) {
            String s = equations.get(i).get(0);
            if(!map.containsKey(s)){
                map.put(s, index++);
            }
            String t = equations.get(i).get(1);
            if(!map.containsKey(t)){
                map.put(t, index++);
            }
            union(map.get(s), map.get(t), values[i]);
        }
        for (int i = 0; i < queries.size(); i++) {
            String s = queries.get(i).get(0);
            String t = queries.get(i).get(1);
            if(!map.containsKey(s) || !map.containsKey(t)){
                res[i] = -1.0d;
            }else{
                int x = map.get(s);
                int y = map.get(t);
                res[i] = query(x, y);
            }
        }
        return res;
    }

    // 并查集
    public void init(int n){
        parent = new int[n];
        weight = new double[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            weight[i] = 1.0d;
        }
    }

    // 路径压缩
    public int find(int x){
        if(x != parent[x]){
            int origin = find(parent[x]);
            parent[x] = origin;
            weight[x] = weight[x] * weight[origin];
        }
        return parent[x];
    }

    public void union(int x, int y, double value){
        int rootX = find(x);
        int rootY = find(y);
        if(rootX == rootY){
            return;
        }
        parent[rootX] = rootY;
        weight[rootX] = weight[y] * value / weight[x];
    }

    public double query(int x, int y){
        int rootX = find(x);
        int rootY = find(y);
        if(rootX == rootY){
            return weight[x] / weight[y];
        }else{
            return -1.0d;
        }
    }
}
