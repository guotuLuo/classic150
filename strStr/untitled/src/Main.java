public class Main {
    public static void main(String[] args) {
        String haystack = "mississippi";
        String needle = "issip";
        int i = strStr(haystack, needle);
        System.out.println(i);
    }
    public static int strStr(String haystack, String needle) {
        int h = haystack.length();
        int n = needle.length();
        int i = 0;
        int j = 0;
        int index = 0;
        while(i < h && j < n){
            if(haystack.charAt(i) == needle.charAt(j)){
                i++;
                j++;
            }else if(j == 0 && haystack.charAt(i) != needle.charAt(j)){
                i++;
                index = i;
            }else{
                i = index + 1;
                index = i;
                j = 0;
            }
        }
        System.out.println("hello");
        if(j == n){
            return index;
        }else{
            return -1;
        }
    }
}
