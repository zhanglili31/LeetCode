package com.zhanglili31.leetCode.editor.cn;

import com.eclipsesource.json.JsonArray;

import java.io.*;
import java.util.*;

class SolutionTreeDiameter {
    //怎么用边构造树：
    //使用邻接表：只有一条边的
    public int treeDiameter(int[][] edges) {
        Map<Integer, List<Integer>> e = new HashMap<>();
        Map<Integer, Queue<Integer>> len = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            List<Integer> list = e.getOrDefault(edges[i][0], new LinkedList<>());
            list.add(edges[i][1]);
            e.put(edges[i][0], list);

            list = e.getOrDefault(edges[i][1], new LinkedList<>());
            list.add(edges[i][0]);
            e.put(edges[i][1], list);
        }
        Queue<Integer> queue = new LinkedList<Integer>();
        e.forEach((k, v) -> {
            if (v.size() == 1) {
                queue.add(k);
                Queue<Integer> priorityQueue = new PriorityQueue<Integer>(new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        return o2 - o1;
                    }
                });
                priorityQueue.add(0);
                len.put(k, priorityQueue);
            }
        });
        int last = 0;
        while (queue.isEmpty()) {
            Integer cur = queue.poll();
            last = cur;
            List<Integer> list = e.get(cur);
            for (int i = 0; i < list.size(); i++) {
                Integer n = list.get(i);
                List<Integer> ln = e.get(n);
                Queue<Integer> priorityQueue = len.getOrDefault(n, new PriorityQueue<Integer>(new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        return o2 - o1;
                    }
                }));
                priorityQueue.add(1 + len.get(cur).peek());
                len.put(n, priorityQueue);
                ln.remove(cur);
                if (ln.size() == 1) {
                    queue.add(n);
                }
            }
        }
        int sum = 0;
        Queue<Integer> tar = len.get(last);
        for (int i = 0; i < 2 && !tar.isEmpty(); i++) {
            sum += tar.poll();
        }
        return sum;
    }
}

class MainClassTreeDiameter {
    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for(int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }

    public static int[][] stringToInt2dArray(String input) {
        JsonArray jsonArray = JsonArray.readFrom(input);
        if (jsonArray.size() == 0) {
            return new int[0][0];
        }

        int[][] arr = new int[jsonArray.size()][];
        for (int i = 0; i < arr.length; i++) {
            JsonArray cols = jsonArray.get(i).asArray();
            arr[i] = stringToIntegerArray(cols.toString());
        }
        return arr;
    }

    public static void main(String[] args) throws IOException {
        File file = new File("/Users/zhanglili/IdeaProjects/LeetCode/src/main/java/com/zhanglili31/leetCode/editor/cn/[1245]树的直径.txt");
        BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        String line;
        while ((line = in.readLine()) != null) {
            int[][] edges = stringToInt2dArray(line);

            int ret = new TreeDiameter().new Solution().treeDiameter(edges);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}