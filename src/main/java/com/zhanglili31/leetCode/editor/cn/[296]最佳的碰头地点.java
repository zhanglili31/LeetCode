package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateArray;
import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//296 最佳的碰头地点
//2022-05-11 09:54:25
class BestMeetingPoint {

    public static void main(String[] args) {
        Solution solution = new BestMeetingPoint().new Solution();
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
            public int minTotalDistance(int[][] grid) {
                int m = grid.length;
                int n = grid[0].length;
                List<Integer> row = new ArrayList<>();
                List<Integer> col = new ArrayList<>();
                List<int[]> nodes = new ArrayList<>();

                for (int i = 0; i < m; i++) {
                    for (int j = 0; j < n; j++) {
                        if (grid[i][j] == 1) {
                            row.add(i);
                            int temp[] = {i, j};
                            nodes.add(temp);
                        }
                    }
                }
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        if (grid[j][i] == 1) {
                            col.add(i);
                        }
                    }
                }
                int r = getMid(row);
                int c = getMid(col);
                int distance = 0;
                for (int i = 0; i < nodes.size(); i++) {
                    int friend[] = nodes.get(i);
                    distance += Math.abs(r - friend[0]) + Math.abs(c - friend[1]);

                }
                return distance;
            }

            public int getMid(List<Integer> list) {
                if (list.size() == 0)
                    return 0;
                int res = 0;
                if (list.size() % 2 == 1) {
                    res = list.get(list.size() / 2);
                } else {
                    int p = list.size() / 2;
                    res = list.get(p) + list.get(p - 1);
                    res /= 2;
                }
                return res;
            }
        }
//leetcode submit region end(Prohibit modification and deletion)
 
}