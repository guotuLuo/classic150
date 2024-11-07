import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static  List<Integer> res = new ArrayList<>();

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        root.right = node2;
        node2.left = node3;
        preorderTraversal(root);
        System.out.println(Arrays.toString(res.toArray()));
    }
    public static List<Integer> preorderTraversal(TreeNode root) {
        res = new ArrayList<>();
        bianli(root);
        return res;
    }

    public static void bianli(TreeNode root){
        if(root != null){
            res.add(root.val);
            bianli(root.left);
            bianli(root.right);
        }
    }
}
