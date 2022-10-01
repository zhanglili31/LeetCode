package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateListNode;
import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.ListNode;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//90 子集 II
//2022-10-01 20:58:11
class SubsetsIi {

    public static void main(String[] args) {
        int dir8[][] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
        int dir4[][] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Solution solution = new SubsetsIi().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        ListNode listNode = CreateListNode.stringToListNode("[1,2,3]");
        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        String testStr = "hello";
        String strArray[] = {"wrt", "wrf"};
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
//        int temp[] = CreateArray.getArray(20, 100);
        int temp[] = {1, 1, 2, 2};
        System.out.println(Arrays.toString(temp));
        System.out.println(solution.subsetsWithDup(temp));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> subsetsWithDup(int[] nums) {
            Arrays.sort(nums);
            List<List<Integer>> res = new ArrayList<>();
            boolean used[] = new boolean[nums.length];
            for (int i = 0; i <= nums.length; i++) {
                DFS(res, new ArrayList<>(), 0, nums, i, used);
            }
            return res;

        }

        private void DFS(List<List<Integer>> res, List<Integer> cur, int index, int[] nums, int tarLen, boolean[] used) {
            if (cur.size() == tarLen) {
                res.add(new ArrayList<>(cur));
                return;
            }
            for (int i = index; i < nums.length; i++) {
                if (i - 1 >= 0 && nums[i] == nums[i - 1] && !used[i - 1]) {//used【i-】却别连着加，和顺着加， ，加常used[i-1]=true,替换used[i-1]=false;
                    continue;
                }
                cur.add(nums[i]);
                used[i] = true;
                DFS(res, cur, i + 1, nums, tarLen, used);
                used[i] = false;
                cur.remove(cur.size() - 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}