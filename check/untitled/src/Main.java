// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

    }

    public static boolean isSymmetric(TreeNode root){
        return check(root, root);
    }

    public static boolean check(TreeNode left, TreeNode right){
        if((left == null && right != null) || (left != null && right == null)){
            return false;
        } else if (left == null && right == null) {
            return true;
        } else if (left.val == right.val) {
            return check(left.left, right.right) && check(left.right, right.left);
        } else {
            return false;
        }
    }
}