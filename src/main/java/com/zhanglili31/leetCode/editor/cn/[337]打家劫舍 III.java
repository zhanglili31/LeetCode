package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.HashMap;
import java.util.Map;

//337 打家劫舍 III
//2022-04-24 07:11:16
class HouseRobberIii {

    public static void main(String[] args) {
        Solution solution = new HouseRobberIii().new Solution();
        TreeNode root = CreateTree.deserialize("[1,1,1,1,1,0,0,0,1,null,0,1,1,null,1,null,null,null,null,null,null,null,null,null,null,null,null]");
        int [][]a={{1,1,1},{1,0,1},{1,1,1}};
        String testStr="hello";
        int temp[] = {-1,0,1,2,-1,-4};
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
    Map<TreeNode,Integer> robed=new HashMap<TreeNode,Integer>();
    Map<TreeNode,Integer> notRobed=new HashMap<TreeNode,Integer>();
    int maxValue = Integer.MIN_VALUE;
    {
        robed.put(null, 0);
        notRobed.put(null, 0);
    }
    public int rob(TreeNode root) {
        if(root==null)return 0;
        rob(root.left);
        rob(root.right);
        Integer leftRobed = robed.get(root.left);
        Integer rightRobed = robed.get(root.right);
        Integer leftNotRobed = notRobed.get(root.left);
        Integer rightNotRobed = notRobed.get(root.right);
        Integer robedValue = root.val + leftNotRobed + rightNotRobed;
        robed.put(root, robedValue);
        Integer notRobedValue = Math.max(leftRobed, leftNotRobed) + Math.max(rightRobed, rightNotRobed);
        notRobed.put(root, notRobedValue);
        maxValue = Math.max(Math.max(robedValue, notRobedValue), maxValue);
        return maxValue;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
 
}