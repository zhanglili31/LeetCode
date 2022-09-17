package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateListNode;
import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.ListNode;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.Arrays;
//416 分割等和子集
//2022-09-12 21:21:43
class PartitionEqualSubsetSum {

    public static void main(String[] args) {
        int dir8[][] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
        int dir4[][] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Solution solution = new PartitionEqualSubsetSum().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        ListNode listNode = CreateListNode.stringToListNode("[1,2,3]");
        int [][]a={{1,1,1},{1,0,1},{1,1,1}};
        String testStr="hello";
        String strArray[] = {"wrt","wrf"};
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
//        int temp[] = CreateArray.getArray(20, 100);
        int temp[] = {5, 3, 2, 2};
        System.out.println(Arrays.toString(temp));
        System.out.println(solution);
    }
    
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean canPartition(int[] nums) {
        int sum=0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum % 2 == 1) {
            return false;
        }
        int target=sum/2;
        boolean dp[][] = new boolean[nums.length][target + 1];
        //初始化第一列为0
        //因为target=0的时候，没有任何一个元素等于0，因此初始化为0
        for (int i = 0; i < nums.length; i++) {
            dp[i][0]=false;
        }
        //初始化第一行，只有第一个元素可以等于target之一。
        if (nums[0] <= target) {
            dp[0][nums[0]]=true;
        }
        //物品体积 num[i]   ,
        //价值：num[i]
        //求是否存在一个target，背包体积，
        for (int i = 1; i < nums.length; i++) {//挨个遍历物品
            for (int j = 1; j <= target; j++) {
                //如果不添加当前的元素
                dp[i][j]=dp[i-1][j];

                //如果添加但前元素
                if (j > nums[i]) {
                    dp[i][j] = dp[i - 1][j - nums[i]] || dp[i][j];
                }
            }
        }
        return dp[nums.length - 1][target];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
 
}