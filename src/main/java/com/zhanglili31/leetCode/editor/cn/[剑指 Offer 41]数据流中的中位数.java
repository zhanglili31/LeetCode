package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.*;

//剑指 Offer 41 数据流中的中位数
//2022-06-27 06:16:59
class ShuJuLiuZhongDeZhongWeiShuLcof {

    public static void main(String[] args) {
        int dir8[][] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
        int dir4[][] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
//        Solution solution = new ShuJuLiuZhongDeZhongWeiShuLcof().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        String testStr = "hello";
        String strArray[] = {"wrt", "wrf"};
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
//        int temp[] = CreateArray.getArray(20, 100);
        int temp[] = {5, 3, 2, 2};
        System.out.println(Arrays.toString(temp));


    }

    //leetcode submit region begin(Prohibit modification and deletion)
    //https://leetcode.cn/problems/shu-ju-liu-zhong-de-zhong-wei-shu-lcof/solution/dai-tu-xiang-jie-jian-zhi-offer-41-shu-j-y3d6/
    class MedianFinder {

        /**
         * initialize your data structure here.
         */
        Queue<Integer> min;
        Queue<Integer> max;

        public MedianFinder() {
            min = new PriorityQueue<Integer>(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o1 - o2;
                }
            });
            max = new PriorityQueue<Integer>(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2 - o1;
                }
            });

        }

        public void addNum(int num) {
            max.add(num);
            if (min.size() < max.size()) {
                min.add(max.poll());
            }
            if (max.size() > 0 && min.size() > 0) {
                if (min.peek() < max.peek()) {
                    int temp = min.poll();
                    min.add(max.poll());
                    max.add(temp);
                }
            }


        }

        public double findMedian() {
            if (min.size() != max.size()) {
                return (double) min.peek();
            } else {
                int top = min.peek();
                int bottom = max.peek();
                double d = ((double) (top + bottom)) / 2;
                return d;

            }

        }
    }

    class MedianFinder1 {

        /**
         * initialize your data structure here.
         */
        //超时
        List<Integer> list = new LinkedList<Integer>();

        public MedianFinder1() {
        }

        public void addNum(int num) {
            if (list.isEmpty()) {
                list.add(num);
                return;
            }

            int head = list.get(0);
            if (num <= head) {
                list.add(0, num);
                return;
            }
            int tail = list.get(list.size() - 1);
            if (num >= tail) {
                list.add(num);
                return;
            }
            int left = 0, right = list.size() - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                int midV = list.get(mid);
                if (num < midV) {
                    right = mid - 1;
                } else if (num > midV) {
                    left = mid + 1;
                } else if (num == midV) {
                    list.add(mid, num);
                    return;
                }
            }
            list.add(right + 1, num);
            System.out.println(list.size());

        }

        public double findMedian() {
            if (list.isEmpty())
                return -1;
            int left = list.size() / 2;
            int right = (list.size() - 1) / 2;
            return ((double) (list.get(left) + list.get(right))) / 2;
        }
    }

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
//leetcode submit region end(Prohibit modification and deletion)

}