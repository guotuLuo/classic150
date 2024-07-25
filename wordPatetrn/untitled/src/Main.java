import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        String s = "abba";
        String t = "dog cat cat dog";
        boolean i = wordPattern(s, t);
        System.out.println(i);
    }

    // 判断两个是否同时属于hashmap

    public static boolean wordPattern(String pattern, String s) {
        int len = pattern.length();
        String[] arr = s.split(" ");
        int slen = arr.length;
        if(len != slen){
            return false;
        }
        HashMap<Character, String> hashMap = new HashMap<>();
        HashMap<String, Character> hashMap1 = new HashMap<>();
        for (int i = 0; i < len; i++) {
            if(hashMap.containsKey(pattern.charAt(i)) && hashMap1.containsKey(arr[i])){
                if(!hashMap.get(pattern.charAt(i)).equals(arr[i]) || hashMap1.get(arr[i]) != (pattern.charAt(i))){
                    return false;
                }
            }else if(!hashMap.containsKey(pattern.charAt(i)) && !hashMap1.containsKey(arr[i])){
                hashMap.put(pattern.charAt(i), arr[i]);
                hashMap1.put(arr[i], pattern.charAt(i));
            }else{
                return false;
            }
        }
        return true;
    }
}