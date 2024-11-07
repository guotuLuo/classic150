// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

    }
    public int count = 0;
    public int countNodes(TreeNode root) {
        if(root != null){
            count++;
            countNodes(root.left);
            countNodes(root.right);
        }
        return count;
    }
}