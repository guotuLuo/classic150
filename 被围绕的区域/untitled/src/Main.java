import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'O', 'O', 'O', 'O', 'X', 'X'},
                {'O', 'O', 'O', 'O', 'O', 'O'},
                {'O', 'X', 'O', 'X', 'O', 'O'},
                {'O', 'X', 'O', 'O', 'X', 'O'},
                {'O', 'X', 'O', 'X', 'O', 'O'},
                {'O', 'X', 'O', 'O', 'O', 'O'},

        };
        solve(board);
    }


    public static void solve(char[][] board) {
        int row = board.length;
        int col = board[0].length;
        boolean[][] visited = new boolean[row][col];
        boolean[][] toxic = new boolean[row][col];
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(!visited[i][j]){
                    boolean flag = dfs(board, i, j, list, visited, toxic);
                    if(flag) {
                        for (int[] ints : list) {
                            board[ints[0]][ints[1]] = 'X';
                        }
                    }
                    list.clear();
                }
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean dfs(char[][] board, int i, int j, List<int[]> list, boolean[][] visited, boolean[][] toxic){
        if(board[i][j] == 'O' && !visited[i][j] && !toxic[i][j]){
            visited[i][j] = true;
            if(i != 0 && i != board.length - 1 && j != 0 && j != board[0].length - 1){
                if(toxic[i - 1][j] || toxic[i + 1][j] || toxic[i][j - 1] || toxic[i][j + 1]){
                    toxic[i][j] = true;
                    return false;
                }
                list.add(new int[]{i, j});
                boolean a = dfs(board, i + 1, j, list, visited, toxic);
                boolean b = dfs(board, i - 1, j, list, visited, toxic);
                boolean c = dfs(board, i, j - 1, list, visited, toxic);
                boolean d = dfs(board, i, j + 1, list, visited, toxic);
                return a && b&& c && d;
            }else{
                toxic[i][j] = true;
                return false;
            }
        }
        visited[i][j] = true;
        return true;
    }
}
