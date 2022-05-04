package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;
import com.zhanglili31.leetCode.editor.cn.utils.CreateArray;
import java.util.Arrays;
//186 翻转字符串里的单词 II
//2022-05-05 00:27:11
class ReverseWordsInAStringIi {

    public static void main(String[] args) {
        Solution solution = new ReverseWordsInAStringIi().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        int [][]a={{1,1,1},{1,0,1},{1,1,1}};
        String testStr="hello";
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
        int temp[] = CreateArray.getArray(20, 100);
        System.out.println(Arrays.toString(temp));
        solution.reverseWords(charArray);
        System.out.println();
    }
    
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void reverseWords(char[] s) {
        System.out.println(Arrays.toString(s));
        int left=0;
        int right = s.length - 1;
        char ch;
        while (left < right) {
            ch = s[left];
            s[left] = s[right];
            s[right] = ch;
            left++;
            right--;
        }
        left=0;
        right=0;
        int i, j;
        while (right < s.length) {
            while (right<s.length&&s[right] != ' ') {
                right++;
            }
            i=left;
            j=right-1;
            while (i < j) {
                ch = s[i];
                s[i] = s[j];
                s[j] = ch;
                i++;
                j--;
            }
            right++;
            left = right;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
 
}