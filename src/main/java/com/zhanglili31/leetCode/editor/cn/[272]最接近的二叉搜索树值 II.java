package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;
import com.zhanglili31.leetCode.editor.cn.utils.CreateArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//272 最接近的二叉搜索树值 II
//2022-05-08 05:30:55
class ClosestBinarySearchTreeValueIi {

    public static void main(String[] args) {
        Solution solution = new ClosestBinarySearchTreeValueIi().new Solution();
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

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    // todo 这个题目，解法比较多，有时间再好好看看其他的解法
    class Solution {
        List<Integer> array = new ArrayList<>();

        public List<Integer> closestKValues(TreeNode root, double target, int k) {
            init(root);
            List<Integer> res = new ArrayList();
            if (target <= (double) (array.get(0))) {
                for (int i = 0; i < k; i++) {
                    res.add(array.get(i));
                }
                return res;
            }
            if (target >= (double) (array.get(array.size() - 1))) {
                for (int i = 0; i < k; i++) {
                    res.add(array.get(array.size() - 1 - i));
                }
                return res;
            }
            int left = 0;
            int right = 0;
            for (int i = 0; i < array.size() - 1; i++) {
                if ((double) (array.get(i)) <= target && (double) (array.get(i + 1)) >= target) {
                    left = i;
                    right = i + 1;
                }
            }
            while (k > 0) {
                double d1 = Double.MAX_VALUE;
                double d2 = Double.MAX_VALUE;
                if (left >= 0) {
                    d1 = Math.abs((double) array.get(left) - target);
                }
                if (right < array.size()) {
                    d2 = Math.abs((double) array.get(right) - target);
                }
                if (d1 < d2) {
                    res.add(array.get(left));
                    left--;
                } else {
                    res.add(array.get(right));
                    right++;
                }
                k--;
            }
            return res;


        }

        public void init(TreeNode root) {
            if (root == null) {
                return;
            }
            init(root.left);
            array.add(root.val);
            init(root.right);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}