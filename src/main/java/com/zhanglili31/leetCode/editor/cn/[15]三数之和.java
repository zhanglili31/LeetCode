package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.*;

//15三数之和
//2021-04-15 00:03:40
class ThreeSum {
    public static void main(String[] args) {
        Solution solution = new ThreeSum().new Solution();
        TreeNode r = CreateTree.deserialize("[5,4,2,3,3,7]");
        int temp[] = {-1,0,1,2,-1,-4};
        System.out.println(solution.threeSum(temp));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //        key:-b-c
//        value:b的坐标
        public List<List<Integer>> threeSum(int[] nums) {
            Arrays.sort(nums);
            List<List<Integer>> list = new ArrayList<>();
            Map<Integer, Integer> map = new HashMap<>();
            int i = 0, j = nums.length;
            int diff = 0;
            for (int k = 0; k < nums.length - 2; k++) {
                if(k!=0&&nums[k]==nums[k-1])continue;
                i = k + 1;
                j = nums.length - 1;
                while (i < j) {
                    diff = nums[k] + (nums[i] + nums[j]);
                    if (diff == 0) {
                        List<Integer> temp = new ArrayList<Integer>();
                        temp.add(nums[k]);
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        list.add(temp);
                        i++;
                        j--;
                        while(i<nums.length&&nums[i]==nums[i-1]){i++;};
                        while(j-1>i&&nums[j]==nums[j+1]){j--;};
                    } else if (diff > 0) {
                        j--;
                    } else {
                        i++;
                    }
                }
            }
            return list;
 /*           hash确实比较麻烦，重点是去重复非常麻烦
            for (int i = 0; i < nums.length; i++) {
                if (i != 0 && nums[i - 1] == nums[i]) break;
                for (int j = i + 1; j < nums.length; j++) {
                    if (map.containsKey(nums[j])) {
                        List<Integer> temp = new ArrayList<Integer>();
                        temp.add(nums[i]);
                        temp.add(nums[map.get(nums[j])]);
                        temp.add(nums[j]);
                        list.add(temp);
                    } else {
                        map.put(0 - nums[i] - nums[j], j);
                    }
                }
                map = new HashMap<Integer, Integer>();
            }
            return list;*/

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
