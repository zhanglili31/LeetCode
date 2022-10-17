package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateListNode;
import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.ListNode;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.*;

//264 丑数 II
//2022-10-18 02:45:33
class UglyNumberIi {

    public static void main(String[] args) {
        int dir8[][] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
        int dir4[][] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Solution solution = new UglyNumberIi().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        ListNode listNode = CreateListNode.stringToListNode("[1,2,3]");
        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        String testStr = "hello";
        String strArray[] = {"wrt", "wrf"};
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
//        int temp[] = CreateArray.getArray(20, 100);
        int temp[] = {5, 3, 2, 2};
        System.out.println(Arrays.toString(temp));
        System.out.println(solution.nthUglyNumber(10));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int nthUglyNumber(int n) {
//            return minHeap(n);
            return dynamicProgramming(n);

        }

        //方法一  堆小堆
        private int minHeap(int n) {
            PriorityQueue<Long> queue = new PriorityQueue<Long>(new Comparator<Long>() {
                @Override
                public int compare(Long o1, Long o2) {
                    return o1.compareTo(o2);
                }
            });
            Set<Long> set = new HashSet<>();
            int[] arr = {2, 3, 5};
            queue.add(1l);
            set.add(1l);
            long res = 0l;
            long t = 0l;
            int ugly = 0;
            for (int i = 0; i < n; i++) {
                res = queue.poll();
                ugly = (int) res;
                for (int j = 0; j < arr.length; j++) {
                    t = res * arr[j];
                    if (!set.contains(t)) {
                        queue.add(t);
                        set.add(t);
                    }
                }
            }
            return ugly;
        }

        //方法二  动态规划
        private int dynamicProgramming(int n) {
            int arr[] = new int[n + 1];
            arr[1] = 1;
            int p2 = 1, p3 = 1, p5 = 1;
            int v2 = 0, v3 = 0, v5 = 0;
            for (int i = 2; i <= n; i++) {
                v2 = arr[p2] * 2;
                v3 = arr[p3] * 3;
                v5 = arr[p5] * 5;
                arr[i] = Math.min(v2, Math.min(v3, v5));
                if (arr[i] == v2) {
                    p2++;
                }
                if (arr[i] == v3) {
                    p3++;
                }
                if (arr[i] == v5) {
                    p5++;
                }
            }
            return arr[n];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}