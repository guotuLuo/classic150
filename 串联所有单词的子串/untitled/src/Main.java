import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String s = "barfoothefoobarman";
        String[] words = new String[]{"foo","bar"};
        List<Integer> substring = findSubstring(s, words);
        System.out.println(Arrays.toString(substring.toArray()));
    }
    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        int n = s.length();
        int wordLen = words[0].length();
        int sum = words.length;
        HashMap<String, Integer> map = new HashMap<>();
        boolean flag = true;
        String v = words[0];
        map.put(words[0], 1);
        for (int i = 1; i < sum; i++) {
            map.merge(words[i], 1, Integer::sum);
            flag = flag & (words[i].equals(words[i - 1]));
            if(flag){
                v += words[i];
            }
        }
        if(flag){
            map = new HashMap<>();
            map.put(v, 1);
            wordLen = wordLen * sum;
            sum = 1;
        }
        // 窗口大小
        int begin = 0;
        int end = 0;
        HashMap<String, Integer> mapTemp = new HashMap<>(map);
        int index = 0;
        while(begin <= n - wordLen * sum && end < n){
            mapTemp = new HashMap<>(map);
            int tempBegin = begin;
            while(index < sum && end < n){
                end = tempBegin + wordLen;
                if(end > n){
                    return res;
                }
                String temp = s.substring(tempBegin, end);
                if(mapTemp.containsKey(temp)){
                    if(mapTemp.get(temp) == 0){
                        break;
                    }
                    mapTemp.put(temp, mapTemp.get(temp) - 1);
                    index++;
                    tempBegin = end;
                }else{
                    break;
                }
            }
            if(index == sum){
                res.add(begin);
                index = 0;
                begin += 1;
            }else {
                begin = begin + 1;
                index = 0;
            }
        }
        return res;
    }
}
