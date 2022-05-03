package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;
import com.zhanglili31.leetCode.editor.cn.utils.CreateArray;

import java.util.Arrays;
import java.util.LinkedList;

//158 用 Read4 读取 N 个字符 II
//2022-05-04 07:33:28
class ReadNCharactersGivenRead4IiCallMultipleTimes {

    public static void main(String[] args) {
        Solution solution = new ReadNCharactersGivenRead4IiCallMultipleTimes().new Solution();
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
        int num = 4;
        LinkedList<Character> cache = new LinkedList<>();

        public int read(char[] buf, int n) {
            int res = 0;
            char[] buffer = new char[num];
            int count = 0;
            int cacheRead = 0;
            if (cache.size() > 0) {
                cacheRead = Math.min(cache.size(), n);
                for (int i = 0; i < cacheRead; i++) {
                    System.out.println(cache);
                    buf[res++] = cache.poll();
                    n--;
                }
            }
            int times = n / num;
            int last = n % num;
            for (int i = 0; i < times; i++) {
                count = read4(buffer);
                for (int j = i * 4; j < i * 4 + count && count > 0; j++) {
                    buf[res++] = buffer[j - i * 4];
                }
                if (count < 4) {
                    return res;
                }
            }

            if (last > 0) {
                count = read4(buffer);
                if (count > 0) {
                    //
                    int couldRead = Math.min(last, count);
                    for (int i = 0; i < couldRead; i++) {
                        buf[res++] = buffer[i];
                        last--;
                    }
                    int left = count - couldRead;
                    for (int i = 0; i < left; i++) {
                        cache.add(buffer[count - left + i]);
                    }

                }
            }

            System.out.println(res);
            return res;
        }

    }

//leetcode submit region end(Prohibit modification and deletion)

}