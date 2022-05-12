package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;
import com.zhanglili31.leetCode.editor.cn.utils.CreateArray;
import java.util.Arrays;
//面试题 01.01 判定字符是否唯一
//2022-05-12 13:41:52
class IsUniqueLcci {

    public static void main(String[] args) {
        Solution solution = new IsUniqueLcci().new Solution();
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
    public boolean isUnique(String astr) {
        int flag=0;
        for (int i = 0; i < astr.length(); i++) {
            char ch = astr.charAt(i);
            int val = 1 << (ch - 'a');
            if ((flag & val) != 0) {
                return false;
            }else{
                flag=flag|val;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
 
}