package com.zhanglili31.LeetCode.editor.cn;

import com.zhanglili31.LeetCode.editor.cn.utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//剑指 Offer 32 - II从上到下打印二叉树 II
//2021-03-07 20:06:14
class CongShangDaoXiaDaYinErChaShuIiLcof{
    public static void main(String[] args){
        Solution solution=new CongShangDaoXiaDaYinErChaShuIiLcof().new Solution();
      //System.out.println(solution);
        
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<Queue<TreeNode>> queue = new LinkedList<>();
        Queue<TreeNode> first = new LinkedList<>();
        Queue<TreeNode> temp = null;
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        first.add(root);
        queue.add(first);
        while (!queue.isEmpty()) {
            temp = queue.poll();
            List<Integer> list = new ArrayList<>();
            Queue<TreeNode> tempQ = new LinkedList<>();
            while (!temp.isEmpty()) {
                TreeNode node = temp.poll();
                if (node != null) {
                    list.add(node.val);
                    tempQ.add(node.left);
                    tempQ.add(node.right);
                }
            }
            if (list.size() > 0) res.add(list);
            if (tempQ.size() > 0) queue.add(tempQ);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}