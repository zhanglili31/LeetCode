package com.zhanglili31.LeetCode.editor.cn;
import com.zhanglili31.LeetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.LeetCode.editor.cn.utils.TreeNode;
//7整数反转
//2021-03-25 00:12:19
class ReverseInteger{
    public static void main(String []args){
        Solution solution=new ReverseInteger().new Solution();
        TreeNode r=CreateTree.deserialize("[5,4,2,3,3,7]");
        System.out.println(solution.reverse(1534236469));
//        int a=1000 0000 0000 0000 0000 0000 0000 0000b;
        int a=0x80000000;
        System.out.println(a);

    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int reverse(int x) {
        int res=0;
        while (x != 0) {
            res*=10;
            try {
                res = Math.multiplyExact(res, 10);
            } catch (Exception e) {
                return 0;
            }
            res+=x%10;
            x/=10;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
