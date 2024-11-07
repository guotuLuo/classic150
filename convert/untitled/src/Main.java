import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        StringBuilder s = new StringBuilder();
        StringBuffer si = new StringBuffer();
        String so = new String();
        List<Integer> list = new ArrayList<>();
        System.out.println(list.size());
        list.add(1);
        System.out.println(list.);
    }

    public String convert(String s, int numRows) {
        String temp = "";
        if(numRows == 1){
            return s;
        }
        int len = s.length();
        for (int i = 0; i < numRows; i++) {
            for (int j = i; j < len; ) {

            }
        }
        return null;
    }
}
