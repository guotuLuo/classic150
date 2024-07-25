import java.util.*;
// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        RandomizedSet randomizedSet = new RandomizedSet();
        randomizedSet.remove(0); // 返回 false ，表示集合中不存在 2 。
        randomizedSet.remove(0); // 返回 false ，表示集合中不存在 2 。
        randomizedSet.insert(0); // 向集合中插入 2 。返回 true 。集合现在包含 [1,2] 。
        randomizedSet.getRandom(); // getRandom 应随机返回 1 或 2 。
        randomizedSet.remove(0); // 从集合中移除 1 ，返回 true 。集合现在包含 [2] 。
        randomizedSet.insert(0); // 2 已在集合中，所以返回 false 。
    }
}
class RandomizedSet {
    private List<Integer> list;
    private Map<Integer, Integer> map;

    public RandomizedSet() {
        list = new ArrayList<>();
        map = new HashMap<>();
    }

    public boolean insert(int val) {
        if (map.get(val) != null) {
            return false;
        } else {
            int size = list.size();
            map.put(val, size);
            list.add(val);
            return true;
        }
    }

    public boolean remove(int val) {
        if (map.get(val) == null) {
            return false;
        } else {
            int index = map.get(val);
            int temp = list.get(list.size() - 1);
            list.set(index, temp);
            list.remove(list.size() - 1);
            map.put(temp, index);
            map.remove(val);
            return true;
        }
    }

    public int getRandom() {
        int len = list.size();
        Random random = new Random();
        return list.get(random.nextInt(len));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);y
 * int param_3 = obj.getRandom();
 */