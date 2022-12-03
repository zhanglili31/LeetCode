package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateListNode;
import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.ListNode;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.Arrays;

//611 有效三角形的个数
//2022-12-04 01:15:51
class ValidTriangleNumber {

    public static void main(String[] args) {
        int dir8[][] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
        int dir4[][] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Solution solution = new ValidTriangleNumber().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        ListNode listNode = CreateListNode.stringToListNode("[1,2,3]");
        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        String testStr = "hello";
        String strArray[] = {"wrt", "wrf"};
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
//        int temp[] = CreateArray.getArray(20, 100);
        int temp[] = {4, 2, 3, 4};
        System.out.println(Arrays.toString(temp));
        System.out.println(solution.triangleNumber(temp));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //参考题解：https://leetcode.cn/problems/valid-triangle-number/solution/gong-shui-san-xie-yi-ti-san-jie-jian-dan-y1we/
        //暴力解法
        public int triangleNumber1(int[] nums) {
            Arrays.sort(nums);
            int res = 0;
            for (int i = 0; i < nums.length - 2; i++) {
                for (int j = i + 1; j < nums.length - 1; j++) {
                    for (int k = j + 1; k < nums.length; k++) {
                        if (nums[i] + nums[j] > nums[k]) {
                            res++;
                        }
                    }
                }
            }
            return res;
        }

        //排序+二分
        public int triangleNumber2(int[] nums) {
            Arrays.sort(nums);
            int res = 0;
            for (int i = 0; i < nums.length; i++) {
                for (int j = i - 1; j >= 0; j--) {
                    int start = 0;
                    int end = j - 1;
                    int n = 0;
                    while (start <= end) {
                        int mid = start + (end - start) / 2;
                        if (nums[mid] + nums[j] > nums[i]) {
                            n = Math.max(j - mid, n);
                            end = mid - 1;
                        } else {
                            start = mid + 1;
                        }
                    }
                    res += n;
                }
            }
            return res;
        }

        //双指针
        public int triangleNumber(int[] nums) {
            Arrays.sort(nums);
            int res = 0;
            for (int i = 0; i < nums.length; i++) {
                for (int j = i - 1, k = 0; k<j; j--) {
                    while (k < j && nums[k] + nums[j] <= nums[i]) {
                        k++;
                    }
                    res += j - k;
                }
            }
            return res;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}