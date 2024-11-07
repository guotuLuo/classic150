import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        int numCourses = 8;
        int[][] prerequisites = new int[6][2];
        prerequisites[0] = new int[]{1, 0};
        prerequisites[1] = new int[]{2, 6};
        prerequisites[2] = new int[]{1, 7};
        prerequisites[3] = new int[]{6, 4};
        prerequisites[4] = new int[]{7, 0};
        prerequisites[5] = new int[]{0, 5};
        int[] order = findOrder(numCourses, prerequisites);
        for (int i : order) {
            System.out.print(i + " ");
        }
    }
    public static HashSet<Integer> zeroDegree = new HashSet<>();
    public static class Edge{
        public HashSet<Integer> from = new HashSet<>();
        public HashSet<Integer> to = new HashSet<>();
    }
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        int index = 0;
        int[] res = new int[numCourses];
        Edge[] edges = new Edge[numCourses];
        for (int i = 0; i < numCourses; i++) {
            edges[i] = new Edge();
            zeroDegree.add(i);
        }
        for (int[] prerequisite : prerequisites) {
            int end = prerequisite[0];
            int begin = prerequisite[1];
            edges[begin].to.add(end);
            edges[end].from.add(begin);
            zeroDegree.remove(end);
        }
        if(zeroDegree.isEmpty()){
            return new int[]{};
        }
        Stack<Integer> stack = new Stack<>();
        for (Integer i : zeroDegree) {
            stack.push(i);
        }
        while(!stack.isEmpty()){
            int top = stack.pop();
            res[index++] = top;
            for (Integer i : edges[top].to) {
                edges[i].from.remove(top);
                if(edges[i].from.isEmpty()){
                    stack.push(i);
                }
            }
        }
        if(index == numCourses){
            return res;
        }else{
            return new int[]{};
        }
    }
}
