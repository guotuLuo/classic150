import java.util.Stack;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        String[] arr = new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        int k = evalRPN(arr);
        System.out.println(k);
    }

    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if(token.equals("+")){
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b + a);
            }else if(token.equals("-")){
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b -a);
            }else if(token.equals("*")){
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b * a);
            }else if(token.equals("/")){
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b / a);
            }else{
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }
}