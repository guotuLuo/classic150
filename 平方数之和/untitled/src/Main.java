import java.util.HashMap;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        boolean flag = judgeSquareSum(60000);
        System.out.println(flag);
    }
    public static HashSet<Long> set = new HashSet<>();
    public static boolean judgeSquareSum(int c) {
        if(set.size() == 0){
            for (int i = 0; i < 65536; i++) {
                set.add(((long) i * i));
            }
        }

        for (int i = 0; i < 65536; i++) {
            if(set.contains(c - (long) i * i)){
                System.out.println(i);
                return true;
            }
        }
        return false;
    }
}
