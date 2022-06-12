package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.*;

//1181 前后拼接
//2022-06-12 15:47:47
class BeforeAndAfterPuzzle {

    public static void main(String[] args) {
        Solution solution = new BeforeAndAfterPuzzle().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        String testStr = "hello";
        String strArray[] = {"a","b","a"};
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
//        int temp[] = CreateArray.getArray(20, 100);
        int temp[] = {5, 3, 2, 2};
        System.out.println(Arrays.toString(temp));
        System.out.println(solution.beforeAndAfterPuzzles(strArray));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> beforeAndAfterPuzzles(String[] phrases) {
            Map<String, List<Integer>> map = new HashMap<>();
            String[][] arr = new String[phrases.length][];
            for (int i = 0; i < phrases.length; i++) {
                String[] temp = phrases[i].split(" ");
                arr[i] = temp;
                List<Integer> list = map.getOrDefault(temp[0], new ArrayList<>());
                list.add(i);
                map.put(temp[0], list);
            }
            List<String> ans = new LinkedList<String>();
            for (int i = 0; i < arr.length; i++) {
                List<Integer> last = map.getOrDefault(arr[i][arr[i].length - 1], new ArrayList<>());
                for (int j = 0; j < last.size(); j++) {
                    if(last.get(j)==i)continue;
                    StringBuilder strB = new StringBuilder(phrases[i]);
                    for (int k = 1; k < arr[last.get(j)].length; k++) {
                        strB.append(" " + arr[last.get(j)][k]);
                    }
                    ans.add(strB.toString());
                }
            }
            ans.sort(new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return o1.compareTo(o2);
                }
            });
            for (int i = 0; i < ans.size()-1; i++) {
                if (ans.get(i).equals(ans.get(i + 1))) {
                    ans.remove(i);
                }
            }
            return ans;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}