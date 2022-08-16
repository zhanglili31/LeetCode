package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;
import com.zhanglili31.leetCode.editor.cn.utils.CreateArray;

import java.util.Arrays;

//912 排序数组
//2022-05-12 21:32:38
class SortAnArray {

    public static void main(String[] args) {
        Solution solution = new SortAnArray().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        String testStr = "hello";
        String strArray[] = {"wrt", "wrf"};
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
        int temp[] = CreateArray.getArray(30, 10);
        System.out.println(Arrays.toString(temp));
        System.out.println(Arrays.toString(solution.sortArray(temp)));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int[] sortArray(int[] nums) {
            //堆排序
//            heapSort(nums);
            //快速排序
//            quickSort(nums, 0, nums.length-1);
            //冒泡排序
//            bubbleSort(nums);
            //归并排序 ,备注：需要考虑原地排序的实现
            dealMerge(nums);
            return nums;

        }

        //递归形式的快速排序
        //思路
        //利用 分治思想 的排序方法
        //首先在数组中确定一个主轴元素(下标记为 pivotpivot )
        //然后将数组分为两部分，小于主轴的放在（确定最终位置的）主轴左侧，大于等于主轴的放在主轴右侧。
        //递归地对主轴左右两侧数组执行这个过程，每次递归都传入待排序数组 arrarr 和本次要处理的部分的左右界，只处理这个范围内的序列。

        private void quickSort(int[] num, int low, int high) {
            if (low < high) {
                int pivot = partition(num, low, high);
                quickSort(num, low, pivot - 1);
                quickSort(num, pivot + 1, high);
            }
        }

        //分区
        private int partition(int num[], int low, int high) {
            int pivot = low;
            int pivotKey = num[low];
            while (low < high) {
                while (low < high && num[high] >= pivotKey) {
                    high--;
                }
                num[pivot] = num[high];
                pivot = high;
                while (low < high && num[low] <= pivotKey) {
                    low++;
                }
                num[pivot] = num[low];
                pivot = low;
            }
            num[pivot] = pivotKey;
            return pivot;
        }

        //堆排序2
        //思路：
        //1：将数组调整为一个堆，满足父节点值大于字节点值即可
        //2：将堆顶的最大值和数组的最后一个值交换，数组的最有一个就是最大值，这样后面的值就是有序的了。此时数组长度缩短1
        //3：在2的基础上调整堆的，保证堆满足父节点值大于字节点值
        //4：重复2，3步骤，直到排序结束

        private void heapSort(int nums[]) {
            //首先将数组理解成一个二叉树数组
            //parentNode=i,
            //leftChildNode=2*i+1;
            //rightChildNode=2*i+2;
            //从最后一个非叶子节点开始，从后往前调整二叉树数组为堆
            //保证每一个父节点的值大于字节点的值
            //最后一个非叶子节点index=nums.length/2-1;

            //初始化数组，使得数组满足堆条件
            for (int i = nums.length / 2 - 1; i >= 0; i--) {
                heapAdjust(nums, i, nums.length - 1);
            }

            //从最后往前依此排序
            for (int i = nums.length - 1; i >= 0; i--) {
                //堆顶元素和最后一个元素交换
                int temp = nums[i];
                nums[i] = nums[0];
                nums[0] = temp;
                //修复堆
                //为什么需要这样调用？？？
                //每一次和堆定元素交换得到最大值以后，堆定留下的就是最小的元素
                //因此：需要从这个最小元素开始，依此往下调整对，保证堆的所有父节点大于其字节点
                heapAdjust(nums, 0, i - 1);

            }


        }

        /**
         * @param nums          数组
         * @param pa            父节点索引
         * @param lastNodeIndex 数组的最后一个索引，这里不使用nums.length,堆排序是将最大的值放入到最后一个，倒着排序的。
         */
        private void heapAdjust(int nums[], int pa, int lastNodeIndex) {
            int left = 2 * pa + 1;
            int right = 2 * pa + 2;
            int max = pa;

            //从pa，left，right三个节点中选择最大的一个索引，将最大索引赋值给max
            if (left <= lastNodeIndex && nums[left] > nums[max]) {
                max = left;
            }
            if (right <= lastNodeIndex && nums[right] > nums[max]) {
                max = right;
            }
            //max和pa不同，索引nums[pa]不是最大的，需要交换
            if (max != pa) {
                int temp = nums[pa];
                nums[pa] = nums[max];
                nums[max] = temp;
                //max 记录了最大的是节点是左还是右的索引
                //因此从这里开始，往下调整树，保证堆的结构满足：父节点大于左右字节点
                heapAdjust(nums, max, lastNodeIndex);
            }
        }

        //冒泡排序，超时
        private void bubbleSort(int nums[]) {
            //本轮执行是否有交换的标志，若无则false，若有则true
            boolean hasSwap = true;
            while (hasSwap) {
                hasSwap = false;
                //// 每轮循环，通过依次向右比较两个数，将本轮循环中最大的数放到最右
                for (int i = 0; i < nums.length - 1; i++) {
                    //// 若左大于右则交换，并将swapped置为true
                    if (nums[i] > nums[i + 1]) {
                        int temp = nums[i];
                        nums[i] = nums[i + 1];
                        nums[i + 1] = temp;
                        hasSwap = true;
                    }
                }
            }
        }
        private void dealMerge(int nums[]){
            int res[] = mergeSort(nums, 0, nums.length - 1);
            for (int i = 0; i < nums.length; i++) {
                nums[i] = res[i];
            }
        }
        //归并排序
        //先拆分成两个数组，
        //在合并为两个有序数组
        private int[] mergeSort(int nums[], int start, int end) {
            if (start == end) {
                return new int[]{nums[start]};
            }

            int mid = (start + end) / 2;
            int nums1[] = mergeSort(nums, start, mid);
            int nums2[] = mergeSort(nums, mid + 1, end);
            return merge(nums1, nums2);
        }

        private int[] merge(int[] nums1, int nums2[]) {
            int res[] = new int[nums1.length + nums2.length];
            int l1 = 0;
            int l2 = 0;
            int i = 0;
            for (; l1 < nums1.length && l2 < nums2.length; ) {
                if (nums1[l1] < nums2[l2]) {
                    res[i++] = nums1[l1++];
                } else {
                    res[i++] = nums2[l2++];
                }
            }
            //剩下部分
            int[] last;
            int lastIndex;
            if (l1 < nums1.length) {
                last = nums1;
                lastIndex = l1;
            } else {
                last = nums2;
                lastIndex = l2;
            }
            while (lastIndex < last.length) {
                res[i++] = last[lastIndex++];
            }
            return res;
        }
        //桶排序
        //根据数据范围和数据分布情况划分桶
        //比如：数据范围是：1-2000，200个数，
        //这些数都是平均分布。
        //有五个桶，则：
        //桶一：范围：1-400
        //桶二：范围：401-800
        //依此，
        //如果数据分布不均匀，那么就需要调整桶的范围。


    }
//leetcode submit region end(Prohibit modification and deletion)

}