public class Main {
    public static void main(String[] args) {
        int n = trailingZeroes(30);
        System.out.println(n);
    }

    public static int trailingZeroes(int n) {
        int count5 = 0;
        int count2 = 0;
        for (int i = n; i >= 1; i--) {
            count5 += count5(i);
            count2 += count2(i);
        }
        return Math.min(count2, count5);
    }

    public static int count5(int n){
        int count = 0;
        while(n % 5 == 0){
            count++;
            n = n / 5;
        }
        return count;
    }

    public static int count2(int n){
        int count = 0;
        while(n % 2 == 0){
            count++;
            n = n / 2;
        }
        return count;
    }
}
