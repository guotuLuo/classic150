import java.util.HashMap;
import java.util.Map;
public class Main{
    public static void main(String[] args) {
        int k = 0;
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(2, 1); // 缓存是 {1=1}
        lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
        k = lRUCache.get(2);    // 返回 1
        lRUCache.put(1, 1); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
        lRUCache.put(4, 1); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
        k = lRUCache.get(2);    // 返回 -1 (未找到)
    }
}

class LRUCache {
    public static class ListNode {
        int key;
        int val;
        ListNode next;
        ListNode pre;
        ListNode() {}
        ListNode(int key, int val) { this.key = key; this.val = val; }
        ListNode(int val, int key, ListNode next, ListNode pre) {this.key = key; this.val = val; this.next = next; this.pre = pre;}
    }

    public ListNode dummyHead;
    public ListNode dummyTail;
    public int capacity;
    public Map<Integer, ListNode> map;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        dummyHead = new ListNode();
        dummyTail = new ListNode();
        dummyHead.next = dummyTail;
        dummyTail.pre = dummyHead;
        map = new HashMap<>();
    }
    // O(1)
    public int get(int key) {
        if(map.containsKey(key)){
            removeToHead(map.get(key));
            return map.get(key).val;
        }else{
            return -1;
        }
    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            ListNode temp = map.get(key);
            removeToHead(temp);
            map.get(key).val = value;
        }else{
            if(capacity == 0){
                // 出队最近最久未使用
                ListNode k = dummyTail.pre;
                dummyTail.pre.pre.next = dummyTail;
                dummyTail.pre = dummyTail.pre.pre;
                map.remove(k.key);
                // 插到开头
                ListNode temp = new ListNode(key, value);
                addNew(temp);
                map.put(key, temp);
            }else{
                ListNode temp = new ListNode(key, value);
                addNew(temp);
                map.put(key, temp);
                capacity--;
            }
        }
    }

    // 怎么在O(1)时间内挪到开头
    public void removeToHead(ListNode temp){
        // 抽出temp
        temp.pre.next = temp.next;
        temp.next.pre = temp.pre;
        // 挪到开头
        temp.next = dummyHead.next;
        dummyHead.next.pre = temp;
        dummyHead.next = temp;
        temp.pre = dummyHead;
    }

    public void addNew(ListNode temp){
        // 挪到开头
        temp.next = dummyHead.next;
        dummyHead.next.pre = temp;
        dummyHead.next = temp;
        temp.pre = dummyHead;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */