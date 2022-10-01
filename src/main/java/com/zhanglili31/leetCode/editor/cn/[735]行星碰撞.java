package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateListNode;
import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.ListNode;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.*;

//735 行星碰撞
//2022-10-02 01:27:33
class AsteroidCollision {

    public static void main(String[] args) {
        int dir8[][] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
        int dir4[][] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Solution solution = new AsteroidCollision().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        ListNode listNode = CreateListNode.stringToListNode("[1,2,3]");
        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        String testStr = "hello";
        String strArray[] = {"wrt", "wrf"};
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
//        int temp[] = CreateArray.getArray(20, 100);
        int temp[] = {-2,-1,1,2};
        System.out.println(Arrays.toString(temp));
        System.out.println(solution.asteroidCollision(temp));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] asteroidCollision(int[] asteroids) {
            Deque<Integer> stack = new LinkedList<>();
            boolean flag = false;
            for (int i = 0; i < asteroids.length; i++) {
                if (asteroids[i] >= 0) {
                    stack.push(asteroids[i]);
                    continue;
                }
                flag = true;
                while (!stack.isEmpty() && stack.peek() >= 0) {
                    int s = stack.peek();
                    int t = Math.abs(asteroids[i]);
                    if (s == t) {//碰完，没有了
                        stack.pop();
                        flag = false;
                        break;
                    } else if (s > t) {//负数碰没了
                        flag = false;
                        break;
                    } else if (s < t) {//正数碰没了
                        stack.pop();
                    }
                }
                if (flag) {
                    stack.push(asteroids[i]);
                }

            }
            int re[] = new int[stack.size()];
            int i=0;
            while (!stack.isEmpty()) {
                re[i] = stack.pollLast();
                i++;
            }
            System.out.println(Arrays.toString(re));
            return re;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}