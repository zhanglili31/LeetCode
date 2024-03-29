package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

//28实现 strStr()
//2021-03-11 22:12:04
class ImplementStrstr {
    public static void main(String args) {
        Solution solution = new ImplementStrstr().new Solution();
        TreeNode r = CreateTree.deserialize("[5,4,2,3,3,7]");

        System.out.println(solution);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int strStr(String haystack, String needle) {
            List<int[]> ans = KMP(haystack, needle);
            if (ans.size() == 0) {
                return -1;
            } else {
                return ans.get(0)[0];
            }


        }

        public List<int[]> KMP(String s, String p) {
            List<int[]> ans = new ArrayList<>();
            int sLen = s.length();
            int pLen = p.length();
            int[] prefixTable = createPrefixTable(p);
            int pPoints = 0;
            int sPoints = 0;
            //结束的条件就是：
            char cs = ' ';
            char cp = ' ';
            while (sPoints < sLen && pPoints < pLen && sLen - sPoints >= pLen - pPoints) {//
                cs = s.charAt(sPoints);
                cp = p.charAt(pPoints);
                if (cs == cp) {
                    if (pPoints + 1 == pLen) {
                        ans.add(new int[]{sPoints - pLen + 1, sPoints});
                        if (pPoints <= 0) {
                            sPoints++;
                        }
                        pPoints = pPoints > 0 ? prefixTable[pPoints - 1] : 0;
                        if (pPoints < 0) {
                            sPoints++;
                            pPoints = 0;
                        }
                    } else {
                        sPoints++;
                        pPoints++;
                    }

                } else {
                    pPoints = prefixTable[pPoints];
                    if (pPoints < 0) {
                        sPoints++;
                        pPoints = 0;
                    }
                }


            }
            return ans;
        }

        //构造p模式串的前缀表
        //构造的思路：对于p的每一个子串（从0开始，到第i个字符结束，i从1到p.length-1），获取字串的最长相等前后缀。
        //例如：aaaa 的最长就是：aaa和aaa ，长度是3
        public int[] createPrefixTable(String p) {
            if (p.length() == 0)
                return null;
            int[] prefixTable = new int[p.length()];
            prefixTable[0] = -1;
            for (int i = 2; i < p.length(); i++) {//i表示p的字串的长度
                String sub = p.substring(0, i);
                for (int j = i - 1; j > 0; j--) {//j表示p的字串的最长前缀的长度，
                    String prefix = sub.substring(0, j);
                    String suffix = sub.substring(sub.length() - j, sub.length());//后缀的截取
                    if (prefix.equals(suffix)) {
                        prefixTable[i] = j;
                        break;
                    }
                }
            }
            return prefixTable;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
//