package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateArray;
import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.*;

//1057 校园自行车分配
//2022-05-27 19:02:45
class CampusBikes {

    public static void main(String[] args) {
        Solution solution = new CampusBikes().new Solution();
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
        public int[] assignBikes(int[][] workers, int[][] bikes) {
            int ans[] = new int[workers.length];
            int dp[][][] = new int[workers.length][bikes.length][3];
            List<int[]> list = new ArrayList<>();
            for (int i = 0; i < workers.length; i++) {
                for (int j = 0; j < bikes.length; j++) {
                    dp[i][j] = new int[]{i,j,manhattan(workers[i], bikes[j])};
                    list.add(dp[i][j]);
                }
            }
            Set<Integer> ws = new HashSet<>();
            Set<Integer> bs = new HashSet<>();
            list.sort((o1, o2) -> {
                if (o1[2] != o2[2]) {
                    return o1[2] - o2[2];
                } else if (o1[0] != o2[0]) {
                    return o1[0] - o2[0];
                } else if (o1[1] != o2[1]) {
                    return o1[1] - o2[1];
                }
                return 0;
            });
            for (int i = 0; i < list.size(); i++) {
                int[] temp = list.get(i);
                if (!ws.contains(temp[0]) && !bs.contains(temp[1])) {
                    ans[temp[0]] = temp[1];
                    ws.add(temp[0]);
                    bs.add(temp[1]);
                }
            }
            return ans;

        }


        //优先队列。
        public int[] assignBikes2(int[][] workers, int[][] bikes) {
            int ans[] = new int[workers.length];
            int dp[][][] = new int[workers.length][bikes.length][3];
            PriorityQueue<int[]>priorityQueue=new PriorityQueue<>(new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    if(o1[2]!=o2[2]){
                        return o1[2] - o2[2];
                    } else if (o1[0] != o2[0]) {
                        return o1[0] - o2[0];
                    }else if(o1[1] != o2[1]){
                        return o1[1] - o2[1];
                    }
                    return 0;
                }
            });
            for (int i = 0; i < workers.length; i++) {
                for (int j = 0; j < bikes.length; j++) {
                    dp[i][j] = new int[]{i,j,manhattan(workers[i], bikes[j])};
                    priorityQueue.add(dp[i][j]);
                }
            }

            for (int k = 0; k < ans.length; k++) {
                int head[]=priorityQueue.peek();
                ans[head[0]] = head[1];
                for (int i = 0; i < dp.length; i++) {
                    priorityQueue.remove(dp[i][head[1]]);
                }
                for (int j = 0; j < dp[0].length; j++) {
                    priorityQueue.remove(dp[head[0]][j]);
                }

            }
            return ans;
        }

        public int manhattan(int[] w, int[] b) {
            return Math.abs(w[0] - b[0]) + Math.abs(w[1] - b[1]);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}