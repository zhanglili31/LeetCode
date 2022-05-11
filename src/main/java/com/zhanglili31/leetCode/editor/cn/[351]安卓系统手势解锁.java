package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateArray;
import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.*;

//351 安卓系统手势解锁
//2022-05-12 05:56:25
class AndroidUnlockPatterns {

    public static void main(String[] args) {
        Solution solution = new AndroidUnlockPatterns().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        String testStr = "hello";
        String strArray[] = {"wrt", "wrf"};
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
        int temp[] = CreateArray.getArray(20, 100);
        System.out.println(Arrays.toString(temp));
        System.out.println(solution.numberOfPatterns(1, 2));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //使用map记录中间有点的情况，DFS解决
        Set<Integer> set = new HashSet<>();
        Map<String, Boolean> map = new HashMap<>();

        {
            map.put("13", true);
            map.put("31", true);
            map.put("17", true);
            map.put("19", true);
            map.put("91", true);
            map.put("71", true);

            map.put("37", true);
            map.put("73", true);
            map.put("39", true);
            map.put("93", true);

            map.put("79", true);
            map.put("97", true);

            map.put("28", true);
            map.put("82", true);
            map.put("46", true);
            map.put("64", true);

        }

        int ans = 0;

        public int numberOfPatterns(int m, int n) {
            recursion(m, n, 0, 0);
            return ans;

        }

        public void recursion(int m, int n, int curLen, int last) {
            if (curLen >= m && curLen <= n) {
                ans++;
            }
            if (curLen >= n) {
                return;
            }
            for (int i = 1; i < 10; i++) {
                if (last <= 0) {
                    set.add(i);
                    recursion(m, n, curLen + 1, i);
                    set.remove(i);
                } else if (set.contains(i)) {
                    continue;
                } else if (map.containsKey(String.valueOf(i) + String.valueOf(last))) {
                    if (set.contains((i + last) / 2)) {
                        set.add(i);
                        recursion(m, n, curLen + 1, i);
                        set.remove(i);
                    }
                } else {
                    set.add(i);
                    recursion(m, n, curLen + 1, i);
                    set.remove(i);
                }

            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}