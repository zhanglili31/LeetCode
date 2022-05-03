package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;
import com.zhanglili31.leetCode.editor.cn.utils.CreateArray;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

//157 用 Read4 读取 N 个字符
//2022-05-04 05:54:09
class ReadNCharactersGivenRead4 {

    public static void main(String[] args) {
        Solution solution = new ReadNCharactersGivenRead4().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        String testStr = "hello";
        int temp[] = CreateArray.getArray(20, 100);
        System.out.println(Arrays.toString(temp));
        System.out.println(solution);
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * The read4 API is defined in the parent class Reader4.
     * int read4(char[] buf4);
     */
    class Reader4 {
        public int read4(char[] buf4) {
            return 0;

        }
    }

    public class Solution extends Reader4 {
        /**
         * @param buf Destination buffer
         * @param n   Number of characters to read
         * @return The number of actual characters read
         */
        public int read(char[] buf, int n) {
            int num = 4;
            int times = n / num;
            int last = n % num;
            int res = 0;
            char[] buffer = new char[num];
            int count = 0;
            for (int i = 0; i < times; i++) {
                count = read4(buffer);
                for (int j = i * 4; j < i * 4 + count; j++) {
                    buf[j] = buffer[j - i * 4];
                }
                res += count;
                if (count < 4) {
                    return res;
                }
            }
            count = read4(buffer);
            if (count > 0) {
                for (int i = 0; i < Math.min(last, count); i++) {
                    buf[res++] = buffer[i];
                }
            }
            System.out.println(res);
            return res;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}