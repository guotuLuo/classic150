import java.util.HashMap;
import java.util.PriorityQueue;

public class Main {
    public static class MedianFinder {

        public HashMap<Integer, Integer> map;
        public PriorityQueue<Integer> queue;
        public int size = 0;
        public MedianFinder() {
            this.map = new HashMap<>();
            this.queue = new PriorityQueue<>((a,b)->b - a);
        }

        public void addNum(int num) {
            if(this.size == 0){
                queue.add(num);
                map.put(this.size, num);
                size++;
            }else{
                if(num == )
            }
        }

        public double findMedian() {

        }
    }

    public static void main(String[] args) {

    }
}
