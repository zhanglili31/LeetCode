package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateArray;
import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.Arrays;

//533 孤独像素 II
//2022-05-17 20:54:18
class LonelyPixelIi {

    public static void main(String[] args) {
        Solution solution = new LonelyPixelIi().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        String testStr = "hello";
        String strArray[] = {"wrt", "wrf"};
        char[][] charArray = {{'W','B','W','B','B','W'},{'W','B','W','B','B','W'},{'W','B','W','B','B','W'},{'B','W','B','W','W','B'}};
        int temp[] = CreateArray.getArray(20, 100);
        System.out.println(Arrays.toString(temp));
        System.out.println(solution.findBlackPixel(charArray, 3));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        class Union {
            int fa[];
            int rank[];

            Union(int n) {
                fa = new int[n + 1];
                rank = new int[n + 1];
                for (int i = 0; i <= n; i++) {
                    fa[i] = i;
                }
            }

            int find(int x) {
                return fa[x] = fa[x] == x ? x : find(fa[x]);
            }

            void merge(int i, int j) {
                int x = find(i);
                int y = find(j);
                if (rank[x] <= rank[y]) {//y的长度大于x,x放在y的下面，这样他们的rank都不会被改变。否则长的放在短的下面，短的那个rank=本身自己+新增的长的那个的和
                    fa[x] = y;
                }else{
                    fa[y]=x;
                }
                if (rank[x] == rank[y] && x != y) {//rank都一样，那么变为头的那个，rank+1即可。
                    rank[y]++;
                }
            }
        }

        public int findBlackPixel(char[][] picture, int target) {
            int row[] = new int[picture.length];
            int col[] = new int[picture[0].length];
            Union union = new Union(picture.length);
            int []fa=union.fa;
            int ans = 0;
            for (int i = 0; i < picture.length; i++) {
                for (int j = 0; j < picture[0].length; j++) {
                    if (picture[i][j] == 'B') {
                        row[i]++;
                        col[j]++;
                    }
                }
            }

            for (int i = 0; i < picture.length - 1; i++) {
                for (int j = i + 1; j < picture.length; j++) {
                    boolean flag = true;
                    for (int k = 0; k < picture[0].length && flag; k++) {
                        if (picture[i][k] != picture[j][k]) {
                            flag = false;
                        }
                    }
                    if (flag) {
                        union.merge(i, j);
                    }
                }
            }


            for (int i = 0; i < row.length; i++) {
                for (int j = 0; j < col.length; j++) {
                    if (row[i] == target && col[j] == target&&picture[i][j]=='B') {
                        int last = -1;
                        int n = 0;
                        for (int k = 0; k < picture.length; k++) {
                            if (picture[k][j] == 'B') {
                                if (last == -1) {
                                    last = k;
                                    n++;
                                } else {
                                    if (union.find(last) == union.find(k)) {
                                        last = k;
                                        n++;
                                    } else {
                                        break;
                                    }
                                }
                            }
                        }
                        if (n == target) {
                            ans += 1;
                        }
                    }
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}