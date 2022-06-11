package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.*;

//1215 步进数
//2022-06-11 15:30:52
class SteppingNumbers {

    public static void main(String[] args) {
        Solution solution = new SteppingNumbers().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        String testStr = "hello";
        String strArray[] = {"wrt", "wrf"};
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
//        int temp[] = CreateArray.getArray(20, 100);
        int temp[] = {5, 3, 2, 2};
        System.out.println(Arrays.toString(temp));
        System.out.println(solution.countSteppingNumbers(0,1000000000));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public List<Integer> countSteppingNumbers(int low, int high) {
            List<Integer> ans = new ArrayList<>();
//            DFS(ans, low, high, -1);
            BFS(ans, low, high);
            ans.sort(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o1 - o2;
                }
            });
            return ans;

        }

        //DFS最大值2e10的时候 发生栈溢出
        private void DFS(List<Integer> ans, int low, int high, int curNum) {
            if (curNum > high) {
                return;
            }
            if (curNum >= low && curNum <= high) {
                ans.add(curNum);
            }
            if (curNum == -1) {
                for (int i = 0; i < 10; i++) {
                    DFS(ans, low, high, i);
                }
            } else {
                if (curNum != 0) {
                    int last = curNum % 10;
                    if (last - 1 >= 0) {
                        DFS(ans, low, high, curNum * 10 + last - 1);
                    }
                    if (last + 1 < 10) {
                        DFS(ans, low, high, curNum * 10 + last + 1);
                    }
                }
            }
        }

        //BFS
        private void BFS(List<Integer> ans, int low, int high) {
            long lowLong=(long)low;
            long highLong=(long)high;
            Queue<Long> queue = new LinkedList<Long>();
            for (long i = 1; i < 10; i++) {
                queue.add(i);
            }
            if (low <= 0 && 0 <= high) {
                ans.add(0);
            }
            while (!queue.isEmpty()) {
                long temp = queue.poll();
                if (low <= temp && temp <= high) {
                    ans.add((int)temp);
                }
                long last = temp % 10;
                long val=temp*10+last-1;
                if (last - 1 >= 0 && val <= highLong) {
                    queue.add(val);
                }
                val=temp*10+last+1;
                if (last + 1 < 10 && val <= highLong) {
                    queue.add(val);
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}