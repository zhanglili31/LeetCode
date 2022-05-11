package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateArray;
import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.*;

//320 列举单词的全部缩写
//2022-05-11 10:17:46
class GeneralizedAbbreviation {

    public static void main(String[] args) {
        Solution solution = new GeneralizedAbbreviation().new Solution();
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
            public List<String> generateAbbreviations(String word) {
                Set<String> res = new HashSet<>();
                if(word.length()>0){
                    res.add(word);
                }
                for (int i = 0; i < word.length(); i++) {
                    for (int j = i + 1; j <= word.length(); j++) {
                        int pre = i - 1;
                        int next = j + 1;
                        String str1 = pre > 0 ? word.substring(0, pre) : "";
                        String str2 = word.substring(i, j);
                        String str3 = next < word.length() ? word.substring(next, word.length()) : "";
                        String mid = String.valueOf(str2.length());
                        mid = pre >= 0 ? String.valueOf(word.charAt(pre)) + mid : mid;
                        mid = j < word.length() ? mid + String.valueOf(word.charAt(j)) : mid;
                        List<String> list1 = generateAbbreviations(str1);
                        List<String> list2 = generateAbbreviations(str3);
                        if (list1.size() == 0 && list2.size() == 0) {
                            res.add(mid);
                        } else if (list2.size() > 0 && list1.size() > 0) {
                            for (int k = 0; k < list1.size(); k++) {
                                for (int l = 0; l < list2.size(); l++) {
                                    res.add(list1.get(k) + mid + list2.get(l));
                                }
                            }
                        } else if (list1.size() > 0) {
                            for (int k = 0; k < list1.size(); k++) {
                                res.add(list1.get(k) + mid);
                            }
                        } else if (list2.size() > 0) {
                            for (int k = 0; k < list2.size(); k++) {
                                res.add(mid+list2.get(k) );
                            }
                        }
                    }
                }
                return new ArrayList<>(res);

            }
        }
//leetcode submit region end(Prohibit modification and deletion)
 
}