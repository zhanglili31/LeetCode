package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.Arrays;

//681 最近时刻
//2022-06-01 02:32:38
class NextClosestTime {

    public static void main(String[] args) {
        Solution solution = new NextClosestTime().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        String testStr = "hello";
        String strArray[] = {"wrt", "wrf"};
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
//        int temp[] = CreateArray.getArray(20, 100);
        int temp[] = {5, 3, 2, 2};
        System.out.println(Arrays.toString(temp));
        System.out.println(solution.nextClosestTime("23:59"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        String ans = null;
        int min = Integer.MAX_VALUE;

        public String nextClosestTime(String time) {
            char[] ch = new char[4];
            ch[0] = time.charAt(0);
            ch[1] = time.charAt(1);
            ch[2] = time.charAt(3);
            ch[3] = time.charAt(4);
            Arrays.sort(ch);
            DFS(new StringBuilder(), ch, 0, time);
            System.out.println(min);
            return ans;
        }

        public void DFS(StringBuilder str, char[] ch, int k, String time) {
            if (k == 2) {
                str.append(":");
            }
            if (k == 4) {
                int init = count(time);
                int curTime = count(str.toString());
                int res = 0;
                if (curTime < init) {
                    res = 24 * 60 - init + curTime;
                } else {
                    res = curTime - init;
                }
                if (res == 0 && 24 * 60 < min) {
                    ans = str.toString();
                    min = 12 * 60;
                } else if (res < min && res != 0) {
                    ans = str.toString();
                    min = res;
                }
                return;
            }
            for (int i = 0; i < ch.length; i++) {
                if (k == 0 && ch[i] > '2') {
                    continue;
                }
                if (k == 1 && ch[i] > '3' && str.charAt(0) == '2') {
                    continue;
                }
                if (k == 2 && ch[i] > '5') {
                    continue;
                }
                str.append(ch[i]);
                DFS(str, ch, k + 1, time);
                str.delete(str.length() - 1, str.length());
            }
            if (k == 2) {
                str.delete(str.length() - 1, str.length());
            }
        }

        public int count(String time) {
            int min = Integer.parseInt(time.substring(3, 5));
            int hour = Integer.parseInt(time.substring(0, 2));
            return hour * 60 + min;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}