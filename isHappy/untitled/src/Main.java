import java.util.HashMap;
import java.util.HashSet;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        boolean fa = isHappy(2);
        System.out.println(fa);
    }

    public static boolean isHappy(int n) {
        int temp = n;
        HashSet<Integer> hashSet = new HashSet<>();
        while(temp != 0 && !hashSet.contains(temp)){
            hashSet.add(temp);
            temp = num(temp);
            if(temp == 1){
                return true;
            }
        }
        return false;
    }

    public static int num(int n){
        int num = 0;
        while(n != 0){
            int temp= n % 10;
            num += temp * temp;
            n = n / 10;
        }
        return num;
    }
}