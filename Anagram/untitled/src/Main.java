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
        boolean i = isAnagram(s, t);
        System.out.println(i);
    }

    // 判断两个是否同时属于hashmap

    public static boolean isAnagram(String s, String t) {
        int slen = s.length();
        int tlen = t.length();
        if (slen != tlen) {
            return false;
        }
//        HashMap<Character, Integer> hashMap1 = new HashMap<>();
//        HashMap<Character, Integer> hashMap2 = new HashMap<>();
//        for (int i = 0; i < slen; i++) {
//            if (hashMap1.containsKey(s.charAt(i))) {
//                hashMap1.put(s.charAt(i), hashMap1.get(s.charAt(i)) + 1);
//            } else {
//                hashMap1.put(s.charAt(i), 1);
//            }
//            if (hashMap2.containsKey(t.charAt(i))) {
//                hashMap2.put(t.charAt(i), hashMap2.get(t.charAt(i)) + 1);
//            } else {
//                hashMap2.put(t.charAt(i), 1);
//            }
//        }
//        for (int i = 0; i < slen; i++) {
//            if (hashMap1.get(s.charAt(i)) != hashMap2.get(s.charAt(i))) {
//                return false;
//            }
//        }
        int[] arr1 = new int[26];
        int[] arr2 = new int[26];
        for (int i = 0; i < slen; i++) {
            arr1[s.charAt(i) - 'a'] += 1;
            arr2[t.charAt(i) - 'a'] += 1;
        }
        for (int i = 0; i < slen; i++) {
            if(arr1[i] != arr2[i]){
                return false;
            }
        }
        return true;
    }
}
