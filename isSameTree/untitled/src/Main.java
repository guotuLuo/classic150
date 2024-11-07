// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        TreeNode p = new TreeNode(1);
        TreeNode nodep = new TreeNode(2);
        p.left = nodep;

        TreeNode q = new TreeNode(1);
        TreeNode node = new TreeNode(2);
        q.right = node;
        boolean k = isSameTree(p, q);
        System.out.println(k);
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if((p == null && q != null) || (p != null && q == null)){
            return false;
        } else if (p == null && q == null) {
            return true;
        } else if (p.val != q.val) {
            return false;
        }else if(p.val == q.val){
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }else{
            return false;
        }
    }
}