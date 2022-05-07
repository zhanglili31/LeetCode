package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;
import com.zhanglili31.leetCode.editor.cn.utils.CreateArray;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//346 数据流中的移动平均值
//2022-05-08 06:32:17
class MovingAverageFromDataStream {

    public static void main(String[] args) {
//        Solution solution = new MovingAverageFromDataStream().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        String testStr = "hello";
        String strArray[] = {"wrt", "wrf"};
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
        int temp[] = CreateArray.getArray(20, 100);
        System.out.println(Arrays.toString(temp));
//        System.out.println(solution);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class MovingAverage {
        LinkedList<Integer> queue = new LinkedList<Integer>();
        int size=0;
        int curLen = 0;
        double sum = 0.0;

        public MovingAverage(int size) {
            this.size=size;
        }

        public double next(int val) {
            if (curLen < size) {
                queue.add(val);
                sum += (double) val;
                curLen++;
            } else {
                int temp = queue.poll();
                sum-=(double)temp;
                sum+=(double)val;
                queue.add(val);
            }
            return sum / (double) curLen;
        }
    }

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
//leetcode submit region end(Prohibit modification and deletion)

}