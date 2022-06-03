package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.*;

//772 基本计算器 III
//2022-06-03 02:47:16
class BasicCalculatorIii {

    public static void main(String[] args) {
        Solution solution = new BasicCalculatorIii().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        String testStr = "(5)";
        String strArray[] = {"wrt", "wrf"};
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
//        int temp[] = CreateArray.getArray(20, 100);
        int temp[] = {5, 3, 2, 2};
        System.out.println(Arrays.toString(temp));
        System.out.println(solution.calculate(testStr));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //参考：https://leetcode.cn/problems/basic-calculator-iii/solution/shuang-zhan-fa-tong-yi-jie-jue-ji-ben-ji-suan-qi-s/
        public int calculate(String s) {
            LinkedList<String> numberStack = new LinkedList<>();
            Stack<String> operationStack = new Stack<>();
            Map<String, Integer> priority = new HashMap<>();
            priority.put("(", 0);
            priority.put(")", 0);
            priority.put("+", 1);
            priority.put("-", 1);
            priority.put("*", 2);
            priority.put("/", 2);
            StringBuilder str = new StringBuilder();
            char ch = ' ';
            String num1 = "";
            String num2 = "";
            for (int i = 0; i < s.length(); i++) {
                ch = s.charAt(i);
                if ('0' <= ch && ch <= '9') {
                    str.append((ch));
                }
                if (((ch < '0' || ch > '9') || i == s.length() - 1) && str.length() > 0) {
                    numberStack.push(str.toString());
                    str = new StringBuilder();
                }
                if (ch == '(') {
                    operationStack.push("" + ch);
                } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                    while (!operationStack.isEmpty() && priority.get(operationStack.peek()) >= priority.get(ch + "")) {
                        num1 = numberStack.pop();
                        num2 = numberStack.pop();
                        String temp = count(num2, operationStack.pop(), num1);
                        numberStack.push(temp);
                    }
                    operationStack.push(ch + "");
                } else if (ch == ')') {
                    while (!operationStack.isEmpty()&&!operationStack.peek().equals("(")) {
                        num1 = numberStack.pop();
                        num2 = numberStack.pop();
                        String temp = count(num2, operationStack.pop(), num1);
                        numberStack.push(temp);
                    }
                    operationStack.pop();
                }
            }
            while (!operationStack.isEmpty()) {
                num1 = numberStack.pop();
                num2 = numberStack.pop();
                numberStack.push(count(num2, operationStack.pop(), num1));
            }
            return Integer.parseInt(numberStack.pop());
        }

        public String count(String num1, String operation, String num2) {
            Integer n1 = Integer.parseInt(num1);
            Integer n2 = Integer.parseInt(num2);
            switch (operation) {
                case "+":
                    return String.valueOf(n1 + n2);
                case "-":
                    return String.valueOf(n1 - n2);
                case "*":
                    return String.valueOf(n1 * n2);
                case "/":
                    return String.valueOf(n1 / n2);
            }
            return null;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}