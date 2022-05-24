package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateArray;
import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.*;

//742 二叉树最近的叶节点
//2022-05-25 00:16:27
class ClosestLeafInABinaryTree {

    public static void main(String[] args) {
        Solution solution = new ClosestLeafInABinaryTree().new Solution();
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
        public int findClosestLeaf(TreeNode root, int k) {
            Queue<Integer> queue = new LinkedList<Integer>();
            Map<Integer, List<Integer>> map = new HashMap<>();
            HashSet<Integer> leaves = new HashSet<>();
            createMap(root, map, leaves);
            Set<Integer> tag = new HashSet<>();
            queue.add(k);
            while (!queue.isEmpty()) {
                Integer node = queue.poll();
                if (tag.contains(node)) {
                    continue;
                }
                tag.add(node);
                if (leaves.contains(node)) {
                    return node;
                }
                List<Integer> temp = map.get(node);
                queue.addAll(temp);
            }
            return -1;


        }

        public void createMap(TreeNode root, Map<Integer, List<Integer>> map, Set<Integer> leaves) {
            if (root == null) {
                return;
            }
            List<Integer> list = null;
            list = map.getOrDefault(root.val, new ArrayList<>());
            map.put(root.val, list);
            if (root.left == null && root.right == null) {
                leaves.add(root.val);
            }
            if (root.left != null) {
                list = map.getOrDefault(root.val, new ArrayList<>());
                list.add(root.left.val);
                map.put(root.val, list);

                list = map.getOrDefault(root.left.val, new ArrayList<>());
                list.add(root.val);
                map.put(root.left.val, list);
                createMap(root.left, map,leaves);
            }
            if (root.right != null) {
                list = map.getOrDefault(root.val, new ArrayList<>());
                list.add(root.right.val);
                map.put(root.val, list);

                list = map.getOrDefault(root.right.val, new ArrayList<>());
                list.add(root.val);
                map.put(root.right.val, list);
                createMap(root.right, map,leaves);
            }

        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}