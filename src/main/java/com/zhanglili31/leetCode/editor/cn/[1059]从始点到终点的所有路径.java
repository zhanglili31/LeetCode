package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateArray;
import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.*;

//1059 从始点到终点的所有路径
//2022-05-26 01:11:38
class AllPathsFromSourceLeadToDestination {

    public static void main(String[] args) {
        Solution solution = new AllPathsFromSourceLeadToDestination().new Solution();
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
        public boolean leadsToDestination(int n, int[][] edges, int source, int destination) {
            Map<Integer, List<Integer>> edge = new HashMap<>();
            Set<Integer> path = new HashSet<>();
            for (int i = 0; i < edges.length; i++) {
                List<Integer> temp = edge.getOrDefault(edges[i][0], new ArrayList<>());
                temp.add(edges[i][1]);
                edge.put(edges[i][0], temp);
            }
            return DFS(edge, source, destination, source, path);

        }

        public boolean DFS(Map<Integer, List<Integer>> edge, int source, int destination, int last, Set<Integer> path) {
            if (last == destination&&edge.get(last)==null)
                return true;
            List<Integer> temp = edge.get(last);
            if (temp==null||temp.size() == 0) {
                return false;
            }
            boolean flag=true;
            for (int i = 0; i < temp.size()&flag; i++) {
                if (path.contains(temp.get(i))) {
                    return false;
                }
                path.add(temp.get(i));
                flag &= DFS(edge, source, destination, temp.get(i), path);
                path.remove(temp.get(i));
            }
            return flag;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}