package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

//380 O(1) 时间插入、删除和获取随机元素
//2022-06-23 02:23:08
class InsertDeleteGetrandomO1 {

    public static void main(String[] args) {
//        Solution solution = new InsertDeleteGetrandomO1().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        String testStr = "hello";
        String strArray[] = {"wrt", "wrf"};
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
//        int temp[] = CreateArray.getArray(20, 100);
        int temp[] = {5, 3, 2, 2};
        System.out.println(Arrays.toString(temp));
//        System.out.println(solution);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    //https://leetcode.cn/problems/insert-delete-getrandom-o1/solution/
    class RandomizedSet {
        int[] arr = new int[200001];
        int index = 0;
        Map<Integer, Integer> map = new HashMap<>();

        public RandomizedSet() {


        }

        public boolean insert(int val) {
            if (map.containsKey(val)) {
                return false;
            }
            map.put(val, index);
            arr[index++] = val;
            return true;

        }

        public boolean remove(int val) {
            if (!map.containsKey(val)) {
                return false;
            }
            int i = map.get(val);
            map.remove(val);
            if (i != index - 1) {
                arr[i] = arr[index - 1];
                map.put(arr[i], i);
            }
            index--;
            return true;

        }

        public int getRandom() {
            Random r = new Random();
            int i = r.nextInt(index);
            return arr[i];

        }
    }

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
//leetcode submit region end(Prohibit modification and deletion)

}