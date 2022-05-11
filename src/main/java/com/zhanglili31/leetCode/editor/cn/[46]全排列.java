package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateArray;
import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.*;

//46 全排列
//2022-05-11 21:21:17
class Permutations {

    public static void main(String[] args) {
        Solution solution = new Permutations().new Solution();
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
        Set<Integer> set = new HashSet<>();

        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                if (set.contains(nums[i])) {
                    continue;
                }
                set.add(nums[i]);
                int a = nums[i];
                List<List<Integer>> subRes = permute(nums);
                for (int j = 0; j < subRes.size(); j++) {
                    List<Integer> sub = subRes.get(j);
                    List<Integer> temp = new ArrayList<>();
                    temp.add(a);
                    temp.addAll(sub);
                    res.add(temp);
                }
                if (subRes.size() == 0) {
                    List<Integer> one = new ArrayList<>();
                    one.add(a);
                    res.add(one);
                }
                set.remove(nums[i]);
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}