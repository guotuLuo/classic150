public class Main {
    public static void main(String[] args) {
        int[] digits = new int[]{1, 2, 3};
        int[] res = plusOne(digits);
        for (int re : res) {
            System.out.print(re + " ");
        }
    }

    public static int[] plusOne(int[] digits) {
        int n = digits.length;
        int c = 1;
        int[] res = new int[n + 1];
        for (int i = n; i >= 1; i--) {
            res[i] = (digits[i - 1] + c) % 10;
            if(digits[i - 1] + c == 10){
                c = 1;
            }else{
                c = 0;
            }
        }
        if(c == 1){
            res[0] = 1;
        }
        if(res[0] == 0){
            int[] x = new int[n];
            for (int i = 1; i <= n; i++) {
                x[i - 1] = res[i];
            }
            return x;
        }else{
            return res;
        }
    }
}
