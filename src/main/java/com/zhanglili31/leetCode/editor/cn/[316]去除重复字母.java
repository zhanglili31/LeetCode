package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateListNode;
import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.ListNode;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//316 去除重复字母
//2022-09-17 22:48:15
class RemoveDuplicateLetters {

    public static void main(String[] args) {
        int dir8[][] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
        int dir4[][] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Solution solution = new RemoveDuplicateLetters().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        ListNode listNode = CreateListNode.stringToListNode("[1,2,3]");
        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        String testStr = "cdadabcc";
        String strArray[] = {"wrt", "wrf"};
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
//        int temp[] = CreateArray.getArray(20, 100);
        int temp[] = {5, 3, 2, 2};
        System.out.println(Arrays.toString(temp));
        System.out.println(solution.removeDuplicateLetters(testStr));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //思路：https://leetcode.cn/problems/remove-duplicate-letters/solution/yi-zhao-chi-bian-li-kou-si-dao-ti-ma-ma-zai-ye-b-4/
        //记录每一个字符的出现次数，每遍历一次，次数减一
        public String removeDuplicateLetters(String s) {
            int count[] = new int[26];
            for (int i = 0; i < s.length(); i++) {
                count[s.charAt(i) - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            int top = -1;
            char ch = ' ';
            Set<Character> set = new HashSet<>();
            for (int i = 0; i < s.length(); i++) {
                ch = s.charAt(i);
                //每遍历一次，次数减一
                count[ch - 'a']--;
                //删除条件：sb中的字符数大于1，  当前的字符比栈顶字符小，应该放在前面，并且后面还有栈顶字符，可以补上。再就是当前字符需要加入进去
                //
                while (top >= 0 && !set.contains(ch) && ch < sb.charAt(top) && count[sb.charAt(top) - 'a'] > 0) {
                    set.remove(sb.charAt(top));
                    sb.deleteCharAt(top);
                    top--;
                }
                if (!set.contains(ch)) {
                    sb.append(ch);
                    set.add(ch);
                    top++;
                }
            }
            return sb.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}