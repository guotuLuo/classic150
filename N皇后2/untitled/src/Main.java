public class Main {
    public static int[][] visited;
    public static int res = 0;

    public static void main(String[] args) {
        int i = totalNQueens(5);
        System.out.println(i);
    }
    public static int totalNQueens(int n) {
        visited = new int[n][n];
        for (int i = 0; i < n; i++) {
            occupy(visited, 0, i, n);
            // 有点蠢
            dfs(visited, 0,1, n);
            reoccupy(visited, 0, i, n);
        }
        return res;
    }

    public static void dfs(int[][] visited, int i, int count, int n){
        if(count == n){
            res++;
            return;
        }
        for (int k = 0; k < n && i + 1 < n; k++) {
            if(visited[i + 1][k] == 0){
                occupy(visited, i + 1, k, n);
                dfs(visited, i + 1, count + 1, n);
                reoccupy(visited, i + 1, k, n);
            }
        }
    }
    
    public static void occupy(int[][] visited, int i, int j, int n){
        for (int k = 0; k < n; k++) {
            visited[i][k]++;
        }
        for (int k = 0; k < n; k++) {
            visited[k][j]++;
        }
        int index = 1;
        while(i + index < n && j + index < n){
            visited[i + index][j + index]++;
            index++;
        }
        index = 1;
        while(i + index < n && j - index >= 0){
            visited[i + index][j - index]++;
            index++;
        }
    }

    public static void reoccupy(int[][] visited, int i, int j, int n){
        for (int k = 0; k < n; k++) {
            visited[i][k]--;
        }
        for (int k = 0; k < n; k++) {
            visited[k][j]--;
        }
        int index = 1;
        while(i + index < n && j + index < n){
            visited[i + index][j + index]--;
            index++;
        }
        index = 1;
        while(i + index < n && j - index >= 0){
            visited[i + index][j - index]--;
            index++;
        }
    }
}
