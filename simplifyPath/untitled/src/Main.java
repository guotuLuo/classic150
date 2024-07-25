import java.util.List;
import java.util.Stack;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        String s = simplifyPath("/../");
        System.out.println(s);
    }

    public static String simplifyPath(String path) {
        String root = "";
        int[] arr = new int[path.length()];
        String[] str = path.split("/");
        Stack<String> stack = new Stack<>();
        for (String s : str) {
            if(!s.isEmpty() && !s.equals(".")){
                if(s.equals("..")){
                    if(!stack.isEmpty()){
                        stack.pop();
                        stack.pop();
                    }
                }else {
                    stack.push("/");
                    stack.push(s);
                }
            }
        }
        while(!stack.isEmpty()){
            root = stack.pop() + root;
        }

        return root.equals("") ? "/" : root;
    }
}