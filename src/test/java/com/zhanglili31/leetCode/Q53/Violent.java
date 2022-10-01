package com.zhanglili31.leetCode.Q53;

import com.zhanglili31.leetCode.Q53_最大子序和1_暴力.Solution;

public class Violent {
    private static volatile Violent violent;

    public Violent getViolent() {
        if (violent == null) {
            synchronized (Violent.class) {
                if (violent == null) {
                    violent = new Violent();
                }
            }
        }
        return violent;

    }

    public static void main() {
        int[] a = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        Solution solution = new Solution();
        int res = solution.maxSubArray(a);
        System.out.println(res);

    }
}
