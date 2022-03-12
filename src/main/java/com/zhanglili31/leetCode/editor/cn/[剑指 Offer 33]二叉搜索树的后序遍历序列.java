package com.zhanglili31.leetCode.editor.cn;
//剑指 Offer 33二叉搜索树的后序遍历序列
//2021-03-07 20:43:22
class ErChaSouSuoShuDeHouXuBianLiXuLieLcof{
    public static void main(String[] args){
        Solution solution=new ErChaSouSuoShuDeHouXuBianLiXuLieLcof().new Solution();
        int []nums={4, 6, 7, 5};
      System.out.println(solution.verifyPostorder(nums));
        
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean verifyPostorder(int[] postorder) {
        return recure(postorder, 0, postorder.length - 1);

    }
    public boolean recure(int[]postorder,int i,int j){
        if(i>=j)return true;
        int l=i;
        int r=j-1;
        while(l<postorder.length&&postorder[l]<postorder[j])l++;
        while(r>=0&&postorder[r]>postorder[j])r--;
        return (l-r==1)&&recure(postorder,i,l-1)&&recure(postorder,r+1,j-1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}