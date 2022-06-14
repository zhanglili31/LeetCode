package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//1153 字符串转化
//2022-06-14 15:02:17
class StringTransformsIntoAnotherString {

    public static void main(String[] args) {
        Solution solution = new StringTransformsIntoAnotherString().new Solution();
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
        //参考思路：https://leetcode.cn/problems/string-transforms-into-another-string/solution/c-jian-dan-bian-li-ji-ke-by-da-li-wang/
        //为什么：str2有26个不同字符时，结果为false？
        //解释：1 如果他们的长度刚好时26， 那么 abcdefghijklmnopqretuvwxyz
        //str1 abcdefghijklmnopqretuvwxyy  变换最后y->z的时候, abcdefghijklmnopqretuvwxzz
        //str2 abcdefghijklmnopqretuvwxyz
        //如果长度大于26
        //str2 abcdefghijklmnopqretuvwxyzyyyy
        //str1 abcdefghijklmnopqretuvwxyzxxxx  x-y的时候 abcdefghijklmnopqretuvwxyzyyyy
        public boolean canConvert(String str1, String str2) {
            if (str1.equals(str2)) {
                return true;
            }
            if (str1.length() != str2.length()) {
                return false;
            }
            Set<Character> set = new HashSet<>();
            for (int i = 0; i < str2.length(); i++) {
                set.add(str2.charAt(i));
            }
            if (set.size() == 26) {
                return false;
            }
            for (int i = 0; i < str1.length(); i++) {
                for (int j = i + 1; j < str1.length(); j++) {
                    if (str1.charAt(i) == str1.charAt(j)) {
                        if (str2.charAt(i) != str2.charAt(j)) {
                            return false;
                        }
                    }
                }
            }
            return true;

        }
        //正向思路：https://leetcode.cn/problems/string-transforms-into-another-string/solution/shi-yong-mapji-lu-zhuan-huan-guan-xi-by-jiaxin-2/
    }
//leetcode submit region end(Prohibit modification and deletion)

}