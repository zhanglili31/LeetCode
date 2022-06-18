package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//1272 删除区间
//2022-06-18 16:11:51
class RemoveInterval {

    public static void main(String[] args) {
        Solution solution = new RemoveInterval().new Solution();
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
        //case1
        public List<List<Integer>> removeInterval(int[][] intervals, int[] toBeRemoved) {
            List<List<Integer>> ans = new ArrayList<>();
            int a = toBeRemoved[0];
            int b = toBeRemoved[1];
            //需要注意判断顺序
            for (int i = 0; i < intervals.length; i++) {
                int x = intervals[i][0];
                int y = intervals[i][1];
                //1：完全在删除区间以外
                if (y <= a || x >= b) {
                    List<Integer> list = new ArrayList<>();
                    list.add(x);
                    list.add(y);
                    ans.add(list);
                    //2：完全在删除区间以内
                } else if (a <= x && y <= b) {
                    continue;
                    //3 区间大于被删除区间
                } else if (x < a && b < y) {
                    List<Integer> list = new ArrayList<>();
                    list.add(x);
                    list.add(a);
                    ans.add(list);
                    list = new ArrayList<>();
                    list.add(b);
                    list.add(y);
                    ans.add(list);
                    //4：和删除区间有交集，左边
                } else if (x < a) {
                    List<Integer> list = new ArrayList<>();
                    list.add(x);
                    list.add(a);
                    ans.add(list);
                    //5：和删除区间有交集，右边
                } else if (y > b) {
                    List<Integer> list = new ArrayList<>();
                    list.add(b);
                    list.add(y);
                    ans.add(list);
                }
            }
            return ans;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}