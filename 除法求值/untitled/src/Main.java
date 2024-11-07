import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<List<String>> equations = new ArrayList<>();
        List<String> i1 = new ArrayList<>();
        i1.add("a");
        i1.add("c");
        equations.add(i1);
        List<String> i2 = new ArrayList<>();
        i2.add("b");
        i2.add("e");
        equations.add(i2);
        List<String> i3 = new ArrayList<>();
        i3.add("c");
        i3.add("d");
        equations.add(i3);
        List<String> i4 = new ArrayList<>();
        i4.add("e");
        i4.add("d");
        equations.add(i4);
        double[] values = new double[]{2.0,3.0,0.5,5.0};
        List<List<String>> queries = new ArrayList<>();
        List<String> s1 = new ArrayList<>();
        s1.add("a");
        s1.add("b");
        queries.add(s1);
        double[] doubles = calcEquation(equations, values, queries);
        String string = Arrays.toString(Arrays.stream(doubles).toArray());
        System.out.println(string);
    }
    public static double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        HashMap<String, Integer> s2i = new HashMap<>();
        int n = 0;
        String[][] graph = new String[40][40];
        for (int i = 0; i < equations.size(); i++) {
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);
            if(!s2i.containsKey(a)){
                s2i.put(a, n);
                n++;
            }
            if(!s2i.containsKey(b)){
                s2i.put(b, n);
                n++;
            }
            int x = s2i.get(a);
            int y = s2i.get(b);
            graph[x][y] = ((Double) values[i]).toString();
            graph[y][y] = ((Double) 1.0).toString();
            if(values[i] != 0){
                graph[y][x] = ((Double) (1 / values[i])).toString();
                graph[x][x] = ((Double) 1.0).toString();
            }
        }
        double[] res = new double[queries.size()];
        bfs(graph, n);
        bfs(graph, n);
        for (int i = 0; i < queries.size(); i++) {
            String x = queries.get(i).get(0);
            String y = queries.get(i).get(1);
            Integer a = s2i.get(x);
            Integer b = s2i.get(y);
            if(a != null && b != null && graph[a][b] != null){
                res[i] = Double.parseDouble(graph[a][b]);
            }else{
                res[i] = -1.00000;
            }
        }
        return res;
    }

    public static void bfs(String[][] graph, int n){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(graph[i][j] != null && i != j){
                    for (int k = 0; k < n; k++) {
                        if(graph[i][k] == null){
                            if(graph[j][k] != null && j != k && k != i){
                                graph[i][k] = String.valueOf((Double.parseDouble(graph[i][j]) * Double.parseDouble(graph[j][k])));
                            }
                        }
                    }
                }
            }
        }
    }
}
