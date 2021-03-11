package com.zhanglili31.LeetCode.editor.cn;

//1047删除字符串中的所有相邻重复项
//2021-03-09 23:27:44
class RemoveAllAdjacentDuplicatesInString {
    public static void main(String[] args) {
        Solution solution = new RemoveAllAdjacentDuplicatesInString().new Solution();
        //System.out.println(solution);

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String removeDuplicates(String S) {
            for (int i = 0, j = 1; j < S.length() && i < S.length(); ) {
                if (S.charAt(i) == S.charAt(j)) {
                    S = S.substring(0, j) + S.substring(j);
                }else{
                    i++;
                    j++;
                }
            }
            return S;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}