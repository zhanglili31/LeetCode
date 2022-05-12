package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;
import com.zhanglili31.leetCode.editor.cn.utils.CreateArray;
import java.util.Arrays;
//面试题 01.02 判定是否互为字符重排
//2022-05-12 13:51:11
class CheckPermutationLcci {

    public static void main(String[] args) {
        Solution solution = new CheckPermutationLcci().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        int [][]a={{1,1,1},{1,0,1},{1,1,1}};
        String testStr="hello";
        String strArray[] = {"wrt","wrf"};
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
        int temp[] = CreateArray.getArray(20, 100);
        System.out.println(Arrays.toString(temp));
        System.out.println(solution);
    }
    
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean CheckPermutation(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        int table[] = new int[26];
        for(int i=0;i<s1.length();i++) {
            char ch = s1.charAt(i);
            table[ch-'a']++;
        }
        for (int i = 0; i < s2.length(); i++) {
            char ch=s2.charAt(i);
            table[ch-'a']--;
            if (table[ch - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
 
}