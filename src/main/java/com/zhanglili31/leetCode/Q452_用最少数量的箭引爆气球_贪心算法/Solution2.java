package com.zhanglili31.leetCode.Q452_用最少数量的箭引爆气球_贪心算法;

import java.util.Arrays;
//优秀之处，
//1 使用lambda表达式，并且使用了Arrays.sort的方法进行排序
//2 使用一层循环解决问题
public class Solution2 {
    public int findMinArrowShots(int[][] points) {
        //边界条件判断
        if (points == null || points.length == 0)
            return 0;
        //按照每个气球的右边界排序
        Arrays.sort(points, (a, b) -> a[1] > b[1] ? 1 : -1);
        //获取排序后第一个气球右边界的位置，我们可以认为是箭射入的位置
        int last = points[0][1];
        //统计箭的数量
        int count = 1;
        for (int i = 1; i < points.length; i++) {
            //如果箭射入的位置小于下标为i这个气球的左边位置，说明这支箭不能
            //击爆下标为i的这个气球，需要再拿出一支箭，并且要更新这支箭射入的
            //位置
            if (last < points[i][0]) {
                last = points[i][1];
                count++;
            }
        }
        return count;
    }
//
//    作者：sdwwld
//    链接：https://leetcode-cn.com/problems/minimum-number-of-arrows-to-burst-balloons/solution/yong-zui-shao-shu-liang-de-jian-yin-bao-qi-qiu-tu-/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}
