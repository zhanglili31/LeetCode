package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Comparator;

//1058 最小化舍入误差以满足目标
//2022-06-04 02:15:32
class MinimizeRoundingErrorToMeetTarget {

    public static void main(String[] args) {
        Solution solution = new MinimizeRoundingErrorToMeetTarget().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        String testStr = "hello";
        String strArray[] = {"0.700","2.800","4.900"};
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
//        int temp[] = CreateArray.getArray(20, 100);
        int temp[] = {5, 3, 2, 2};
        System.out.println(Arrays.toString(temp));
        System.out.println(solution.minimizeError(strArray, 8));
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    //参考思路：https://leetcode.cn/problems/minimize-rounding-error-to-meet-target/solution/greedy-by-lizju/
    class Solution {
        int FLOOR = 0;
        int CEIL = 1;
        String ans = "-1";



        public String minimizeError(String[] prices, int target) {
            int v[][] = new int[prices.length][2];
            BigDecimal d[][] = new BigDecimal[prices.length][2];
            int min=0;
            int max=0;
            for (int i = 0; i < prices.length; i++) {
                BigDecimal t = new BigDecimal(prices[i]);
                v[i][FLOOR] = t.intValue();
                BigDecimal del = t.subtract(new BigDecimal(v[i][FLOOR]));

                v[i][CEIL] = del.compareTo(new BigDecimal(0)) > 0 ? v[i][FLOOR] + 1 : v[i][FLOOR];
                d[i][FLOOR] = del;
                d[i][CEIL] = del.compareTo(new BigDecimal(0)) > 0 ? (new BigDecimal(1)).subtract(del) : new BigDecimal(0);
                min += v[i][FLOOR];
                max += v[i][CEIL];
            }
            if (target < min || target > max) {
                return ans;
            }
            int k = target-min;
            Arrays.sort(d, new Comparator<BigDecimal[]>() {
                @Override
                public int compare(BigDecimal[] o1, BigDecimal[] o2) {
                    return o2[0].compareTo(o1[0]);
                }
            });
            BigDecimal res = new BigDecimal(0);
            //先取k个1
            for (int i = 0; i < k; i++) {
                res = res.add(d[i][CEIL]);
            }
            // 剩下的全部选择0
            for (int i = k; i < d.length; i++) {
                res = res.add(d[i][FLOOR]);
            }

            ans= res.toString();
            if (!ans.contains(".")) {
                ans = ans + ".000";
            }
            return ans;
        }
        //DFS超时
        private void DFS(int[][] v, BigDecimal[][] d, int k, int target, BigDecimal delSum, int sum) {
            if (!"-1".equals(ans) || k > v.length) {
                return;
            }
            if (k==v.length&&sum == target) {
                System.out.println(delSum);
                ans=delSum.toString();
                return;
            }
            if (sum >= target) {
                return;
            }
            for (int i = 0; k < v.length && i < v[k].length; i++) {
                sum += v[k][i];
                delSum=delSum.add(d[k][i]);
                DFS(v, d, k + 1, target, delSum, sum);
                sum -= v[k][i];
                delSum=delSum.subtract(d[k][i]);
            }
        }

        public String minimizeError2(String[] prices, int target) {
            int v[][] = new int[prices.length][2];
            double d[][] = new double[prices.length][2];
            for (int i = 0; i < prices.length; i++) {
                double t = Double.parseDouble(prices[i]);
                v[i][FLOOR] = (int) t;
                double del = t - (double) v[i][FLOOR];
                v[i][CEIL] = del > 0 ? v[i][FLOOR] + 1 : v[i][FLOOR];
                d[i][FLOOR] = del;
                d[i][CEIL] = del > 0.0 ? 1 - del : 0.0;
            }
            DFS2(v, d, 0, target, 0.0, 0);
            return ans;
        }

        private void DFS2(int[][] v, double[][] d, int k, int target, double delSum, int sum) {
            if (!"-1".equals(ans) || k > v.length) {
                return;
            }
            if (sum == target) {
                String[] temp = String.valueOf(delSum).split("\\.");
                while (temp[1].length() < 3) {
                    temp[1] += "0";
                }
                ans = temp[0] + "." + temp[1];
                return;
            }
            for (int i = 0; k < v.length && i < v[k].length; i++) {
                sum += v[k][i];
                delSum += d[k][i];
                DFS2(v, d, k + 1, target, delSum, sum);
                sum -= v[k][i];
                delSum -= d[k][i];
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}