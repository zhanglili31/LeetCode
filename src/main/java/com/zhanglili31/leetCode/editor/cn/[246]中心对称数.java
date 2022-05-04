package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;
import com.zhanglili31.leetCode.editor.cn.utils.CreateArray;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//246 中心对称数
//2022-05-04 08:35:43
class StrobogrammaticNumber {

    public static void main(String[] args) {
        Solution solution = new StrobogrammaticNumber().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        int [][]a={{1,1,1},{1,0,1},{1,1,1}};
        String testStr="hello";
        int temp[] = CreateArray.getArray(20, 100);
        System.out.println(Arrays.toString(temp));
        System.out.println(solution.isStrobogrammatic("524"));
    }
    
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isStrobogrammatic(String num) {
        Map<Character, Character> map = new HashMap<>();
        map.put('9', '6');
        map.put('6', '9');
        map.put('8', '8');
        map.put('1', '1');
        map.put('0', '0');
        boolean res=true;
        int i = 0, j = num.length() - 1;
        while (i <= j) {
            char ch = num.charAt(i);
            if (ch == map.getOrDefault(num.charAt(j),'a')) {
                i++;
                j--;
            }else{
                return false;
            }
        }
        return true;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
 
}