public class Main {
    public static void main(String[] args) {
        int[][] intervals = new int[][]{{0, 0}};
        int[] newInterval = new int[]{1, 5};
        int[][] insert = insert(intervals, newInterval);
        for (int i = 0; i < insert.length; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(insert[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        int begin = newInterval[0];
        int end = newInterval[1];
        int finalBegin = begin;
        int finalEnd = end;
        for (int[] interval : intervals) {
            if(interval[0] <= begin && begin <= interval[1]){
                finalBegin = interval[0];
            }
            if(interval[0] <= end && end <= interval[1]){
                finalEnd = interval[1];
            }
        }
        int count = 0;
        for (int[] interval : intervals) {
            if(interval[0] >= finalBegin && interval[1] <= finalEnd){
                count++;
            }
        }
        int[][] res = new int[n - count + 1][2];
        int index = 0;
        boolean flag = true;
        if(n - count + 1 <= n){
            for (int[] interval : intervals) {
                if(interval[1] < finalBegin || interval[0] > finalEnd){
                    res[index][0] = interval[0];
                    res[index][1] = interval[1];
                    index++;
                } else if(flag){
                    res[index][0] = finalBegin;
                    res[index][1] = finalEnd;
                    index++;
                    flag = false;
                }
            }
        }else{
            // 没有相交的地方，那咋办？
            // null 5 7
            // 5 7 0 0
            boolean use = false;
            int i = 0;
            for (; i < n; i++) {
                if(intervals[i][0] < newInterval[0]){
                    res[i][0] = intervals[i][0];
                    res[i][1] = intervals[i][1];
                }else if(intervals[0].length == 0 || intervals[i][0] > newInterval[0]){
                    res[i][0] = newInterval[0];
                    res[i][1] = newInterval[1];
                    use = true;
                    break;
                }
            }
            if(use){
                for (; i < n; i++) {
                    res[i + 1][0] = intervals[i][0];
                    res[i + 1][1] = intervals[i][1];
                }
            }else{
                res[i][0] = newInterval[0];
                res[i][1] = newInterval[1];
            }
        }
        return res;
    }
}
