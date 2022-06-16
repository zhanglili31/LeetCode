package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.Arrays;

//剑指 Offer 66 构建乘积数组
//2022-06-16 17:26:56
class GouJianChengJiShuZuLcof {

    public static void main(String[] args) {
        Solution solution = new GouJianChengJiShuZuLcof().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        String testStr = "hello";
        String strArray[] = {"wrt", "wrf"};
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
//        int temp[] = CreateArray.getArray(20, 100);
        int temp[] = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(temp));
        System.out.println(solution.constructArr(temp));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //dp[i][j]：表示区间[i,j]的所有元素的乘积
        //ans[i]=dp[0][i-1]*dp[i+1][n]
        public int[] constructArr2(int[] a) {
            int n = a.length;
            int dp[][] = new int[n][n];
            for (int i = 0; i < n; i++) {
                dp[i][i] = a[i];
            }
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    dp[i][j] = a[j] * dp[i][j - 1];
                }
            }
            int ans[] = new int[n];
            for (int i = 0; i < n; i++) {
                int pre = 1;
                if (i - 1 >= 0) {
                    pre = dp[0][i - 1];
                }
                int pro = 1;
                if (i + 1 < n) {
                    pro = dp[i + 1][n - 1];
                }
                ans[i] = pre * pro;
            }
            return ans;
        }

        //前缀*后缀
        public int[] constructArr(int[] a) {
            int n = a.length;
            int ans[] = new int[n];
            int pre[] = new int[n];
            int pro[] = new int[n];
            for (int i = 0; i < n; i++) {
                pre[i] = 1;
                pro[i] = 1;
            }
            for (int i = 1; i < n; i++) {
                pre[i] = a[i - 1] * pre[i - 1];
            }
            for (int i = n - 2; i >= 0; i--) {
                pro[i] = a[i + 1] * pro[i + 1];
            }
            for (int i = 0; i < n; i++) {
                ans[i] = pre[i] * pro[i];
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}