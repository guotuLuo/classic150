import java.util.HashMap;

public class Main {
    public int singleNumber(int[] nums) {
        // 记录每个数位上1的个数之和，一定是某个3(N - 1) + "1"的形式，那么对每个数位对3取余，剩下的值就是真实的贡献
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int cnt = 0;
            for (int num : nums) {
                // 第i位上的数是否为1；为1则加上
                cnt += num >> i & 1;
            }
            res |= cnt % 3 << i;
        }
        return res;
    }
}
