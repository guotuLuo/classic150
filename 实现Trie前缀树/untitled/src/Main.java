import java.util.HashMap;
import java.util.HashSet;
public class Main {
    public static class Trie {

        public static class Node{
            boolean isEnd;
            Node[] next;
            public Node(){
                isEnd = false;
                next = new Node[26];
            }
        }
        public Node tree;

        public Trie() {
            tree = new Node();
        }

        public void insert(String word) {
            Node temp = tree;
            int n = word.length();
            for (int i = 0; i < n; i++) {
                char c = word.charAt(i);
                if(temp.next[c - 'a'] == null){
                    temp.next[c - 'a'] = new Node();
                }
                temp = temp.next[c - 'a'];
            }
            temp.isEnd = true;
        }

        public boolean search(String word) {
            Node temp = tree;
            int n = word.length();
            for (int i = 0; i < n; i++) {
                char c = word.charAt(i);
                if(temp.next[c - 'a'] == null){
                    return false;
                }
                temp = temp.next[c - 'a'];
            }
            return temp.isEnd;
        }

        public boolean startsWith(String prefix) {
            Node temp = tree;
            int n = prefix.length();
            for (int i = 0; i < n; i++) {
                char c = prefix.charAt(i);
                if(temp.next[c - 'a'] == null){
                    return false;
                }
                temp = temp.next[c - 'a'];
            }
            return true;
        }
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        boolean apple = trie.search("apple");// 返回 True
        System.out.println(apple);
        boolean app = trie.search("app");// 返回 False
        System.out.println(app);
        boolean flag = trie.startsWith("app");// 返回 True
        System.out.println(flag);
        trie.insert("app");
        boolean app1 = trie.search("app");// 返回 True
        System.out.println(app1);
    }
}
