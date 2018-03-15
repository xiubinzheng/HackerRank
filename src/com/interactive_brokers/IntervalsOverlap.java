package com.interactive_brokers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author Anatoly Chernysh
 */
public class IntervalsOverlap {

    public static void main(String[] args) {
        /*
        Interval []intervals = new Interval[4];

        intervals[0] = new Interval();
        intervals[0].start = 1;
        intervals[0].end = 3;

        intervals[1] = new Interval();
        intervals[1].start = 5;
        intervals[1].end = 7;

        intervals[2] = new Interval();
        intervals[2].start = 2;
        intervals[2].end = 4;

        intervals[3] = new Interval();
        intervals[3].start = 6;
        intervals[3].end = 8;

        System.out.println(isOverlap(intervals));
        */


        Interval []intervals = new Interval[4];

        intervals[0] = new Interval();
        intervals[0].start = 1;
        intervals[0].end = 3;

        intervals[1] = new Interval();
        intervals[1].start = 7;
        intervals[1].end = 9;

        intervals[2] = new Interval();
        intervals[2].start = 4;
        intervals[2].end = 6;

        intervals[3] = new Interval();
        intervals[3].start = 10;
        intervals[3].end = 13;


        System.out.println(isOverlap(intervals));

    }

    public static boolean isOverlap(Interval []intervals) {
        final List<Interval> overlappedIntervals = new ArrayList<>();

        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return Integer.compare(o1.start, o2.start);
            }
        });


        for (int i = 0;i < intervals.length - 1;i++) {
            if (intervals[i].end > intervals[i + 1].start) {
                return true;
            }
        }

        return false;
    }
}

class Interval {
    public int start;
    public int end;
}
