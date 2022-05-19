package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;
import com.zhanglili31.leetCode.editor.cn.utils.CreateArray;
import java.util.Arrays;
//459 重复的子字符串
//2022-05-19 14:52:55
class RepeatedSubstringPattern {

    public static void main(String[] args) {
        Solution solution = new RepeatedSubstringPattern().new Solution();
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
/*

            如果您的字符串 S 包含一个重复的子字符串，那么这意味着您可以多次 “移位和换行”`您的字符串，并使其与原始字符串匹配。

            例如：abcabc

            移位一次：cabcab
            移位两次：bcabca
            移位三次：abcabc

            现在字符串和原字符串匹配了，所以可以得出结论存在重复的子串。

            基于这个思想，可以每次移动k个字符，直到匹配移动 length - 1 次。但是这样对于重复字符串很长的字符串，效率会非常低。在 LeetCode 中执行时间超时了。

            为了避免这种无用的环绕，可以创建一个新的字符串 str，它等于原来的字符串 S 再加上 S 自身，这样其实就包含了所有移动的字符串。

            比如字符串：S = acd，那么 str = S + S = acdacd

            acd 移动的可能：dac、cda。其实都包含在了 str 中了。就像一个滑动窗口

            一开始 acd (acd) ，移动一次 ac(dac)d，移动两次 a(cda)cd。循环结束

            所以可以直接判断 str 中去除首尾元素之后，是否包含自身元素。如果包含。则表明存在重复子串。

            作者：13217319563
            链接：https://leetcode.cn/problems/repeated-substring-pattern/solution/jian-dan-ming-liao-guan-yu-javaliang-xing-dai-ma-s/
            来源：力扣（LeetCode）

            总结关键点：
            1 如果s中存在重复的字串连续重复构成s，那么至少移动length-1次的过程中，存在一个子字符串能够连续重复构成s
            2 t=s+s,t中包含了s所有的移动情况，所以t中去掉头尾以后至少有一个子字符串等于s，（s满足题意的情况下）
            3 为什么要去头尾？如果没有去头尾，t中肯定是有s的，因为t=s+s,这个肯定能发现s，并且s有可能是组成t的那个s，并非是移动生成的s
*/

    public boolean repeatedSubstringPattern(String s) {
        String t = s + s;
        return t.substring(1, t.length() - 1).contains(s);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
 
}