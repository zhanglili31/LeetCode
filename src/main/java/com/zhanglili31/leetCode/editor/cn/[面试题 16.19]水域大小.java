package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateListNode;
import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.ListNode;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.*;

//面试题 16.19 水域大小
//2022-10-20 06:55:45
class PondSizesLcci {

    public static void main(String[] args) {
        int dir8[][] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
        int dir4[][] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Solution solution = new PondSizesLcci().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        ListNode listNode = CreateListNode.stringToListNode("[1,2,3]");
        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        String testStr = "hello";
        String strArray[] = {"wrt", "wrf"};
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
//        int temp[] = CreateArray.getArray(20, 100);
        int temp[] = {5, 3, 2, 2};
        System.out.println(Arrays.toString(temp));
        System.out.println(solution);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] pondSizes(int[][] land) {
            int dir8[][] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
            List<Integer> res = new ArrayList<>();
            Queue<int[]> queue = new LinkedList<int[]>();
            List<int[]> area = new ArrayList<>();
            int m = land.length;
            int n = land[0].length;
            for (int i = 0; i < land.length; i++) {
                for (int j = 0; j < land[i].length; j++) {
                    if (land[i][j] == 0) {
                        area.add(new int[]{i, j});
                    }
                }
            }
            boolean flag[][] = new boolean[land.length][land[0].length];
            for (int i = 0; i < area.size(); i++) {
                int[] source = area.get(i);
                if (flag[source[0]][source[1]]) {
                    continue;
                }
                flag[source[0]][source[1]] = true;
                queue.clear();
                queue.add(source);
                int size = 1;
                while (!queue.isEmpty()) {
                    int[] pos = queue.poll();
                    for (int j = 0; j < dir8.length; j++) {
                        int x = pos[0] + dir8[j][0];
                        int y = pos[1] + dir8[j][1];
                        if (x >= 0 && x < m && y >= 0 && y < n && land[x][y] == 0 && !flag[x][y]) {
                            flag[x][y] = true;
                            size++;
                            queue.add(new int[]{x, y});
                        }
                    }
                }
                res.add(size);
            }
            Collections.sort(res);
            int re[] = new int[res.size()];
            for (int i = 0; i < res.size(); i++) {
                re[i] = res.get(i);
            }
            return re;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}