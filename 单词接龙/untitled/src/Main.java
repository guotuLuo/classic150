import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {

    }

    public class node{
        public node(String s, int step){
            this.s = s;
            this.step = step;
        }
        public String s;
        public int step;
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int n = wordList.size();
        int l = endWord.length();
        boolean[] visited = new boolean[n];
        Queue<node> queue = new LinkedList<>();
        queue.offer(new node(beginWord, 0));
        while(!queue.isEmpty()){
            node temp = queue.poll();
            String s = temp.s;
            int step = temp.step;
            if(s.equals(endWord)){
                return step + 1;
            }
            for (int i = 0; i < n; i++) {
                int count = 0;
                if(!visited[i]){
                    for (int j = 0; j < l; j++) {
                        if(wordList.get(i).charAt(j) != s.charAt(j)){
                            count++;
                        }
                    }
                    if(count == 1){
                        queue.add(new node(wordList.get(i), step + 1));
                        visited[i] = true;
                    }
                }
            }
        }
        return 0;
    }
}
