package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateListNode;
import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.ListNode;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.*;

//310 最小高度树
//2022-08-22 16:40:29
class MinimumHeightTrees {

    public static void main(String[] args) {
        int dir8[][] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
        int dir4[][] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Solution solution = new MinimumHeightTrees().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        ListNode listNode = CreateListNode.stringToListNode("[1,2,3]");
        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        String testStr = "hello";
        String strArray[] = {"wrt", "wrf"};
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
//        int temp[] = CreateArray.getArray(20, 100);
        int temp[] = {5, 3, 2, 2};
        System.out.println(Arrays.toString(temp));
        System.out.println(solution);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> findMinHeightTrees(int n, int[][] edges) {

            //每一个节点的度数
            int deg[] = new int[n + 1];
            //每一个节点的关联关系
            Map<Integer, List<Integer>> edgeRelation = new HashMap<Integer, List<Integer>>();
            //初始化所有的边关系
            for (int i = 0; i < edges.length; i++) {
                int x = edges[i][0];
                int y = edges[i][1];
                deg[x]++;
                deg[y]++;
                List<Integer> list = edgeRelation.getOrDefault(x, new ArrayList<Integer>());
                list.add(y);
                edgeRelation.put(x, list);
                list = edgeRelation.getOrDefault(y, new ArrayList<Integer>());
                list.add(x);
                edgeRelation.put(y, list);
            }
            //处理最后的节点
            LinkedList<LinkedList<Integer>> outer = new LinkedList<>();
            LinkedList<Integer> inner = new LinkedList<>();
            for (int i = 0; i < deg.length; i++) {
                if (deg[i] == 1) {
                    inner.add(i);
                }
            }
            outer.add(inner);
            //拓扑处理
            List<Integer> res = new LinkedList<>();
            if (edges == null || edges.length == 0) {
                res.add(0);
                return res;
            }
            while (!outer.isEmpty()) {
                inner = outer.poll();
                if (n < 3) {
                    return inner;
                }
                LinkedList<Integer> temp = new LinkedList<>();
                while (!inner.isEmpty()) {
                    int t = inner.poll();
                    n--;
                    List<Integer> list = edgeRelation.get(t);
                    for (int e : list) {
                        deg[e]--;
                        if (deg[e] == 1) {
                            temp.add(e);
                        }
                    }
                }
                if (!temp.isEmpty()) {
                    outer.add(temp);
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}