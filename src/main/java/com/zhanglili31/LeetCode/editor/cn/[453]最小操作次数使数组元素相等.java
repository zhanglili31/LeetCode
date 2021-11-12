package com.zhanglili31.LeetCode.editor.cn;
import com.zhanglili31.LeetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.LeetCode.editor.cn.utils.TreeNode;
//453最小操作次数使数组元素相等
//2021-10-22 00:13:41
class MinimumMovesToEqualArrayElements{
    public static void main(String []args){
        Solution solution=new MinimumMovesToEqualArrayElements().new Solution();
        TreeNode r=CreateTree.deserialize("[5,4,2,3,3,7]");
        int []temp={1,2,3,99};
        System.out.println(solution.minMoves(temp));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minMoves(int[] nums) {
        int min=Integer.MAX_VALUE;
        int sum=0;
        for (int num : nums) {
            if (min > num) {
                min=num;
            }
            sum += num;

        }
        int res=sum-min*nums.length;
        System.out.println(res);
        return (int)res;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
