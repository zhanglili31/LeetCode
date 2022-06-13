package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//剑指 Offer 49 丑数
//2022-06-13 14:37:06
class ChouShuLcof {

    public static void main(String[] args) {
        Solution solution = new ChouShuLcof().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        String testStr = "hello";
        String strArray[] = {"wrt", "wrf"};
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
//        int temp[] = CreateArray.getArray(20, 100);
        int temp[] = {5, 3, 2, 2};
        System.out.println(Arrays.toString(temp));
        System.out.println(solution.nthUglyNumber(1690));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //https://leetcode.cn/problems/chou-shu-lcof/solution/mian-shi-ti-49-chou-shu-dong-tai-gui-hua-qing-xi-t/
        public int nthUglyNumber(int n) {
            List<Integer> list = new ArrayList<>();
            list.add(1);
            int[] x = new int[3];
            int[] v = new int[3];
            int[] y = {2, 3, 5};
            while (list.size() < n) {
                int cur = list.get(list.size() - 1);
                int minIndex = -1;
                for (int i = 0; i < 3; i++) {
                    do {
                        v[i] = list.get(x[i]) * y[i];
                        x[i]++;
                    } while ((v[i] <= cur));
                    x[i]--;
                    if (minIndex == -1) {
                        minIndex = i;
                    } else if (v[minIndex] > v[i]) {
                        minIndex = i;
                    }
                }
                list.add(v[minIndex]);

            }
            System.out.println(list);
            return list.get(n - 1);

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}