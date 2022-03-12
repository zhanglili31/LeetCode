package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

//剑指 Offer 68 - I二叉搜索树的最近公共祖先
//2021-03-07 16:07:58
class ErChaSouSuoShuDeZuiJinGongGongZuXianLcof {
    public static void main(String[] args) {
        Solution solution = new ErChaSouSuoShuDeZuiJinGongGongZuXianLcof().new Solution();
        String tree = "[6,2,8,0,4,7,9,null,null,3,5]";
        TreeNode root = CreateTree.deserialize(tree);
        TreeNode p = new TreeNode(2);
        TreeNode q = new TreeNode(8);
        System.out.println(solution.lowestCommonAncestor(root, p, q));

    }
    //leetcode submit region begin(Prohibit modification and deletion)

//Definition for a binary tree node.


    class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null || root.val == p.val || root.val == q.val) return root;
            TreeNode L = p.val > root.val && q.val > root.val ? null : lowestCommonAncestor(root.left, p, q);
            TreeNode R = p.val < root.val && q.val < root.val ? null : lowestCommonAncestor(root.right, p, q);
            if ((L!=null&R!=null)&&(L.val == p.val || L.val == q.val) && (R.val == p.val || R.val == q.val)) return root;
            return L == null ? R : L;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}