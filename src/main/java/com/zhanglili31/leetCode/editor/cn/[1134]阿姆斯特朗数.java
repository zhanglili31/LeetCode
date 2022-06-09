package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.Arrays;

//1134 阿姆斯特朗数
//2022-06-09 20:17:11
class ArmstrongNumber {

    public static void main(String[] args) {
        Solution solution = new ArmstrongNumber().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        String testStr = "hello";
        String strArray[] = {"wrt", "wrf"};
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
//        int temp[] = CreateArray.getArray(20, 100);
        int temp[] = {5, 3, 2, 2};
        System.out.println(Arrays.toString(temp));
        System.out.println(solution.isArmstrong(153));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isArmstrong(int n) {
            int[] num = new int[9];
            int index = 0;
            int temp = n;
            while (temp > 0) {
                num[index++] = temp % 10;
                temp /= 10;
            }
            int sum = 0;
            for (int i = 0; i < 8; i++) {
                sum += Math.pow(num[i], index );
            }
            System.out.println(sum);
            return sum == n;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}