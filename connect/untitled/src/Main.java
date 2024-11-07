import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n7 = new Node(7);

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.right = n7;

        Node root = connect(n1);
        printTree(root);
    }
    // 层级遍历 队列
    public static Node connect(Node root) {
        List<Node> list = new ArrayList<>();
        list.add(root);
        if(root == null){
            return root;
        }
        while(!list.isEmpty()){
            List<Node> temp = list;
            list = new ArrayList<>();
            for (int i = 0; i < temp.size(); i++) {
                if(i > 0){
                    temp.get(i - 1).next = temp.get(i);
                }
                if(temp.get(i).left != null){
                    list.add(temp.get(i).left);
                }
                if(temp.get(i).right != null){
                    list.add(temp.get(i).right);
                }
            }
        }
        return root;
    }

    public static void printTree(Node root){
        if(root != null){
            System.out.println(root.val);
            printTree(root.left);
            printTree(root.right);
        }
    }
}