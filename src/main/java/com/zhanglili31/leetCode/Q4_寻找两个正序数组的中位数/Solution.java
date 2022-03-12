package com.zhanglili31.leetCode.Q4_寻找两个正序数组的中位数;

public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] sum = new int[nums1.length + nums2.length];
        int i=0,j=0,k=0;
        while (i < nums1.length && j < nums2.length) {
            if(nums1[i]>nums2[j]){
                sum[k]=nums2[j];
                j++;
            }else{
                sum[k] = nums1[i];
                i++;
            }
            k++;
        }
        if (i == nums1.length) {
            while (j < nums2.length) {
                sum[k] = nums2[j];
                k++;
                j++;
            }
        }else{
            while (i < nums1.length) {
                sum[k] = nums1[i];
                i++;
                k++;
            }
        }
        if(sum.length%2==1){
            return (double) sum[sum.length / 2];
        }else{
            double res = sum[sum.length / 2] + sum[sum.length / 2 - 1];
            return res/2;
        }
    }
}
