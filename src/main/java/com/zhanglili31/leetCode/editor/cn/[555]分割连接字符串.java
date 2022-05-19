package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;
import com.zhanglili31.leetCode.editor.cn.utils.CreateArray;

import java.util.Arrays;

//555 分割连接字符串
//2022-05-19 16:30:12
class SplitConcatenatedStrings {

    public static void main(String[] args) {
        Solution solution = new SplitConcatenatedStrings().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        String testStr = "hello";
        String strArray[] = {"abc","xyz"};
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
        int temp[] = CreateArray.getArray(20, 100);
        System.out.println(Arrays.toString(temp));
        System.out.println(solution.splitLoopedString(strArray));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String splitLoopedString(String[] strs) {
            String ans = "";
            StringBuilder cycle = new StringBuilder();
            for (int i = 0; i < strs.length; i++) {
                String revers = new StringBuilder(strs[i]).reverse().toString();
                int res = strs[i].compareTo(revers);
                if (res < 0) {
                    strs[i] = revers;
                }
                cycle.append((strs[i]));
            }
            ans = cycle.toString();
            for (int i = 0; i < strs.length; i++) {
                StringBuilder re = new StringBuilder(cycle);
                StringBuilder temp = new StringBuilder(re.substring(0, strs[i].length()));
                re.delete(0, strs[i].length());
                temp=temp.reverse();
                temp.append(re);
                re=temp;
                for (int j = 0; j < strs[i].length(); j++) {
                    char c = cycle.charAt(0);
                    char r = re.charAt(0);
                    re.deleteCharAt(0);
                    re.append(r);
                    cycle.deleteCharAt(0);
                    cycle.append(c);
                    if (ans.compareTo(cycle.toString()) < 0) {
                        ans = cycle.toString();
                    }
                    if (ans.compareTo(re.toString()) < 0) {
                        ans = re.toString();
                    }
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}