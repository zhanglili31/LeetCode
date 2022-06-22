package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.Arrays;

//341 扁平化嵌套列表迭代器
//2022-06-23 06:40:37
class FlattenNestedListIterator {

    public static void main(String[] args) {
//        Solution solution = new FlattenNestedListIterator().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        String testStr = "hello";
        String strArray[] = {"wrt", "wrf"};
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
//        int temp[] = CreateArray.getArray(20, 100);
        int temp[] = {5, 3, 2, 2};
        System.out.println(Arrays.toString(temp));
//        System.out.println(solution);
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * // This is the interface that allows for creating nested lists.
     * // You should not implement it, or speculate about its implementation
     * public interface NestedInteger {
     * <p>
     * // @return true if this NestedInteger holds a single integer, rather than a nested list.
     * public boolean isInteger();
     * <p>
     * // @return the single integer that this NestedInteger holds, if it holds a single integer
     * // Return null if this NestedInteger holds a nested list
     * public Integer getInteger();
     * <p>
     * // @return the nested list that this NestedInteger holds, if it holds a nested list
     * // Return empty list if this NestedInteger holds a single integer
     * public List<NestedInteger> getList();
     * }
     */
    //todo 栈的解法再做一遍
    //方法一：递归
//    public class NestedIterator implements Iterator<Integer> {
//        Deque<Integer> queue = new LinkedList<Integer>();
//
//        public NestedIterator(List<NestedInteger> nestedList) {
//            for (int i = 0; i < nestedList.size(); i++) {
//                recursion(nestedList.get(i), queue);
//            }
//
//        }
//        private void recursion(NestedInteger n,Queue<Integer> queue){
//            if (n.isInteger()) {
//                queue.add(n.getInteger());
//            }else{
//                List<NestedInteger> list = n.getList();
//                for (int i = 0; i < list.size(); i++) {
//                    recursion(list.get(i), queue);
//                }
//            }
//        }
//
//        @Override
//        public Integer next() {
//            return queue.poll();
//
//        }
//
//        @Override
//        public boolean hasNext() {
//            return !queue.isEmpty();
//        }
//    }

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
//leetcode submit region end(Prohibit modification and deletion)

}