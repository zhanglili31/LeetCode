package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateArray;
import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.Arrays;
import java.util.Stack;

//439 三元表达式解析器
//2022-05-15 22:17:56
class TernaryExpressionParser {

    public static void main(String[] args) {
        Solution solution = new TernaryExpressionParser().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        String testStr = "F?1:T?4:5";
        String strArray[] = {"wrt", "wrf"};
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
        int temp[] = CreateArray.getArray(20, 100);
        System.out.println(Arrays.toString(temp));
        System.out.println(solution.parseTernary(testStr));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String parseTernary(String expression) {
            char val[] = new char[3];
            int index = 0;
            Stack<Character> stack = new Stack<Character>();
            char res = ' ';
            char last = ' ';

            for (int i = expression.length() - 1; i >= 0; i--) {
                char ch = expression.charAt(i);
                if (last=='?'&&ch>'9') {
                    char temp[] = new char[3];
                    temp[1] = stack.pop();
                    temp[2] = stack.pop();
                    temp[0] = ch;
                    res = getValue(temp);
                    stack.push(res);

                } else if (ch != '?' && ch != ':') {
                    stack.push(ch);
                }
                last=ch;
            }
            return String.valueOf(res);

        }
        public char getValue(char[] val) {
            if (val[0] == 'T') {
                return val[1];
            } else {
                return val[2];
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}