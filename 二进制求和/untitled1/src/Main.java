public class Main {
    public static void main(String[] args) {

    }

    public int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32 && n != 0; i++) {
            res |= (n & 1) << (31 - i);
            n = n >>> 1;
        }
        return res;
    }
}
