package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;
import com.zhanglili31.leetCode.editor.cn.utils.CreateArray;

import java.util.*;

//277 搜寻名人
//2022-05-08 14:56:08
class FindTheCelebrity {

    public static void main(String[] args) {
        Solution solution = new FindTheCelebrity().new Solution();
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
/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */
    class Relation {
        boolean knows(int a, int b) {
            return false;
        }


    }

    public class Solution extends Relation {
        public int findCelebrity(int n) {
            int res = 0;
            int num = 0;
            List<Integer> list = new ArrayList<>();
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < n; i++) {
                list.add(i);
            }
            Iterator<Integer> iterator = list.iterator();
            while (iterator.hasNext()) {
                res = iterator.next();
                if (set.contains(res))
                    continue;
                boolean find = true;
                for (int j = 0; j < n; j++) {
                    if (res == j)
                        continue;
                    if (!knows(j, res) || knows(res, j)) {
                        set.add(res);
                        find = false;
                        break;
                    }
                    //j 认识i，
                    set.add(j);
                }
                if (find)
                    return res;

            }
            return n == set.size() ? -1 : res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}