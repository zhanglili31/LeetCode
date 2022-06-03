package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

//759 员工空闲时间
//2022-06-03 01:23:09
class EmployeeFreeTime {

    public static void main(String[] args) {
        Solution solution = new EmployeeFreeTime().new Solution();
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

    class Interval {
        public int start;
        public int end;

        public Interval() {
        }

        public Interval(int _start, int _end) {
            start = _start;
            end = _end;
        }
    }

    ;


    class Solution {
        //参考会议室上下车方案。
        public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
            List<int[]> getInAndOff = new ArrayList<>();
            //第一步：将所有的区间放入list，{上班，+1}  {下班，-1}
            for (int i = 0; i < schedule.size(); i++) {
                List<Interval> intervals = schedule.get(i);
                for (int j = 0; j < schedule.get(i).size(); j++) {
                    Interval interval = intervals.get(j);
                    getInAndOff.add(new int[]{interval.start, 1});
                    getInAndOff.add(new int[]{interval.end, -1});

                }
            }
            //排序，如果时间相同，先上班在下班。
            getInAndOff.sort(new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    if (o1[0] == o2[0]) {
                        return o2[1] - o1[1];
                    } else {
                        return o1[0] - o2[0];
                    }
                }
            });
            int begin = -1;
            List<Interval> ans = new ArrayList<Interval>();
            int end = -1;
            int count = 1;
            int pre = 0;
            //模拟上下车，当车内没有人的时候，就是目标区间段
            // begin截取位置在 pre=1,count=0 ,count对应位置
            //end 截取在pre=0,count!=0 count对应的位置
            //详细见下方代码
            for (int i = 1; i < getInAndOff.size(); i++) {
                pre = count;
                count += getInAndOff.get(i)[1];
                if (pre > 0 && count == 0) {
                    begin = getInAndOff.get(i)[0];
                }
                if (pre == 0 && count != 0) {
                    end = getInAndOff.get(i)[0];
                    ans.add(new Interval(begin, end));
                }
            }
            return ans;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}