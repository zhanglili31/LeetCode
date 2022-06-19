package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.Arrays;

//38 外观数列
//2022-06-20 05:11:41
class CountAndSay {

    public static void main(String[] args) {
        Solution solution = new CountAndSay().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
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

        public String countAndSay(int n) {
            String ans = "1";
            for (int i = 2; i <= n; i++) {
                int count = 1;
                StringBuilder str = new StringBuilder();
                for (int k = ans.length() - 2; k >= 0; k--) {
                    if (ans.charAt(k) == ans.charAt(k + 1)) {
                        count++;
                    } else {
                        str.insert(0, "" + count + ans.charAt(k + 1));
                        count = 1;
                    }
                }
                str.insert(0, "" + count + ans.charAt(0));
                ans = str.toString();

            }
            return ans;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}