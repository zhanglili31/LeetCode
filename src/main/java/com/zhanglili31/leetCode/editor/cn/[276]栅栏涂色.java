package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;
import com.zhanglili31.leetCode.editor.cn.utils.CreateArray;
import java.util.Arrays;
//276 栅栏涂色
//2022-05-08 06:07:58
class PaintFence {

    public static void main(String[] args) {
        Solution solution = new PaintFence().new Solution();
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
    public int numWays(int n, int k) {
        //dp[0] 是与前一个栅栏颜色相同的方案数量
        //dp[1] 是与前一个栅栏颜色不同的方案数量
        int dp[][] = new int[n][2];
        dp[0][1] = k;
        for (int i = 1; i < n; i++) {
            //栅栏i和栅栏i-1的图的颜色相同，i的涂色方式只有1种，并且i-1不能与i-2的涂色方案相同，因此dp[i][0]的递推公式如下
            dp[i][0] = 1 * dp[i - 1][1];
            //栅栏i和栅栏i-1的图的颜色不同，i的涂色方式有k-1z中，栅栏i-1的涂色方案可以与i-1相同，也可以不同因此dp[i][1]的递推公式如下
            dp[i][1] = (k - 1) * (dp[i - 1][0] + dp[i - 1][1]);
        }
        return dp[n - 1][0] + dp[n - 1][1];
        //最后还可以把dp数组改为两个变量，节省内存。但是为了方便理解，使用数组
    }
}
//leetcode submit region end(Prohibit modification and deletion)
 
}