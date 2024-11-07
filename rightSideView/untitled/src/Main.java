import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

    }

    public List<Integer> res = new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root){
        if(root == null){
            return res;
        }
        List<TreeNode> list = new ArrayList<>();
        list.add(root);
        res.add(root.val);
        while(!list.isEmpty()){
            List<TreeNode> temp = list;
            list = new ArrayList<>();
            for (int i = 0; i < temp.size(); i++) {
                if(temp.get(i) != null){
                    if(temp.get(i).left != null){
                        list.add(temp.get(i).left);
                    }
                    if(temp.get(i).right != null){
                        list.add(temp.get(i).right);
                    }
                }
            }
            if(list.size() > 0){
                res.add(list.get(list.size() - 1).val);

            }
        }
        return res;
    }
}