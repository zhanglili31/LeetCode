package com.zhanglili31.leetCode.Q452_用最少数量的箭引爆气球_贪心算法;

public class Solution {
    public static void main(String[] args) {
        int[][] points = {{10, 16}, {2, 8}, {1, 6}, {7, 12}};
        System.out.println(new Solution().findMinArrowShots(points));

    }

    public int findMinArrowShots(int[][] points) {
        int nums = 0;
        int[] tmp = null;
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points.length - 1; j++) {
                if (points[j][1] > points[j + 1][1]) {
                    tmp = points[j];
                    points[j] = points[j + 1];
                    points[j + 1] = tmp;

                }
            }
        }
        //戳破的气球第一个元素用-1表示
        for (int i = 0; i < points.length ; i++) {
            if(points[i][0]==-1)continue;
            for (int j = i + 1; j < points.length; j++) {
                if (points[j][0] != -1 && points[j][0] <= points[i][1]) {
                    points[j][0] = -1;
                }
            }
            nums++;
        }
        return nums;
    }
}
