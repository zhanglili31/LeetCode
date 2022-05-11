package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;
import com.zhanglili31.leetCode.editor.cn.utils.CreateArray;
import java.util.Arrays;
//288 单词的唯一缩写
//2022-05-11 09:46:06
class UniqueWordAbbreviation {

    public static void main(String[] args) {
//        Solution solution = new UniqueWordAbbreviation().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        int [][]a={{1,1,1},{1,0,1},{1,1,1}};
        String testStr="hello";
        String strArray[] = {"wrt","wrf"};
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
        int temp[] = CreateArray.getArray(20, 100);
        System.out.println(Arrays.toString(temp));
//        System.out.println(solution);
    }
    
        //leetcode submit region begin(Prohibit modification and deletion)
        class ValidWordAbbr {
            String dictionary[] = null;
            String abbreviation[] = null;

            public ValidWordAbbr(String[] dictionary) {
                this.dictionary=dictionary;
                this.abbreviation = new String[dictionary.length];
                for (int i = 0; i < dictionary.length; i++) {
                    abbreviation[i] = getAbbreviation(dictionary[i]);
                }
            }

            public boolean isUnique(String word) {
                String abb = getAbbreviation(word);
                boolean res=true;
                for (int i = 0; i < dictionary.length; i++) {
                    if (abbreviation[i].equals(abb)) {
                        if (dictionary[i].equals(word)) {
                            res=true;
                        }else{
                            return false;
                        }
                    }
                }
                return res;

            }

            String getAbbreviation(String str) {
                int strLen=str.length();
                if (strLen< 3) {
                    return str;
                }else{
                    int len=strLen-2;
                    String head = str.substring(0, 1);
                    String tail = str.substring(strLen - 1, strLen);
                    return  head+String.valueOf(len)+tail;
                }
            }
        }

/**
 * Your ValidWordAbbr object will be instantiated and called as such:
 * ValidWordAbbr obj = new ValidWordAbbr(dictionary);
 * boolean param_1 = obj.isUnique(word);
 */
//leetcode submit region end(Prohibit modification and deletion)
 
}