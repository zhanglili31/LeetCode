package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;
import com.zhanglili31.leetCode.editor.cn.utils.CreateArray;

import java.util.*;

//170 两数之和 III - 数据结构设计
//2022-05-04 23:53:53
class TwoSumIiiDataStructureDesign {

    public static void main(String[] args) {
//        Solution solution = new TwoSumIiiDataStructureDesign().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        String testStr = "hello";
        int temp[] = CreateArray.getArray(20, 100);
        System.out.println(Arrays.toString(temp));
//        System.out.println(solution);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class TwoSum {
        List<Integer> list = new ArrayList<>();

        public TwoSum() {

        }

        public void add(int number) {
            list.add(number);
            Collections.sort(list, new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o1 - o2;
                }
            });

        }
        //查找还有一种哈希的思路，有时间在写下。
        public boolean find(int value) {
            System.out.println(list);
            int i=0;
            int j = list.size() - 1;
            int sum=0;
            while(i<j){
                sum = list.get(i) + list.get(j);
                if(value==sum)return true;
                if (sum > value) {
                    j--;
                }else{
                    i++;
                }
            }
            return false;
        }
    }

/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */
//leetcode submit region end(Prohibit modification and deletion)

}