package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.Arrays;

//171 Excel 表列序号
//2022-06-22 04:08:36
class ExcelSheetColumnNumber {

    public static void main(String[] args) {
        Solution solution = new ExcelSheetColumnNumber().new Solution();
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
        public int titleToNumber(String columnTitle) {
            int ans = 0;
            int in = 1;
            for (int i = columnTitle.length() - 1; i >= 0; i--) {
                char ch = columnTitle.charAt(i);
                ans += (ch-'A'+1) * in;
                in *= 26;
            }
            return ans;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}