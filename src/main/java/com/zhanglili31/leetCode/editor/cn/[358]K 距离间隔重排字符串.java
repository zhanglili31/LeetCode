package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateArray;
import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//358 K 距离间隔重排字符串
//2022-05-12 11:40:43
class RearrangeStringKDistanceApart {

    public static void main(String[] args) {
        Solution solution = new RearrangeStringKDistanceApart().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        String testStr = "aabbcc";
        String strArray[] = {"wrt", "wrf"};
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
        int temp[] = CreateArray.getArray(20, 100);
        System.out.println(Arrays.toString(temp));
        System.out.println(solution.rearrangeString(testStr, 2));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String rearrangeString(String s, int k) {
            Map<Character, Integer> map1 = new HashMap<>();
            Map<Integer, Character> map2 = new HashMap<>();
            StringBuilder strB = new StringBuilder();
            int len = 0;//s的字符位置
            int i = 0;
            for (; len < s.length(); len++) {
                if (map2.containsKey(len)) {
                    strB.append(map2.get(len));
                    map1.put(map2.get(len), len);
                    map2.remove(len);
                } else {
                    for (; i < s.length(); i++) {
                        char ch = s.charAt(i);
                        int last = map1.getOrDefault(ch, -7 * 100000);
                        if (len - last >= k) {
                            strB.append(ch);
                            map1.put(ch, len);
                            i++;
                            break;
                        } else {
                            map2.put(k+map1.get(ch), ch);
                        }

                    }
                }

            }

            return map2.size() == 0 ? strB.toString() : "";
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}