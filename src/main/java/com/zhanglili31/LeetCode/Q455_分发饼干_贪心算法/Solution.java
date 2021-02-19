package com.zhanglili31.LeetCode.Q455_分发饼干_贪心算法;

import java.util.Arrays;

public class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g,0,g.length);
        Arrays.sort(s,0,s.length);
        int nums=0;
        for(int i=0,j=0;i<g.length&&j<s.length;){
            if(s[j]>=g[i]){
                i++;
                j++;
                nums++;
            }else{
                j++;
            }
        }
        return nums;
    }
}
