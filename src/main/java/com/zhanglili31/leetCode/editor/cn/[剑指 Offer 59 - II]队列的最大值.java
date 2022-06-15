package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

//剑指 Offer 59 - II 队列的最大值
//2022-06-15 23:21:23
class DuiLieDeZuiDaZhiLcof {

    public static void main(String[] args) {
//        Solution solution = new DuiLieDeZuiDaZhiLcof().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        String testStr = "hello";
        String strArray[] = {"wrt", "wrf"};
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
//        int temp[] = CreateArray.getArray(20, 100);
        int temp[] = {5, 3, 2, 2};
        System.out.println(Arrays.toString(temp));
        MaxQueue q = new MaxQueue();
        q.push_back(868);
        q.push_back(525);
        int a1 = q.max_value();
        System.out.println();
        int a2 = q.pop_front();
        System.out.println();
//        System.out.println(solution);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    //当一个元素进入队列的时候，它前面所有比它小的元素就不会再对答案产生影响。
    //https://leetcode.cn/problems/dui-lie-de-zui-da-zhi-lcof/solution/mian-shi-ti-59-ii-dui-lie-de-zui-da-zhi-by-leetcod/
    //从队列尾部插入元素时，我们可以提前取出队列中所有比这个元素小的元素，使得队列中只保留对结果有影响的数字。这样的方法等价于要求维持队列单调递减，
    static class MaxQueue {
        Queue<Integer> q = new LinkedList<Integer>();
        Deque<Integer> deque = new LinkedList<Integer>();

        public MaxQueue() {

        }

        public int max_value() {
            if (deque.size() == 0) {
                return -1;
            }
            return deque.peekFirst();

        }

        public void push_back(int value) {
            q.add(value);
            while (!deque.isEmpty() && deque.peekLast() < value) {
                deque.pollLast();
            }
            deque.addLast(value);


        }

        public int pop_front() {
            if (q.isEmpty()) {
                return -1;
            }
            if (Integer.compare(q.peek(),deque.peekFirst())==0) {
                deque.pollFirst();
            }
            return q.poll();

        }
    }

/**
 * Your MaxQueue object will be instantiated and called as such:
 * MaxQueue obj = new MaxQueue();
 * int param_1 = obj.max_value();
 * obj.push_back(value);
 * int param_3 = obj.pop_front();
 */
//leetcode submit region end(Prohibit modification and deletion)

}