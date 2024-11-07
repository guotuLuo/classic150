import com.sun.source.tree.Tree;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        int[] inorder = new int[]{9,3,15,20,7};
        int[] postorder = new int[]{9,15,7,20,3};
        TreeNode root = buildTree(inorder, postorder);
        printTree(root);
    }
    // {4 2 8 5 9} 1 {6 10 3 7}
    // {4 8 9 5 2} {10 6 7 3} {1}
    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        return build(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    public static TreeNode build(int[] inorder, int inLeft, int inRight,
                          int[] postorder, int postLeft, int postRight){
        if(inLeft > inRight || postLeft > postRight){
            return null;
        }
        int rootValue = postorder[postRight];
        TreeNode root = new TreeNode(rootValue);
        int pivotIndex = 0;
        while(inorder[pivotIndex] != rootValue){
            pivotIndex++;
        }
        root.left = build(inorder, inLeft, pivotIndex - 1,
                          postorder, postLeft, postRight - inRight + pivotIndex - 1);
        root.right = build(inorder, pivotIndex + 1, inRight,
                          postorder, postRight - inRight + pivotIndex, postRight - 1);
        return root;
    }

    public static void printTree(TreeNode root){
        if(root != null){
            System.out.println(root.val);
            printTree(root.left);
            printTree(root.right);
        }
    }
}