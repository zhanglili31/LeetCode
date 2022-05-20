package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;
import com.zhanglili31.leetCode.editor.cn.utils.CreateArray;

import java.util.Arrays;

//剑指 Offer 15 二进制中1的个数
//2022-05-21 02:06:45
class ErJinZhiZhong1deGeShuLcof {

    public static void main(String[] args) {
        Solution solution = new ErJinZhiZhong1deGeShuLcof().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        String testStr = "hello";
        String strArray[] = {"wrt", "wrf"};
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
        int temp[] = CreateArray.getArray(20, 100);
        System.out.println(Arrays.toString(temp));
        System.out.println(solution);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    public class Solution {
        // you need to treat n as an unsigned value
        public int hammingWeight2(int n) {
            int ch = 1;
            int ans = 0;
            for (int i = 0; i < 32; i++) {
                if ((ch & n) != 0) {
                    ans++;
                }
                ch = ch << 1;
            }
            return ans;
        }

        public int hammingWeight(int n) {
            int ans = 0;
            while (n != 0) {
                n = n & (n - 1);
                ans++;
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}