import javax.sql.rowset.spi.SyncResolver;
import java.util.Stack;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        String s = "-2+ 1";
        int k = calculate(s);
        System.out.println(k);
    }

    public static int calculate(String s) {
        int len = s.length();
        Stack<String> stack = new Stack<>();

        for (int i = 0; i < len;) {
            if(s.charAt(i) == '('){
                stack.push("(");
                i++;
            }else if(s.charAt(i) == ')'){
                String number = stack.pop();
                stack.pop();
                rpush(stack, number);
                i++;
            }else if(s.charAt(i) == '+'){
                stack.push("+");
                i++;
            }else if(s.charAt(i) == '-'){
                stack.push("-");
                i++;
            }else if(s.charAt(i) != ' '){
                // 当前是数字的情况
                String temp = "";
                while(i < len && s.charAt(i) - '0' >= 0 && s.charAt(i) - '0' <= 9){
                    temp = temp + s.charAt(i);
                    i++;
                }
                rpush(stack, temp);
            }else{
                i++;
            }
        }
        return Integer.parseInt(stack.pop());
    }

    public static void rpush(Stack<String> stack, String s){
        // 如果当前压入的元素是右括号或者数值元素，需要考虑弹栈情况，这里只考虑数值压入的情况
        if(stack.isEmpty() || stack.peek().equals("(")){
            stack.push(String.valueOf(s));
        }else if(stack.peek().equals("+")){
            // 弹出加号
            stack.pop();
            // 弹出加号之前的数值
            String value = stack.pop();
            s = String.valueOf(Integer.parseInt(value) + Integer.parseInt(s));
            rpush(stack, s);

        }else if(stack.peek().equals("-")){
            stack.pop();
            if(stack.isEmpty() || stack.peek().equals("(")){
                s = String.valueOf(-Integer.parseInt(s));
                rpush(stack, s);
            }else{
                String value = stack.pop();
                s = String.valueOf(Integer.parseInt(value) - Integer.parseInt(s));
                rpush(stack, s);
            }
        }
    }
}