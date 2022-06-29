package com.river.leetcode.studyplan.level1;

public class FirstBadVersion {

    int badVersion;

    public FirstBadVersion(int badVersion) {
        this.badVersion = badVersion;
    }

    /**
     * intuition: if call returns false => good version pinpoint this as leftMost, go forward
     *
     * reach a call which returns true => bad version, find the earliest, go backwards until reach
     * false
     * 
     * @param n
     * @return
     */
    public int firstBadVersion(int n) {
        return findFirst(1, n);
    }

    private int findFirst(int start, int end) {
        if (start == end)
            return start;

        int mid = start + ((end - start) / 2);
        if (!isBadVersion(mid)) {
            return findFirst(mid + 1, end);
        }

        if (isBadVersion(mid)) {
            return findFirst(start, mid);
        }

        return -1;
    }

    // simulate api call
    private boolean isBadVersion(int version) {
        return version >= this.badVersion;
    }

    public static void main(String[] args) {
        FirstBadVersion fbv = new FirstBadVersion(4);
        System.out.printf("1. %s\n", fbv.firstBadVersion(5));

        fbv = new FirstBadVersion(1);
        System.out.printf("2. %s\n", fbv.firstBadVersion(1));
    }
}
