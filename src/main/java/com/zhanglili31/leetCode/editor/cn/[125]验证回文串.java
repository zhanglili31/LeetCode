package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.Arrays;

//125 验证回文串
//2022-06-17 00:17:35
class ValidPalindrome {

    public static void main(String[] args) {
        Solution solution = new ValidPalindrome().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        String testStr = "hello";
        String strArray[] = {"wrt", "wrf"};
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
//        int temp[] = CreateArray.getArray(20, 100);
        int temp[] = {5, 3, 2, 2};
        System.out.println(Arrays.toString(temp));
        System.out.println(solution.isPalindrome("A man, a plan, a canal: Panama"));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isPalindrome(String s) {
            s = s.toLowerCase();
            int left = 0, right = s.length() - 1;
            while (left <= right) {
                if (!isLetter(s.charAt(left))) {
                    left++;
                } else if (!isLetter(s.charAt(right))) {
                    right--;
                } else if (s.charAt(left) == s.charAt(right)) {
                    left++;
                    right--;
                } else {
                    return false;
                }
            }
            return true;

        }

        private boolean isLetter(char ch) {
            return 'a' <= ch && ch <= 'z' || 'A' <= ch && ch <= 'Z'||'0'<=ch&&ch<='9';
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}