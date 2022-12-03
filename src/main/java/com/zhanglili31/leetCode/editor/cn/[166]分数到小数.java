package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateListNode;
import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.ListNode;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//166 分数到小数
//2022-12-04 00:32:50
class FractionToRecurringDecimal {

    public static void main(String[] args) {
        int dir8[][] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
        int dir4[][] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Solution solution = new FractionToRecurringDecimal().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        ListNode listNode = CreateListNode.stringToListNode("[1,2,3]");
        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        String testStr = "hello";
        String strArray[] = {"wrt", "wrf"};
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
//        int temp[] = CreateArray.getArray(20, 100);
        int temp[] = {5, 3, 2, 2};
        System.out.println(Arrays.toString(temp));
        System.out.println(solution.fractionToDecimal(4, 333));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 参考题解：https://leetcode.cn/problems/fraction-to-recurring-decimal/solution/gong-shui-san-xie-mo-ni-shu-shi-ji-suan-kq8c4/
        public String fractionToDecimal(int numerator, int denominator) {
            long a = (long) numerator;
            long b = (long) denominator;
            // a/b
            StringBuilder sb = new StringBuilder();
            if (a * b < 0) {
                sb.append('-');
            }
            a = Math.abs(a);
            b = Math.abs(b);

            sb.append(a / b);
            if (a % b == 0) {
                return sb.toString();
            }

            a = a % b;
            sb.append('.');
            Map<Long, Integer> map = new HashMap<>();
            map.put(a, sb.length());
            while (a != 0) {
                a = a * 10;
                while (a < b) {
                    a = a * 10;
                    sb.append('0');
                }
                sb.append(a / b);
                a = a % b;
                if (map.containsKey(a)) {
                    sb.insert(map.get(a), "(");
                    sb.append(')');
                    break;
                }
                map.put(a, sb.length());
            }
            return sb.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}