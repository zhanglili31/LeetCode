package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

//剑指 Offer 38 字符串的排列
//2022-06-20 05:13:57
class ZiFuChuanDePaiLieLcof {

    public static void main(String[] args) {
        Solution solution = new ZiFuChuanDePaiLieLcof().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        String testStr = "hello";
        String strArray[] = {"wrt", "wrf"};
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
//        int temp[] = CreateArray.getArray(20, 100);
        int temp[] = {5, 3, 2, 2};
        System.out.println(Arrays.toString(temp));
        System.out.println(solution);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //回溯
        public String[] permutation(String s) {
            Set<String> ans = new HashSet<>();
            DFS(ans, new HashSet<>(), 0, s, "");
            String[] str = new String[ans.size()];
            Iterator<String> iterator = ans.iterator();
            int index = 0;
            while (iterator.hasNext()) {
                str[index++] = iterator.next();
            }
            return str;

        }

        public void DFS(Set<String> ans, Set<Integer> set, int k, String s, String temp) {
            if (k == s.length()) {
                ans.add(temp);
            }
            for (int i = 0; i < s.length(); i++) {
                if (set.contains(i)) {
                    continue;
                }
                set.add(i);
                DFS(ans, set, k + 1, s, temp + s.charAt(i));
                set.remove(i);
            }
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}