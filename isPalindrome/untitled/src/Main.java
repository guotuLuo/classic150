// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        boolean flag = isPalindrome(s);
        System.out.println(flag);
    }

    public static boolean isPalindrome(String s) {
        int begin = 0;
        int end= s.length() - 1;
        while(begin <= end){
            int pre = isValid(s.charAt(begin));
            int tail = isValid(s.charAt(end));
            if(pre == -1){
                begin++;
            }else if(tail == -1){
                end--;
            }else{
                if(pre != tail){
                    return false;
                }
                begin++;
                end--;
            }
        }
        return true;
    }

    public static int isValid(char a){
        int temp = a - 'A';
        if((temp >= 0 && temp <= 25) || (temp >= 32 && temp <= 57) || (temp >= -17 && temp <= -8)){
            if(temp >= 0 && temp <= 25){
                temp = temp + 32;
            }
            return temp;
        }else{
            return -1;
        }
    }
}