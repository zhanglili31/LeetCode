package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;
import com.zhanglili31.leetCode.editor.cn.utils.CreateArray;

import java.util.Arrays;

//剑指 Offer 11 旋转数组的最小数字
//2022-05-21 01:27:43
class XuanZhuanShuZuDeZuiXiaoShuZiLcof {

    public static void main(String[] args) {
        Solution solution = new XuanZhuanShuZuDeZuiXiaoShuZiLcof().new Solution();
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
        //方法一：暴力方法
        public int minArray1(int[] numbers) {
            int ans = Integer.MAX_VALUE;
            for (int i = 0; i < numbers.length; i++) {
                ans = Math.min(numbers[i], ans);
            }
            return ans;
        }
        //方法二：二分+分治
        public int minArray(int[] numbers) {
            return recursion(numbers, 0, numbers.length - 1);

        }
        private int recursion(int[]numbers,int left,int right) {
            if (right - left <= 1) {
                return Math.min(numbers[left], numbers[right]);
            }
            int mid=left+(right-left)/2;
            if (numbers[mid] > numbers[right]) {
                return recursion(numbers, mid+1, right);
            }
            if (numbers[mid]  < numbers[left]) {
                return recursion(numbers, left + 1, mid);
            }
            return Math.min(recursion(numbers, left, mid - 1), recursion(numbers, mid + 1, right));
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}