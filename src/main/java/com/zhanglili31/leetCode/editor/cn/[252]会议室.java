package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;
import com.zhanglili31.leetCode.editor.cn.utils.CreateArray;

import java.util.Arrays;

//252 会议室
//2022-05-06 04:04:52
class MeetingRooms {

    public static void main(String[] args) {
        Solution solution = new MeetingRooms().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        String testStr = "hello";
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
        int temp[] = CreateArray.getArray(20, 100);
        System.out.println(Arrays.toString(temp));
        System.out.println(solution);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canAttendMeetings(int[][] intervals) {
            int array[][] = new int[intervals.length * 2][2];
            for (int i = 0; i < intervals.length; i++) {
                array[i * 2][0] = intervals[i][0];
                array[i * 2][1] = 1;
                array[i * 2 + 1][0] = intervals[i][1];
                array[i * 2 + 1][1] = -1;
            }
            //排序
            boolean flag = true;
            int[] temp = null;
            while (flag) {
                flag = false;
                for (int i = 0; i < array.length - 1; i++) {
                    if (array[i][0] > array[i + 1][0] || (array[i][0] == array[i + 1][0] && array[i][1] > array[i + 1][1])) {
                        temp = array[i];
                        array[i] = array[i + 1];
                        array[i + 1] = temp;
                        flag = true;
                    }
                }
            }
            //上下车
            int res = 0;
            for (int i = 0; i < array.length; i++) {
                res += array[i][1];
                if (res > 1)
                    return false;
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}