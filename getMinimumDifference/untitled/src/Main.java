// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

    }

    public int minD;
    public int pre;

    public int getMinimumDifference(TreeNode root) {
        if (root.left != null){
            minD = Math.abs(root.val - root.left.val);
        }else{
            minD = Math.abs(root.val - root.right.val);
        }
        pre = root.val + minD;
        inorder(root);
        return minD;
    }

    public void inorder(TreeNode root){
        if(root != null){
            inorder(root.left);
            if(Math.abs(root.val - pre) < minD){
                minD = Math.abs(root.val - pre);
            }
            inorder(root.right);
        }
    }
}