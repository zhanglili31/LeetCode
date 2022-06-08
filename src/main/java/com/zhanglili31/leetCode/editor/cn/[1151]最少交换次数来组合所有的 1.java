package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.Arrays;
//1151 最少交换次数来组合所有的 1
//2022-06-08 09:14:12
class MinimumSwapsToGroupAll1sTogether {

    public static void main(String[] args) {
        Solution solution = new MinimumSwapsToGroupAll1sTogether().new Solution();
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
    public int minSwaps(int[] data) {
        //第一步：统计1的个数k
        int k=0;
        for (int i = 0; i < data.length; i++) {
            if (data[i] == 1) {
                k++;
            }
        }
        //第二部：初始化窗口
        int w=0;
        for (int i = 0; i < k; i++) {
            if (data[i] == 1) {
                w++;
            }
        }
        //滑动窗口，寻找窗口内1的数量最多的情况
        int max=w;
        int left=0;
        int right=k;
        while (right < data.length) {
            if (data[left++] == 1) {
                w--;
            }
            if (data[right++] == 1) {
                w++;
            }
            max = Math.max(max, w);
        }
        return k-max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
 
}