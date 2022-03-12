package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

//96 不同的二叉搜索树
//2022-03-12 22:25:18
class UniqueBinarySearchTrees {

    public static void main(String[] args) {
        Solution solution = new UniqueBinarySearchTrees().new Solution();
        TreeNode root = CreateTree.deserialize("[1,1,1,1,1,0,0,0,1,null,0,1,1,null,1,null,null,null,null,null,null,null,null,null,null,null,null]");
        int [][]a={{1,1,1},{1,0,1},{1,1,1}};
        String testStr="hello";
        int temp[] = {-1,0,1,2,-1,-4};
        System.out.println(solution);
    }

        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        /*
        * 方法二：卡塔兰数
        * */
    public int numTrees(int n) {
        if (n == 1) {
            return 1;
        }
        long res=1;
        for (int i = 2; i <= n; i++) {
            int k=i-1;
            res =res* 2 * (2 * k + 1) / (k + 2);
        }
        return (int)res;
    }

    //todo：深刻理解方法一：动态规划
}
//leetcode submit region end(Prohibit modification and deletion)

}