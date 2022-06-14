package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;

//1244 力扣排行榜
//2022-06-14 16:49:39
class DesignALeaderboard {

    public static void main(String[] args) {
//        Solution solution = new DesignALeaderboard().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        String testStr = "hello";
        String strArray[] = {"wrt", "wrf"};
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
//        int temp[] = CreateArray.getArray(20, 100);
        int temp[] = {5, 3, 2, 2};
        System.out.println(Arrays.toString(temp));
        Leaderboard leaderboard=new Leaderboard();
        leaderboard.addScore(1, 4);
        leaderboard.addScore(2, 5);
        leaderboard.addScore(1, 2);
//        System.out.println(solution);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    static class Leaderboard {
        class Node {
            int score;
            int playerId;
            Node next;

            public Node( int playerId,int score) {
                this.score = score;
                this.playerId = playerId;
            }
        }

        LinkedList<Node> list = new LinkedList<>();




        public void addScore(int playerId, int score) {
            if (list.size() == 0) {
                list.add(new Node(playerId, score));
                return;
            }
            int left = 0;
            int right = list.size() - 1;
            Node node = new Node(playerId, score);
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).playerId == playerId) {
                    node.score = list.get(i).score+score;
                    list.remove(i);
                    break;
                }
            }
            int j = list.size()-1;
            for (; j >= 0; j--) {
                if (list.get(j).score >= node.score) {
                    break;
                }
            }
            if (j == -1) {
                list.add(0, node);
            } else {
                list.add(j + 1, node);
            }
            System.out.println(list);

        }

        public int top(int K) {
            int sum = 0;
            for (int i = 0; i < K; i++) {
                sum += list.get(i).score;
            }
            return sum;

        }

        public void reset(int playerId) {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).playerId == playerId) {
                    list.remove(i);
                }
            }

        }
    }

/**
 * Your Leaderboard object will be instantiated and called as such:
 * Leaderboard obj = new Leaderboard();
 * obj.addScore(playerId,score);
 * int param_2 = obj.top(K);
 * obj.reset(playerId);
 */
//leetcode submit region end(Prohibit modification and deletion)

}