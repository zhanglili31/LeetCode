package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.Arrays;

//755 倒水
//2022-05-25 18:40:20
class PourWater {

    public static void main(String[] args) {
        Solution solution = new PourWater().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        String testStr = "hello";
        String strArray[] = {"wrt", "wrf"};
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
        int temp[] = {1,2,3,4,3,2,1,2,3,4,3,2,1};
        System.out.println(Arrays.toString(temp));
        System.out.println(solution.pourWater(temp,10,2));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] pourWater(int[] heights, int volume, int k) {
            int[] box = new int[heights.length];
            for (int i = 0; i < heights.length; i++) {
                box[i] = heights[i];
            }
            int left=k-1;
            int right=k+1;
            for (int i = 0; i < volume; i++) {
                if (left(box, k)) {
                    continue;
                } else if (right(box, k)) {
                    continue;
                }else{
                    box[k]++;
                }
            }
            return box;
        }

        public boolean left(int[] box, int key) {
            int left=key-1;
            while (left >= 0 && box[left] == box[key]) {
                left--;
            }
            if (left >= 0 && box[left] < box[key]) {
                if(left(box,left)){
                    return true;
                }else{
                    box[left]++;
                    return true;
                }
            }else{
                return false;
            }
        }
        public boolean right(int[] box, int key) {
            int right=key+1;
            while (right <box.length && box[right] == box[key]) {
                right++;
            }
            if (right <box.length && box[right] < box[key]) {
                if(right(box,right)){
                    return true;
                }else{
                    box[right]++;
                    return true;
                }
            }else{
                return false;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}