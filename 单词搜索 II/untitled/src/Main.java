import java.util.ArrayList;
import java.util.List;

public class Main {
    public static class Node{
        Node[] next;
        public Node(){
            next = new Node[26];
        }
    }
    public static Node root = new Node();
    public static boolean[][] visited;
    public static List<String> findWords(char[][] board, String[] words) {
        int row = board.length;
        int col = board[0].length;
        visited = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                visited[i][j] = true;
                build(i, j, board, root);
                visited[i][j] = false;
            }
        }
        List<String> res = new ArrayList<>();
        for (String word : words) {
            if(search(word)){
                res.add(word);
            }
        }
        return res;
    }

    public static void build(int i, int j, char[][] board, Node root){
        Node temp = root;
        int row = board.length;
        int col = board[0].length;
        char c = board[i][j];
        if(temp.next[c - 'a'] == null){
            temp.next[c - 'a'] = new Node();
        }
        temp = temp.next[c - 'a'];
        if(i - 1 >= 0 && !visited[i - 1][j]){
            visited[i - 1][j] = true;
            build(i - 1, j, board, temp);
            visited[i - 1][j] = false;
        }
        if(i + 1 < row && !visited[i + 1][j]){
            visited[i + 1][j] = true;
            build(i + 1, j, board, temp);
            visited[i + 1][j] = false;
        }
        if(j - 1 >= 0 && !visited[i][j - 1]){
            visited[i][j - 1] = true;
            build(i, j - 1, board, temp);
            visited[i][j - 1] = false;
        }
        if(j + 1 < col && !visited[i][j + 1]){
            visited[i][j + 1] = true;
            build(i, j + 1, board, temp);
            visited[i][j + 1] = false;
        }
    }

    public static boolean search(String word){
        Node temp = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(temp.next[c - 'a'] == null){
                return false;
            }
            temp = temp.next[c - 'a'];
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'o','a','a','n'},
                {'e','t','a','e'},
                {'i','h','k','r'},
                {'i','f','l','v'}
        };
        String[] words = new String[]{
                "oath","pea","eat","rain"
        };
        List<String> words1 = findWords(board, words);
        for (String s : words1) {
            System.out.println(s);
        }
    }
}
