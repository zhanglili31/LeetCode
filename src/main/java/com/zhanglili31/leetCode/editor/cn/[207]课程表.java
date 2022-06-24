package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.*;

//207 课程表
//2022-06-24 04:31:17
class CourseSchedule {

    public static void main(String[] args) {
        int dir8[][] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
        int dir4[][] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Solution solution = new CourseSchedule().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        int [][]a={{1,1,1},{1,0,1},{1,1,1}};
        String testStr="hello";
        String strArray[] = {"wrt","wrf"};
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
//        int temp[] = CreateArray.getArray(20, 100);
        int temp[] = {5, 3, 2, 2};
        System.out.println(Arrays.toString(temp));
        System.out.println(solution);
    }
    
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int deg[] = new int[numCourses];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < prerequisites.length; i++) {
            int x = prerequisites[i][1];
            int y = prerequisites[i][0];
            List<Integer> list = map.getOrDefault(x, new ArrayList<>());
            list.add(y);
            map.put(x, list);
            deg[y]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < deg.length; i++) {
            if (deg[i] == 0) {
                queue.add(i);
            }
        }
        int ans[] = new int[numCourses];
        int index = 0;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            ans[index++] = cur;
            List<Integer> list = map.getOrDefault(cur, new ArrayList<>());
            for (int i = 0; i < list.size(); i++) {
                int y = list.get(i);
                deg[y]--;
                if (deg[y] == 0) {
                    queue.add(y);
                }
            }
        }
       return index==numCourses;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
 
}