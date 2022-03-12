package com.zhanglili31.leetCode.editor.cn;
import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;
//191位1的个数
//2021-03-22 22:51:49
class NumberOf1Bits{
    public static void main(String []args){
        Solution solution=new NumberOf1Bits().new Solution();
        TreeNode r=CreateTree.deserialize("[5,4,2,3,3,7]");
        System.out.println(solution.hammingWeight(7));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int t=1;
        int res=0;
        for (int i = 0; i < 32; i++) {
            if((t&n)==t){
                res++;
            }
            t=t<<1;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
