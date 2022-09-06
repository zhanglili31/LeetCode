package com.zhanglili31.leetCode.editor.cn;

//208 实现 Trie (前缀树)
//2022-05-02 07:08:06
class ImplementTriePrefixTree {
    //    public static void main(String[] args) {
//        Solution solution = new ImplementTriePrefixTree().new Solution();
//        TreeNode root = CreateTree.deserialize("[1,1,1,1,1,0,0,0,1,null,0,1,1,null,1,null,null,null,null,null,null,null,null,null,null,null,null]");
//        int [][]a={{1,1,1},{1,0,1},{1,1,1}};
//        String testStr="hello";
//        int temp[] = {-1,0,1,2,-1,-4};
//        System.out.println(solution);
//    }
//
    //leetcode submit region begin(Prohibit modification and deletion)

    class Trie {

        private Trie[] children;
        private boolean isEnd;

        public Trie() {
            children = new Trie[26];
            isEnd = false;
        }


        //一个字母单词，多个字母单词，0个字母单词。
        //null ，不为null，isEend false，true
        public void insert(String word) {
            char ch = ' ';
            Trie node = this;
            for (int i = 0; i < word.length(); i++) {
                ch = word.charAt(i);
                if (node.children[ch - 'a'] == null) {
                    node.children[ch - 'a'] = new Trie();
                }
                node = node.children[ch - 'a'];
            }
            node.isEnd = true;
        }

        // 存在单词，不存在单词
        //存在：遍历湾word，并且node.isEnd=true
        //不存在：没有遍历完word，就结束。
        public boolean search(String word) {
            char ch = ' ';
            Trie node = this;
            int i = 0;
            while (i < word.length()) {
                ch = word.charAt(i);
                node = node.children[ch - 'a'];
                i++;
                if (node == null) {
                    return false;
                }
            }
            return node.isEnd;

        }

        public boolean startsWith(String prefix) {
            char ch = ' ';
            Trie node = this;
            int i = 0;
            for (; i < prefix.length() && node != null; i++) {
                ch = prefix.charAt(i);
                node = node.children[ch - 'a'];
            }
            return i == prefix.length() && node != null;
        }
    }

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
//leetcode submit region end(Prohibit modification and deletion)

}