package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;
import com.zhanglili31.leetCode.editor.cn.utils.CreateArray;

import java.util.Arrays;

//251 展开二维向量
//2022-05-06 03:19:34
class Flatten2dVector {

    public static void main(String[] args) {
//        Solution solution = new Flatten2dVector().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        String testStr = "hello";
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
        int temp[] = CreateArray.getArray(20, 100);
        System.out.println(Arrays.toString(temp));
//        System.out.println(solution);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Vector2D {
        int[][] vec = null;
        int column = 0;
        int[] curArray = null;
        int curPoint = 0;


        public Vector2D(int[][] vec) {
            this.vec = vec;
            if (vec.length > 0)
                curArray = vec[0];
            curPoint = 0;
        }

        public int next() {
            if (hasNext()) {
                return curArray[curPoint++];
            }
            return -1;

        }

        public boolean hasNext() {
            Object temp = this;
            if (curArray != null && curPoint < curArray.length) {
                return true;
            }
            //向下走
            while (column < vec.length) {
                column++;
                if (column >= vec.length) {
                    curArray = null;
                    curPoint = -1;
                    return false;
                }
                if (vec[column].length == 0) {
                    continue;
                } else {
                    curArray = vec[column];
                    curPoint = 0;
                    return true;
                }
            }
            return false;
        }
    }

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D obj = new Vector2D(vec);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
//leetcode submit region end(Prohibit modification and deletion)

}