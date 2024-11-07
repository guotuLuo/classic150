public class Main {
    public static void main(String[] args) {
        int i = rangeBitwiseAnd(5, 7);
        System.out.println(i);
    }
//    public static int rangeBitwiseAnd(int left, int right) {
//        int res = 0;
//        while(left > 0){
//            int bit = isSame(left, right) - 1;
//            if(bit == -2){
//                return res;
//            }else{
//                res |= 1 << bit;
//                left = left - (int) Math.pow(2, bit);
//                right = right - (int) Math.pow(2, bit);
//            }
//        }
//        return res;
//    }
//
//    public static int isSame(int left, int right){
//        int x = 0;
//        int y = 0;
//        while(left != 0){
//            left = left >> 1;
//            x++;
//        }
//        while(right != 0){
//            right = right >> 1;
//            y++;
//        }
//        if(x != y){
//            return -1;
//        }else{
//            return x;
//        }
//    }

    public static int rangeBitwiseAnd(int left, int right) {
        int offset = 0;
        while(left < right){
            left = left >> 1;
            right = right >> 1;
            offset++;
        }
        return left << offset;
    }
}
