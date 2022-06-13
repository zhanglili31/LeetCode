package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.Arrays;

//剑指 Offer 56 - II 数组中数字出现的次数 II
//2022-06-13 17:28:40
class ShuZuZhongShuZiChuXianDeCiShuIiLcof {

    public static void main(String[] args) {
        Solution solution = new ShuZuZhongShuZiChuXianDeCiShuIiLcof().new Solution();
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
        //遍历统计
        public int singleNumber(int[] nums) {
            int count[] = new int[32];
            for (int i = 0; i < nums.length; i++) {
                int div = 1;
                for (int j = 0; j < 32; j++) {
                    count[j] += (div & nums[i]) != 0 ? 1 : 0;
                    div = div << 1;
                }
            }
            int ans = 0;
            for (int i = 31; i >= 0; i--) {
                ans = ans << 1;
                ans += count[i] % 3;
            }
            return ans;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}