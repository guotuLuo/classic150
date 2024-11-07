// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        String a = "axc ";
        String b = "ahbgdc";
        boolean flag = isSubsequence(a, b);
        System.out.println(flag);
    }

    public static boolean isSubsequence(String s, String t) {
        int slen = s.length();
        int tlen = t.length();
        int i = 0;
        int j = 0;
        while(j < slen && i < tlen){
            if(s.charAt(j) == t.charAt(i)){
                j++;
            }
            i++;
        }
        if(j == slen){
            return true;
        }
        return false;
    }
}