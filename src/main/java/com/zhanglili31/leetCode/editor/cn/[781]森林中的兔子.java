package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateListNode;
import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.ListNode;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

//781 森林中的兔子
//2022-09-17 11:48:52
class RabbitsInForest {

    public static void main(String[] args) {
        int dir8[][] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
        int dir4[][] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Solution solution = new RabbitsInForest().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        ListNode listNode = CreateListNode.stringToListNode("[1,2,3]");
        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        String testStr = "hello";
        String strArray[] = {"wrt", "wrf"};
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
//        int temp[] = CreateArray.getArray(20, 100);
        int temp[] = {0, 1, 0, 2, 0, 1, 0, 2, 1, 1};
        System.out.println(Arrays.toString(temp));
        System.out.println(solution.numRabbits(temp));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //参考思路：https://leetcode.cn/problems/rabbits-in-forest/solution/gong-shui-san-xie-noxiang-xin-ke-xue-xi-v17p5/
        public int numRabbits(int[] answers) {
            Map<Integer, Integer> map = new HashMap<>();
            int sum = 0;
            for (int i = 0; i < answers.length; i++) {
                if (answers[i] != 0) {
                    map.put(answers[i], map.getOrDefault(answers[i], 0) + 1);
                } else {
                    sum++;
                }

            }
            Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<Integer, Integer> entry = iterator.next();
                int key = entry.getKey();
                int value = entry.getValue();
                if (value <= key + 1) {
                    sum += key + 1;
                } else {
                    sum += (value / (key + 1)) * (key + 1);
                    sum += value % (key + 1) != 0 ? (key + 1) : 0;
                }
            }
            return sum;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}