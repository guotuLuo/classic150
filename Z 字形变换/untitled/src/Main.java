public class Main {
    public static void main(String[] args) {
        String convert = convert("chrynqxqqmlfotpqhvokiiammqmvxjvbsoaifzyxnjcberrnmixxsyjhovengbpyqrixqgwdrygxrxkfhicainhwi", 24);
        System.out.println(convert);
    }
    public static String convert(String s, int numRows) {
        int n = s.length();
        if(numRows == 1){
            return s;
        }
        int part = numRows + numRows - 2;
        int col = 0;
        if(n < part){
            col = 1 + (Math.max((n - numRows), 0)) % part;
        }
        else{
            col = n / part * (numRows - 1) + n % part;
        }

        String x = "";
        if(n % part != 0){
            col += 1;
        }
        char[][] res = new char[numRows][col];
        boolean down = true;
        int r = 0;
        int l = 0;
        int index = 0;
        while(index < n){
            if(down){
                res[r][l] = s.charAt(index);
                r++;
                if(r == numRows){
                    down = false;
                    r -= 2;
                    l++;
                }
            }else{
                res[r][l] = s.charAt(index);
                r--;
                l++;
                if(r < 0){
                    r += 2;
                    l--;
                    down = true;
                }
            }
            index++;
        }
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < col; j++) {
                if(res[i][j] != '\u0000'){
                    x+=res[i][j];
                }
            }
        }
        return x;
    }
}
