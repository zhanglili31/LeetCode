package com.zhanglili31.leetCode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//131分割回文串
//2021-03-07 06:22:57
class PalindromePartitioning {
    public static void main(String[] args) {
        Solution solution = new PalindromePartitioning().new Solution();
        System.out.println(solution.partition("aajkhklhjkljhkljhk"));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<String>> partition(String s) {
            List<List<String>> list = new ArrayList<>();
            List<String> res = new ArrayList<>();
            for (int i = 0; i < s.length(); i++) {
                for (int j = i+1; j <= s.length(); j++) {
                    StringBuffer strB = new StringBuffer(s.substring(i, j));
                    String temp=strB.toString();
                    strB.reverse();
                    String temp2=strB.toString();
                    if (temp.equals(temp2)) {
                        res.add(strB.toString());
                    }
                }
            }
            list.add(res);
            return list;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}