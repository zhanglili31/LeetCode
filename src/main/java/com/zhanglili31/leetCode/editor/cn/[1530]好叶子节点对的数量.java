package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

//1530好叶子节点对的数量
//2021-03-20 14:06:04
class NumberOfGoodLeafNodesPairs {
    public static void main(String[] args) {
        Solution solution = new NumberOfGoodLeafNodesPairs().new Solution();
        TreeNode r = CreateTree.deserialize("[1,2,3,null,4]");
        System.out.println(solution.countPairs(r, 3));
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
        int res = 0;

        //整体遍历树，计算每一个公共节点下的所有p[叶子1+叶子2]<distanch  的数量。累加到res。
        public int countPairs(TreeNode root, int distance) {
            if (root == null) return res;
            res += recure(root, distance);
            countPairs(root.left, distance);
            countPairs(root.right, distance);
            return res;
        }

        //1 计算当前节点的左子树的所有叶节点到当前节点的高度，放入数组left，
        //2 计算当前节点的右子树的所有叶节点到当前节点的高度，放入数组right，
        //3 使用笛卡尔积，将满足条件的叶子节对找出来，if(left.get(i)+right.get(j)<=distance)res++
        public int recure(TreeNode root, int distance) {
            int res = 0;
            if (root == null || root.left == null || root.right == null) return 0;
            List<Integer> left = new ArrayList<Integer>();
            List<Integer> right = new ArrayList<Integer>();
            getDistance(root.left, left, 1);
            getDistance(root.right, right, 1);
            for (int i = 0; i < left.size(); i++) {
                for (int j = 0; j < right.size(); j++) {
                    if (left.get(i) + right.get(j) <= distance) res++;
                }
            }
            return res;
        }

        //计算当前节点下的所有叶子节点到当前节点的高度，放入list
        private void getDistance(TreeNode root, List list, int h) {
            if (root == null) return;
            if (root.left == null && root.right == null) {
                list.add(h);
                return;
            }
            ++h;
            getDistance(root.left, list, h);
            getDistance(root.right, list, h);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
