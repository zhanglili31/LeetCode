package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.Arrays;

//324 摆动排序 II
//2022-06-24 02:51:53
class WiggleSortIi {

    public static void main(String[] args) {
        Solution solution = new WiggleSortIi().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        String testStr = "hello";
        String strArray[] = {"wrt", "wrf"};
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
//        int temp[] = CreateArray.getArray(20, 100);
        int temp[] = {1, 4, 3, 4, 1, 2, 1, 3, 1, 3, 2, 3, 3};
        System.out.println(Arrays.toString(temp));
        solution.wiggleSort(temp);

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //NOT AC
        public void wiggleSort(int[] nums) {
            boolean flag = true;
            for (int i = 0, j = i + 1; i < nums.length && j < nums.length; i++, j++) {
                int k = j;
                while (k < nums.length && nums[k] == nums[i]) {
                    k++;
                }

                if (i % 2 == 0) {
                    if (nums[i] > nums[k]) {
                        int t = nums[k];
                        nums[k] = nums[i];
                        nums[i] = t;
                    }
                } else {
                    if (nums[i] < nums[k]) {
                        int t = nums[k];
                        nums[k] = nums[i];
                        nums[i] = t;
                    }
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}