package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.Arrays;
import java.util.HashMap;

//1166 设计文件系统
//2022-06-15 17:48:08
class DesignFileSystem {

    public static void main(String[] args) {
//        Solution solution = new DesignFileSystem().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        String testStr = "/leet/code";
        String strArray[] = {"wrt", "wrf"};
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
//        int temp[] = CreateArray.getArray(20, 100);
        int temp[] = {5, 3, 2, 2};
        System.out.println(Arrays.toString(temp));
//        System.out.println(solution);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class FileSystem {
        //Dir 就是一个目录，Dir中可以存放子目录，也可以存放文件
        class Dir {
            HashMap<String, Dir> dirs = new HashMap<>();
            int value;
//            HashMap<String, Integer> files = new HashMap<>();

            public Dir(int value) {
                this.value = value;
            }
        }

        Dir root = null;


        public FileSystem() {
            root = new Dir(-1);

        }

        public boolean createPath(String path, int value) {
            String paths[] = path.split("/");
            Dir temp = root;
            int i = 1;
            for (; i < paths.length - 1; i++) {
                if (temp.dirs.containsKey(paths[i])) {
                    temp = temp.dirs.get(paths[i]);
                } else {
                    return false;
                }
            }
            if(temp.dirs.containsKey(paths[i])) {
                return false;
            }
            temp.dirs.put(paths[i], new Dir(value));
            return true;

        }

        public int get(String path) {
            String paths[] = path.split("/");
            Dir temp = root;
            int i = 1;
            for (; i < paths.length; i++) {
                if (temp.dirs.containsKey(paths[i])) {
                    temp = temp.dirs.get(paths[i]);
                } else {
                    return -1;
                }
            }
            return temp.value;

        }
    }

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * boolean param_1 = obj.createPath(path,value);
 * int param_2 = obj.get(path);
 */
//leetcode submit region end(Prohibit modification and deletion)

}