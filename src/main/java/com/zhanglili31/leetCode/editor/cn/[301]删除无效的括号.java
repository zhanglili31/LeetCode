package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.*;

//301 删除无效的括号
//2022-05-02 20:16:58
class RemoveInvalidParentheses {

    public static void main(String[] args) {
        Solution solution = new RemoveInvalidParentheses().new Solution();
        TreeNode root = CreateTree.deserialize("[1,1,1,1,1,0,0,0,1,null,0,1,1,null,1,null,null,null,null,null,null,null,null,null,null,null,null]");
        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        String testStr = "hello";
        int temp[] = {-1, 0, 1, 2, -1, -4};
        System.out.println(solution);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<String> res = new ArrayList<>();
        Set<String> hashSet = new HashSet<>();
        Queue<Set<String>> queue = new LinkedList<>();

        public List<String> removeInvalidParentheses(String s) {
            if (isValid(s)) {
                res.add(s);
                return res;
            }
            Set<String> temp = new HashSet<>();
            temp.add(s);
            queue.add(temp);
            while (!queue.isEmpty()) {
                temp = queue.poll();
                Iterator<String> iterator = temp.iterator();
                Set<String> tempSet = new HashSet<>();
                while (iterator.hasNext()) {
                    String str = String.valueOf(iterator.next());
                    StringBuilder strB = new StringBuilder(str);
                    for (int i = 0; i < str.length(); i++) {
                        char ch = s.charAt(i);
                        String strTemp = strB.deleteCharAt(i).toString();
                        strB.insert(i, ch);
                        if (isValid(strTemp)) {
                            hashSet.add(strTemp);
                        } else {
                            tempSet.add(strTemp);
                        }
                    }
                }
                if (hashSet.size() > 0) {
                    res.addAll(hashSet);
                    return res;

                }
                queue.add(tempSet);
            }
            return null;
        }

        private boolean isValid(String str) {
            int cnt = 0;
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == '(') {
                    cnt++;
                } else if (str.charAt(i) == ')') {
                    cnt--;
                    if (cnt < 0) {
                        return false;
                    }
                }
            }

            return cnt == 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}