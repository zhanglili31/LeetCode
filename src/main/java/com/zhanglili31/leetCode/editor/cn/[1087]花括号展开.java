package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.*;

//1087 花括号展开
//2022-06-07 14:53:23
class BraceExpansion {

    public static void main(String[] args) {
        Solution solution = new BraceExpansion().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        String testStr = "hello";
        String strArray[] = {"wrt", "wrf"};
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
//        int temp[] = CreateArray.getArray(20, 100);
        int temp[] = {5, 3, 2, 2};
        System.out.println(Arrays.toString(temp));
        System.out.println(solution.expand("{a,b}cf"));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String[] expand(String s) {
            List<String> ans = new ArrayList<>();
            String temp = "";
            StringBuilder str = new StringBuilder();
            Stack<String> stack = new Stack<>();
            for (int i = 0; i < s.length(); i++) {
                temp = s.substring(i, i + 1);
                if (temp.equals("{")) {
                    if (str.length() > 0) {
                        if (ans.size() == 0) {
                            ans.add(str.toString());
                        } else {
                            for (int j = 0; j < ans.size(); j++) {
                                ans.set(j, ans.get(j) + str.toString());
                            }
                        }
                        str = new StringBuilder();
                    }
                    stack.push(temp);
                } else if (temp.equals("}")) {
                    stack.push(str.toString());
                    str = new StringBuilder();
                    List<String> swap = new ArrayList<>();

                    if (ans.size() == 0) {
                        while (!stack.peek().equals("{")) {
                            swap.add(stack.pop());
                        }
                        stack.clear();
                        ans = swap;
                    } else {
                        while (!stack.peek().equals("{")) {
                            String pop = stack.pop();

                            for (int j = 0; j < ans.size(); j++) {
                                swap.add(ans.get(j) + pop);
                            }
                        }
                        ans = swap;
                        stack.clear();
                    }
                } else if (!stack.isEmpty()) {
                    if (temp.equals(",")) {
                        stack.push(str.toString());
                        str = new StringBuilder();
                    } else {
                        str.append(temp);
                    }
                } else {
                    str.append(temp);
                }
                if (i == s.length() - 1 && str.length() > 0) {
                    if (ans.size() == 0) {
                        ans.add(str.toString());
                    } else {
                        for (int j = 0; j < ans.size(); j++) {
                            ans.set(j, ans.get(j) + str.toString());
                        }
                    }
                }
            }
            ans.sort(new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return o1.compareTo(o2);
                }
            });
            System.out.println(ans);
            return ans.toArray(new String[ans.size()]);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}