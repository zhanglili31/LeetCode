package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;
import com.zhanglili31.leetCode.editor.cn.utils.CreateArray;

import java.util.Arrays;

//307 区域和检索 - 数组可修改
//2022-05-30 08:50:29
class RangeSumQueryMutable {

    public static void main(String[] args) {
//        Solution solution = new RangeSumQueryMutable().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        String testStr = "hello";
        String strArray[] = {"wrt", "wrf"};
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
        int temp[] = CreateArray.getArray(20, 100);
        System.out.println(Arrays.toString(temp));
//        System.out.println(solution);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class NumArray {
        int[] tree = null;
        int[] nums = null;

        //线段树的 求和
        //参考：https://www.bilibili.com/video/BV1cb411t7AM?spm_id_from=333.999.0.0
        public NumArray(int[] nums) {
            tree = new int[nums.length * 5];//5被长度才够用
            this.nums = nums;
            buildTree(nums, tree, 0, 0, nums.length - 1);
            System.out.println(Arrays.toString(tree));
        }

        private int buildTree(int[] nums, int tree[], int node, int start, int end) {
            //没有设置的地方，默认就是0；
            if (start == end) {
                tree[node] = nums[start];
            } else {
                int mid = start + (end - start) / 2;
                int leftNode = node * 2 + 1;
                int rightNode = node * 2 + 2;
                int leftSum = buildTree(nums, tree, leftNode, start, mid);
                int rightSum = buildTree(nums, tree, rightNode, mid + 1, end);
                tree[node] = leftSum + rightSum;
            }
            return tree[node];
        }


        public void update(int index, int val) {
            update(nums, tree, 0, 0, nums.length-1, index, val);
        }

        public void update(int nums[], int tree[], int node, int start, int end, int index, int val) {
            if (start == end) {
                nums[index]=val;
                tree[node]=val;
            } else {
                int mid = start + (end - start) / 2;
                int leftNode = node * 2 + 1;
                int rightNode = node * 2 + 2;
                if (index <= mid) {
                     update(nums, tree, leftNode, start, mid, index, val);
                } else {
                     update(nums, tree, rightNode, mid + 1, end, index, val);
                }
                tree[node] = tree[leftNode] + tree[rightNode];
            }
        }


        public int sumRange(int left, int right) {
            return sumRange(tree, 0, 0, nums.length-1, left, right);
        }

        public int sumRange(int tree[], int node, int start, int end, int L, int R) {
            if (end < L || R < start) {
                return 0;
            } else if (start == end) {
                return tree[node];
            } else if (L<=start&&end<=R) {
                return tree[node];
            } else {
                int mid = start + (end - start) / 2;
                int leftNode = node * 2 + 1;
                int rightNode = node * 2 + 2;
                int left = sumRange(tree, leftNode, start, mid, L, R);
                int right = sumRange(tree, rightNode, mid + 1, end, L, R);
                return left + right;
            }
        }
    }

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */
//leetcode submit region end(Prohibit modification and deletion)

}