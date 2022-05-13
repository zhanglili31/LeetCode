package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateArray;
import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

//379 电话目录管理系统
//2022-05-13 18:50:24
class DesignPhoneDirectory {

    public static void main(String[] args) {
//        Solution solution = new DesignPhoneDirectory().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        String testStr = "hello";
        String strArray[] = {"wrt", "wrf"};
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
        int temp[] = CreateArray.getArray(20, 100);
        System.out.println(Arrays.toString(temp));
//        System.out.println(solution);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class PhoneDirectory {
        Set<Integer> set = new HashSet<>();
        public PhoneDirectory(int maxNumbers) {
            for (int i = 0; i < maxNumbers; i++) {
                set.add(i);
            }
        }
        public int get() {
            Iterator iterator = set.iterator();
            if (!iterator.hasNext())
                return -1;
            int ans = (int) iterator.next();
            iterator.remove();
            return ans;
        }
        public boolean check(int number) {
            return set.contains(number);

        }

        public void release(int number) {
            set.add(number);

        }
    }

/**
 * Your PhoneDirectory object will be instantiated and called as such:
 * PhoneDirectory obj = new PhoneDirectory(maxNumbers);
 * int param_1 = obj.get();
 * boolean param_2 = obj.check(number);
 * obj.release(number);
 */
//leetcode submit region end(Prohibit modification and deletion)

}