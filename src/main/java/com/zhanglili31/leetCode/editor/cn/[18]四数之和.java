package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.*;

//18 四数之和
//2022-06-22 22:14:01
class FourSum {

    public static void main(String[] args) {
        Solution solution = new FourSum().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        String testStr = "hello";
        String strArray[] = {"wrt", "wrf"};
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
//        int temp[] = CreateArray.getArray(20, 100);
        int temp[] = {1, 0, -1, 0, -2, 2};
        System.out.println(Arrays.toString(temp));
        System.out.println(solution.fourSum(temp, 0));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> fourSum(int[] nums, int target) {
            Arrays.sort(nums);
            int left = 0;
            int right = nums.length - 1;
            List<List<Integer>> ans = new ArrayList<>();
            Set<String> set = new HashSet<>();
            for (left = 0; left < nums.length; left++) {
                for (right = nums.length - 1; right > left + 2; right--) {
                    int i = left + 1;
                    int j = right - 1;
                    long target2 = (long)target -(long) nums[left] -(long) nums[right];
                    while (i < j) {
                        long v = (long)nums[i] + (long)nums[j];
                        if (v > target2) {
                            j--;
                        } else if (v < target2) {
                            i++;
                        } else {

                            String str = "" + nums[left] + nums[i] + nums[j] + nums[right];
                            if (set.contains(str)) {
                                i++;
                                continue;
                            }
                            set.add(str);
                            List<Integer> list = new ArrayList<>();
                            list.add(nums[left]);
                            list.add(nums[i]);
                            list.add(nums[j]);
                            list.add(nums[right]);
                            ans.add(list);
                            i++;

                        }
                    }
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}