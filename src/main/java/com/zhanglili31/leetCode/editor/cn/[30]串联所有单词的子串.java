package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateListNode;
import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.ListNode;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.*;

//30 串联所有单词的子串
//2022-08-22 08:21:45
class SubstringWithConcatenationOfAllWords {

    public static void main(String[] args) {
        int dir8[][] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
        int dir4[][] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Solution solution = new SubstringWithConcatenationOfAllWords().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        ListNode listNode = CreateListNode.stringToListNode("[1,2,3]");
        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        String testStr = "barfoothefoobarman";
        String strArray[] = {"foo","bar"};
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
//        int temp[] = CreateArray.getArray(20, 100);
        int temp[] = {5, 3, 2, 2};
        System.out.println(Arrays.toString(temp));
        System.out.println(solution.findSubstring(testStr,strArray));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    //普通的滑动窗口
    class Solution {
        public List<Integer> findSubstring(String s, String[] words) {
            int wLen = words[0].length();
            int n = wLen * words.length;
            int left = 0;
            int right = n - 1;
            Set<Integer> set = new HashSet<>();
            List<Integer> res = new ArrayList<>();
            while (right < s.length()) {
                set.clear();
                for (int i = 0; i < words.length; i++) {//
                    String st = s.substring(left + wLen * i, left + wLen * i + wLen);
                    int j = 0;
                    for (; j < words.length; j++) {
                        if (words[j].equals(st) && !set.contains(j)) {
                            set.add(j);
                            if (i == words.length - 1) {
                                res.add(left);
                            }
                            break;
                        }
                    }
                    if (j == words.length) {
                        break;
                    }
                }
                left++;
                right++;

            }
            return res;
        }

    }


//leetcode submit region end(Prohibit modification and deletion)

}