package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.*;

//1088 易混淆数 II
//2022-06-09 08:49:50
class ConfusingNumberIi {

    public static void main(String[] args) {
        Solution solution = new ConfusingNumberIi().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        String testStr = "hello";
        String strArray[] = {"wrt", "wrf"};
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
//        int temp[] = CreateArray.getArray(20, 100);
        int temp[] = {5, 3, 2, 2};
        System.out.println(Arrays.toString(temp));
        System.out.println(solution.confusingNumberII(1000000000));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //暴力
        Map<Character, Character> map = new HashMap<>();

        {
            map.put('0', '0');
            map.put('1', '1');
            map.put('6', '9');
            map.put('9', '6');
            map.put('8', '8');
        }

        int count = 0;

        public int confusingNumberII2(int n) {
            int ans = 0;
            for (int i = 1; i <= n; i++) {
                String digits = String.valueOf(i);
                int confusingNumberII = getConfusionNumber(digits);
                if (confusingNumberII == -1 || confusingNumberII == i) {
                    continue;
                } else {
                    ans++;
                }
            }
            return ans;
        }

        private int getConfusionNumber(String digits) {
            StringBuilder str = new StringBuilder(digits);
            str = str.reverse();
            for (int i = 0; i < digits.length(); i++) {
                char ch = str.charAt(i);
                if (ch == '2' || ch == '3' || ch == '4' || ch == '5' || ch == '7') {
                    return -1;
                } else {
                    str.setCharAt(i, map.get(ch));
                }
            }
            return Integer.parseInt(str.toString());
        }

        int[] nums = new int[]{0, 1, 6, 8, 9};
        int[] revs = new int[]{0, 1, 9, 8, 6};
        int n;

        public int confusingNumberII(int n) {
            this.n = n;
            DFS(0, 0, 0);
            return count;


        }

        private void DFS(int cur, int rev, int digits) {
            if (cur > n) {
                return;
            }
            if (cur != rev) {
                count++;
            }
            for (int i = 0; i < nums.length; i++) {
                if (i == 0 && cur == 0)
                    continue;
                if (cur > n / 10) {
                    return;
                }
                int nextCur = cur * 10 + nums[i];
                int nextRev = revs[i] * ((int) Math.pow(10, digits)) + rev;
                DFS(nextCur, nextRev, digits + 1);

            }
        }


        //

        public List<String>[] DFS(int nums[], int[] revs, int k, int n, HashSet<Integer> set) {
            List<String> ans[] = new List[2];
            ans[0] = new ArrayList<>();
            ans[1] = new ArrayList<>();
            if (k > 1) {
                List<String>[] sub = DFS(nums, revs, k - 1, n, set);
                for (int i = 0; i < nums.length; i++) {
                    for (int j = 0; j < sub[0].size(); j++) {
                        String str = sub[0].get(j) + nums[i];
                        String revsStr = revs[i] + sub[1].get(j);
                        ans[0].add(str);
                        ans[1].add(revsStr);
                        int combined = Integer.parseInt(str);
                        if (combined <= n && !set.contains(combined) && combined != Integer.parseInt(revsStr)) {
//                            System.out.println(k + " " + str);
                            count++;
                        }
                        set.add(combined);
                    }
                }
            } else {
                for (int i = 0; i < nums.length; i++) {
                    String str = "" + nums[i];
                    String revsStr = revs[i] + "";
                    ans[0].add(str);
                    ans[1].add(revsStr);
                    if (nums[i] != revs[i]) {
//                        System.out.println(k + " " + nums[i]);
                        count++;
                    }
                    set.add(nums[i]);
                }


            }

            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}