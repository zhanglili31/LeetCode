package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateArray;
import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.*;

//484 寻找排列
//2022-05-17 17:40:19
class FindPermutation {

    public static void main(String[] args) {
        Solution solution = new FindPermutation().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        String testStr = "hello";
        String strArray[] = {"wrt", "wrf"};
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
        int temp[] = CreateArray.getArray(20, 100);
        System.out.println(Arrays.toString(temp));
        System.out.println(solution.findPermutation("DID"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] findPermutation(String s) {
            int n = s.length();
            int deg[] = new int[n + 1];
            int ans[] = new int[n + 1];
            Map<Integer, List<Integer>> edges = new HashMap<>();
            //建立边的关系
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == 'I') {
                    List<Integer> list = edges.getOrDefault(i, new ArrayList<>());
                    list.add(i + 1);
                    edges.put(i, list);
                    deg[i+1]++;
                } else {
                    List<Integer> list = edges.getOrDefault(i + 1, new ArrayList<>());
                    list.add(i);
                    edges.put(i + 1, list);
                    deg[i]++;
                }
            }
            //拓扑排序
            PriorityQueue<Integer> priorityQueue=new PriorityQueue<Integer>(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o1-o2;
                }
            });
            for (int i = 0; i < deg.length; i++) {
                if (deg[i] == 0) {
                    priorityQueue.add(i);
                }
            }
            int curNum=1;
            while (!priorityQueue.isEmpty()) {
                int index=priorityQueue.poll();
                ans[index]=curNum++;
                List<Integer> tempList = edges.getOrDefault(index, new ArrayList<>());
                for (int i = 0; i < tempList.size(); i++) {
                    int e = tempList.get(i);
                    deg[e]--;
                    if (deg[e] == 0) {
                        priorityQueue.add(e);
                    }
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}