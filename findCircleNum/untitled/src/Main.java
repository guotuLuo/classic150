// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

    }

    class UnionFindSet{
        public int[] parent;
        public int[] rank;
        public UnionFindSet(int n){
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = -1;
                rank[i] = 1;
            }
        }

        public int find(int x){
            while(parent[x] >= 0){
                x = find(parent[x]);
            }
            return x;
        }

        public void union(int x, int y){
            int index1 = find(x);
            int index2 = find(y);
            if(index1 == index2){
                return ;
            }
            if(rank[index1] < rank[index2]){
                parent[index2] = parent[index2] + parent[index1];
                parent[index1] = index2;
            }else if(rank[index1] > rank[index2]){
                parent[index1] = parent[index2] + parent[index1];
                parent[index2] = index1;
            }else{
                rank[index1]++;
                parent[index1] = parent[index1] + parent[index2];
                parent[index2] = index1;
            }
        }

    }

    public int findCircleNum(int[][] isConnected) {
        int len = isConnected.length;
        UnionFindSet unionFindSet = new UnionFindSet(len);
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if(isConnected[i][j] == 1){
                    unionFindSet.union(i, j);
                }
            }
        }
        int res = 0;
        int n = unionFindSet.parent.length;
        for (int i = 0; i < n; i++) {
            if(unionFindSet.parent[i] < 0){
                res++;
            }
        }
        return res;
    }
}