import java.util.*;

public class Main {
    public static void main(String[] args) {
        String startGene = "AAAAAAAA";
        String endGene = "CCCCCCCC";
        String[] bank = new String[]{"AAAAAAAA","AAAAAAAC","AAAAAACC","AAAAACCC","AAAACCCC","AACACCCC","ACCACCCC","ACCCCCCC","CCCCCCCA"};
        int t = minMutation(startGene, endGene, bank);
        System.out.println(t);
    }

    public static class node{
        public node(String s, int step){
            this.s = s;
            this.step = step;
        }
        public String s;
        public int step;
    }
    public static int minMutation(String startGene, String endGene, String[] bank) {
        int n = bank.length;
        boolean[] visited = new boolean[n];
        Queue<node> queue = new LinkedList<>();
        queue.offer(new node(startGene, 0));
        while(!queue.isEmpty()){
            node temp = queue.poll();
            String t = temp.s;
            int step = temp.step;
            if(endGene.equals(t)){
                return step;
            }
            for (int i = 0; i < n; i++) {
                int count = 0;
                if(!visited[i]){
                    for (int j = 0; j < 8; j++) {
                        if(bank[i].charAt(j) != t.charAt(j)){
                            count++;
                        }
                    }
                    if(count == 1){
                        queue.add(new node(bank[i], step + 1));
                        visited[i] = true;
                    }
                }
            }
        }
        return -1;
    }
}
