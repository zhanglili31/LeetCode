package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;
import com.zhanglili31.leetCode.editor.cn.utils.CreateArray;

import java.util.Arrays;

//333 最大 BST 子树
//2022-05-11 12:32:18
class LargestBstSubtree {

    public static void main(String[] args) {
        Solution solution = new LargestBstSubtree().new Solution();
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
    class Solution {
        int INFO = Integer.MAX_VALUE;
        int ans = 0;


        public int largestBSTSubtree(TreeNode root) {
            recursion(root);
            return ans;

        }

        int[] recursion(TreeNode root) {
            int res[] = new int[4];// 0:INOF null节点  1：BST节点数量： 2：0BST数的最大值
            if (root == null) {
                res[0] = INFO;
                return res;
            }
            int[] left = recursion(root.left);
            int[] right = recursion(root.right);
            if (left[0] == INFO && right[0] == INFO) {
                res[1] = 1;
                res[2] = root.val;
                res[3] = root.val;
            } else if (left[0] != INFO && right[0] != INFO) {
                if (left[1] <= 0 || right[1] <= 0 || left[2] >= root.val || right[3] <= root.val) {
                    res[1] = 0;
                } else {
                    res[1] = left[1] + right[1] + 1;
                    res[2] = right[2];
                    res[3] = left[3];
                }
            } else if (left[0] != INFO) {
                if (left[1] > 0 && left[2] < root.val) {
                    res[1] = 1 + left[1];
                    res[2] = root.val;
                    res[3] = left[3];
                }
            } else if (right[0] != INFO) {
                if (right[1] > 0 && right[3] > root.val) {
                    res[1] = 1 + right[1];
                    res[2] = right[2];
                    res[3] = root.val;
                }
            }
            ans = Math.max(ans, res[1]);
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}