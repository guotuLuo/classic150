

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

    }
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        List<TreeNode> list = new ArrayList<>();
        if(root == null){
            return res;
        }
        list.add(root);
        res.add(List.of(root.val));
        while(!list.isEmpty()){
            List<TreeNode> temp = list;
            List<Integer> num = new ArrayList<>();
            list = new ArrayList<>();
            for (int i = 0; i < temp.size(); i++) {
                if(temp.get(i) != null){
                    if(temp.get(i).left != null){
                        list.add(temp.get(i).left);
                        num.add(temp.get(i).left.val);
                    }
                    if(temp.get(i).right != null){
                        list.add(temp.get(i).right);
                        num.add(temp.get(i).right.val);
                    }
                }
            }
            if(!num.isEmpty())
                res.add(num);
        }
        return res;
    }
}