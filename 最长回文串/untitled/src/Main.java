public class Main {
    public static void main(String[] args) {
        int i = longestPalindrome("zeusnilemacaronimaisanitratetartinasiaminoracamelinsuez");
        System.out.println(i);
    }
    public static int longestPalindrome(String s) {
        int n = 'z' - 'A' + 1;
        int len = s.length();
        int res = 0;
        int single = 0;
        int[] data = new int[n];
        for(int i = 0; i < len; i++){
            data[s.charAt(i) - 'A']++;
        }
        for(int i = 0; i < n; i++){
            if(data[i] % 2 == 0){
                res += data[i];
            }else{
                res += (data[i] / 2) * 2;
                single = 1;
            }
        }
        return res + single;
    }
}
