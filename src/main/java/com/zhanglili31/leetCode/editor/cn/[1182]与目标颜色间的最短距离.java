package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.*;

//1182 与目标颜色间的最短距离
//2022-06-13 18:00:36
class ShortestDistanceToTargetColor {

    public static void main(String[] args) {
        Solution solution = new ShortestDistanceToTargetColor().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        int[][] a = {{49, 2}};
        String testStr = "hello";
        String strArray[] = {"wrt", "wrf"};
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
//        int temp[] = CreateArray.getArray(20, 100);
        int temp[] = {3, 1, 1, 2, 3, 3, 2, 1, 2, 3, 1, 1, 3, 2, 3, 1, 1, 1, 1, 2, 2, 1, 2, 2, 2, 1, 1, 1, 1, 2, 3, 3, 3, 1, 3, 2, 1, 1, 2, 2, 1, 3, 1, 2, 1, 1, 2, 2, 1, 1};
        System.out.println(Arrays.toString(temp));
        System.out.println(solution.shortestDistanceColor(temp, a));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //二分查找 区间标准示例
        public List<Integer> shortestDistanceColor(int[] colors, int[][] queries) {
            Map<Integer, List<Integer>> map = new HashMap<>();
            for (int i = 0; i < colors.length; i++) {
                List<Integer> list = map.getOrDefault(colors[i], new ArrayList<>());
                list.add(i);
                map.put(colors[i], list);
            }
            List<Integer> ans = new ArrayList<>();
            for (int i = 0; i < queries.length; i++) {
                List<Integer> list = map.get(queries[i][1]);
                if (list == null || list.size() == 0) {
                    ans.add(-1);
                    continue;
                }
                if (colors[queries[i][0]] == queries[i][1]) {
                    ans.add(0);
                    continue;
                }

                int left = 0, right = list.size() - 1;
                int target = queries[i][0];
                while (left <= right) {
                    int mid = left + (right - left) / 2;
                    if (target > list.get(mid)) {
                        left = mid + 1;
                    } else if (target < list.get(mid)) {
                        right = mid - 1;
                    }
                }
                int step = Integer.MAX_VALUE;
                if (left >= 0 && left < list.size()) {
                    step = Math.min(Math.abs(list.get(left) - target), step);
                }
                if (right >= 0 && right < list.size()) {
                    step = Math.min(Math.abs(list.get(right) - target), step);
                }
                ans.add(step);
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}