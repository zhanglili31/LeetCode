package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;
import com.zhanglili31.leetCode.editor.cn.utils.CreateArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//267 回文排列 II
//2022-05-07 08:17:37
class PalindromePermutationIi {

    public static void main(String[] args) {
        Solution solution = new PalindromePermutationIi().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        String testStr = "aaaabbbbccccdddd";
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
        int temp[] = CreateArray.getArray(20, 100);
        System.out.println(Arrays.toString(temp));
        System.out.println(solution.generatePalindromes(testStr));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int array[] = new int[26];
        String mid = "";

        public List<String> generatePalindromes(String s) {
            List<String> res = new ArrayList<>();
            if (!canPermutePalindrome(s)) {
                return res;
            }
            if (s.length() == 1) {
                res.add(s);
                return res;
            }
            List<StringBuilder> list = traceBack();
            for (int i = 0; i < list.size(); i++) {
                StringBuilder strB = list.get(i);
                String addStr = strB.toString() + mid + strB.reverse().toString();
                res.add(addStr);
            }
            return res;
        }

        public List<StringBuilder> traceBack() {
            List<StringBuilder> res = new ArrayList<>();
            for (int i = 0; i < array.length; i++) {
                if (array[i] > 0) {
                    array[i]--;
                    List<StringBuilder> temp = traceBack();
                    array[i]++;
                    for (int k = 0; k < temp.size(); k++) {
                        StringBuilder strB = new StringBuilder(String.valueOf((char) (i + 'a')));
                        strB.append(temp.get(k));
                        res.add(strB);
                    }
                    if (temp.size() == 0) {
                        res.add(new StringBuilder(String.valueOf((char) (i + 'a'))));
                    }
                }
            }
            return res;
        }

        public boolean canPermutePalindrome(String s) {
            int q = 0;
            for (int i = 0; i < s.length(); i++) {
                array[s.charAt(i) - 'a']++;
            }
            for (int i = 0; i < array.length; i++) {
                if (array[i] % 2 == 1) {
                    q++;
                    mid = String.valueOf((char) (i + 'a'));
                }
                if (array[i] == 1) {
                    array[i] = 0;
                } else if (array[i] > 1) {
                    array[i] /= 2;

                }
            }
            return q < 2;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}