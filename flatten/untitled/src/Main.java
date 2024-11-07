
// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

    public TreeNode dummyNode = new TreeNode();
    public TreeNode temp = dummyNode;
    public static void main(String[] args) {

    }

    public void flatten(TreeNode root){
        while(root != null){
            if(root.left == null){
                root = root.right;
            }else{
                // 找到左子树的最右节点
                TreeNode left = root.left;
                while(left.right != null){
                    left = left.right;
                }
                left.right = root.right;
                root.right = root.left;
                root.left = null;
                root = root.right;
            }
        }
    }
}