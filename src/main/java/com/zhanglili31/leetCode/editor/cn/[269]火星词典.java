package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;
import com.zhanglili31.leetCode.editor.cn.utils.CreateArray;

import java.util.*;

//269 火星词典
//2022-05-08 01:50:36
class AlienDictionary {

    public static void main(String[] args) {
        Solution solution = new AlienDictionary().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        String testStr = "hello";
        String strArray[] = {"wrt","wrf","er","ett","rftt"};
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
        int temp[] = CreateArray.getArray(20, 100);
        System.out.println(Arrays.toString(temp));
        System.out.println(solution.alienOrder(strArray));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //拓扑排序
        public String alienOrder(String[] words) {
            //deg 记录每一个字符的入度
            Map<Character, Integer> deg = new HashMap<>();

            //记录每一个字符指向的边。如 a->b;a-c;  存储为：key=a, list=[b,c]，list可能会存在重复
            Map<Character, List<Character>> edges = new HashMap<>();
            //初始化所有字符的入度为0；
            for (int i = 0; i < words.length; i++) {
                //初始化所有字符串
                String init = words[i];
                for (int l = 0; l < init.length(); l++) {
                    char addCh = init.charAt(l);
                    if (!deg.containsKey(l)) {
                        deg.put(addCh, 0);
                    }
                }
            }
            //寻找边，遇到第一个不同字符，记录对应的边。
            for (int i = 0; i < words.length - 1; i++) {
                String s = words[i];
                String t = words[i + 1];
                int len = Math.min(s.length(), t.length());
                boolean hasSwap = false;
                for (int k = 0; k < len; k++) {
                    char sch = s.charAt(k);
                    char tch = t.charAt(k);
                    if (sch != tch) {
                        deg.put(tch, deg.get(tch) + 1);
                        List<Character> temp = edges.getOrDefault(sch, new ArrayList<>());
                        temp.add(tch);
                        edges.put(sch, temp);
                        hasSwap = true;
                        break;
                    }
                }
                //判断这种情况  ["abc","ab"]
                if (!hasSwap && s.length() > t.length()) {
                    return "";
                }
            }
            StringBuilder res = new StringBuilder();
            //进行拓扑排序
            Queue<Character> queue = new LinkedList<>();
            deg.forEach((key, value) -> {
                if (value == 0) {
                    queue.add(key);
                }
            });
            while (!queue.isEmpty()) {
                char ch = queue.poll();
                res.append(ch);
                List<Character> chList = edges.getOrDefault(ch, new ArrayList<>());
                chList.forEach((points) -> {
                    int d = deg.get(points);
                    d--;
                    deg.put(points, d);
                    if (d == 0) {
                        queue.add(points);
                    }
                });
            }
            //判断依据：如果存在环，那么组成环的节点的入度不可能=0，因此最终加入res中的字符数肯定小于deg的长度
            return res.length() == deg.size() ? res.toString() : "";
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}