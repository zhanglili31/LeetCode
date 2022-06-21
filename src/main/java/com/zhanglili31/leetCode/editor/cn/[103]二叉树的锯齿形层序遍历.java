package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.*;

//103 二叉树的锯齿形层序遍历
//2022-06-22 01:36:19
class BinaryTreeZigzagLevelOrderTraversal {

    public static void main(String[] args) {
        Solution solution = new BinaryTreeZigzagLevelOrderTraversal().new Solution();
        TreeNode root = CreateTree.deserialize("[3,9,20,null,null,15,7]");
        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        String testStr = "hello";
        String strArray[] = {"wrt", "wrf"};
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
//        int temp[] = CreateArray.getArray(20, 100);
        int temp[] = {5, 3, 2, 2};
        System.out.println(Arrays.toString(temp));
        System.out.println(solution.zigzagLevelOrder(root));
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
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            Queue<Queue<TreeNode>> queue = new LinkedList<>();
            Queue<TreeNode> init = new LinkedList<>();
            init.add(root);
            queue.add(init);
            List<List<Integer>> ans = new ArrayList<>();
            while (!queue.isEmpty()) {
                Queue<TreeNode> temp = queue.poll();
                Queue<TreeNode> nextQueue = new LinkedList<>();
                List<Integer> list = new LinkedList<>();
                int b = 0;
                int factor = 1;
                if (ans.size() % 2 != 0) {//正
                    b = 0;
                    factor = 0;
                }
                while (!temp.isEmpty()) {
                    TreeNode cur = temp.poll();
                    if (cur == null)
                        continue;
                    list.add(b, cur.val);
                    b += factor;
                    if (cur.left != null)
                        nextQueue.add(cur.left);
                    if (cur.right != null)
                        nextQueue.add(cur.right);
                }
                if (list.size() > 0) {
                    ans.add(list);
                }
                if (!nextQueue.isEmpty()) {
                    queue.add(nextQueue);
                }
            }
            return ans;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}