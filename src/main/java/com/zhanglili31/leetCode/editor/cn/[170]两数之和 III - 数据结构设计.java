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
        List<Integer> array = new ArrayList<>();


        public TwoSum() {

        }

        public void add(int number) {
            array.add(number);

        }
        //查找还有一种哈希的思路，有时间在写下。
        public boolean find(int value) {
            Set<Integer> set=new HashSet<Integer>();
            for (int i :array) {
                if (set.contains(value - i)) {
                    return true;
                }else{
                    set.add(i);
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