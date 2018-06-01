package com.leetcode;

/**
 * @author Anatoly Chernysh
 */
public class FirstBadVersion {

    public static boolean isBadVersion(int version) {
        if (version > 1 && version < 4) {
            return false;
        }
        return true;
    }

    public static int firstBadVersion(int n) {
        int start = 0, end = n, version = 1;

        while (start < end) {
            int mid = start + (end - start) / 2;
            if (isBadVersion(mid)) {
                end = mid;
                version = mid;
            }
            else {
                start = mid + 1;
            }
        }

        return version;
    }

    public static void main(String[] args) {
        System.out.println(firstBadVersion(5));
    }
}
