public class Main {
    public static void main(String[] args) {
        String s = "day";
        int t = lengthOfLastWord(s);
        System.out.println(t);
    }
    public static int lengthOfLastWord(String s) {
        int len = s.length();
        int start = 0;
        int end = 0;
        boolean flag = true;
        for (int i = s.length() - 1; i >= 0 && flag; i--) {
            if(s.charAt(i) - 'a' >= 0 && s.charAt(i) - 'a' <= 25 || s.charAt(i) - 'A' >= 0 && s.charAt(i) - 'A' <= 25){
                start = i;
                end = start - 1;
                for (; end >=0; end--) {
                    if(s.charAt(end) == ' '){
                        flag = false;
                        break;
                    }
                }
                if(end < 0){
                    break;
                }
            }
        }
        return start - end;
    }
}
