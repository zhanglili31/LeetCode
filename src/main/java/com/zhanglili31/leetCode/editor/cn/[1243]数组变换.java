package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//1243 数组变换
//2022-06-11 18:28:23
class ArrayTransformation {

    public static void main(String[] args) {
        Solution solution = new ArrayTransformation().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        String testStr = "hello";
        String strArray[] = {"wrt", "wrf"};
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
//        int temp[] = CreateArray.getArray(20, 100);
        int temp[] = {5, 3, 2, 2};
        System.out.println(Arrays.toString(temp));
        System.out.println(solution);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> transformArray(int[] arr) {
            boolean flag = true;
            while (flag) {
                flag = false;
                int temp[] = new int[arr.length];
                temp[0] = arr[0];
                temp[arr.length - 1] = arr[arr.length - 1];
                for (int i = 1; i < arr.length - 1; i++) {
                    if (arr[i] < arr[i - 1] && arr[i] < arr[i + 1]) {
                        temp[i]=arr[i]+1;
                        flag=true;
                    } else if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {
                        temp[i]=arr[i]-1;
                        flag=true;
                    }else{
                        temp[i] = arr[i];
                    }
                }
                arr=temp;
            }
            List<Integer>ans=new ArrayList<>();
            for (int i = 0; i < arr.length; i++) {
                ans.add(arr[i]);
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}