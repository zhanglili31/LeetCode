package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateListNode;
import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.ListNode;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.Arrays;

//67 二进制求和
//2022-10-19 02:57:13
class AddBinary {

    public static void main(String[] args) {
        int dir8[][] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
        int dir4[][] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Solution solution = new AddBinary().new Solution();
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
        public String addBinary(String a, String b) {
            int maxLen = Math.max(a.length(), b.length()) + 1;
            StringBuilder sb1 = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            for (int i = 0; i < maxLen - a.length(); i++) {
                sb1.append('0');
            }
            sb1.append(a);
            for (int i = 0; i < maxLen - b.length(); i++) {
                sb2.append('0');
            }
            sb2.append(b);

            //计算结果
            StringBuilder res = new StringBuilder();
            int flag = 0;
            int sum = 0;
            for (int i = maxLen - 1; i >= 0; i--) {
                sum = sb1.charAt(i) + sb2.charAt(i) + flag - 2 * '0';
                int v = sum % 2;
                flag = sum >> 1;
                res.append(v + "");
            }
            while (res.length() > 1 && res.charAt(res.length() - 1) == '0') {
                res.setLength(res.length() - 1);
            }
            res.reverse();
            return res.toString();

        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}