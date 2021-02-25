package com.zhanglili31.LeetCode.Q76_最小覆盖字串_滑动窗口;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

//AC
public class Solution2 {
    public static void main(String[] args) {
        System.out.println(new Solution().minWindow("ADOBECODEBANC", "ABC"));

    }

    public String minWindow(String s, String t) {
        int left = 0;
        int right = 0;
        String res = "";
        Map<Character, Integer> smap = new HashMap();
        Map<Character, Integer> tmap = new HashMap();
        Character chL;
        Character chR;

        //计算字符中不同字母的个数，以及单个字母的个数
        for (int i = 0; i < t.length(); i++) {
            tmap.put(t.charAt(i), tmap.getOrDefault(t.charAt(i), 0) + 1);
        }
        for (; left < s.length(); left++) {
            //如果当前的left到right之间的字符传没有找到包含t的字符串，那么继续循环。如果找到了，就停止跳出循环，
            //如果right<s.length,那么就继续循环。
            for (; right < s.length() && !check(smap,tmap); right++) {//left到right之前的字符串没有包含t字符串
                chR = s.charAt(right);
                if (tmap.get(chR) != null) {//
                    smap.put(chR, smap.getOrDefault(chR, 0) + 1);
                }
            }
            if (check(smap,tmap)) {
                if ("".equals(res) || right - left < res.length()) {
                    res = s.substring(left, right);
                }
                chL = s.charAt(left);
                if (smap.containsKey(chL)) {
                    smap.put(chL, smap.get(chL) - 1);
                }
            }
        }
        return res;
    }

    public boolean check(Map smap, Map tmap) {
        Iterator iter = tmap.entrySet().iterator();
        Map.Entry entry = null;
        Character key = null;
        Integer tval = null;
        Integer sval=null;
        while (iter.hasNext()) {
            entry = (Map.Entry) iter.next();
            key = (Character) entry.getKey();
            tval = (Integer) entry.getValue();
            sval = (Integer) smap.getOrDefault(key, 0);
            if(sval<tval) {
                return false;
            }
        }
        return true;
    }
}
