package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;
import com.zhanglili31.leetCode.editor.cn.utils.CreateArray;
import java.util.Arrays;
//302 包含全部黑色像素的最小矩形
//2022-05-11 10:13:47
class SmallestRectangleEnclosingBlackPixels {

    public static void main(String[] args) {
        Solution solution = new SmallestRectangleEnclosingBlackPixels().new Solution();
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
            //
            int x1 = Integer.MAX_VALUE;//上x
            int x2 = Integer.MIN_VALUE;//下x
            int y1 = Integer.MAX_VALUE;//左y
            int y2 = Integer.MIN_VALUE;//右y
            int hasLooked[][] = null;

            public int minArea(char[][] image, int x, int y) {
                hasLooked = new int[image.length][image[0].length];
                DFS(image, x, y);
                return (x2 - x1 + 1) * (y2 - y1 + 1);

            }

            public void DFS(char[][] image, int x, int y) {
                hasLooked[x][y] = 1;
                x1 = Math.min(x1, x);
                x2 = Math.max(x2, x);
                y1 = Math.min(y1, y);
                y2 = Math.max(y2, y);
                if (x - 1 >= 0 && hasLooked[x - 1][y] == 0 && image[x - 1][y] == '1') {
                    DFS(image, x - 1, y);
                }
                if (x + 1 < image.length && hasLooked[x + 1][y] == 0 && image[x + 1][y] == '1') {
                    DFS(image, x + 1, y);
                }
                if (y - 1 >= 0 && hasLooked[x][y - 1] == 0 && image[x][y - 1] == '1') {
                    DFS(image, x, y - 1);
                }
                if (y + 1 < image[0].length && hasLooked[x][y + 1] == 0 && image[x][y + 1] == '1') {
                    DFS(image, x, y + 1);
                }
            }
        }
//leetcode submit region end(Prohibit modification and deletion)
 
}