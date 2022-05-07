package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;
import com.zhanglili31.leetCode.editor.cn.utils.CreateArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//271 字符串的编码与解码
//2022-05-08 04:35:08
class EncodeAndDecodeStrings {

    public static void main(String[] args) {
//        Solution solution = new EncodeAndDecodeStrings().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        String testStr = "hello";
        String strArray[] = {"wrt", "wrf", "er"};
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
        int temp[] = CreateArray.getArray(20, 100);
        System.out.println(Arrays.toString(temp));
        List<String> array = new ArrayList<>();
        array.add("helloworld");
//        new Codec().encode(array);
//        System.out.println(solution);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Codec {

        // Encodes a list of strings to a single string.
        public String encode(List<String> strs) {
            StringBuilder strB = new StringBuilder();
            for (int i = 0; i < strs.size(); i++) {
                String temp = strs.get(i);
                String len = String.valueOf(Integer.toHexString(temp.length()));
                int addNum = 4 - len.length();
                for (int k = 0; k < addNum; k++) {
                    len = "0" + len;
                }
                strB.append(len);
                strB.append(temp);
            }
            return strB.toString();


        }

        // Decodes a single string to a list of strings.
        public List<String> decode(String s) {
            System.out.println(s);
            List<String> res = new ArrayList();
            int i = 0;
            while (i < s.length()) {
                String strLen = s.substring(i, i + 4);
                int len = 0;
                for (int k = 0; k < 4; k++) {
                    len = len * 16;
                    char ch = strLen.charAt(k);
                    if (ch <= '9') {
                        len += ch - '0';
                    } else {
                        len += ch - 'a' + 10;
                    }
                }
                String temp = s.substring(i + 4, i + 4 + len);
                res.add(temp);
                i = i + 4 + len;
            }
            System.out.println(res);
            return res;

        }
    }

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));
//leetcode submit region end(Prohibit modification and deletion)

}