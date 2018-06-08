package com.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Anatoly Chernysh
 */
public class SimplifyPath {

    public static void main(String[] args) {
        //String path = "/home//";
        //String path = "/a/./b/../../c/";
        //String path = "/home//foo/";
        String path = "/abc/...";
        System.out.println(simplifyPath(path));
    }

    public static String simplifyPath(String path) {
        String []folders = path.split("/+");
        Deque<String> stack = new ArrayDeque<String>();

        for (String folder : folders) {
            if (folder.equals(".") || folder.isEmpty()) {
                // skip current directory
                continue;
            }
            if (folder.equals("..")) {
                // go up, so remove previous folder from path
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            }
            else {
                stack.push(folder);
            }
        }

        StringBuilder sb = new StringBuilder("/");
        while (!stack.isEmpty()) {
            sb.append(stack.removeLast());
            if (!stack.isEmpty()) {
                sb.append("/");
            }
        }

        return sb.toString();
    }
}
