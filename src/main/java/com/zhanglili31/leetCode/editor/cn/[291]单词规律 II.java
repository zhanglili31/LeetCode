package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;
import com.zhanglili31.leetCode.editor.cn.utils.CreateArray;

import java.util.*;

//291 单词规律 II
//2022-05-11 09:47:05
class WordPatternIi {

    public static void main(String[] args) {
        Solution solution = new WordPatternIi().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        int [][]a={{1,1,1},{1,0,1},{1,1,1}};
        String testStr="hello";
        String strArray[] = {"wrt","wrf"};
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
        int temp[] = CreateArray.getArray(20, 100);
        System.out.println(Arrays.toString(temp));
        System.out.println(solution);
    }
    
        //leetcode submit region begin(Prohibit modification and deletion)
        class Solution {
            Map<Character, String> map = new HashMap<>();
            Set<String> set = new HashSet<>();
            boolean res = false;

            public boolean wordPatternMatch(String pattern, String s) {
                recursion(pattern, s);
                return res;


            }

            public void recursion(String pattern, String s) {
                if (pattern.length() == 0 && s.length() == 0) {
                    res = true;
                    return;
                }
                if (pattern.length() == 0 || s.length() == 0) {
                    return;
                }
                String str;
                char ch = pattern.charAt(0);
                if (!map.containsKey(ch)) {
                    for (int j = 1; j <= s.length(); j++) {
                        str = s.substring(0, j);
                        String subS = s.substring(j, s.length());
                        String subP = pattern.substring(1, pattern.length());
                        if (set.contains(str)) {
                            continue;
                        }
                        set.add(str);
                        map.put(pattern.charAt(0), str);
                        recursion(subP, subS);
                        set.remove(map.get(ch));
                        map.remove(ch);
                    }
                } else {
                    str = map.get(ch);
                    String subs = str.length()<=s.length()?s.substring(0, str.length()):"";
                    if (str.equals(subs)) {
                        s = s.substring(str.length(), s.length());
                        pattern = pattern.substring(1, pattern.length());
                        recursion(pattern,s);
                    }
                }
            }
        }
//leetcode submit region end(Prohibit modification and deletion)
 
}