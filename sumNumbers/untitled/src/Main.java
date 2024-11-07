import java.util.ArrayList;
import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

    }
    public int sum = 0;
    public int sumNumbers(TreeNode root) {
        hasPathSum(root, "");
        return sum;
    }

    public void hasPathSum(TreeNode root, String path) {
        if(root != null){
            if(root.left == null && root.right == null){
                path = path + root.val;
                sum += Integer.parseInt(path);
            }else{
                path = path + root.val;
            }
            hasPathSum(root.left, path);
            hasPathSum(root.right, path);
        }
    }
}