package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.Arrays;
//660 移除 9
//2022-06-01 07:10:22
class Remove9 {

    public static void main(String[] args) {
        Solution solution = new Remove9().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        int [][]a={{1,1,1},{1,0,1},{1,1,1}};
        String testStr="hello";
        String strArray[] = {"wrt","wrf"};
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
//        int temp[] = CreateArray.getArray(20, 100);
        int temp[] = {5, 3, 2, 2};
        System.out.println(Arrays.toString(temp));
        System.out.println(solution);
    }
    
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int newInteger(int n) {
        int k=9;
        StringBuilder str = new StringBuilder();
        while (n >= k) {
            str.append(n % k);
            n=n/k;
        }
        str.append(n);
        return Integer.parseInt(str.reverse().toString());
    }
}
//leetcode submit region end(Prohibit modification and deletion)
 
}