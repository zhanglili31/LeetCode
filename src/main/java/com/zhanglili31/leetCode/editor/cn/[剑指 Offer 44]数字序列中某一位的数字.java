package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.Arrays;

//剑指 Offer 44 数字序列中某一位的数字
//2022-06-27 07:51:24
class ShuZiXuLieZhongMouYiWeiDeShuZiLcof {

    public static void main(String[] args) {
        int dir8[][] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
        int dir4[][] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Solution solution = new ShuZiXuLieZhongMouYiWeiDeShuZiLcof().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        String testStr = "hello";
        String strArray[] = {"wrt", "wrf"};
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
//        int temp[] = CreateArray.getArray(20, 100);
        int temp[] = {5, 3, 2, 2};
        System.out.println(Arrays.toString(temp));
        System.out.println(solution.findNthDigit(10));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findNthDigit(int n) {
            long[] num = new long[10];
            long[] begin = new long[10];
            long pre = 0;
            long next = 10;
            for (int i = 0; i < 9; i++) {
                num[i] = next - pre;
                num[i] *= (i + 1);
                begin[i] = pre;
                pre = next;
                next *= 10;

            }
            begin[9] = next;
            num[9] = Integer.MAX_VALUE - (long) 1e9 + 1;
            int index = 0;
            long th = n;
            while (th >= num[index]) {
                th = th - num[index++];
            }
            int len = index + 1;
            long tar = th / (len);
            long bit = th % (len);
            int v = (int) (begin[index] + tar);
            int ans = 0;
            for (int k = 0; k < len - bit; k++) {
                ans = v % 10;
                v = v / 10;
            }
            return ans;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}