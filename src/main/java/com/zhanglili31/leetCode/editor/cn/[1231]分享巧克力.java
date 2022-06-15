package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.Arrays;

//1231 分享巧克力
//2022-06-15 18:42:33
class DivideChocolate {

    public static void main(String[] args) {
        Solution solution = new DivideChocolate().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        String testStr = "hello";
        String strArray[] = {"wrt", "wrf"};
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
//        int temp[] = CreateArray.getArray(20, 100);
        int temp[] = {87506,32090,9852,96263,52415,67669,10703,27,98672,48664};
        System.out.println(Arrays.toString(temp));
        System.out.println(solution.maximizeSweetness(temp, 1));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //https://leetcode.cn/problems/divide-chocolate/solution/python3-jing-dian-er-fen-qiu-zui-da-zhi-kxhcd/
//            1、题目要求：将巧克力切分为k次，得到k+1块蛋糕，你获取其中最小的一块。
//            2、每一种切分方式产生的最小一块巧克力的甜度不同，选择甜度最大的方式切分
//            3、甜度值的范围区间一定是在最min(sweetness[i]),avg(sweetness[i])之间，
//            4、因此在以上的范围区间使用二分查找，确保切分的每块蛋糕甜度都是大于等于target，当切分完以后，大于count，这个是满足的，继续二分。
        public int maximizeSweetness(int[] sweetness, int k) {
            int sum = 0;
            int right = 0;
            int left = Integer.MAX_VALUE;
            for (int i = 0; i < sweetness.length; i++) {
                sum += sweetness[i];
                left = Math.min(sweetness[i], left);
            }
            right = sum / (k + 1);
            int count = 0;
            int cur = 0;
            int ans = 0;
            while (left <= right) {
                count = 0;
                int mid = left + (right - left) / 2;
                cur=0;
                for (int i = 0; i < sweetness.length && count < k + 1; i++) {
                    cur += sweetness[i];
                    if (cur >= mid) {
                        count++;
                        cur = 0;
                    }
                }
                if (count < k + 1) {
                    right = mid - 1;
                } else if (count >= k + 1) {
                    ans = mid;
                    left = mid + 1;
                }

            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}