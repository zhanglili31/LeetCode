package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.Arrays;

//393 UTF-8 编码验证
//2022-03-13 19:24:29
class Utf8Validation {

    public static void main(String[] args) {
        Solution solution = new Utf8Validation().new Solution();
        TreeNode root = CreateTree.deserialize("[1,1,1,1,1,0,0,0,1,null,0,1,1,null,1,null,null,null,null,null,null,null,null,null,null,null,null]");
        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        String testStr = "hello";
        int temp[] = {228,189,160,229,165,189,13,10};
        System.out.println(solution.validUtf8(temp));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean validUtf8(int[] data) {
            boolean res = true;
            int i = 0;

            while (i < data.length) {
                int byte1 = 128;
                int bytes = 0;
                if((data[i]&128)==0){
                    bytes=1;
                }else{
                    for (int j = 0; j < 8; j++) {

                        if ((data[i] & byte1) != 0){
                            bytes++;
                        }else{
                            break;
                        }
                        byte1 >>= 1;
                    }
                    if(bytes<=1)return false;
                }
                if (bytes > 4)
                    return false;
                int[] copy = new int[bytes];
                if(i+bytes>data.length)return false;
                System.arraycopy(data, i, copy, 0,
                        bytes);
                if (!validUtf82(copy)) {
                    return false;
                }
                i += bytes;
            }
            return res;
        }

        public boolean validUtf82(int[] data) {
            int byte1 = 128;
            boolean res = false;
            int num = data[0];
            if ((byte1 & num) == 0) {
                res = true;
                for (int i = 1; i < data.length; i++) {
                    if ((byte1 & data[i]) != 0) {
                        res = false;
                        break;
                    }
                }
            } else {
                int bytes = 0;
                for (int i = 0; i < 8; i++) {
                    if ((data[0] & byte1) != 0) {
                        bytes++;
                    } else {
                        break;
                    }
                    byte1 >>= 1;
                }
                if (bytes > 4)
                    return false;
                int isZero = 128;
                isZero >>= bytes;
                if ((data[0] & isZero) != 0) {
                    return false;
                }
                res = true;
                for (int i = 1; i < data.length; i++) {
                    if (((data[i] & 128) == 128 && (data[i] & 64) != 64)) {
                        continue;
                    } else {
                        return false;
                    }
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}