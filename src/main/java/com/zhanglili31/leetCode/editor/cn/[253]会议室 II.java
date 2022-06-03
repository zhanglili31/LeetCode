package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateArray;
import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.Arrays;

//253 会议室 II
//2022-05-04 03:33:32
class MeetingRoomsIi {

    public static void main(String[] args) {
        Solution solution = new MeetingRoomsIi().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        String testStr = "hello";
        int temp[] = CreateArray.getArray(20, 100);
        System.out.println(Arrays.toString(temp));
        System.out.println(solution);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //参考上下车问题：https://leetcode.cn/problems/meeting-rooms-ii/solution/tu-jie-zhuan-hua-wei-shang-xia-che-wen-t-uy2q/
        //注意：排序时，遇到一个会议结束时间和另一个会议开始时间一样的，先下车再上车。
        //关键点：上车时间和下车时间分开排序。
        public int minMeetingRooms(int[][] intervals) {
            int n = intervals.length;
            int array[][] = new int[2 * n][2];
            for (int i = 0; i < n; i++) {
                array[i * 2][0] = intervals[i][0];
                array[i * 2][1] = 1;
                array[i * 2 + 1][0] = intervals[i][1];
                array[i * 2 + 1][1] = -1;
            }
            //排序
            boolean flag = true;
            while (flag) {
                flag = false;
                for (int i = 0; i < 2 * n - 1; i++) {
                    if (array[i][0] > array[i + 1][0]) {
                        int[] a = array[i];
                        array[i] = array[i + 1];
                        array[i + 1] = a;
                        flag = true;
                    }
                    if (array[i][0] == array[i+1][0]) {
                        if (array[i][1] > array[i + 1][1]) {
                            int[] a = array[i];
                            array[i] = array[i + 1];
                            array[i + 1] = a;
                            flag = true;
                        }
                    }
                }
            }
            int res=0;
            int nums=0;
            for (int i = 0; i < 2 * n; i++) {
                nums += array[i][1];
                res = Math.max(res, nums);
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}