package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateListNode;
import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.ListNode;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.Arrays;

//860 柠檬水找零
//2022-10-01 20:33:43
class LemonadeChange {

    public static void main(String[] args) {
        int dir8[][] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
        int dir4[][] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Solution solution = new LemonadeChange().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        ListNode listNode = CreateListNode.stringToListNode("[1,2,3]");
        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        String testStr = "hello";
        String strArray[] = {"wrt", "wrf"};
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
//        int temp[] = CreateArray.getArray(20, 100);
        int temp[] = {5, 5, 5, 10, 5, 5, 5, 5, 5, 5, 10, 20, 20, 20};
        System.out.println(Arrays.toString(temp));
        System.out.println(solution.lemonadeChange(temp));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean lemonadeChange(int[] bills) {
            int[] arr = new int[21];
            for (int i = 0; i < bills.length; i++) {
                int charge = bills[i] - 5;
                arr[bills[i]]++;
                if (charge == 0) {
                    continue;
                } else if (charge == 5) {
                    arr[5]--;
                    if (arr[5] < 0) {
                        return false;
                    }
                } else if (charge == 15) {
                    if (arr[10] - 1 >= 0 && arr[5] - 1 >= 0) {
                        arr[10]--;
                        arr[5]--;
                    } else if (arr[5] - 3 >= 0) {
                        arr[5] -= 3;
                    } else {
                        return false;
                    }
                }

            }
            return true;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}