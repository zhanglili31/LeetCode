package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.TreeSet;

//683 K 个关闭的灯泡
//2022-06-02 00:27:24
class KEmptySlots {

    public static void main(String[] args) {
        Solution solution = new KEmptySlots().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        String testStr = "hello";
        String strArray[] = {"wrt", "wrf"};
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
//        int temp[] = CreateArray.getArray(20, 100);
        int temp[] = {1,3,2,6,5,4,7,9,8,10};
        System.out.println(Arrays.toString(temp));
        System.out.println(solution.kEmptySlots(temp,5));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    //todo 滑动窗口再实现一遍。
    class Solution {

        // 依然是前后比较的方式实现
        public int kEmptySlots(int[] bulbs, int k) {
            int n = bulbs.length;
            int lastDay = n - k;//可以开lastDay数量的灯。
            TreeSet<Integer>treeSet=new TreeSet<>();
            for (int i = 0; i < lastDay; i++) {
                int slot = bulbs[i];
                treeSet.add(slot);
                Integer lower = treeSet.lower(slot);
                if (lower != null && slot - lower - 1 == k) {
                    return i+1;
                }
                Integer higher = treeSet.higher(slot);
                if (higher != null && higher - slot - 1 == k) {
                    return i+1;
                }

            }
            return -1;
        }
        //每次点亮一个灯泡，将点亮的灯泡插入对应的位置
        //二分查找对应的位置
        //比较前后的灯泡距离，满足条件即可返回结果。
        public int kEmptySlots3(int[] bulbs, int k) {
            int n = bulbs.length;
            int lastDay = n - k;//可以开lastDay数量的灯。
            LinkedList<Integer> list = new LinkedList<Integer>();
            for (int i = 0; i < lastDay; i++) {
                int left = 0;
                int right = list.size();
                int po = 0;
                if (list.size() == 0) {
                    list.add(bulbs[i]);
                    po = 0;
                } else if ( bulbs[i] < list.get(0)) {
                    list.add(0, bulbs[i]);
                    po=0;
                } else if (bulbs[i] > list.getLast()) {
                    list.add(bulbs[i]);
                    po = list.size() - 1;
                } else {
                    while (left < right) {
                        int mid = left + (right - left) / 2;
                        if (list.get(mid) > bulbs[i]) {
                            right = mid;
                        } else {
                            left = mid+1;
                        }
                        if (left == right) {
                            po = left;
                            break;
                        }
                    }
                    list.add(po, bulbs[i]);
                }
                if (po - 1 >= 0 && bulbs[i] - list.get(po - 1) - 1 == k) {
                    return i + 1;
                }
                if (po + 1 < list.size() && list.get(po + 1) - bulbs[i] - 1 == k) {
                    return i + 1;
                }
            }
            return -1;
        }

        //普通模拟+排序+间隔---超时
        public int kEmptySlots2(int[] bulbs, int k) {
            int n = bulbs.length;
            int lastDay = n - k;//可以开lastDay数量的灯。
            LinkedList<Integer> list = new LinkedList<Integer>();
            for (int i = 0; i < lastDay; i++) {
                list.add(bulbs[i]);
                list.sort(new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        return o1 - o2;
                    }
                });
                for (int j = 0; j < list.size() - 1; j++) {
                    if (list.get(j + 1) - list.get(j) - 1 == k) {
                        return i + 1;
                    }
                }
            }
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}