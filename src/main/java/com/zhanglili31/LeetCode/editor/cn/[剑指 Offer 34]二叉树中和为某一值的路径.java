package com.zhanglili31.LeetCode.editor.cn;

import com.zhanglili31.LeetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.LeetCode.editor.cn.utils.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//剑指 Offer 34二叉树中和为某一值的路径
//2021-03-07 16:58:10
class ErChaShuZhongHeWeiMouYiZhiDeLuJingLcof {
    public static void main(String[] args) {
        Solution solution = new ErChaShuZhongHeWeiMouYiZhiDeLuJingLcof().new Solution();
        TreeNode root = CreateTree.deserialize("[-2,null,-3]");
        System.out.println(solution.pathSum(root,-5));

    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        public List<List<Integer>> pathSum(TreeNode root, int sum) {
            List<List<Integer>> res = new ArrayList<>();
            preorder(root, sum, res);
            return res;
        }

        private void preorder(TreeNode node, int sum, List res) {
            if (node == null) return;
            List<Integer> list = new ArrayList<>();
            DFS(node, list, res, sum);
//            preorder(node.left, sum, res);
//            preorder(node.right, sum, res);
        }

        private void DFS(TreeNode cur, List list, List res, int lack) {
            if (cur == null) {
                return;
            }
            lack = lack - cur.val;
             if (lack == 0&&cur.left==null&&cur.right==null) {
                list.add(cur.val);
                List temp = new ArrayList<Integer>();
                for(int i=0;i<list.size();i++){
                    temp.add(list.get(i));
                }
                res.add(temp);
                list.remove(list.size() - 1);
                lack += cur.val;
                return;
            }else  {
                 list.add(cur.val);
                 DFS(cur.left, list, res, lack);
                 DFS(cur.right, list, res, lack);
                 list.remove(list.size() - 1);
             }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}