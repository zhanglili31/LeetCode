package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateListNode;
import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.ListNode;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//93 复原 IP 地址
//2022-10-03 12:43:05
class RestoreIpAddresses {

    public static void main(String[] args) {
        int dir8[][] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
        int dir4[][] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Solution solution = new RestoreIpAddresses().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        ListNode listNode = CreateListNode.stringToListNode("[1,2,3]");
        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        String testStr = "hello";
        String strArray[] = {"wrt", "wrf"};
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
//        int temp[] = CreateArray.getArray(20, 100);
        int temp[] = {5, 3, 2, 2};
        System.out.println(Arrays.toString(temp));
        System.out.println(solution.restoreIpAddresses("25525511135"));

//        System.out.println("0".compareTo("000"));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> restoreIpAddresses(String s) {
            List<String> result = new ArrayList<String>();
            DFS(result, new ArrayList<>(), s, 0);
            return result;

        }

        private void DFS(List<String> res, List<String> cur, String s, int index) {
            if (cur.size() == 4) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < cur.size(); i++) {
                    sb.append(cur.get(i));
                    sb.append(".");
                }
                sb.setLength(sb.length() - 1);
                res.add(sb.toString());
                return;
            }
            if (cur.size() == 3) {
                String sub = s.substring(index);
                if (isValid(sub)) {
                    cur.add(sub);
                    DFS(res, cur, s, index + sub.length());
                    cur.remove(cur.size() - 1);
                }
                return;
            }
            for (int i = index; i <= index + 2 && i < s.length(); i++) {
                String sub = s.substring(index, i + 1);
                if (isValid(sub)) {
                    cur.add(sub);
                    DFS(res, cur, s, index + sub.length());
                    cur.remove(cur.size() - 1);
                } else {
                    break;
                }
            }
        }

        private boolean isValid(String s) {
            if (s.length() > 3) {
                return false;
            }
            try {
                int val = Integer.valueOf(s);
                String v = String.valueOf(val);
                return val >= 0 && val <= 255 && v.length() == s.length();
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}