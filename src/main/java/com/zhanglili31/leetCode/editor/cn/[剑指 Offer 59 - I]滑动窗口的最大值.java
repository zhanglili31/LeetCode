package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.*;

//剑指 Offer 59 - I 滑动窗口的最大值
//2022-06-15 22:08:44
class HuaDongChuangKouDeZuiDaZhiLcof {

    public static void main(String[] args) {
        Solution solution = new HuaDongChuangKouDeZuiDaZhiLcof().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        String testStr = "hello";
        String strArray[] = {"wrt", "wrf"};
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
//        int temp[] = CreateArray.getArray(20, 100);
        int temp[] = {1, 3, -1, -3, 5, 3, 6, 7};
        System.out.println(Arrays.toString(temp));
        System.out.println(solution.maxSlidingWindow(temp, 3));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //理解起来也不难，有时间可以做以下todo
        //https://leetcode.cn/problems/sliding-window-maximum/solution/hua-dong-chuang-kou-zui-da-zhi-by-leetco-ki6m/
        //方法三：分块 + 预处理
        public int[] maxSlidingWindow3(int[] nums, int k) {
            return null;
        }

        //大顶堆，如果堆定的索引不再窗口范围内，那么就把堆定的元素poll，直到，堆定的index在窗口范围内。
        public int[] maxSlidingWindow2(int[] nums, int k) {
            if (nums == null || nums.length == 0) {
                return new int[0];
            }
            int left = 0;
            int right = k - 1;
            Queue<int[]> q = new PriorityQueue<int[]>(new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o2[0] - o1[0];
                }
            });
            for (int i = 0; i < right; i++) {
                q.add(new int[]{nums[i], i});
            }
            int index = 0;
            int ans[] = new int[nums.length - k + 1];
            while (right < nums.length) {
                q.add(new int[]{nums[right], right});
                while (!q.isEmpty() && q.peek()[1] < left) {
                    q.poll();
                }
                ans[index++] = q.peek()[0];
                left++;
                right++;

            }
            System.out.println(Arrays.toString(ans));
            return ans;
        }

        //单调队列，如果新增加的元素大于队列head元素，则清空队列
        public int[] maxSlidingWindow(int[] nums, int k) {
            Deque<int[]> q = new LinkedList<>();

            for (int i = 0; i < k - 1; i++) {
                while (!q.isEmpty() && q.getLast()[0] <= nums[i]) {
                    q.pollLast();
                }
                q.addLast(new int[]{nums[i], i});

            }
            int left = 0;
            int right = k - 1;
            int index = 0;
            int ans[] = new int[nums.length - k + 1];
            while (right < nums.length) {
                while (!q.isEmpty() && q.getLast()[0] <= nums[right]) {
                    q.pollLast();
                }
                q.addLast(new int[]{nums[right], right});
                while (q.getFirst()[1] < left) {
                    q.pollFirst();
                }
                ans[index++] = q.getFirst()[0];
                left++;
                right++;

            }
            return ans;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}