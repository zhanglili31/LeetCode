package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;
import com.zhanglili31.leetCode.editor.cn.utils.CreateArray;

import java.util.Arrays;

//604 迭代压缩字符串
//2022-05-20 21:10:51
class DesignCompressedStringIterator {

    public static void main(String[] args) {
//        Solution solution = new DesignCompressedStringIterator().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        String testStr = "hello";
        String strArray[] = {"wrt", "wrf"};
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
        int temp[] = CreateArray.getArray(20, 100);
        System.out.println(Arrays.toString(temp));
//        System.out.println(solution);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class StringIterator {
        String compressedString = null;
        int num;
        char ch;
        int po=0;

        public StringIterator(String compressedString) {
            this.compressedString = compressedString;
        }

        public char next() {
            if (hasNext()) {
                num--;
                return ch;
            }else{
                return ' ';
            }

        }

        public boolean hasNext() {
            if(num>0)return true;
            //记录下一个字符
            if (po < compressedString.length()) {
                ch = compressedString.charAt(po++);
            }
            //计算下一个字符的数量
            while (po < compressedString.length()&&compressedString.charAt(po)>='0'&&compressedString.charAt(po)<='9') {
                num*=10;
                num += compressedString.charAt(po++) - '0';
            }
            return num != 0;

        }
    }

/**
 * Your StringIterator object will be instantiated and called as such:
 * StringIterator obj = new StringIterator(compressedString);
 * char param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
//leetcode submit region end(Prohibit modification and deletion)

}