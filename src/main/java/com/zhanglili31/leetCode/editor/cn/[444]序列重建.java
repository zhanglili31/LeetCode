package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateArray;
import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.*;

//444 序列重建
//2022-05-17 10:37:14
class SequenceReconstruction {

    public static void main(String[] args) {
        Solution solution = new SequenceReconstruction().new Solution();
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

        //方案：拓扑排序
        public boolean sequenceReconstruction(int[] nums, List<List<Integer>> sequences) {
            //deg 记录每一个数字的入度
            Map<Integer, Integer> deg = new HashMap<>();
            // 记录每一个字符指向的边，
            Map<Integer, Set<Integer>> edges = new HashMap<>();
            int MIN = nums[0];
            int MAX = nums[nums.length - 1];
            for (int i = 0; i < nums.length; i++) {
                MIN = Math.min(MIN, nums[i]);
                MAX = Math.max(MAX, nums[i]);
            }
            int u, v;
            for (List<Integer> subList : sequences) {
                u = subList.get(0);
                if (!deg.containsKey(u)) {
                    deg.put(u, 0);
                }
                for (int i = 0; i < subList.size() - 1; i++) {
                    u = subList.get(i);
                    v = subList.get(i + 1);
                    if (u < MIN || u > MAX || v > MAX || v < MIN)
                        return false;
                    Set<Integer> set = edges.getOrDefault(u, new HashSet<>());
                    if (!set.contains(v)) {
                        set.add(v);
                        edges.put(u, set);
                        deg.put(v, deg.getOrDefault(v, 0) + 1);
                    }
                }
            }
            Queue<Integer> queue = new LinkedList<>();
            deg.forEach((key, val) -> {
                if (val == 0) {
                    queue.add(key);
                }
            });
            int index = 0;
            while (!queue.isEmpty()) {
                if (queue.size() > 1)
                    return false;
                int n = queue.poll();
                if (nums[index++] != n)
                    return false;
                Set<Integer> to = edges.get(n);
                if (to != null) {
                    to.forEach(e -> {
                        int tempDeg = deg.get(e);
                        tempDeg--;
                        deg.put(e, tempDeg);
                        if (tempDeg == 0) {
                            queue.offer(e);
                        }

                    });
                }
                if (index == nums.length) {
                    return queue.isEmpty();
                }

            }
            return index == nums.length;//长度小于的时候
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}