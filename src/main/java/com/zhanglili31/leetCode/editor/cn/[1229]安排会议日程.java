package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

//1229 安排会议日程
//2022-06-11 18:00:20
class MeetingScheduler {

    public static void main(String[] args) {
        Solution solution = new MeetingScheduler().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
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
        //本质就是区间合并
        public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
            List<int[]> list = new ArrayList<>();
            for (int i = 0; i < slots1.length; i++) {
                list.add(new int[]{slots1[i][0], 1});
                list.add(new int[]{slots1[i][1], -1});
            }
            for (int i = 0; i < slots2.length; i++) {
                list.add(new int[]{slots2[i][0], 1});
                list.add(new int[]{slots2[i][1], -1});
            }
            list.sort(new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    if (o1[0] == o2[0]) {
                        return o2[1] - o1[1];
                    } else {
                        return o1[0] - o2[0];
                    }
                }
            });
            int count = 0;
            int begin = -1;
            for (int i = 0; i < list.size(); i++) {
                count += list.get(i)[1];
                if (count == 2) {
                    begin = list.get(i)[0];
                } else if (count == 1 && begin != -1) {
                    if (list.get(i)[0] - begin >= duration) {
                        List<Integer> ans = new ArrayList<>();
                        ans.add(begin);
                        ans.add(begin + duration);
                        return ans;
                    } else {
                        begin = -1;
                    }
                } else {
                    begin = -1;
                }
            }
            return new ArrayList<>();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}