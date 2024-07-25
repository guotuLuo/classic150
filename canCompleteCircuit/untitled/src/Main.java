// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        int[] gas = new int[]{1,2,3,4,5};
        int[] cost = new int[]{3,4,5,1,2};
        // {-2, -2, -2, 3, 3  -7   20   }
        // { 2   2   2 -3 -3   7   -20  }
        //
        int res = canCompleteCircuit(gas, cost);
        System.out.println(res);
    }

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int len = gas.length;
        int[] cur = new int[len];
        int sum = 0;
        for (int i = 0; i < len; i++) {
            cur[i] = gas[i] - cost[i];
            sum += cur[i];
        }
        if(sum < 0){
            return -1;
        }
        for (int i = 0; i < len; i++) {
            sum = 0;
            for (int j = 0; j < len; j++) {
                if(cost[i] < 0){
                    break;
                }
                sum += cur[(i + j) % len];
                if(sum < 0){
                    break;
                }
            }
            if(sum >= 0){
                return i;
            }
        }
        return 0;
    }
}