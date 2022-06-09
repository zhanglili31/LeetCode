package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//1067 范围内的数字计数
//2022-06-08 07:02:21
class DigitCountInRange {

    public static void main(String[] args) {
        Solution solution = new DigitCountInRange().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
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
        //暴力超时，正确的应该用数学归纳的方式计算
        public int digitsCount2(int d, int low, int high) {
            int ans = 0;
            for (int i = low; i <= high; i++) {
                int temp = i;
                while (temp >= d) {
                    int k = temp % 10;
                    temp = temp / 10;
                    if (k == d) {
                        ans++;
                    }
                }
            }
            return ans;

        }

        public int digitsCount(int d, int low, int high) {
            int lower = countDigitOne(low - 1, d);
            int higher = countDigitOne(high, d);
            return higher - lower;

        }

        public int countDigitOne(int n, int d) {
            if (d == 0) {
                return countDigitZero(n, 0);
            }
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

        public int countDigitZero(int n, int d) {
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
                    count += multiply * (temp);
                } else if (list.get(i) == d) {
                    count += multiply * (temp - 1) + n % multiply + 1;
                }
                multiply *= 10;
            }
            return count;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}