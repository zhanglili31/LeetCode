package com.zhanglili31.leetCode.editor.cn;
import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;
//11盛最多水的容器
//2021-04-14 00:59:03
class ContainerWithMostWater{
    public static void main(String []args){
        Solution solution=new ContainerWithMostWater().new Solution();
        TreeNode r=CreateTree.deserialize("[5,4,2,3,3,7]");
        System.out.println(solution);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxArea(int[] height) {
        int i=0,j=height.length-1;
        int res=0;
        while (i < j) {
            int temp=Math.min(height[i],height[j])*(j-i);
            if(res<temp){
                res=temp;
            }
            if(height[i]<height[j]){
                i++;
            }else{
                j--;
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
