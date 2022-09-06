package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateListNode;
import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.ListNode;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//22 括号生成
//2022-09-06 15:15:25
class GenerateParentheses {

    public static void main(String[] args) {
        int dir8[][] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
        int dir4[][] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Solution solution = new GenerateParentheses().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        ListNode listNode = CreateListNode.stringToListNode("[1,2,3]");
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
        //参考题解：https://leetcode.cn/problems/generate-parentheses/solution/gua-hao-sheng-cheng-by-leetcode-solution/
        //方法二
        public List<String> generateParenthesis(int n) {
            List<String> answer = new ArrayList<String>();
            backTrace(answer, new StringBuilder(), 0, 0, n);
            return answer;
        }

        private void backTrace(List<String> answer, StringBuilder strB, int left, int right, int max) {
            if (strB.length() == max * 2) {
                answer.add(strB.toString());
                return;
            }
            if (left < max) {
                strB.append('(');
                backTrace(answer, strB, left + 1, right, max);
                strB.deleteCharAt(strB.length() - 1);
            }
            if (right < left) {
                strB.append(')');
                backTrace(answer, strB, left, right + 1, max);
                strB.deleteCharAt(strB.length() - 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}