package com.zhanglili31.LeetCode.editor.cn;

<<<<<<< HEAD
import com.zhanglili31.LeetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.LeetCode.editor.cn.utils.TreeNode;

//617合并二叉树
//2021-03-15 23:39:58
class MergeTwoBinaryTrees {
    public static void main(String[] args) {
        Solution solution = new MergeTwoBinaryTrees().new Solution();
        TreeNode r = CreateTree.deserialize("[1,3,2,5]");
        TreeNode r2 = CreateTree.deserialize("[2,1,3,null,4,null,7]");
        System.out.println(solution.mergeTrees(r,r2));
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
        public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
            if (root1 == null && root2 == null) return null;
            if (root1 == null) return root2;
            if (root2 == null) return root1;
            root1.val += root2.val;
            if (root1.left == null && root2.left == null) {

            } else if (root1.left == null || root2.left == null) {
                root1.left=root1.left==null?root2.left:root1.left;
            } else {
                mergeTrees(root1.left, root2.left);
            }
            if (root2.right == null && root2.right == null) {

            } else if (root1.right == null || root2.right == null) {
                root1.right = root1.right==null?root2.right:root2.right;
            } else {
                mergeTrees(root1.right, root2.right);
            }
            return root1;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
=======
import com.zhanglili31.LeetCode.editor.cn.utils.TreeNode;

//617合并二叉树
//2021-03-09 23:57:14
class MergeTwoBinaryTrees{
    public static void main(String[] args){
        Solution solution=new MergeTwoBinaryTrees().new Solution();
      //System.out.println(solution);
        
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
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if(root1==null&&root2==null) return null;
        if(root1==null){
            root1=root2;
            return root1;
        }
        if(root2==null)return root1;
        root1.val+=root2.val;
        if(root1.left==null){
            root1.left=root2.left;
        }
        else mergeTrees(root1.left, root2.left);
        if(root1.right==null){
            root1.right=root2.right;
        }
        else mergeTrees(root2.right, root2.right);
        return root1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
>>>>>>> af9b1a1a7313476048906f5ddd3d73f78b99b581
