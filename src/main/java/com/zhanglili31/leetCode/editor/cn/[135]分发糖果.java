package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateListNode;
import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.ListNode;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.*;

//135 分发糖果
//2022-10-20 03:58:54
class Candy {

    public static void main(String[] args) {
        int dir8[][] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
        int dir4[][] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Solution solution = new Candy().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        ListNode listNode = CreateListNode.stringToListNode("[1,2,3]");
        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        String testStr = "hello";
        String strArray[] = {"wrt", "wrf"};
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
//        int temp[] = CreateArray.getArray(20, 100);
        int temp[] = {1,3,4,5,2};
        System.out.println(Arrays.toString(temp));
        System.out.println(solution.candy(temp));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //贪心
        public int candy(int[] ratings) {
            Map<Integer, List<Integer>> map = new TreeMap<>(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o1 - o2;
                }
            });
            for (int i = 0; i < ratings.length; i++) {
                List<Integer> list = map.getOrDefault(ratings[i], new ArrayList<>());
                list.add(i);
                if (!map.containsKey(ratings[i])) {
                    map.put(ratings[i], list);
                }
            }
            int res = 0;
            int dp[] = new int[ratings.length];
            for (int key : map.keySet()) {
                List<Integer> list = map.get(key);
                for (int index : list) {
                    dp[index] = 1;
                    int left = index - 1;
                    int right = index + 1;
                    if (left >= 0 && key > ratings[left]) {
                        dp[index] = dp[left] + 1;
                    }
                    if (right < ratings.length && key > ratings[right]) {
                        dp[index] = Math.max(dp[index], dp[right] + 1);
                    }
                    res += dp[index];
                }
            }
            return res;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}