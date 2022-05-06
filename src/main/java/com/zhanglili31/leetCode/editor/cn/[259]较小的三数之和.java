package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;
import com.zhanglili31.leetCode.editor.cn.utils.CreateArray;

import java.util.Arrays;
import java.util.Comparator;

//259 较小的三数之和
//2022-05-07 03:18:34
class ThreeSumSmaller {

    public static void main(String[] args) {
        Solution solution = new ThreeSumSmaller().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        String testStr = "hello";
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
        int temp[] = CreateArray.getArray(20, 100);
        int temp2[] = {-2, 0, 1, 3};
        System.out.println(Arrays.toString(temp));
        System.out.println(solution.threeSumSmaller(temp2, 2));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int threeSumSmaller(int[] nums, int target) {
            int res = 0;
            Arrays.sort(nums);
            for (int i = 0; i < nums.length - 2; i++) {
                for (int j = nums.length - 1; j > i + 1; j--) {
                    for (int k = i + 1; k < j; k++) {
                        int sum = nums[i] + nums[j] + nums[k];
                        if (sum < target) {
                            res++;
                        } else {
                            break;
                        }
                    }
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}