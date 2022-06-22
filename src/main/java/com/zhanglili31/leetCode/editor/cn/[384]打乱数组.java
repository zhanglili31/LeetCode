package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.*;

//384 打乱数组
//2022-06-23 00:20:11
class ShuffleAnArray {

    public static void main(String[] args) {
//        Solution solution = new ShuffleAnArray().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        String testStr = "hello";
        String strArray[] = {"wrt", "wrf"};
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
//        int temp[] = CreateArray.getArray(20, 100);
        int temp[] = {5, 3, 2, 2};
        System.out.println(Arrays.toString(temp));
//        System.out.println(solution);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int original[] = null;
        List<int[]> ans = new ArrayList<>();

        public Solution(int[] nums) {
            this.original = nums;
//            DFS(nums, 0, new HashSet<Integer>(), new ArrayList<Integer>());

        }

        private void DFS(int nums[], int k, Set<Integer> set, List<Integer> v) {
            if (k == nums.length) {
                int[] temp = new int[k];
                for (int i = 0; i < k; i++) {
                    temp[i] = v.get(i);
                }
                ans.add(temp);
                return;
            }
            for (int i = 0; i < nums.length; i++) {
                if (set.contains(i)) {
                    continue;
                }
                set.add(i);
                v.add(nums[i]);
                DFS(nums, k + 1, set, v);
                set.remove(i);
                v.remove(v.size() - 1);
            }

        }

        public int[] reset() {
            return this.original;

        }

        //洗牌算法 https://leetcode.cn/problems/shuffle-an-array/solution/gong-shui-san-xie-xi-pai-suan-fa-yun-yon-0qmy/
        public int[] shuffle() {
            Random r = new Random();
//            int index = r.nextInt(ans.size());
            int temp[] = new int[original.length];
            for (int i = 0; i < temp.length; i++) {
                temp[i] = original[i];
            }
            for (int i = 0; i < original.length; i++) {
                int index = i + r.nextInt(temp.length-i);
                int a = temp[index];
                temp[index] = temp[i];
                temp[i] = a;
            }
            return temp;
        }
    }

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
//leetcode submit region end(Prohibit modification and deletion)

}