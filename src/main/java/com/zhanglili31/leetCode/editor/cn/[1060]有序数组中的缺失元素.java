package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.Arrays;

//1060 有序数组中的缺失元素
//2022-05-26 01:45:37
class MissingElementInSortedArray {

    public static void main(String[] args) {
        Solution solution = new MissingElementInSortedArray().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        String testStr = "hello";
        String strArray[] = {"wrt", "wrf"};
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
        int temp[] ={4,7,9,10};
        System.out.println(Arrays.toString(temp));
        System.out.println(solution.missingElement(temp,50));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int missingElement(int[] nums, int k) {
            int left=0;
            int right=nums.length-1;
            int mid=0;
            //判断是否在区间内
            int in = (nums[right] - nums[left] - 1) - (right - left - 1);
            if ( in< k) {
                //在区间外
                return nums[right]+k-in;
            }
            //在区间内
            while (left < right) {
                mid=left+(right-left)/2;
                if(mid==left)break;
                int n = (nums[mid] - nums[left] - 1) - (mid - left - 1);
                if (n < k) {
                    left=mid;
                    k=k-n;
                }else{
                    right=mid;
                }
            }

            return nums[left]+k;


        }

        public int missingElement2(int[] nums, int k) {
            int th = 0;
            for (int i = 1; i < nums.length; i++) {
                int pre = nums[i - 1];
                int next = nums[i];
                for (int j = pre + 1; j < next; j++) {
                    th++;
                    if (th == k) {
                        return j;
                    }
                }
            }
            int j = nums[nums.length - 1];
            j = j + k - th;
            return j;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}