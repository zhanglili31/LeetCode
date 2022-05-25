package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateArray;
import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//1056 易混淆数
//2022-05-26 00:46:01
class ConfusingNumber {

    public static void main(String[] args) {
        Solution solution = new ConfusingNumber().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        String testStr = "hello";
        String strArray[] = {"wrt", "wrf"};
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
        int temp[] = CreateArray.getArray(20, 100);
        System.out.println(Arrays.toString(temp));
        System.out.println(solution);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean confusingNumber(int n) {
            if(n==0){
                return false;
            }
            Map<Integer, Integer> map = new HashMap<Integer, Integer>();
            map.put(6, 9);
            map.put(9, 6);
            map.put(8, 8);
            map.put(0, 0);
            map.put(1, 1);
            StringBuilder str = new StringBuilder();
            int init = n;
            while (n > 0) {
                int a = n % 10;
                n /= 10;
                if (a == 2 || a == 5 || a == 7 || a == 3 || a == 4 || a == 5) {
                    return false;
                }
                str.append(map.get(a));
            }
            return init != Integer.parseInt(str.toString());
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}