package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.Arrays;

//1259 不相交的握手
//2022-06-20 02:50:01
class HandshakesThatDontCross {

    public static void main(String[] args) {
        Solution solution = new HandshakesThatDontCross().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        String testStr = "hello";
        String strArray[] = {"wrt", "wrf"};
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
//        int temp[] = CreateArray.getArray(20, 100);
        int temp[] = {5, 3, 2, 2};
        System.out.println(Arrays.toString(temp));
        System.out.println(solution.numberOfWays(6));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    //https://leetcode.cn/problems/handshakes-that-dont-cross/solution/dp-by-mike-meng-16/
    //一定要使用long，因为有的树可能已经溢出了，返回了一个小的数，再去mod已经没有意义了。
    class Solution {
        long dp[];
        long mod=1000000007;
        public int numberOfWays(int numPeople) {
            dp = new long[numPeople + 1];
            dp[0]=1;
            return (int)recursion(numPeople);
        }

        private long recursion(int numPeople) {
            if (dp[numPeople] != 0) {
                return dp[numPeople];
            }
            for (int i = 0; i < numPeople; i += 2) {
                dp[numPeople] =(dp[numPeople]+ (recursion(i) * recursion(numPeople-i-2))%mod)%mod;
            }
            return dp[numPeople];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}