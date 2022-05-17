package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateArray;
import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.*;

//531 孤独像素 I
//2022-05-17 20:09:50
class LonelyPixelI {

    public static void main(String[] args) {
        Solution solution = new LonelyPixelI().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        String testStr = "hello";
        String strArray[] = {"wrt", "wrf"};
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
        int temp[] = CreateArray.getArray(20, 100);
        System.out.println(Arrays.toString(temp));
        System.out.println(solution);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findLonelyPixel(char[][] picture) {
            int row[] = new int[picture.length];
            int col[] = new int[picture[0].length];
            List<int[]> list = new ArrayList<>();
            for (int i = 0; i < picture.length; i++) {
                for (int j = 0; j < picture[0].length; j++) {
                    if (picture[i][j] == 'B') {
                        row[i]++;
                        col[j]++;
                        list.add(new int[]{i, j});
                    }
                }
            }
            int ans = 0;
            for (int i = 0; i < row.length; i++) {
                for (int j = 0; j < col.length; j++) {
                    if(row[i]!=1)break;
                    if (col[j] == 1&&picture[i][j]=='B') {
                        ans++;
                    }
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}