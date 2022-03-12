package com.zhanglili31.leetCode.Q76_最小覆盖字串_滑动窗口;

import java.util.HashMap;
import java.util.Map;
//没有完全通过，也排查不出问题。
//如何记录滑动窗口的过程中，每个字符的个数，使用hashmap。
//如何判断当前的窗口是否完整的包含了t的字符？
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().minWindow("A", "AA"));

    }
    public String minWindow(String s, String t) {
        int left = 0;
        int right = 0;
        int containCharNums=0;
        int tnums=0;
        Map<Character,Long> smap=new HashMap();
        Map<Character,Long> tmap=new HashMap();
        Long tmp=0l;
        //计算字符中不同字母的个数，以及单个字母的个数
        for (int i = 0; i < t.length(); i++) {
            tmp=tmap.get(t.charAt(i));
            if ( tmp!=null) {
                tmap.put(t.charAt(i),++tmp);
            }else{
                tmap.put(t.charAt(i),1l);
                tnums++;
            }
        }
        Long tmpR=null;
        Long tmpL=null;
        Long stmp=null;
        String res="";
         for(;left<s.length();){
            if(containCharNums==tnums){
                if ("".equals(res) || (!"".equals(res) && res.length() > right - left )) {
                    res=s.substring(left,right);
                }
                tmpL = smap.get(s.charAt(left));
                if (tmpL != null) {
                    tmpL--;
                    if(tmpL>0){
                        smap.put(s.charAt(left), tmpL);
                    }else{
                        smap.remove(s.charAt(left));
                    }
                    if(tmpL<tmap.get(s.charAt(left))){
                        containCharNums--;
                    }
                }
                left++;
            }else{
                if(right==s.length())break;//右边已经走到底，左边也是走到最小了，这时候应该退出了。
                tmpR=tmap.get(s.charAt(right));
                if(tmpR==null){//t不含该字符
                    right++;
                    continue;//继续向右
                }else{//t含有该字符
                    stmp = smap.get(s.charAt(right));
                    if(stmp!=null){
                        stmp++;
                        smap.put(s.charAt(right), stmp);
                        if(stmp==tmpR){//只有刚好相等的时候才需要将当前窗口包含的字符加一
                            containCharNums++;
                        }
                    }else{
                        smap.put(s.charAt(right),1l);
                        if(1==tmpR){//只有刚好相等的时候才需要将当前窗口包含的字符加一
                            containCharNums++;
                        }
                    }
                }
                right++;
            }
        }
        return res;
    }
}
