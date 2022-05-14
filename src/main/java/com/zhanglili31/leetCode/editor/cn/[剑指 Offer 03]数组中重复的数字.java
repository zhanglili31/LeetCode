package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;
import com.zhanglili31.leetCode.editor.cn.utils.CreateArray;
import java.util.Arrays;
//剑指 Offer 03 数组中重复的数字
//2022-05-14 21:50:23
class ShuZuZhongZhongFuDeShuZiLcof {

    public static void main(String[] args) {
        Solution solution = new ShuZuZhongZhongFuDeShuZiLcof().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        int [][]a={{1,1,1},{1,0,1},{1,1,1}};
        String testStr="hello";
        String strArray[] = {"wrt","wrf"};
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
        int temp[] = CreateArray.getArray(20, 100);
        System.out.println(Arrays.toString(temp));
        System.out.println(solution);
    }
    
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findRepeatNumber(int[] nums) {
        int n=nums.length;
        long flag[] = new long[n / 64 + 1];
        for (int i = 0; i < nums.length; i++) {
            int index=nums[i]/64;
            int points=nums[i]%64;
            long c=1l<<points;
            if ((flag[index] & c) != 0) {
                return nums[i];
            }else{
                flag[index] |= c;
            }
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
 
}