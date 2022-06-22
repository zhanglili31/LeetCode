package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//412 Fizz Buzz
//2022-06-22 23:32:13
class FizzBuzz {

    public static void main(String[] args) {
        Solution solution = new FizzBuzz().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        String testStr = "hello";
        String strArray[] = {"wrt", "wrf"};
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
//        int temp[] = CreateArray.getArray(20, 100);
        int temp[] = {5, 3, 2, 2};
        System.out.println(Arrays.toString(temp));
        System.out.println(solution);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> fizzBuzz(int n) {
            List<String> ans = new ArrayList<>();
            for (int i = 1; i <= n; i++) {
                if (i % 15 == 0) {
                    ans.add("FizzBuzz");
                } else if (i % 3 == 0) {
                    ans.add("Fizz");
                } else if (i % 5 == 0) {
                    ans.add("Buzz");
                } else {
                    ans.add("" + i);
                }
            }
            return ans;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}