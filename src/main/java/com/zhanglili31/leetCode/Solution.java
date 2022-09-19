package com.zhanglili31.leetCode;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Solution {
    int a=0;
    String str="";
    List<Integer> list = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Solution))
            return false;
        Solution solution = (Solution) o;
        return a == solution.a && Objects.equals(str, solution.str) && Objects.equals(list, solution.list);
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, str, list);
    }

}
//
