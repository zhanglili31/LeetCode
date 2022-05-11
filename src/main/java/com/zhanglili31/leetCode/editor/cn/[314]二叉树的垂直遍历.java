package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateArray;
import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.*;

//314 二叉树的垂直遍历
//2022-05-11 10:16:26
class BinaryTreeVerticalOrderTraversal {

    public static void main(String[] args) {
        Solution solution = new BinaryTreeVerticalOrderTraversal().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        int [][]a={{1,1,1},{1,0,1},{1,1,1}};
        String testStr="hello";
        String strArray[] = {"wrt","wrf"};
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
        int temp[] = CreateArray.getArray(20, 100);
        System.out.println(Arrays.toString(temp));
        System.out.println(solution);
    }
    
        //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int min = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;
    int mid = 0;
    int init = 200;
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> verticalOrder(TreeNode root) {
        countMinAndMax(root, init);
        min = min + 1;
        max = max - 1;
        mid = init - min;
        for (int i = 0; i < max - min + 1; i++) {
            res.add(new ArrayList<>());
        }
//            recursion(root, init);
        verticalOrder2(root, mid);
        return res;


    }

    void countMinAndMax(TreeNode root, int rank) {
        if (root == null) {
            min = Math.min(min, rank);
            max = Math.max(max, rank);
            return;
        }
        countMinAndMax(root.left, rank - 1);
        countMinAndMax(root.right, rank + 1);

    }

    public void recursion(TreeNode root, int rank) {
        if (root == null) {
            return;
        }
        List<Integer> temp = null;
        temp = res.get(rank - min);
        temp.add(root.val);
        recursion(root.left, rank - 1);
        recursion(root.right, rank + 1);
    }


    //层次遍历二叉树
    public List<List<Integer>> verticalOrder2(TreeNode root, int index) {
        Map<TreeNode, Integer> rank = new HashMap<TreeNode, Integer>();
        Queue<Queue<TreeNode>> queue1 = new LinkedList<>();
        Queue<TreeNode> init = new LinkedList<>();
        init.add(root);
        queue1.add(init);
        rank.put(root, index);
        while (!queue1.isEmpty()) {
            Queue<TreeNode> temp = queue1.poll();
            Queue<TreeNode> addNode = new LinkedList<>();
            while (!temp.isEmpty()) {
                TreeNode node = temp.poll();
                if (node == null)
                    continue;
                int points = rank.get(node);
                List<Integer> vList = res.get(rank.get(node));
                vList.add(node.val);
                addNode.add(node.left);
                rank.put(node.left, points - 1);
                addNode.add(node.right);
                rank.put(node.right, points + 1);
            }
            if (addNode.size() > 0) {
                queue1.add(addNode);
            }
        }
        return res;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
 
}