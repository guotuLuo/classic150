public class Main {
    public static void main(String[] args) {
        int[] gas = new int[]{1,2,3,4,5};
        int[] cost = new int[]{3,4,5,1,2};
        int i = canCompleteCircuit(gas, cost);
        System.out.println(i);
    }
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
       int minValue = Integer.MAX_VALUE;
       int ans = 0;
       int index = 0;
        for (int i = 0; i < n; i++) {
            ans += gas[i] - cost[i];
            if(minValue > ans){
                minValue = ans;
                index = i;
            }
        }
        if(ans < 0){
            return -1;
        }else {
            return (index + 1) % n;
        }
    }
}
