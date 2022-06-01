package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.*;

//656 金币路径
//2022-06-01 04:02:33
class CoinPath {

    public static void main(String[] args) {
        Solution solution = new CoinPath().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        String testStr = "hello";
        String strArray[] = {"wrt", "wrf"};
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
//        int temp[] = CreateArray.getArray(1000, 100);
        int temp[] = {0,-1,-1,-1,-1,-1};
//        System.out.println(Arrays.toString(temp));
        System.out.println(solution.cheapestJump(temp, 5));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        int minCost = Integer.MAX_VALUE;

        //DFS 超时，无法通过
        public List<Integer> cheapestJump2(int[] coins, int maxJump) {
            PriorityQueue<List<Integer>> priorityQueue = new PriorityQueue<>(new Comparator<List<Integer>>() {
                @Override
                public int compare(List<Integer> o1, List<Integer> o2) {
                    return o1.toString().compareTo(o2.toString());
                }
            });
            LinkedList<Integer> path = new LinkedList<>();
            int cost = coins[0];
            int cur = 0;
            path.add(1);

            DFS(coins, maxJump, priorityQueue, path, cur, cost);
            System.out.println(priorityQueue);
            if (priorityQueue.size() == 0) {
                return new ArrayList<>();
            } else {
                return priorityQueue.poll();
            }
        }

        public void DFS(int[] coins, int maxJump, PriorityQueue<List<Integer>> priorityQueue, LinkedList<Integer> path, int cur, int cost) {
            if (cur == coins.length - 1) {
                if (cost > minCost) {
                    return;
                }
                if (cost < minCost) {
                    priorityQueue.clear();
                    minCost = cost;
                }
                LinkedList<Integer> pa = new LinkedList<Integer>();
                pa.addAll(path);
                priorityQueue.add(pa);
                return;
            }
            if (cost > minCost) {
                return;
            }
            for (int i = cur + 1; i <= maxJump + cur && i < coins.length; i++) {
                if (coins[i] == -1) {
                    continue;
                }
                path.add(i + 1);
                DFS(coins, maxJump, priorityQueue, path, i, cost + coins[i]);
                path.pollLast();
            }

        }

        //DP+DFS获取最小路径
        public List<Integer> cheapestJump(int[] coins, int maxJump) {
            int m = coins.length;
            int n = maxJump;
            int[] dp = new int[m];
            //dp[i]=Math.min(dp[i-maxJump~i-1]
            int[] path = new int[m];
            List<List<Integer>> p = new ArrayList<List<Integer>>();
            p.add(new ArrayList<>());
            List<Integer> ans = new ArrayList<>();
            dp[0] = coins[0];
            for (int i = 1; i < m; i++) {
                p.add(new ArrayList<>());
                if (coins[i] == -1) {
                    dp[i] = -1;
                    continue;
                }
                int add = Integer.MAX_VALUE;
                int fa = 0;
                for (int j = i - maxJump; j < i; j++) {
                    if (j < 0 || dp[j] == -1 || dp[j] > add) {
                        continue;
                    }
                    if (add > dp[j]) {
                        add = dp[j];
                        fa = j;
                        p.get(i).clear();
                    }
                    p.get(i).add(j);
                }
                if (add == Integer.MAX_VALUE) {
                    return ans;
                }
                dp[i] = add + coins[i];
            }
            PriorityQueue<List<Integer>> priorityQueue = new PriorityQueue<>(new Comparator<List<Integer>>() {
                @Override
                public int compare(List<Integer> o1, List<Integer> o2) {
                    if(o1.size()==o2.size()){
                        return o1.toString().compareTo(o2.toString());
                    }else{
                        return o2.size()-o1.size();
                    }

                }
            });

            List<Integer>temp = new ArrayList<>();
            temp.add(coins.length);
            DFS2(p, priorityQueue, temp, coins.length - 1);
            System.out.println(priorityQueue);
            return priorityQueue.isEmpty()?ans:priorityQueue.poll();
        }

        public void DFS2(List<List<Integer>> p, PriorityQueue<List<Integer>> priorityQueue,List<Integer>path, int cur) {
            if(cur==0){
                List<Integer> re = new ArrayList<>();
                for (int i = path.size() - 1; i >= 0; i--) {
                    re.add(path.get(i));
                }
                priorityQueue.add(re);
                return;
            }
            List<Integer> pa = p.get(cur);
            for (int i = 0; i < pa.size(); i++) {
                path.add(pa.get(i) + 1);
                DFS2(p, priorityQueue, path, pa.get(i));
                path.remove(path.size() - 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}