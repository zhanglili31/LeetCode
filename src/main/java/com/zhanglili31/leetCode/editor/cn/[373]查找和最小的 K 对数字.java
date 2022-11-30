package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateListNode;
import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.ListNode;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.*;

//373 查找和最小的 K 对数字
//2022-10-20 05:47:39
class FindKPairsWithSmallestSums {

    public static void main(String[] args) {
        int dir8[][] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
        int dir4[][] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Solution solution = new FindKPairsWithSmallestSums().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        ListNode listNode = CreateListNode.stringToListNode("[1,2,3]");
        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        String testStr = "hello";
        String strArray[] = {"wrt", "wrf"};
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
//        int temp[] = CreateArray.getArray(20, 100);
        int temp[] = {1, 2};
        int temp2[] = {3};
        System.out.println(Arrays.toString(temp));
        System.out.println(solution.kSmallestPairs(temp, temp2, 3));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private class Node {
            int i;
            int j;

            public Node(int i, int j, int[] nums1, int nums2[]) {
                this.i = i;
                this.j = j;
                this.sum = nums1[i] + nums2[j];
            }

            int sum;
        }

        //多路归并
        //参考题解：https://leetcode.cn/problems/find-k-pairs-with-smallest-sums/solution/gong-shui-san-xie-duo-lu-gui-bing-yun-yo-pgw5/
        public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
            if (nums1.length > nums2.length) {
                return kSmallestPairs(nums2, nums1, k);
            }
            Queue<Node> priorityQueue = new PriorityQueue<Node>(((o1, o2) -> o1.sum - o2.sum));
            //i-1  j-2;
            for (int i = 0; i < Math.min(nums1.length,k); i++) {
                Node node = new Node(i, 0, nums1, nums2);
                priorityQueue.add(node);
            }
            List<List<Integer>> result = new ArrayList<List<Integer>>();
            while (result.size()<k&&!priorityQueue.isEmpty()) {
                Node node = priorityQueue.poll();
                List<Integer> minNode = new ArrayList<>();
                minNode.add(nums1[node.i]);
                minNode.add(nums2[node.j]);
                result.add(minNode);
                if (++node.j < nums2.length) {
                    node.sum = nums1[node.i] + nums2[node.j];
                    priorityQueue.add(node);
                }

            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}