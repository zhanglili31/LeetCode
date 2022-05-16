package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateArray;
import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.Arrays;

//1271 十六进制魔术数字
//2022-05-16 16:00:36
class Hexspeak {

    public static void main(String[] args) {
        Solution solution = new Hexspeak().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        int [][]a={{1,1,1},{1,0,1},{1,1,1}};
        String testStr="hello";
        String strArray[] = {"wrt","wrf"};
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
        int temp[] = CreateArray.getArray(20, 100);
        System.out.println(Arrays.toString(temp));
        System.out.println(solution.toHexspeak("4654321"));
    }
    
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String toHexspeak(String num) {
        long n = Long.valueOf(num);
        String ans = "";
        while (n > 0) {
            long temp = n & 15l;
            if (temp == 0) {
                ans="O"+ans;
            } else if (temp == 1) {
                ans="I"+ans;
            } else if (temp >= 10) {
                char ch = (char)(temp - 10L + 'A');
                ans=String.valueOf(ch)+ans;
            }else {
                return "ERROR";
            }
            n=n>>4;
        }
        return ans.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
 
}