package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

//642 设计搜索自动补全系统
//2022-05-31 23:04:01
class DesignSearchAutocompleteSystem {

    public static void main(String[] args) {
//        Solution solution = new DesignSearchAutocompleteSystem().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        String testStr = "hello";
        String strArray[] = {"i love you","island","iroman","i love leetcode"};
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
//        int temp[] = CreateArray.getArray(20, 100);
        int temp[] = {5, 3, 2, 2};
        System.out.println(Arrays.toString(temp));
//        AutocompleteSystem autocomplete = new AutocompleteSystem(strArray, temp);
//        autocomplete.input('a');
//        System.out.println(solution);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
 class AutocompleteSystem {
        //字典树
        //并且存在排名上升的情况
        class TreeNode {
            String val=null;
            boolean isEnd;
            int times=0;
            TreeNode[] child = new TreeNode[26 + 1];//增加空格
        }

        TreeNode root = new TreeNode();
        TreeNode cur=root;
        StringBuilder str = new StringBuilder();

        public AutocompleteSystem(String[] sentences, int[] times) {
            for (int i = 0; i < sentences.length; i++) {
                addString(sentences[i], times[i]);
            }
        }

        private void addString(String sentence,int times) {
            TreeNode node = root;
            for (int j = 0; j < sentence.length(); j++) {
                char ch = sentence.charAt(j);
                if (ch == ' ') {
                    if (node.child[26] == null) {
                        node.child[26] = new TreeNode();
                    }
                    node = node.child[26];
                }else{
                    if (node.child[ch - 'a' ]== null) {
                        node.child[ch - 'a'] = new TreeNode();
                    }
                    node =  node.child[ch - 'a'];
                }
            }
            node.isEnd=true;
            node.times = times;
            node.val = sentence;

        }


        public List<String> input(char c) {
            List<String> ans = new ArrayList<>();
            if (c == '#') {
                cur.isEnd=true;
                cur.times++;
                cur.val=str.toString();
                cur=root;
                str = new StringBuilder();
                return ans;
            } else if (c == ' ') {
                if (cur.child[26] == null) {
                    cur.child[26] = new TreeNode();
                }
                cur = cur.child[26];
            }else{
                if (cur.child[c - 'a' ]== null) {
                    cur.child[c - 'a'] = new TreeNode();
                }
                cur =  cur.child[c - 'a'];
            }
            str.append(c);
            List<TreeNode>res=new ArrayList<>();
            DFS(res, cur);
            res.sort(new Comparator<TreeNode>() {
                @Override
                public int compare(TreeNode o1, TreeNode o2) {
                    if (o1.times == o2.times) {
                        return(o1.val.compareTo(o2.val));
                    }
                    return o2.times-o1.times;
                }
            });
            for (int i = 0; i < 3&&i<res.size(); i++) {
                ans.add(res.get(i).val);
            }
            return ans;
        }

        public void DFS(List<TreeNode>list,TreeNode node) {
            if (node == null) {
                return;
            }
            if (node.isEnd) {
                list.add(node);
            }
            for (int i = 0; i < node.child.length; i++) {
                if (node.child[i] != null) {
                    DFS(list, node.child[i]);
                }
            }
        }

    }

/**
 * Your AutocompleteSystem object will be instantiated and called as such:
 * AutocompleteSystem obj = new AutocompleteSystem(sentences, times);
 * List<String> param_1 = obj.input(c);
 */
//leetcode submit region end(Prohibit modification and deletion)

}