package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//202 快乐数
//2022-06-22 06:04:03
class HappyNumber {

    public static void main(String[] args) {
        Solution solution = new HappyNumber().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        String testStr = "hello";
        String strArray[] = {"wrt", "wrf"};
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
//        int temp[] = CreateArray.getArray(20, 100);
        int temp[] = {5, 3, 2, 2};
        System.out.println(Arrays.toString(temp));
        System.out.println(solution.isHappy(Integer.MAX_VALUE));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    //
    class Solution {
        public boolean isHappy(int n) {
            int sum = 0;
            Set<Integer> set = new HashSet<>();
            while (n >= 1) {
                int temp = n;
                set.add(n);
                while (temp > 0) {
                    int x = temp % 10;
                    sum += x * x;
                    temp = temp / 10;
                }
                System.out.println(sum);
                if (sum == 1) {
                    return true;
                }
                if (set.contains(sum)) {
                    return false;
                }
                n = sum;
                sum=0;

            }
            return false;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}