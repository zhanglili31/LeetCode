package com.zhanglili31.LeetCode.Q118杨辉三角_动态规划;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        new Solution().generate(5);
    }
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> l= new ArrayList<List<Integer>>();
        if(numRows==0)return null;
        if(numRows>=1) {
            List<Integer>t=new ArrayList<Integer>();
            t.add(1);
            l.add(t);
        }
        if (numRows >= 2) {
            List<Integer>t2=new ArrayList<Integer>();
            t2.add(1);
            t2.add(1);
            l.add(t2);
        }
        for (int i = 2; i < numRows; i++) {
            List<Integer>t=new ArrayList<Integer>();
            t.add(1);
            for (int j = 1; j < i; j++) {
                t.add(l.get(i-1).get(j-1)+l.get(i-1).get(j));
            }
            t.add(1);
            l.add(t);
        }
        return l;
    }
}