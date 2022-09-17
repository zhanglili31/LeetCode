package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateListNode;
import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.ListNode;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.Arrays;

//402 移掉 K 位数字
//2022-09-17 23:35:07
class RemoveKDigits {

    public static void main(String[] args) {
        int dir8[][] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
        int dir4[][] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Solution solution = new RemoveKDigits().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        ListNode listNode = CreateListNode.stringToListNode("[1,2,3]");
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
        //https://leetcode.cn/problems/remove-duplicate-letters/solution/yi-zhao-chi-bian-li-kou-si-dao-ti-ma-ma-zai-ye-b-4/
        public String removeKdigits(String num, int k) {

            int remain = num.length() - k;
            StringBuilder sb = new StringBuilder();
            int top = -1;
            for (int i = 0; i < num.length(); i++) {
                //k=0,全是append，刚好
                //k>0,全都满足递增，长度大于remain
                while (k > 0 && top >= 0 && num.charAt(i) < sb.charAt(top)) {
                    sb.deleteCharAt(top);
                    top--;
                    k--;
                }
                sb.append(num.charAt(i));
                top++;
            }
            String res = sb.toString().substring(0, remain);
            while (res.length() > 0 && res.charAt(0) == '0') {
                res = res.substring(1);
            }
            return res.length() == 0 ? "0" : res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}