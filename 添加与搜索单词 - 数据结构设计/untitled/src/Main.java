public class Main {
    public static class WordDictionary {

        public static class Node{
            boolean isEnd;
            Node[] next;
            public Node(){
                isEnd = false;
                next = new Node[26];
            }
        }

        public Node root;
        public WordDictionary() {
            root = new Node();
        }

        public void addWord(String word) {
            Node temp = root;
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
            int n = word.length();
            int index = 0;
            Node temp = root;
            return dfs(word, temp, index, n);
        }

        public boolean dfs(String word, Node root, int index, int n){
            if(index == n){
                return root.isEnd;
            }
            char c = word.charAt(index);
            if(c != '.'){
                if(root.next[c - 'a'] == null){
                    return false;
                }else{
                    return dfs(word, root.next[c - 'a'], index + 1, n);
                }
            }else{
                for (int i = 0; i < 26; i++) {
                    if(root.next[i] != null){
                        boolean flag =  dfs(word, root.next[i], index + 1, n);
                        if(flag){
                            return true;
                        }
                    }
                }
                return false;
            }

        }
    }
    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("at");
        wordDictionary.addWord("and");
        wordDictionary.addWord("an");
        wordDictionary.addWord("add");
        boolean pad = wordDictionary.search("a");// 返回 False
        System.out.println(pad);
    }
}
