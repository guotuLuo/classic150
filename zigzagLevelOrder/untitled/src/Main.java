import java.util.*;
// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

    }
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        // 双端链表村数据， 队列存节点
        Queue<TreeNode> queue = new LinkedList<>();
        if(root != null){
            queue.add(root);
        }
        boolean flag = true;
        while(!queue.isEmpty()){
            LinkedList<Integer> linkedList = new LinkedList<>();
            int len = queue.size();
            for (int i = 0; i < len; i++){
                TreeNode temp = queue.poll();
                if(flag){
                    linkedList.addLast(temp.val);
                }else{
                    linkedList.addFirst(temp.val);
                }
                if(temp.left != null){
                    queue.add(temp.left);
                }
                if(temp.right != null){
                    queue.add(temp.right);
                }
            }
            res.add(linkedList);
            flag = !flag;
        }
        return res;
    }
}