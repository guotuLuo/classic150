// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        String s = "a good   example";
        s = reverseWords(s);
        System.out.println(s);
    }

    public static String reverseWords(String s) {
        String[] S = s.split(" ");
        String res = "";
        res += S[S.length - 1];
        for (int i = S.length - 2; i >= 0; i--) {
            if(!S[i].isEmpty()){
                res += " ";
                res += S[i];
            }
        }
        return res;
    }
}