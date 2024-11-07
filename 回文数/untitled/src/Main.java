public class Main {
    public boolean isPalindrome(int x) {
        String s = String.valueOf(x);
        int n = s.length();
        int begin = 0;
        int end = n - 1;
        while(begin < end){
            if(s.charAt(begin) != s.charAt(end)){
                return false;
            }
            begin++;
            end--;
        }
        return true;
    }
}
