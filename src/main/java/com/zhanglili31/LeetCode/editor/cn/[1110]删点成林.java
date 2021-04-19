package com.zhanglili31.LeetCode.editor.cn;
import com.zhanglili31.LeetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.LeetCode.editor.cn.utils.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//1110删点成林
//2021-03-21 23:35:31
class DeleteNodesAndReturnForest{
    public static void main(String []args){
        Solution solution=new DeleteNodesAndReturnForest().new Solution();
        TreeNode r=CreateTree.deserialize("[5,4,2,3,3,7]");
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
    List<TreeNode> list = new ArrayList<>();
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        Map<Integer,Boolean> map=new HashMap<>();
        for(int i=0;i<to_delete.length;i++){
            map.put(to_delete[i], true);
        }
        if(map.get(root.val)==null){
            list.add(root);
        }
        recure(root, map);
        return list;

    }

    private TreeNode  recure(TreeNode root, Map map) {
        if(root==null)return null;
        root.left=recure(root.left, map);
        root.right=recure(root.right, map);
        if(map.get(root.val)!=null){
            if(root.left!=null)list.add(root.left);
            if(root.right!=null) list.add(root.right);
            root=null;
        }
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
