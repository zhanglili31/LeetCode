package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//剑指 Offer 57 - II 和为s的连续正数序列
//2022-06-14 20:31:16
class HeWeiSdeLianXuZhengShuXuLieLcof {

    public static void main(String[] args) {
        Solution solution = new HeWeiSdeLianXuZhengShuXuLieLcof().new Solution();
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
        //双指针：https://leetcode.cn/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof/solution/jian-zhi-offer-57-ii-he-wei-s-de-lian-xu-t85z/
        public int[][] findContinuousSequence(int target) {
            int i = 1, j = 2, sum = 3;
            List<int[]> list = new ArrayList<>();
            while (i < j) {
                if (sum < target) {
                    j++;
                    sum += j;
                } else if (sum > target) {
                    sum -= i;
                    i++;
                } else if (sum == target) {
                    int[] temp = new int[j - i + 1];
                    for (int k = 0; k < j - i + 1; k++) {
                        temp[k] = i + k;
                    }
                    list.add(temp);
                    sum -= i;
                    i++;
                }
            }
            int ans[][] = new int[list.size()][];
            for (int k = 0; k < list.size(); k++) {
                ans[k] = list.get(k);
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}