package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.Arrays;

//剑指 Offer II 020 回文子字符串的个数
//2022-06-16 13:11:27
class A7VOhD {

    public static void main(String[] args) {
        Solution solution = new A7VOhD().new Solution();
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
        //中心拓展
        //关键点：中心点为一个字符和两个字符统一起来的方式
        //l和r的计算方式
        public int countSubstrings(String s) {
            int n = s.length();
            int ans = 0;
            int l = 0, r = 0;
            for (int i = 0; i < 2 * n - 1; i++) {
                l = i / 2;
                r = i / 2 + i % 2;
                while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                    l--;
                    r++;
                    ans++;
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}