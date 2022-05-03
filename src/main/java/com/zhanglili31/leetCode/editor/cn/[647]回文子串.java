package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;
import com.zhanglili31.leetCode.editor.cn.utils.CreateArray;
import java.util.Arrays;
//647 回文子串
//2022-05-03 23:59:20
class PalindromicSubstrings {

    public static void main(String[] args) {
        Solution solution = new PalindromicSubstrings().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        int [][]a={{1,1,1},{1,0,1},{1,1,1}};
        String testStr="hello";
        int temp[] = CreateArray.getArray(20, 100);
        System.out.println(Arrays.toString(temp));
        System.out.println(solution);
    }
    
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        //暴力方法
    public int countSubstrings(String s) {
        int count=0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String subStr = s.substring(i, j);
                //判断是否为会文字符
                int l = 0, r = subStr.length() - 1;
                while (l <= r) {
                    if (subStr.charAt(l) != subStr.charAt(r)) {
                        break;
                    }
                    l++;
                    r--;
                }
                if(l>r)
                    count++;
            }
        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
 
}