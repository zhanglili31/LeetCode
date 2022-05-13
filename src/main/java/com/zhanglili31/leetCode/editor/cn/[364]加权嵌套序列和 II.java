package com.zhanglili31.leetCode.editor.cn;

//364 加权嵌套序列和 II
//2022-05-13 15:47:13
class NestedListWeightSumIi {

    public static void main(String[] args) {
//        Solution solution = new NestedListWeightSumIi().new Solution();
//        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
//        int [][]a={{1,1,1},{1,0,1},{1,1,1}};
//        String testStr="hello";
//        String strArray[] = {"wrt","wrf"};
//        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
//        int temp[] = CreateArray.getArray(20, 100);
//        System.out.println(Arrays.toString(temp));
//        System.out.println(solution);
    }

    
        //leetcode submit region begin(Prohibit modification and deletion)
/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
//class Solution {
//    int sum=0;
//    int sumNumDepth=0;
//    int maxDepth=0;
//    public int depthSumInverse(List<NestedInteger> nestedList) {
//        depthSumInverse(nestedList,1);
//        int ans=sum*(maxDepth+1)-sumNumDepth;
//        return ans;
//    }
//
//    public void depthSumInverse(List<NestedInteger> nestedList,int depth) {
//        maxDepth = Math.max(maxDepth, depth);
//        for(NestedInteger n:nestedList){
//            if(n.isInteger()){
//                sum+=n.getInteger();
//                sumNumDepth+=n.getInteger()*depth;
//            }else{
//                depthSumInverse(n.getList(), depth + 1);
//            }
//        }
//
//    }
//}
//leetcode submit region end(Prohibit modification and deletion)
 
}