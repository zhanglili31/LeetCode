package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateArray;
import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//634 寻找数组的错位排列
//2022-05-22 14:58:12
class FindTheDerangementOfAnArray {

    public static void main(String[] args) {
        Solution solution = new FindTheDerangementOfAnArray().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        String testStr = "hello";
        String strArray[] = {"wrt", "wrf"};
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
        int temp[] = CreateArray.getArray(20, 100);
        System.out.println(Arrays.toString(temp));
        System.out.println(solution.findDerangement(30));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        Set<Integer> set = new HashSet<>();
        int ans = 0;

        //参考解决方案：https://leetcode.cn/problems/find-the-derangement-of-an-array/solution/xun-zhao-shu-zu-de-cuo-wei-pai-lie-by-lenn123/
        //情况2；n已经放在位置k上，剩下：1-n-1(中间去掉k)+k  问题转化为n-1的字问题。k不能放在n的位置上。
        public int findDerangement(int num) {
            int dp[] = new int[num + 1];
            dp[0] = 0;
            dp[1] = 0;
            for (int i = 2; i <= num; i++) {
                dp[i] = (int) (((i - 1L) * (dp[i - 1] + dp[i - 2])) % 1000000007);
            }
            return dp[num];
        }

        //模拟构造所有排列的方式，必定超时。n!的复杂度。
        public int findDerangement2(int n) {
            recursion(n, 1);
            return ans;
        }

        //
        public void recursion(int n, int index) {
            if (set.size() == n) {
                ans++;
                ans = ans % 1000000007;
                return;
            }
            for (int i = 1; i <= n; i++) {
                if (i == index || set.contains(i)) {
                    continue;
                }
                set.add(i);
                recursion(n, index + 1);
                set.remove(i);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}