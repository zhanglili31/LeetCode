package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateArray;
import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.Arrays;
import java.util.List;

//469 凸多边形
//2022-05-17 16:35:50
class ConvexPolygon {

    public static void main(String[] args) {
        Solution solution = new ConvexPolygon().new Solution();
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
        public boolean isConvex(List<List<Integer>> points) {
            int n = points.size();
            long last = 0;
            for (int i = 0; i < points.size(); i++) {
                List<Integer> p1 = points.get(i % n);
                List<Integer> p2 = points.get((i + 1) % n);
                List<Integer> p3 = points.get((i + 2) % n);
                long cur = getV(p1, p2, p3);
                if (cur != 0) {
                    if (last * cur < 0) {
                        return false;
                    }
                    last = cur;
                }
            }
            return true;

        }

        public long getV(List<Integer> p1, List<Integer> p2, List<Integer> p3) {
            int x1 = p2.get(0) - p1.get(0);
            int x2 = p3.get(0) - p2.get(0);
            int y1 = p2.get(1) - p1.get(1);
            int y2 = p3.get(1) - p2.get(1);
            return x1 * y2 - x2 * y1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}