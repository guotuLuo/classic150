import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        List<Node> list1 = new ArrayList<>();
        list1.add(node2);
        list1.add(node4);
        node1.neighbors = list1;

        List<Node> list2 = new ArrayList<>();
        list2.add(node1);
        list2.add(node3);
        node2.neighbors = list2;

        List<Node> list3 = new ArrayList<>();
        list3.add(node2);
        list3.add(node4);
        node3.neighbors = list3;

        List<Node> list4 = new ArrayList<>();
        list4.add(node1);
        list4.add(node3);
        node4.neighbors = list4;

        Node temp = cloneGraph(node1);

    }
    public static Node cloneGraph(Node node) {
        if(node == null){
            return null;
        }
        boolean[] visited = new boolean[101];
        Queue<Node> queue = new LinkedList<>();
        Node[] data = new Node[101];
        queue.add(node);
        data[1] = new Node(1);
        while(!queue.isEmpty()){
            visited[node.val] = true;
            node = queue.peek();
            ArrayList<Node> list = new ArrayList<>();
            for (Node neighbor : node.neighbors) {
                if(data[neighbor.val] == null){
                    data[neighbor.val] = new Node(neighbor.val);
                }
                list.add(data[neighbor.val]);
                if(!visited[neighbor.val]){
                    queue.add(neighbor);
                    visited[neighbor.val] = true;
                }
            }
            data[node.val].neighbors = list;
            queue.poll();
        }
        return data[1];
    }
}
