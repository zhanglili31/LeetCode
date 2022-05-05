package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;
import com.zhanglili31.leetCode.editor.cn.utils.CreateArray;

import java.util.Arrays;

//204 计数质数
//2022-05-06 05:06:03
class CountPrimes {

    public static void main(String[] args) {
        Solution solution = new CountPrimes().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        String testStr = "hello";
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
        int temp[] = CreateArray.getArray(20, 100);
        System.out.println(Arrays.toString(temp));
        long t1 = System.currentTimeMillis();
        System.out.println(solution.countPrimes(5000000));
        System.out.println(System.currentTimeMillis() - t1);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countPrimes(int number) {
            int[] array = new int[number];
            int res=0;
            for (int i = 2; i < number; i++) {
                if(array[i]==0){
                    if (isPrime(i)) {
                        res++;
                        int x=2;
                        int points = i * x;
                        while (points < number) {
                            x++;
                            array[points]=-1;
                            points=x*i;
                        }
                    }
                }
            }
            return res;

        }

        public boolean isPrime(int number) {
            for (int j = 2; j * j <= number; j++) {
                if(number%j==0){
                    return false;
                }
            }
            return true;
        }


        //总是超时 无了大语,官方的这种方式也超时fuck，
        public int countPrimes0(int n) {
            int res = 0;
            int init[] = {2, 3, 5, 7};
            for (int i = 0; i < init.length; i++) {
                if (n > init[i]) {
                    res++;
                } else {
                    return res;
                }
            }
            boolean flag = true;
            for (int i = 8; i < n; i++) {
                flag = true;
                for (int j = 2; j * j <= i; j++) {
                    if (i == j)
                        continue;
                    if (i % j == 0) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    res++;
                }

            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}