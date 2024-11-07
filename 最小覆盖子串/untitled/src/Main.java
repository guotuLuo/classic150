import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        String s = minWindow("aaaaaaaaaaaabbbbbcdd", "abcdd");
        System.out.println(s);
    }
    public static String minWindow(String s, String t) {
        int n = s.length();
        int l = t.length();
        if(n < l){
            return "";
        }
        int begin = 0;
        int end = l;
        int[] data = new int[60];
        int[] pata = new int[60];
        String temp = s.substring(begin, end);
        for (int i = 0; i < l; i++) {
            int j = t.charAt(i) - 'A';
            data[j]++;
            int k = temp.charAt(i) - 'A';
            pata[k]++;
        }
        int sum = 0;
        for (int i = 0; i < 60; i++) {
            if(data[i] > pata[i] &&data[i] != 0){
                sum += data[i] - pata[i];
            }
        }
        String error;
        String minWindow = "";
        minWindow = n > l ? s + "a" : t + "a";
        error = minWindow;
        while(end <= n){
            if(sum == 0){
                while(begin < end){
                    if(end - begin < minWindow.length()){
                        minWindow = s.substring(begin, end);;
                    }
                    int index = s.charAt(begin) - 'A';
                    pata[index]--;
                    begin++;
                    if(pata[index] < data[index]){
                        sum++;
                        break;
                    }
                }
            }else{
                if(end < n){
                    int x = s.charAt(end) - 'A';
                    pata[x]++;
                    if(data[x] != 0 && pata[x] - 1 < data[x]){
                        sum--;
                    }
                }
                end++;
            }
        }
        if(minWindow.equals(error)){
            return "";
        }
        return minWindow;
    }
}
