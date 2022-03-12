package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

//20有效的括号
//2021-04-20 22:18:23
class ValidParentheses {
    public static void main(String[] args) {
        Solution solution = new ValidParentheses().new Solution();
        TreeNode r = CreateTree.deserialize("[5,4,2,3,3,7]");
        System.out.println(solution.isValid("([)]"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isValid(String s) {
            Stack<Character> stack = new Stack<>();
            Map<Character, Character> map = new HashMap<>();
            map.put('(', ')');
            map.put('[', ']');
            map.put('{', '}');
            for (int i = 0; i < s.length(); i++) {
                if (stack.size() == 0) {
                    stack.push(s.charAt(i));
                } else {
                    char c = stack.peek();
                    if(c=='('||c=='['||c=='{'){
                        c = map.get(c);
                        if (c != s.charAt(i)) stack.push(s.charAt(i));
                        else stack.pop();
                    }else{
                        stack.push(s.charAt(i));
                    }
                }

            }
            return stack.size() == 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
