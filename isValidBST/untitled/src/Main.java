import java.util.Stack;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

    }

    public boolean isValidBST(TreeNode root){
        TreeNode temp = root;
        while(temp != null && temp.left != null){
            temp = temp.left;
        }
        int pre = temp.val;
        int index = 1;
        Stack<TreeNode> stack = new Stack<>();
        while(!stack.isEmpty() || root!= null){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if(root.val <= pre && index != 1){
                return false;
            }
            pre = root.val;
            root = root.right;
            index++;
        }
        return true;
    }
}