import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String[] words = new String[]{"Listen","to","many,","speak","to","a","few."};
        List<String> res = fullJustify(words, 6);
        System.out.println(Arrays.toString(res.toArray()));
    }

    public static List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        int index = 0;
        int lastLen = 0;
        boolean endFlag = false;
        while(index < words.length){
            String s = "";
            int x = 0;
            for (int i = index; i < words.length; i++) {
                if ((s + words[i]).length() + x <= maxWidth) {
                    s += words[i];
                    temp.add(words[i]);
                    if(i == words.length - 1){
                        endFlag = true;
                    }
                    x++;
                }else{
                    break;
                }
            }
            if(s.length() == maxWidth){
                res.add(s);
                lastLen = 1;
                index++;
            }else{
                int offset = maxWidth - s.length();
                int space = temp.size() - 1 - lastLen;
                lastLen = temp.size();
                if(space == 0){
                    String t = temp.get(index++);
                    for (int i = t.length(); i < maxWidth; i++) {
                        t += " ";
                    }
                    res.add(t);
                }else{
                    int perSapce = offset / space;
                    String t = temp.get(index++);
                    if(endFlag){
                        while(index < words.length){
                            t += " " + temp.get(index++);
                        }
                        while(t.length() < maxWidth){
                            t += " ";
                        }
                        res.add(t);
                        continue;
                    }
                    if(offset % space != 0){
                        // 尽可能多的左空格

                        String leftSpace = "";
                        for (int i = 0; i < perSapce + 1;i++){
                            leftSpace += " ";
                        }
                        String rightSpace = "";
                        for (int i = 0; i < perSapce;i++){
                            rightSpace += " ";
                        }
                        offset = offset - space * perSapce;
                        for (int i = 0; i < offset; i++) {
                            t += leftSpace;
                            t += temp.get(index++);
                        }
                        for (int i = offset; i < space; i++) {
                            t += rightSpace;
                            t += temp.get(index++);
                        }
                    }else{
                        String spaceX = "";
                        for (int i = 0; i < perSapce; i++) {
                            spaceX += " ";
                        }
                        while(offset != 0){
                            t += spaceX;
                            offset -= perSapce;
                            t += temp.get(index++);
                        }
                    }
                    res.add(t);
                }
            }
        }
        return res;
    }
}
