package com.zhanglili31.LeetCode.editor.cn;

//9回文数
//2021-03-07 06:14:27
class PalindromeNumber {
    public static void main(String[] args) {
        Solution solution = new PalindromeNumber().new Solution();
        //System.out.println(solution);

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isPalindrome(int x) {
            String before = String.valueOf(x);
            StringBuffer temp = new StringBuffer(before);
            StringBuffer t2 = temp.reverse();
            return before.equals(t2.toString());
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}