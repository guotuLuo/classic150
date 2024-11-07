

import java.util.ArrayList;
import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

    }
    public List<Double> res = new ArrayList<>();
    public List<Double> averageOfLevels(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        list.add(root);
        res.add((double) root.val);
        while(!list.isEmpty()){
            List<TreeNode> temp = list;
            list = new ArrayList<>();
            double sum = 0;
            int count = 0;
            for (int i = 0; i < temp.size(); i++) {
                if(temp.get(i) != null){
                    if(temp.get(i).left != null){
                        list.add(temp.get(i).left);
                        sum += temp.get(i).left.val;
                        count++;
                    }
                    if(temp.get(i).right != null){
                        list.add(temp.get(i).right);
                        sum += temp.get(i).right.val;
                        count++;
                    }
                }
            }
            if(count == 0){
                break;
            }
            res.add(sum / count);
        }
        return res;
    }
}