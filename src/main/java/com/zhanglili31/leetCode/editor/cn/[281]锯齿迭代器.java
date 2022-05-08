package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;
import com.zhanglili31.leetCode.editor.cn.utils.CreateArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//281 锯齿迭代器
//2022-05-08 16:30:51
class ZigzagIteratora {

    public static void main(String[] args) {
//        Solution solution = new ZigzagIterator().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        String testStr = "hello";
        String strArray[] = {"wrt", "wrf"};
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
        int temp[] = CreateArray.getArray(20, 100);
        System.out.println(Arrays.toString(temp));
//        System.out.println(solution);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    public class ZigzagIterator {
        List<List<Integer>> list = new ArrayList<>();
        int points[] = null;
        int cur = -1;
        int left = 0;

        public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
            if (v1.size() > 0)
                list.add(v1);
            if (v2.size() > 0)
                list.add(v2);
            points = new int[list.size()];
            left = list.size();
        }

        public int next() {
            do {
                cur = (cur + 1) % list.size();
            } while (left > 0 && list.get(cur).size() == points[cur]);
            List<Integer> temp = list.get(cur);
            int res = temp.get(points[cur]);
            points[cur] += 1;
            if (points[cur] == temp.size()) {
                left--;
            }
            return res;


        }

        public boolean hasNext() {
            return left != 0;
        }
    }

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */
//leetcode submit region end(Prohibit modification and deletion)

}