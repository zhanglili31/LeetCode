package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//233 数字 1 的个数
//2022-06-09 07:04:51
class NumberOfDigitOne {

    public static void main(String[] args) {
        Solution solution = new NumberOfDigitOne().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        String testStr = "hello";
        String strArray[] = {"wrt", "wrf"};
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
//        int temp[] = CreateArray.getArray(20, 100);
        int temp[] = {5, 3, 2, 2};
        System.out.println(Arrays.toString(temp));
        System.out.println(solution.countDigitOne(110));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int d = 1;

        public int countDigitOne(int n) {
            int count = 0;
            int multiply = 1;
            int temp = n;
            List<Integer> list = new ArrayList<>();
            while (temp > 0) {
                int x = temp % 10;
                list.add(x);
                temp = temp / 10;
            }
            temp = n;
            for (int i = 0; i < list.size() - 1; i++) {
                temp /= 10;
                if (list.get(i) > d) {
                    count += multiply * (temp + 1);
                } else if (list.get(i) < d) {
                    count += multiply * (temp);
                } else if (list.get(i) == d) {
                    count += multiply * temp + n % multiply + 1;
                }
                multiply *= 10;
            }
            int index = list.size() - 1;
            if (index >= 0) {
                int last = list.get(index);
                if (last < d) {
                    //do nothing
                } else if (last == d) {
                    count += n % (Math.pow(10, index)) + 1;
                } else if (last > d) {
                    count += multiply;
                }
            }
            return count;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}