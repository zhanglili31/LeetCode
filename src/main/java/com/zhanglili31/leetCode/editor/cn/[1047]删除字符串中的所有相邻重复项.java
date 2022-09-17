package com.zhanglili31.leetCode.editor.cn;

//1047删除字符串中的所有相邻重复项
//2021-03-09 23:27:44
class RemoveAllAdjacentDuplicatesInString {
    public static void main(String[] args) {
        Solution solution = new RemoveAllAdjacentDuplicatesInString().new Solution();
        System.out.println(solution.removeDuplicates("abbaca"));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //栈方案：https://leetcode.cn/problems/remove-all-adjacent-duplicates-in-string/solution/tu-jie-guan-fang-tui-jian-ti-jie-shan-ch-x8iz/
        public String removeDuplicates(String S) {
            StringBuilder sb = new StringBuilder();
            int top = -1;
            for (int i = 0; i < S.length(); i++) {
                if (top >= 0 && sb.charAt(top) == S.charAt(i)) {
                    sb.deleteCharAt(top);
                    top--;
                } else {
                    sb.append(S.charAt(i));
                    top++;
                }

            }
            return sb.toString();
        }

        public String removeDuplicates2(String S) {
            //贪心 思路没有问题，但是出现了超时
            boolean flag = true;
            StringBuilder sb = new StringBuilder(S);
            while (flag) {
                flag = false;
                for (int i = 0; i < sb.length() - 1; i++) {
                    if (sb.charAt(i) == sb.charAt(i + 1)) {
                        sb.delete(i, i + 2);
                        flag = true;
                        break;
                    }
                }
            }
            return sb.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}