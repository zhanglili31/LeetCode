package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateListNode;
import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.ListNode;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//47 全排列 II
//2022-09-06 16:04:08
class PermutationsIi {

    public static void main(String[] args) {
        int dir8[][] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
        int dir4[][] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Solution solution = new PermutationsIi().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        ListNode listNode = CreateListNode.stringToListNode("[1,2,3]");
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
        //官方回溯思路
        //https://leetcode.cn/problems/permutations-ii/solution/quan-pai-lie-ii-by-leetcode-solution/
        public List<List<Integer>> permuteUnique(int[] nums) {
            List<List<Integer>> ans = new ArrayList<>();
            ArrayList<Integer> permute = new ArrayList<>();
            Arrays.sort(nums);
            backTrace(ans, permute, nums, new boolean[nums.length]);
            return ans;
        }

        private void backTrace(List<List<Integer>> ans, ArrayList<Integer> permute, int nums[], boolean[] vis) {
            if (permute.size() == nums.length) {
                ans.add(new ArrayList<>(permute));
                return;
            }
            for (int i = 0; i < nums.length; i++) {
                if (vis[i] || (i > 0 && nums[i] == nums[i - 1] && !vis[i - 1])) {//vis[i-1]=true  结果为false,表示前一个用过，目的就是排除下一位继续使用的场景
                    continue;
                }
                permute.add(nums[i]);
                vis[i] = true;
                backTrace(ans, permute, nums, vis);
                vis[i] = false;
                permute.remove(permute.size() - 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}