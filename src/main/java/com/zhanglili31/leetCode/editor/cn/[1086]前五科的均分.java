package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.*;

//1086 前五科的均分
//2022-06-08 09:40:29
class HighFive {

    public static void main(String[] args) {
        Solution solution = new HighFive().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        int[][] a = {{1,100},{7,100},{1,100},{7,100},{1,100},{7,100},{1,100},{7,100},{1,100},{7,100}};
        String testStr = "hello";
        String strArray[] = {"wrt", "wrf"};
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
//        int temp[] = CreateArray.getArray(20, 100);
        int temp[] = {5, 3, 2, 2};
        System.out.println(Arrays.toString(temp));
        System.out.println(solution.highFive(a));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] highFive(int[][] items) {
            Map<Integer, List<Integer>> map = new HashMap<>();
            for (int i = 0; i < items.length; i++) {
                int id = items[i][0];
                int v = items[i][1];
                List<Integer> list = map.getOrDefault(id, new ArrayList<>());
                list.add(v);
                map.put(id, list);
            }
            List<int[]> ans = new ArrayList<>();
            int index = 0;
            map.forEach((k, v) -> {
                v.sort(new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        return o2-o1;
                    }
                });
                Iterator iterator = v.iterator();
                int sum = 0;
                int th = 5;
                while (th > 0) {
                    th--;
                    sum += (int) iterator.next();
                }
                ans.add(new int[]{k, sum / 5});
            });
            ans.sort(new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[0] - o2[0];
                }
            });
            return ans.toArray(new int[ans.size()][]);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}