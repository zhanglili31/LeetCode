package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.Arrays;

//剑指 Offer 58 - I 翻转单词顺序
//2022-06-14 20:45:27
class FanZhuanDanCiShunXuLcof {

    public static void main(String[] args) {
        Solution solution = new FanZhuanDanCiShunXuLcof().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        String testStr = "hello";
        String strArray[] = {"wrt", "wrf"};
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
//        int temp[] = CreateArray.getArray(20, 100);
        int temp[] = {5, 3, 2, 2};
        System.out.println(Arrays.toString(temp));
        System.out.println(solution.reverseWords(""));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String reverseWords(String s) {
            s = s.trim();
            String[] temp = s.split(" ");
            StringBuilder ans = new StringBuilder();
            for (int i = 0; i < temp.length; i++) {
                if ("".equals(temp[temp.length - 1 - i])) {
                    continue;
                }
                ans.append(temp[temp.length - 1 - i]);
                ans.append(" ");
            }
            if (ans.length() > 0) {
                ans.deleteCharAt(ans.length() - 1);
            }
            return ans.toString();

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}