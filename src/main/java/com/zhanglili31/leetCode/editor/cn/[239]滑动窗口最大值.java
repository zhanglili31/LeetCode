package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

//239 滑动窗口最大值
//2022-04-24 06:23:38
class SlidingWindowMaximum {

    public static void main(String[] args) {
        Solution solution = new SlidingWindowMaximum().new Solution();
        TreeNode root = CreateTree.deserialize("[1,1,1,1,1,0,0,0,1,null,0,1,1,null,1,null,null,null,null,null,null,null,null,null,null,null,null]");
        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        String testStr = "hello";
        int temp[] = {9,10,9,-7,-4,-8,2,-6};
        System.out.println(solution.maxSlidingWindow(temp,4));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //方法一 暴力方法,这种方式会导致超时
        //方法二 对每次一窗口滑动后的结果使用一次冒泡排序，因为冒泡排序，每一次遍历，会把最大值放后面,其实这个和暴力的方法是一样的。这种方式的本质和方法一一样，同样将窗口内的所有值比较了一遍，求max
        public int[] maxSlidingWindow1(int[] nums, int k) {
            int[] res = new int[nums.length - k + 1];
            for (int begin = 0, end = k - 1; end < nums.length; begin++, end++) {
                res[begin] = getMaxValue(nums, begin, end);
            }
            return res;

        }

        public int getMaxValue(int[] nums, int begin, int end) {
            int i = begin;
            int maxValue = Integer.MIN_VALUE;
            while (0 <= i && i <= end) {
                if (maxValue < nums[i])
                    maxValue = nums[i];
                i++;
            }
            return maxValue;
        }

        //方法三，使用优先队列。优先队列头中的就是最大值
        public int[] maxSlidingWindow3(int[] nums, int k) {
            System.out.println(nums.length);
            List<int[]> list = new ArrayList<>();

            PriorityQueue<int[]> priorityQueue = new PriorityQueue(10000, new myComparator());
            int[] res = new int[nums.length - k + 1];
            for (int i = 0; i < k; i++) {
                int[] array = new int[]{nums[i], i};
                priorityQueue.add(array);
                list.add(array);
            }
            res[0] = priorityQueue.peek()[0];
            int begin = 0, end = k;
            for (; end < nums.length; begin++, end++) {
                priorityQueue.remove(list.get(begin));
                int[] array = new int[]{nums[end], end};
                priorityQueue.add(array);
                list.add(array);
                res[begin + 1] = priorityQueue.peek()[0];

            }
            return res;
        }

        class myComparator implements Comparator<int[]> {
            @Override
            public int compare(int[]o1, int[] o2) {
                return o2[0] - o1[0];
            }
        }
        //方法四，使用单调队列
        public int[] maxSlidingWindow(int[] nums, int k) {
            List<Integer> list = new ArrayList<>();
            int[] res = new int[nums.length - k + 1];
            for (int i = 0; i < k; i++) {
                put(list, nums, i);
            }
            res[0] = nums[list.get(0)];
            int begin = 0, end = k;
            for (; end < nums.length; begin++, end++) {
                list.remove((Integer) begin);
                put(list,nums, end);
                res[begin + 1] = nums[list.get(0)];
            }
            return res;

        }

        public void put(List<Integer> list,int[] nums,int index) {
            for (int i = list.size() - 1; i >= 0; i--) {
                if (nums[index] > nums[list.get(i)]) {
                    list.remove(i);
                }else{
                    break;
                }
            }
            list.add(index);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}