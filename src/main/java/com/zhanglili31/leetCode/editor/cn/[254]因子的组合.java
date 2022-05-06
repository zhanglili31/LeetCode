package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;
import com.zhanglili31.leetCode.editor.cn.utils.CreateArray;

import java.util.*;

//254 因子的组合
//2022-05-06 04:55:07
class FactorCombinations {

    public static void main(String[] args) {
        Solution solution = new FactorCombinations().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        String testStr = "hello";
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
        int temp[] = CreateArray.getArray(20, 100);
        System.out.println(Arrays.toString(temp));
        System.out.println(solution.getFactors(8192));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<Integer> primes = null;
        List<List<Integer>> res = new LinkedList<>();

        public List<List<Integer>> getFactors(int n) {
            this.primes = countPrimes(n);
            recursion(n, new ArrayList<Integer>());
            for (int i = 0; i < res.size(); i++) {
                Collections.sort(res.get(i), new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        return o1 - o2;
                    }
                });
            }
            boolean needSwap = true;
            while (needSwap) {
                needSwap = false;
                for (int i = 0; i < res.size() - 1; i++) {
                    List<Integer> temp1 = res.get(i);
                    List<Integer> temp2 = res.get(i + 1);
                    if (temp1.size() > temp2.size()) {
                        res.set(i + 1, temp1);
                        res.set(i, temp2);
                        needSwap = true;
                    }

                }
            }

            //去重复
            for (int i = 0; i < res.size() - 1; i++) {
                List<Integer> temp1 = res.get(i);
                List<Integer> temp2 = res.get(i + 1);
                if (temp1.size() != temp2.size()) {
                    continue;
                } else {
                    for (int k = i+1; k < res.size(); k++) {
                        temp2 = res.get(k);
                        if(temp1.size()!=temp2.size())break;
                        boolean flag = true;
                        for (int j = 0; j < temp1.size(); j++) {
                            if (temp1.get(j) != temp2.get(j)) {
                                flag = false;
                                break;
                            }
                        }
                        if (flag) {
                            res.remove(k);
                            k--;
                        }
                    }


                }

            }
            return res;
        }

        public void recursion(int n, List<Integer> list) {
            if (primes.contains(n)) {
                List<Integer> addList = new ArrayList<>();
                addList.addAll(list);
                addList.add(n);
                res.add(addList);
                return;
            }
            for (int i = 2; i <= n / 2; i++) {
                int factor = i;
                if (n % factor == 0) {
                    int num = n / factor;
                    List<Integer> list2 = new ArrayList();
                    list2.add(factor);
                    list2.add(num);
                    List<Integer> addList = new ArrayList<>(list);
                    addList.addAll(list2);
                    res.add(addList);
                    addList.remove(addList.size() - 1);
                    recursion(num, addList);
                    addList.add(num);
                }
            }
        }


        public List countPrimes(int number) {
            int[] array = new int[number];
            List<Integer> list = new ArrayList<>();
            for (int i = 2; i < number; i++) {
                if (array[i] == 0) {
                    list.add(i);
                    int x = 2;
                    int points = i * x;
                    while (points < number) {
                        x++;
                        array[points] = -1;
                        points = x * i;
                    }

                }
            }
            return list;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}