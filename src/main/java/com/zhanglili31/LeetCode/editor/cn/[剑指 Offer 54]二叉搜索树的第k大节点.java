package com.zhanglili31.LeetCode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//剑指 Offer 54二叉搜索树的第k大节点
//2021-03-07 07:00:55
class ErChaSouSuoShuDeDiKdaJieDianLcof{
    public static void main(String[] args){
        Solution solution=new ErChaSouSuoShuDeDiKdaJieDianLcof().new Solution();
      //System.out.println(solution);
        
    }
    //leetcode submit region begin(Prohibit modification and deletion)

//Definition for a binary tree node.
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    public int kthLargest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        recure(root, list);
        return list.get(list.size() - k);
    }

    public void recure(TreeNode cur, List L) {
        if(cur==null)return;
        recure(cur.left, L);
        L.add(cur.val);
        recure(cur.right, L);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}