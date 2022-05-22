package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateArray;
import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.*;

//666 路径总和 IV
//2022-05-22 23:22:04
class PathSumIv {

    public static void main(String[] args) {
        Solution solution = new PathSumIv().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        String testStr = "hello";
        String strArray[] = {"wrt", "wrf"};
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
        int temp[] = CreateArray.getArray(20, 100);
        temp = new int[]{111, 217, 221, 315, 415};
        System.out.println(Arrays.toString(temp));
        System.out.println(solution.pathSum(temp));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int pathSum(int[] nums) {
            int level = nums[nums.length - 1] / 100;
            Map<Integer, int[]> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                int l = nums[i] / 100;
                int[] temp = map.getOrDefault(l, new int[9]);
                temp[nums[i] % 100 / 10] = nums[i];
                map.put(l, temp);
            }
            List<Integer> leaves = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                int p=nums[i]%100/10;
                int l=nums[i]/100+1;
                if (!map.containsKey(l)) {
                    leaves.add(nums[i]);
                }else{
                    int[] temp = map.get(l);
                    if (temp[p * 2] == 0 && temp[p * 2 - 1] == 0) {
                        leaves.add(nums[i]);
                    }
                }
            }

            int ans = 0;
            int fa;
            for (int i = 0; i < leaves.size(); i++) {
                fa = leaves.get(i);
                ans += fa%10;
                while (fa > 200) {
                    fa = map.get(fa / 100 - 1)[(fa % 100 / 10+1) / 2];
                    ans += fa%10;
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}