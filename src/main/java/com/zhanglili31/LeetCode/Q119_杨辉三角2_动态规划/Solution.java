package com.zhanglili31.LeetCode.Q119_杨辉三角2_动态规划;
import java.util.ArrayList;
import java.util.List;
//c(k,i)=c(k,i-1)*(k-i+1)/i
public class Solution {
    public List<Integer> getRow(int rowIndex) {
        int k = rowIndex;
        List<Integer> l = new ArrayList<Integer>();
        l.add(1);
        long pre = 1;
        for (int i = 1; i <= rowIndex; i++) {
            long cur = pre * (k - i + 1) / i;
            l.add((int) cur);
            pre = cur;
        }
        return l;
    }
}
