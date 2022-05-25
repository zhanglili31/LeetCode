package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateArray;
import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.Arrays;

//489 扫地机器人
//2022-05-25 15:26:33
class RobotRoomCleaner {

    public static void main(String[] args) {
//        Solution solution = new RobotRoomCleaner().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        String testStr = "hello";
        String strArray[] = {"wrt", "wrf"};
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
        int temp[] = CreateArray.getArray(20, 100);
        System.out.println(Arrays.toString(temp));
//        System.out.println(solution);
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * // This is the robot's control interface.
     * // You should not implement it, or speculate about its implementation
     * interface Robot {
     * // Returns true if the cell in front is open and robot moves into the cell.
     * // Returns false if the cell in front is blocked and robot stays in the current cell.
     * public boolean move();
     * <p>
     * // Robot will stay in the same cell after calling turnLeft/turnRight.
     * // Each turn will be 90 degrees.
     * public void turnLeft();
     * public void turnRight();
     * <p>
     * // Clean the current cell.
     * public void clean();
     * }
     */
/*
    class Solution {
        *//*
         * DFS遍历每一个角落，遇到不能向左，向右，向前的格子，就回退
         * 问题：如何记录机器人走过的位置，避免机器人重复经过，导致死循环？
         * 解决方案：以机器人的坐标为起点，（0,0）,每次移动生成一个新的坐标，记录新的坐标。使用hashset记录格子，
         * 初始化：机器人四个方向都要走，后续机器人不走后面方向。
         * *//*

        //上 右 下  左   顺时针
        //假设机器人的初始方向上，第一次不许转动，
        int[][] direction = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

        public void cleanRoom(Robot robot) {
            Set<String> set = new HashSet<>();
            DFS(robot, set, 0, 0, 0);

        }

        public void DFS(Robot robot, Set<String> set, int a, int b, int dir) {
            robot.clean();
            set.add(getPosition(a, b));
            for (int i = 0; i < 4; i++) {
                int x = a + direction[dir][0];
                int y = b + direction[dir][1];
                if (!set.contains(getPosition(x, y)) && robot.move()) {
                    DFS(robot, set, x, y, dir);//移动完以后需要向后退，并且恢复方向。
                }
                robot.turnRight();
                dir = (dir + 1) % 4;
            }
            ///////////将机器后退到上一次的格子，并且将机器掉头的原来的方向。
            //掉头
            robot.turnLeft();
            robot.turnLeft();
            //回退一格
            robot.move();
            //再次掉头
            robot.turnLeft();
            robot.turnLeft();
        }

        public String getPosition(int a, int b) {
            return "(" + a + "," + b + ")";
        }
    }*/
//leetcode submit region end(Prohibit modification and deletion)


}