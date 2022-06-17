package com.zhanglili31.leetCode.editor.cn;

import com.eclipsesource.json.JsonArray;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

class Solution {
    class Node {
        int hashcode = 0;
        String str = null;
        List<Node> children = new ArrayList<Node>();

        public Node(int hashcode, String str) {
            this.hashcode = hashcode;
            this.str = str;
        }
    }

    List<Node> list = new ArrayList<>();
    String ans = "";


    public String findSmallestRegion(List<List<String>> regions, String region1, String region2) {

        //build tree
        for (int i = 0; i < regions.size(); i++) {
            String pa = regions.get(i).get(0);
            Node father = null;
            for (int k = 0; k < list.size(); k++) {
                father = findParent(list.get(k), pa.hashCode());
                if (father != null) {
                    break;
                }
            }
            if (father == null) {
                father = new Node(pa.hashCode(), pa);
                list.add(father);
            }
            for (int j = 1; j < regions.get(i).size(); j++) {
                String child = regions.get(i).get(j);
                father.children.add(new Node(child.hashCode(), child));
            }
        }
        //在每一刻构建的树中查找是否存在最近公共父节点
        for (int i = 0; i < list.size(); i++) {
            findTwoRegions(list.get(i), region1.hashCode(), region2.hashCode());
        }
        return ans;


    }

    private int findTwoRegions(Node root, int region1HashCode, int region2HashCode) {
        if (root == null) {
            return 0;
        }

        int count = 0;
        for (int i = 0; i < root.children.size(); i++) {
            count += findTwoRegions(root.children.get(i), region1HashCode, region2HashCode);
            if (count == 2) {
                ans = root.str;
                return 0;
            }
        }
        if (root.hashcode == region1HashCode || root.hashcode == region2HashCode) {
            count++;
        }
        if (count == 2) {
            ans = root.str;
            return 0;
        }
        return count;

    }

    private Node findParent(Node node, int hashcode) {
        if (node == null) {
            return null;
        }
        if (node.hashcode == hashcode) {
            return node;
        } else {
            for (int i = 0; i < node.children.size(); i++) {
                Node ans = findParent(node.children.get(i), hashcode);
                if (ans != null) {
                    return ans;
                }
            }
            return null;
        }
    }
}

class MainClass {
    public static List stringToStringList(String line) {
        JsonArray jsonArray = JsonArray.readFrom(line);
        String[] arr = new String[jsonArray.size()];
        List<String> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = jsonArray.get(i).asString();
            list.add(arr[i]);
        }
        return list;
    }

    public static List<List<String>> stringToString2dList(String input) {
        JsonArray jsonArray = JsonArray.readFrom(input);
        if (jsonArray.size() == 0) {
            return new ArrayList<List<String>>();
        }
        List<List<String>> list = new ArrayList<>(jsonArray.size());
        for (int i = 0; i < jsonArray.size(); i++) {
            JsonArray cols = jsonArray.get(i).asArray();
            list.add(stringToStringList(cols.toString()));
        }
        return list;
    }

    public static String[] stringToStringArray(String line) {
        JsonArray jsonArray = JsonArray.readFrom(line);
        String[] arr = new String[jsonArray.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = jsonArray.get(i).asString();
        }
        return arr;
    }

    public static List<List<String>> stringToString2dArray(String input) {
        JsonArray jsonArray = JsonArray.readFrom(input);
        if (jsonArray.size() == 0) {
            return new ArrayList<List<String>>();
        }
        List<List<String>> list = new ArrayList<>(jsonArray.size());
        for (int i = 0; i < jsonArray.size(); i++) {
            JsonArray cols = jsonArray.get(i).asArray();
            list.add(stringToStringList(cols.toString()));
        }
        return list;
    }

    public static String stringToString(String input) {
        return JsonArray.readFrom("[" + input + "]").get(0).asString();
    }

    /*    使用说明：Debug 本地调试
        1：在leecode中查找缺失的函数补上
        2：替换以下两行代码：
            File file = new File("/Users/zhanglili/IdeaProjects/LeetCode/src/main/java/com/zhanglili31/Debug/[1257]最小公共区域.txt");
            BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        3: 替换执行代码：
            String ret = new SmallestCommonRegion().new Solution().findSmallestRegion(regions, region1, region2);
        */
    public static void main(String[] args) throws IOException {
        File file = new File("/Users/zhanglili/IdeaProjects/LeetCode/src/main/java/com/zhanglili31/leetCode/editor/cn/[1257]最小公共区域.txt");
        BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        String line;
        while ((line = in.readLine()) != null) {
            List<List<String>> regions = stringToString2dList(line);
            line = in.readLine();
            String region1 = stringToString(line);
            line = in.readLine();
            String region2 = stringToString(line);

//            String ret = new Solution().findSmallestRegion(regions, region1, region2);
            String ret = new SmallestCommonRegion().new Solution().findSmallestRegion(regions, region1, region2);

            String out = (ret);

            System.out.print(out);
        }
    }
}