package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.Arrays;

//743 网络延迟时间
//2022-06-10 12:59:08
class NetworkDelayTime {

    public static void main(String[] args) {
        Solution solution = new NetworkDelayTime().new Solution();
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
        //算法学习地址：https://www.bilibili.com/video/BV1QK411V7V4/?spm_id_from=333.337.search-card.all.click&vd_source=b91faa59653a5095e85707fe0b3c8cda
        //最短路径算法 Dijkstra}Dijkstra  https://leetcode.cn/problems/network-delay-time/solution/gong-shui-san-xie-yi-ti-wu-jie-wu-chong-oghpz/
        public int networkDelayTime(int[][] times, int n, int k) {

            //初始化源点到所有其他点的距离，默认为Integer.MAX_VALUE
            int[] dist = new int[n + 1];
            Arrays.fill(dist, Integer.MAX_VALUE);

            //初始化是否已经找到最短长度数组
            boolean isFind[] = new boolean[n + 1];


            //初始化邻接点。
            int[][] grid = new int[n + 1][n + 1];
            for (int i = 0; i < grid.length; i++) {
                Arrays.fill(grid[i], -1);
            }
            int x = 0, y = 0;
            for (int i = 0; i < times.length; i++) {
                grid[times[i][0]][times[i][1]] = times[i][2];
            }

            //初始化数据
            dist[k] = 0;
            isFind[k] = false;

            int num = 0;

            int cur = 0;
            boolean flag = true;

            int res = 0;
            while (flag) {//循环的条件是每一轮都能找到一个源点，

                flag = false;
                cur = 0;
                for (int i = 1; i <= n; i++) {//寻找源点
                    if (!isFind[i] && dist[i] < dist[cur]) {
                        cur = i;
                        flag = true;
                    }
                }
                if (!flag) {//找不到可以用的最小的点就停止循环
                    break;
                }
                res = Math.max(dist[cur], res);
                isFind[cur] = true;
                num++;
                for (int i = 1; i <= n; i++) {//从源点除法的所有的点
                    if (grid[cur][i] != -1 && dist[cur] + grid[cur][i] < dist[i]) {
                        dist[i] = dist[cur] + grid[cur][i];
                    }
                }
            }
            return num == n ? res : -1;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}