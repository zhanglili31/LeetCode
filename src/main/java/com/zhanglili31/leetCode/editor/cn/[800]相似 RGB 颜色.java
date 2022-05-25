package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;
import com.zhanglili31.leetCode.editor.cn.utils.CreateArray;

import java.util.Arrays;

//800 相似 RGB 颜色
//2022-05-26 00:31:30
class SimilarRgbColor {

    public static void main(String[] args) {
        Solution solution = new SimilarRgbColor().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        String testStr = "hello";
        String strArray[] = {"wrt", "wrf"};
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
        int temp[] = CreateArray.getArray(20, 100);
        System.out.println(Arrays.toString(temp));
        System.out.println(solution);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String similarRGB(String color) {
            return "#" + f(color.substring(1, 3)) + f(color.substring(3, 5)) + f(color.substring(5, 7));

        }

        public String f(String comp) {
            int v = Integer.parseInt(comp, 16);
            int v2=v/17+(v % 17 > 8 ? 1 : 0);
            return String.format("%2x", v2);

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}