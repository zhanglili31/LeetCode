package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.*;

//1462 课程表 IV
//2022-06-24 05:28:44
class CourseScheduleIv {

    public static void main(String[] args) {
        int dir8[][] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
        int dir4[][] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Solution solution = new CourseScheduleIv().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        String testStr = "hello";
        String strArray[] = {"wrt", "wrf"};
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
//        int temp[] = CreateArray.getArray(20, 100);
        int temp[] = {5, 3, 2, 2};
        System.out.println(Arrays.toString(temp));
        System.out.println(solution);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
            int deg[] = new int[numCourses];
            Map<Integer, List<Integer>> map = new HashMap<>();
            for (int i = 0; i < prerequisites.length; i++) {
                int x = prerequisites[i][0];
                int y = prerequisites[i][1];
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
            List<Boolean> ans = new ArrayList<>();
            for (int i = 0; i < queries.length; i++) {
                ans.add(BFS(map, queries[i], numCourses));
            }
            return ans;

        }

        private boolean BFS(Map<Integer, List<Integer>> map, int[] query, int numCourses) {
            int arr[] = new int[numCourses];
            Queue<Integer> queue = new LinkedList<>();
            queue.add(query[0]);
            while (!queue.isEmpty()) {
                int cur = queue.poll();
                arr[cur] = 1;
                List<Integer> list = map.getOrDefault(cur, new ArrayList<>());
                for (int i = 0; i < list.size(); i++) {
                    int t = list.get(i);
                    if (t == query[1]) {
                        return true;
                    }
                    if (arr[t] != 1) {
                        queue.add(t);
                    }
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}