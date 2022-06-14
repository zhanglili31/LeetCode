package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.Arrays;

//1183 矩阵中 1 的最大数量
//2022-06-14 16:13:52
class MaximumNumberOfOnes {

    public static void main(String[] args) {
        Solution solution = new MaximumNumberOfOnes().new Solution();
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
        //https://haokan.baidu.com/v?pd=wisenatural&vid=3471247213900204772
        public int maximumNumberOfOnes(int width, int height, int sideLength, int maxOnes) {
            int arr[] = new int[sideLength * sideLength];
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    int x = i % sideLength;
                    int y = j % sideLength;
                    arr[x * sideLength + y]++;
                }
            }
            Arrays.sort(arr);
            int ans = 0;
            for (int i = 0; i < maxOnes; i++) {
                ans += arr[arr.length - 1 - i];
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}