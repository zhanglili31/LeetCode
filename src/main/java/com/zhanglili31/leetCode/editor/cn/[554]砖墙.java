package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateListNode;
import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.ListNode;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//554 砖墙
//2022-10-01 13:30:09
class BrickWall {

    public static void main(String[] args) {
        int dir8[][] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
        int dir4[][] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Solution solution = new BrickWall().new Solution();
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
        public int leastBricks(List<List<Integer>> wall) {
            int n = wall.size();
            int maxGapNum = 0;
            Map<Long, Integer> map = new HashMap<>();
            for (int i = 0; i < wall.size(); i++) {
                List<Integer> temp = wall.get(i);
                long sum = 0;
                for (int j = 0; j < temp.size() - 1; j++) {
                    sum += temp.get(j);
                    int num = map.getOrDefault(sum, 0) + 1;
                    map.put(sum, num);
                    maxGapNum = Math.max(maxGapNum, num);
                }
            }
            return n - maxGapNum;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}