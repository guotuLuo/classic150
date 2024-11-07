import java.util.HashMap;
import java.util.HashSet;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        String s = "badc";
        String t = "baba";
        boolean i = isIsomorphic(s, t);
        System.out.println(i);
    }

    // 判断两个是否同时属于hashmap

    public static boolean isIsomorphic(String s, String t) {
        int slen = s.length();
        HashMap<Character, Character> hashMap = new HashMap<>();
        HashMap<Character, Character> hashMap1 = new HashMap<>();
        for (int i = 0; i < slen; i++) {
            if(hashMap.containsKey(s.charAt(i)) && hashMap1.containsKey(t.charAt(i))){
                if(hashMap.get(s.charAt(i)) != t.charAt(i) || hashMap1.containsKey(t.charAt(i) != s.charAt(i))){
                    return false;
                }
            }else if(!hashMap.containsKey(s.charAt(i)) && !hashMap1.containsKey(t.charAt(i))){
                hashMap.put(s.charAt(i), t.charAt(i));
                hashMap1.put(t.charAt(i), s.charAt(i));
            }else{
                return false;
            }
        }
        return true;
    }
}