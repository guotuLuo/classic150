import static com.sun.tools.javac.jvm.ByteCodes.swap;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

    }

    public String longestCommonPrefix(String[] strs) {
        int i = 0;
        String res = "";
        boolean flag = true;
        for (; i < strs[0].length() && flag; i++) {
            char temp = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if(i < strs[j].length() && temp != strs[j].charAt(i)){
                    flag = false;
                    break;
                }else if(i >= strs[j].length()){
                    flag = false;
                    break;
                }
            }
            if(flag)
                res += temp;
        }
        return res;
    }
}