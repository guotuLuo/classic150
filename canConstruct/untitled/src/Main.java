import java.util.HashMap;
import java.util.HashSet;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

    }

    public boolean canConstruct(String ransomNote, String magazine) {
        int rlen = ransomNote.length();
        int mlen = magazine.length();
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < mlen; i++) {
            if(hashMap.containsKey(magazine.charAt(i))){
                hashMap.put(magazine.charAt(i), hashMap.get(magazine.charAt(i)) + 1);
            }else{
                hashMap.put(magazine.charAt(i), 1);
            }
        }
        for (int i = 0; i < rlen; i++) {
            if(hashMap.containsKey(ransomNote.charAt(i)) && hashMap.get(ransomNote.charAt(i)) != 0){
                hashMap.put(ransomNote.charAt(i), hashMap.get(ransomNote.charAt(i)) - 1);
            }else{
                return false;
            }
        }
        return true;
    }

}