package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateArray;
import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.*;

//588 设计内存文件系统
//2022-05-30 05:23:03
class DesignInMemoryFileSystem {

    public static void main(String[] args) {
//        Solution solution = new DesignInMemoryFileSystem().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        String testStr = "hello";
        String strArray[] = {"wrt", "wrf"};
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
        int temp[] = CreateArray.getArray(20, 100);
        System.out.println(Arrays.toString(temp));
//        FileSystem f=new FileSystem();
//        f.mkdir("/a/b/c");
//        f.ls("/b");
//        System.out.println(solution);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    //https://leetcode.cn/problems/design-in-memory-file-system/solution/she-ji-nei-cun-wen-jian-xi-tong-by-leetcode/
    class FileSystem {
        //Dir 就是一个目录，Dir中可以存放子目录，也可以存放文件
        class Dir {
            HashMap<String, Dir> dirs = new HashMap<>();
            HashMap<String, String> files = new HashMap<>();
        }

        Dir root = null;

        public FileSystem() {
            this.root = new Dir();

        }

        public List<String> ls(String path) {
            Dir root = this.root;
            List<String> ans = new ArrayList<>();
            String dirs[] = path.split("/");
            if (!path.equals("/")) {
                for (int i = 1; i < dirs.length - 1; i++) {
                    root = root.dirs.get(dirs[i]);
                }
                if (root.files.containsKey(dirs[dirs.length - 1])) {
                    ans.add(dirs[dirs.length - 1]);
                    return ans;
                }
                root = root.dirs.get(dirs[dirs.length - 1]);
            }
            root.files.forEach((k, v) -> {
                ans.add(k);
            });
            root.dirs.forEach((k, v) -> {
                ans.add(k);
            });
            ans.sort(new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return o1.compareTo(o2);
                }
            });
            return ans;
        }

        public void mkdir(String path) {
            String dirs[] = path.split("/");
            Dir root = this.root;
            for (int i = 1; i < dirs.length; i++) {
                if (!root.dirs.containsKey(dirs[i])) {
                    root.dirs.put(dirs[i], new Dir());
                }
                root = root.dirs.get(dirs[i]);
            }
        }

        public void addContentToFile(String filePath, String content) {
            String dirs[] = filePath.split("/");
            Dir root = this.root;
            for (int i = 1; i < dirs.length - 1; i++) {
                if (!root.dirs.containsKey(dirs[i])) {
                    root.dirs.put(dirs[i], new Dir());
                }
                root = root.dirs.get(dirs[i]);
            }
            String fileName = dirs[dirs.length - 1];
            root.files.put(fileName, root.files.getOrDefault(fileName, "") + content);


        }

        public String readContentFromFile(String filePath) {
            String dirs[] = filePath.split("/");
            Dir root = this.root;
            for (int i = 1; i < dirs.length - 1; i++) {
                root = root.dirs.get(dirs[i]);
            }
            String fileName = dirs[dirs.length - 1];
            return root.files.get(fileName);
        }
    }

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * List<String> param_1 = obj.ls(path);
 * obj.mkdir(path);
 * obj.addContentToFile(filePath,content);
 * String param_4 = obj.readContentFromFile(filePath);
 */
//leetcode submit region end(Prohibit modification and deletion)

}