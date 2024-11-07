import java.util.HashMap;
import java.util.Map;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

    }

    // 递归建树
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    public TreeNode build(int[] preorder, int preLeft, int preRight,
                          int[] inorder, int inLeft, int inRight){
        if(preLeft > preRight || inLeft > inRight){
            return null;
        }
        // 先序遍历的最左节点是根节点
        int rootvalue = preorder[preLeft];
        TreeNode root = new TreeNode(rootvalue);
        // 中序遍历中寻找根节点的索引，将中序遍历左右分为左子树和右子树
        int pivotIndex = inLeft;
        while(inorder[pivotIndex] != rootvalue){
            pivotIndex++;
        }
        // pivotIndex 对应root值的索引
        // 那么新的左子树为
        // 1 |2 4 5 8 9| |3 6 10 7|
        // 4 2 8 5 9 |1| 6 10 3 7
        root.left = build(preorder, preLeft + 1, pivotIndex - inLeft + preLeft,
                          inorder, inLeft, pivotIndex - 1);
        root.right = build(preorder, pivotIndex - inLeft + preLeft + 1, preRight,
                               inorder, pivotIndex + 1, inRight);
        return root;
    }

}