package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;
import com.zhanglili31.leetCode.editor.cn.utils.CreateArray;
import java.util.Arrays;
//471 编码最短长度的字符串
//2022-05-18 13:04:04
class EncodeStringWithShortestLength {

    public static void main(String[] args) {
        Solution solution = new EncodeStringWithShortestLength().new Solution();
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
        //推荐使用回溯，暴力搜索。所有的连续相同字串。
        //参考方案：https://leetcode.cn/problems/encode-string-with-shortest-length/solution/liang-chong-jie-fa-by-jason-2-65/
    public String encode(String s) {
        return null;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
 
}