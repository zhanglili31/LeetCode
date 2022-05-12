package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateArray;
import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.*;

//356 直线镜像
//2022-05-12 10:45:40
class LineReflection {

    public static void main(String[] args) {
        Solution solution = new LineReflection().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        String testStr = "hello";
        String strArray[] = {"wrt", "wrf"};
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
        int temp[] = CreateArray.getArray(20, 100);
        System.out.println(Arrays.toString(temp));
        System.out.println(solution);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //参考方案：https://leetcode.cn/problems/line-reflection/solution/c-xian-zhao-zhong-xian-wei-zhi-ran-hou-yan-zheng-b/
        public boolean isReflected(int[][] points) {
            Map<Integer, Set<Integer>> map = new HashMap<>();

            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < points.length; i++) {
                min = Math.min(min, points[i][0]);
                max = Math.max(max, points[i][0]);
                Set<Integer> set = map.getOrDefault(points[i][1], new HashSet<>());
                set.add(points[i][0]);
                map.put(points[i][1], set);
            }
            int m = min + max;
            for (int[] p : points) {
                if (!map.get(p[1]).contains(m - p[0])) {
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}