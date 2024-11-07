// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

    }

    public static TreeNode invertTree(TreeNode root){
        if(root != null){
            invertTree(root.left);
            invertTree(root.right);
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
        }
        return root;
    }

    public void invert(TreeNode root){
        if(root != null){
            invert(root.left);
            invert(root.right);
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
        }
    }
}