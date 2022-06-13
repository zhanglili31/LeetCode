package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//剑指 Offer 48 最长不含重复字符的子字符串
//2022-06-13 13:55:35
class ZuiChangBuHanZhongFuZiFuDeZiZiFuChuanLcof {

    public static void main(String[] args) {
        Solution solution = new ZuiChangBuHanZhongFuZiFuDeZiZiFuChuanLcof().new Solution();
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
        public int lengthOfLongestSubstring(String s) {
            Set<Character> set = new HashSet<>();
            int len = 0;
            int ans = 0;
            int left=0;
            for (int i = 0; i < s.length(); i++) {
                if (set.contains(s.charAt(i))) {
                    while (left < i && s.charAt(left) != s.charAt(i)) {
                        set.remove(s.charAt(left));
                        len--;
                        left++;
                    }
                    len--;
                    left++;
                }
                len++;
                set.add(s.charAt(i));
                ans = Math.max(ans, len);
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}