package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateListNode;
import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.ListNode;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.*;

//168 Excel表列名称
//2022-10-19 04:04:34
class ExcelSheetColumnTitle {

    public static void main(String[] args) {
        int dir8[][] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
        int dir4[][] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Solution solution = new ExcelSheetColumnTitle().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        ListNode listNode = CreateListNode.stringToListNode("[1,2,3]");
        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        String testStr = "hello";
        String strArray[] = {"wrt", "wrf"};
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
//        int temp[] = CreateArray.getArray(20, 100);
        int temp[] = {5, 3, 2, 2};
        System.out.println(Arrays.toString(temp));
        System.out.println(solution.convertToTitle(1024));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    //本身是一个26进制问题，但是比较特殊的是，26有表示的字符。
    class Solution {
        public String convertToTitle(int columnNumber) {
            Map<Integer, Character> map = new HashMap<>();
            for (int i = 0; i < 26; i++) {
                map.put(i + 1, (char) ('A' + i));
            }
            StringBuilder result = new StringBuilder();
            List<Integer> list = nAry(columnNumber, 26);
            for (int i = list.size() - 1; i >= 0; i--) {
                if (list.get(i) == 0) {
                    if (i - 1 >= 0) {
                        list.set(i - 1, list.get(i - 1) - 1);
                        result.append('Z');
                    }
                } else {
                    result.append(map.get(list.get(i)));
                }

            }
            return result.reverse().toString();


        }

        //这里是从10进制转化到其他任意进制
        private List<Integer> nAry(int n, int radix) {
            List<Integer> list = new ArrayList<>();
            while (n > 0) {
                int mod = n % radix;
                n = n / radix;
                list.add(mod);
            }
            Collections.reverse(list);
            return list;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}