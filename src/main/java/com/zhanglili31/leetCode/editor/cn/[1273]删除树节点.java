package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.*;

//1273 删除树节点
//2022-06-18 16:46:23
class DeleteTreeNodes {

    public static void main(String[] args) {
        Solution solution = new DeleteTreeNodes().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
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

        //这种方式：必须要求：树的节点按照层次和顺序摆放的。 不能通过
        public int deleteTreeNodes2(int nodes, int[] parent, int[] value) {
            //child记录每一个节点上，孩子节点包括自己节点的数量，
            int child[] = new int[nodes];
            for (int i = 0; i < child.length; i++) {
                child[i] = 1;
            }
            //从后往前开始遍历。最后的节点肯定没有子节点，0节点暂不处理，因为0节点的parent=-1;
            for (int i = nodes - 1; i >= 1; i--) {
                //父节点的节点数量加上当前节点的节点数量=最终得出父节点对应的树的所有节点数量
                child[parent[i]] += child[i];
                //父节点的值加上当前的节点值，求得父节点对应树的sum
                value[parent[i]] += value[i];
                //如果当前节点被删除，那么说明当前的节点的值等于0，对父节点的值不会影响，但是父节点需要减掉当前节点的树的节点数量
                if (value[i] == 0) {
                    nodes -= child[i];
                    child[parent[i]] -= child[i];
                }

            }
            //处理0节点：如果0节点的value==0,那么就是所有的节点都删除。
            if (value[0] == 0) {
                return 0;
            }
            return nodes;
        }

        //拓扑排序
        public int deleteTreeNodes(int nodes, int[] parent, int[] value) {
            //child记录每一个节点上，孩子节点包括自己节点的数量，
            int child[] = new int[nodes];
            for (int i = 0; i < child.length; i++) {
                child[i] = 1;
            }
            //
            int deg[] = new int[nodes];//
            Map<Integer, Integer> edges = new HashMap<>();
            for (int i = nodes - 1; i >= 1; i--) {
                int u = i;
                int v = parent[i];
                edges.put(u, v);
                deg[v]++;
            }
            Queue<Integer> queue = new LinkedList<Integer>();
            for (int i = 0; i < deg.length; i++) {
                if (deg[i] == 0) {
                    queue.add(i);
                }
            }
            while (!queue.isEmpty()) {
                int ch = queue.poll();
                if (ch == 0) {
                    if (value[0] == 0)
                        return 0;
                    break;
                }
                int pa = edges.get(ch);
                value[pa] += value[ch];
                if (value[ch] == 0) {
                    nodes -= child[ch];
                } else {
                    child[pa] += child[ch];
                }
                deg[pa]--;
                if (deg[pa] == 0) {
                    queue.add(pa);
                }
            }
            return nodes;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}