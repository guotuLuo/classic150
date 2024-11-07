public class Main {
    public static void main(String[] args) {
        double v = myPow(2, -2147483648);
        System.out.println(v);
    }

    public static double myPow(double x, int n) {
        long N = (long) n;
        if(n >= 0){
            return quickPow(x, N);
        }else{
            return 1 / quickPow(x, -N);
        }
    }

    public static double quickPow(double x, long n){
        double t = x;
        double res = 1;
        while(n > 0){
            // 需要加权
            if(n % 2 == 1){
                res *= t;
            }
            n = n / 2;
            t = t * t;
        }
        return res;
    }
}
