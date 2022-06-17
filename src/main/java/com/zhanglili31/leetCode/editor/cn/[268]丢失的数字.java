package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.Arrays;

//268 丢失的数字
//2022-06-18 02:22:49
class MissingNumber {

    public static void main(String[] args) {
        Solution solution = new MissingNumber().new Solution();
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

        //方法一：计数法
        public int missingNumber1(int[] nums) {
            int arr[] = new int[nums.length + 1];
            for (int i = 0; i < nums.length; i++) {
                arr[nums[i]]++;
            }
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == 0) {
                    return i;
                }
            }
            return -1;
        }

        //方法二：求和
        public int missingNumber2(int[] nums) {
            int n = nums.length;
            int allSum = ((n + 1) * (0 + n)) >> 1;
            int sum = 0;
            for (int i = 0; i < nums.length; i++) {
                sum += nums[i];
            }
            return allSum - sum;
        }
        //方法三：异或  原理： a^a=0  a^0=a
        public int missingNumber(int[] nums) {
            int sum = 0;
            for (int i = 0; i < nums.length; i++) {
                sum ^= nums[i]^(i+1);
            }
            sum^=0;
            return sum;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}