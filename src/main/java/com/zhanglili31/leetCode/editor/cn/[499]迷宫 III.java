package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateArray;
import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.*;

//499 迷宫 III
//2022-05-29 01:44:54
class TheMazeIii {

    public static void main(String[] args) {
        Solution solution = new TheMazeIii().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        int[][] a = {{0, 0, 1, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 1, 0}, {1, 1, 0, 1, 1}, {0, 0, 0, 0, 0}};
        String testStr = "hello";
        String strArray[] = {"wrt", "wrf"};
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
        int temp[] = CreateArray.getArray(20, 100);
        System.out.println(Arrays.toString(temp));
        System.out.println(solution.findShortestWay(a, new int[]{0, 4}, new int[]{4, 4}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    //关键点：BFS，计算每一个空地到球的距离
    //对于每一个空地，球可能从四个不同的方向经过，每一个空地的每一个方向都标记，避免重复访问。
    class Solution {
        Map<Integer, Integer> map = new HashMap<>();
        int[][] direction = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        {
            map.put(0, (int) 'u');
            map.put(1, (int) 'd');
            map.put(2, (int) 'l');
            map.put(3, (int) 'r');

            map.put((int) 'u', 0);
            map.put((int) 'd', 1);
            map.put((int) 'l', 2);
            map.put((int) 'r', 3);
        }

        class Node {
            int i;
            int j;
            String path;
            int len = 0;

            public Node(int i, int j, String path, int len) {
                this.i = i;
                this.j = j;
                this.path = path;
                this.len = len;
            }
        }

        public String findShortestWay(int[][] maze, int[] ball, int[] hole) {
            int m = maze.length;
            int n = maze[0].length;
            int dp[][][] = new int[m][n][4];
            String ans = "impossible";
            Queue<Node> queue = new LinkedList<Node>();
            int minPathLength = Integer.MAX_VALUE;
            queue.add(new Node(ball[0], ball[1], "", 0));
            while (!queue.isEmpty()) {
                Node node = queue.poll();
                if (node.i == hole[0] && node.j == hole[1]) {
                    if (minPathLength > node.len) {
                        minPathLength = node.len;
                        ans = node.path;
                    } else if (minPathLength == node.len && ans != null && ans.compareTo(node.path) > 0) {
                        ans = node.path;
                    } else {
                        return ans;
                    }
                } else if(node.path.length() > 0) {
                    dp[node.i][node.j][map.get((int) node.path.charAt(node.path.length() - 1))] = -1;
                }
                if (node.path.length() > 0) {
                    int dir = map.get((int) node.path.charAt(node.path.length() - 1));
                    int[] next = {node.i + direction[dir][0], node.j + direction[dir][1]};
                    if (next[0] >= 0 && next[0] < m && next[1] >= 0 && next[1] < n && maze[next[0]][next[1]] != 1&&dp[next[0]][next[1]][dir] != -1) {
                        queue.add(new Node(next[0], next[1], node.path, node.len + 1));
                        continue;
                    }
                }
                for (int i = 0; i < direction.length; i++) {
                    int next[] = new int[2];
                    next[0] = node.i + direction[i][0];
                    next[1] = node.j + direction[i][1];
                    if (next[0] >= 0 && next[0] < m && next[1] >= 0 && next[1] < n && maze[next[0]][next[1]] != 1 && dp[next[0]][next[1]][i] != -1) {
                        char ch = (char) (int) map.get(i);
                        queue.add(new Node(next[0], next[1], node.path + String.valueOf(ch), node.len + 1));
                    }
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}