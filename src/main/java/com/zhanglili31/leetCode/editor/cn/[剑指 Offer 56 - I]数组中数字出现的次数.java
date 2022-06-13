package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

//剑指 Offer 56 - I 数组中数字出现的次数
//2022-06-13 16:31:00
class ShuZuZhongShuZiChuXianDeCiShuLcof {

    public static void main(String[] args) {
        Solution solution = new ShuZuZhongShuZiChuXianDeCiShuLcof().new Solution();
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
        //set 集合判断
        public int[] singleNumbers2(int[] nums) {
            Set<Integer> set = new HashSet<Integer>();
            for (int i = 0; i < nums.length; i++) {
                if (set.contains(nums[i])) {
                    set.remove(nums[i]);
                } else {
                    set.add(nums[i]);
                }
            }
            int ans[] = new int[2];
            Iterator<Integer> iterator = set.iterator();
            ans[0] = iterator.next();
            ans[1] = iterator.next();
            return ans;
        }

        //异或运算
        public int[] singleNumbers(int[] nums) {
            int res = nums[0];
            for (int i = 1; i < nums.length; i++) {
                res ^= nums[i];
            }
            //循转a b     0^1=1 的那一位
            int div = 1;
            while ((res & div) == 0) {
                div = div << 1;
            }
            int a = 0, b = 0;// 注意：0^a=a
            for (int i = 0; i < nums.length; i++) {
                if ((nums[i] & div) == div) {
                    a ^= nums[i];
                } else {
                    b ^= nums[i];
                }
            }
            return new int[]{a, b};

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}