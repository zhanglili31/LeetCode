package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateArray;
import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.*;

//353 贪吃蛇
//2022-05-12 07:37:07
class DesignSnakeGame {

    public static void main(String[] args) {
//        Solution solution = new DesignSnakeGame().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        int[][] a = {{2, 0}, {0, 0}, {0, 2}, {0, 1}, {2, 2}, {0, 1}};
        String testStr = "hello";
        String strArray[] = {"wrt", "wrf"};
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
        int temp[] = CreateArray.getArray(20, 100);
        System.out.println(Arrays.toString(temp));
        SnakeGame snakeGame = new SnakeGame(3, 3, a);
        Scanner sc = new Scanner(System.in);
        String[] dir = {"D", "D", "R", "U", "U", "L", "D", "R", "R", "U", "L", "L", "D", "R", "U"};
        int i = 0;
        while (i < dir.length) {
//            String input = sc.nextLine();
            snakeGame.move(dir[i]);
            i++;
        }

//        System.out.println(solution);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    //关键点：先去掉蛇尾，再加蛇头， 需要使用真是变化后的身体长度
    static class SnakeGame {
        Map<String, int[]> dictionMap;
        Set<Integer> bodies;
        LinkedList<int[]> bodyList;
        int[][] food;
        int curFood;
        int width;
        int height;
        int ans = 1;


        public SnakeGame(int width, int height, int[][] food) {
            this.width = width;
            this.height = height;
            this.food = food;
            curFood = 0;
            dictionMap = new HashMap<>();
            dictionMap.put("U", new int[]{-1, 0});
            dictionMap.put("D", new int[]{1, 0});
            dictionMap.put("L", new int[]{0, -1});
            dictionMap.put("R", new int[]{0, 1});

            bodies = new HashSet<>();
            bodies.add(0);

            bodyList = new LinkedList<>();
            bodyList.add(new int[]{0, 0});
        }

        public int move(String direction) {
            if (ans == -1) {
                return ans;
            }
            int dir[] = dictionMap.get(direction);
            int head[] = bodyList.get(0);
            int x = dir[0] + head[0];
            int y = dir[1] + head[1];
            int val = x * width + y;
            if (x >= 0 && x < height && y >= 0 && y < width) {
                int len = bodies.size();
                if (curFood < this.food.length && x == this.food[curFood][0] && y == this.food[curFood][1]) {
                    curFood++;
                    len++;
                } else {
                    int tail[] = bodyList.pollLast();
                    bodies.remove(tail[0] * width + tail[1]);
                }
                if (!bodies.contains(val) || len <= 4) {
                    bodies.add(val);
                    bodyList.addFirst(new int[]{x, y});
                    ans = bodies.size() - 1;
                } else {
                    ans = -1;
                }

            } else {
                ans = -1;
            }
            return ans;
        }
    }

/**
 * Your SnakeGame object will be instantiated and called as such:
 * SnakeGame obj = new SnakeGame(width, height, food);
 * int param_1 = obj.move(direction);
 */
//leetcode submit region end(Prohibit modification and deletion)

}