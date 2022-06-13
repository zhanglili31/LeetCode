package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//剑指 Offer 50 第一个只出现一次的字符
//2022-06-13 15:16:42
class DiYiGeZhiChuXianYiCiDeZiFuLcof {

    public static void main(String[] args) {
        Solution solution = new DiYiGeZhiChuXianYiCiDeZiFuLcof().new Solution();
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
        public char firstUniqChar(String s) {
            Set<Character> set = new HashSet<>();
            Set<Character> repeat = new HashSet<>();
            for (int i = 0; i < s.length(); i++) {
                if (repeat.contains(s.charAt(i))) {
                    continue;
                }
                if (!set.contains(s.charAt(i))) {
                    set.add(s.charAt(i));
                } else {
                    set.remove(s.charAt(i));
                    repeat.add(s.charAt(i));
                }
            }
            for (int i = 0; i < s.length(); i++) {
                if (set.contains(s.charAt(i))) {
                    return s.charAt(i);
                }
            }
            return ' ';
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}