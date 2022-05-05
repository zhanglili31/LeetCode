package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;
import com.zhanglili31.leetCode.editor.cn.utils.CreateArray;

import java.util.*;

//249 移位字符串分组
//2022-05-05 21:18:36
class GroupShiftedStrings {

    public static void main(String[] args) {
        Solution solution = new GroupShiftedStrings().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        String testStr = "hello";
        String strArray[] = {"zb"};
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
        int temp[] = CreateArray.getArray(20, 100);
        StringBuilder stringBuilder = new StringBuilder();
        System.out.println(Arrays.toString(temp));
        System.out.println(solution.groupStrings(strArray));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<String>> groupStrings(String[] strings) {
            List<List<String>> res = new ArrayList<>();
            Map<String, List<String>> featureMap = new HashMap<>();
            List<String> temp = new ArrayList<>();
            String feature = null;
            for (int i = 0; i < strings.length; i++) {
                feature = getFeature(strings[i]);
                temp = featureMap.getOrDefault(feature, new ArrayList<String>());
                temp.add(strings[i]);
                featureMap.put(feature, temp);
            }
            for (Map.Entry<String, List<String>> entry : featureMap.entrySet()) {
                res.add(entry.getValue());
            }
            return res;
        }

        public String getFeature(String string) {
            StringBuilder stringBuilder = new StringBuilder();
            char pre, next;
            for (int i = 0; i < string.length() - 1; i++) {
                pre = string.charAt(i);
                next = string.charAt(i + 1);
                if (pre <= next) {
                    stringBuilder.append(String.valueOf(next - pre) + ",");
                } else {
                    stringBuilder.append(String.valueOf(26 - pre+next) + ",");
                }
            }
            return stringBuilder.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}