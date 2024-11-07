import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class BSTIterator {
    public int cur = 0;
    public List<TreeNode> list = new ArrayList<>();
    public BSTIterator(TreeNode root) {
        TreeNode temp = root;
        // 二叉搜索树的最左侧节点是整棵树的最小元素
        while(temp != null && temp.left != null){
            temp = temp.left;
        }
        inorder(root);
    }

    public int next() {
        return list.get(cur++).val;
    }

    public boolean hasNext() {
        if(cur < list.size()){
            return true;
        }else{
            return false;
        }
    }

    public void inorder(TreeNode root){
        if(root != null){
            inorder(root.left);
            list.add(root);
            inorder(root.right);
        }
    }
}