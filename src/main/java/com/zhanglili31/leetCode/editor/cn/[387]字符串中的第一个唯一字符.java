package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.Arrays;

//387 字符串中的第一个唯一字符
//2022-06-23 00:10:54
class FirstUniqueCharacterInAString {

    public static void main(String[] args) {
        Solution solution = new FirstUniqueCharacterInAString().new Solution();
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
        public int firstUniqChar(String s) {
            int arr[] = new int[26];
            for (int i = 0; i < s.length(); i++) {
                arr[s.charAt(i) - 'a']++;
            }
            for (int i = 0; i < s.length(); i++) {
                if (arr[s.charAt(i) - 'a'] == 1) {
                    return i;
                }
            }
            return -1;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}