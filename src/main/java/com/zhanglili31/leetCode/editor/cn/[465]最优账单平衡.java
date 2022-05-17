package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateArray;
import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

//465 最优账单平衡
//2022-05-17 14:17:33
class OptimalAccountBalancing {

    public static void main(String[] args) {
        Solution solution = new OptimalAccountBalancing().new Solution();
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
        //暴力回溯,超出时间限制
        int ans = Integer.MAX_VALUE;

        public int minTransfers(int[][] transactions) {
            //预处理交易
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < transactions.length; i++) {
                map.put(transactions[i][1],map.getOrDefault(transactions[i][1],0)+transactions[i][2]);
                map.put(transactions[i][0],map.getOrDefault(transactions[i][0],0)-transactions[i][2]);
            }
            LinkedList<Integer> po = new LinkedList<Integer>();
            LinkedList<Integer> ne = new LinkedList<Integer>();
            map.forEach((k,v)->{
                if (v > 0) {
                    po.add(v);
                } else if (v < 0) {
                    ne.add(v);
                }
            });
            traceBack(po, ne, 0);
            return ans;
        }

        public void traceBack(LinkedList<Integer> po, LinkedList<Integer> ne, int t) {
            if (po.size() == 0 && ne.size() == 0) {
                ans = Math.min(ans, t);
                return;
            }
            if(t>=ans)return;
            int p1, n1, d;
            for (int i = 0; i < po.size(); i++) {
                for (int j = 0; j < ne.size(); j++) {
                    p1 = po.get(i);
                    n1 = ne.get(j);
                    d = p1 + n1;
                    if (d == 0) {
                        po.remove(i);
                        ne.remove(j);
                        traceBack(po, ne, t + 1);
                        po.add(i, p1);
                        ne.add(j, n1);
                    } else if (d < 0) {
                        po.remove(i);
                        ne.set(j, d);
                        traceBack(po, ne, t + 1);
                        po.add(i, p1);
                        ne.set(j, n1);
                    } else if (d > 0){
                        po.set(i, d);
                        ne.remove(j);
                        traceBack(po, ne, t + 1);
                        po.set(i, p1);
                        ne.add(j, n1);
                    }

                }
            }
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}