package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.Arrays;

//1118 一月有多少天
//2022-06-09 19:59:36
class NumberOfDaysInAMonth {

    public static void main(String[] args) {
        Solution solution = new NumberOfDaysInAMonth().new Solution();
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
        //润年的定义：https://baike.baidu.com/item/%E9%97%B0%E5%B9%B4/27098?fr=aladdin
//            普通闰年：公历年份是4的倍数，且不是100的倍数的，为闰年（如2004年、2020年等就是闰年）。
//            世纪闰年：公历年份是整百数的，必须是400的倍数才是闰年（如1900年不是闰年，2000年是闰年）。
        public int numberOfDays(int year, int month) {
            int days[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
            if (month != 2) {
                return days[month - 1];
            }
            if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
                return 29;
            } else {
                return 28;
            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}