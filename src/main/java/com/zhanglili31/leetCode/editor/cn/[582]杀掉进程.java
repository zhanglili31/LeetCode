package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateArray;
import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.*;

//582 杀掉进程
//2022-05-20 20:23:38
class KillProcess {

    public static void main(String[] args) {
        Solution solution = new KillProcess().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        String testStr = "hello";
        String strArray[] = {"wrt", "wrf"};
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
        int temp[] = CreateArray.getArray(20, 100);
        System.out.println(Arrays.toString(temp));
        System.out.println(solution);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //思路：杀掉进程I，所以以进程I为父进程的进程都应该找出来，并且杀掉。
        // 拓扑排序的思路，建立父子进程的边的关系
        public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
            Map<Integer, List<Integer>> map = new HashMap<>();
            for (int i = 0; i < pid.size(); i++) {
                int id = pid.get(i);
                int fid = ppid.get(i);
                List<Integer> temp = map.getOrDefault(fid, new ArrayList<>());
                temp.add(id);
                map.put(fid, temp);
            }
            List<Integer> ans = new ArrayList<>();
            Queue<Integer> queue = new LinkedList<>();
            queue.addAll(map.getOrDefault(kill, new ArrayList<>()));
            ans.add(kill);
            while (!queue.isEmpty()) {
                int child=queue.poll();
                ans.add(child);
                queue.addAll(map.getOrDefault(child, new ArrayList<>()));
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}