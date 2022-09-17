package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateListNode;
import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.ListNode;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.Arrays;

//621 任务调度器
//2022-09-17 20:51:58
class TaskScheduler {

    public static void main(String[] args) {
        int dir8[][] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
        int dir4[][] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Solution solution = new TaskScheduler().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        ListNode listNode = CreateListNode.stringToListNode("[1,2,3]");
        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        String testStr = "hello";
        String strArray[] = {"wrt", "wrf"};
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
//        int temp[] = CreateArray.getArray(20, 100);
        int temp[] = {5, 3, 2, 2};
        System.out.println(Arrays.toString(temp));
        System.out.println(solution);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //参考：https://leetcode.cn/problems/task-scheduler/solution/tong-zi-by-popopop/
        public int leastInterval(char[] tasks, int n) {
            int count[] = new int[26];
            for (int i = 0; i < tasks.length; i++) {
                count[tasks[i] - 'A']++;
            }
            Arrays.sort(count);
            int len = (count[25] - 1) * (n + 1) + 1;
            int i=24;
            while (i >= 0 && count[i] == count[25]) {
                len++;
                i--;
            }
            //如果桶里没有被添满，最大值就是len，
            //如果桶里添满，最大值就是任务的个数，因为这种情况cpu没有空等时间
            return Math.max(len, tasks.length);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}