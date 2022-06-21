package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.Arrays;

//41 缺失的第一个正数
//2022-06-21 19:05:42
class FirstMissingPositive {

    public static void main(String[] args) {
        Solution solution = new FirstMissingPositive().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        String testStr = "hello";
        String strArray[] = {"wrt", "wrf"};
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
//        int temp[] = CreateArray.getArray(20, 100);
        int temp[] = {3, 4, -1, 1};
        System.out.println(Arrays.toString(temp));
        System.out.println(solution.firstMissingPositive(temp));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //方法一：使用位记录每一个数字是否存在
        public int firstMissingPositive2(int[] nums) {
            int len = (int) 5e5 + 1;
            long val[] = new long[len / 64 + 1];
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] <= 0 || nums[i] >= len) {
                    continue;
                }
                int a = nums[i] / 64;
                int b = nums[i] % 64;
                long l = 1L << b;
                val[a] = val[a] | l;
            }
            for (int i = 1; i <= len; i++) {
                int a = i / 64;
                int b = i % 64;
                long l = 1L << b;
                if ((val[a] & l) == 0) {
                    return i;
                }
            }
            return -1;

        }

        //方法二：置换数组中的数据。
        //1 2 3 4 5 6对应坐标：0 1 2 3 4 5
        public int firstMissingPositive(int[] nums) {
            int n = nums.length;
            for (int i = 0; i < nums.length; i++) {
                //对于nums[i]来说，如果nums[i]属于[1,n]
                //那么他的位置就应该是：num[i]-1,
                //如果：nums[i]=i+1,
                while (nums[i] - 1 >= 0 && nums[i] - 1 < nums.length && nums[i] - 1 != i && nums[nums[i] - 1] != nums[i]) {
                    int temp = nums[nums[i] - 1];
                    nums[nums[i] - 1] = nums[i];
                    nums[i] = temp;
                }

            }
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != i + 1) {
                    return i + 1;
                }
            }
            return n+1;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}