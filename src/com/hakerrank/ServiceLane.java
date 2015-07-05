package com.hakerrank;

import java.util.Scanner;

/**
 * @author Anatoly Chernysh
 */
public class ServiceLane {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int amountOfLaneSegments = in.nextInt();
        int amountOfTestCases = in.nextInt();

        int[] laneSegments = new int[amountOfLaneSegments];
        for(int i = 0;i < amountOfLaneSegments;i++){
            laneSegments[i] = in.nextInt();
        }

        for (int i = 0;i < amountOfTestCases;i++) {
            int startSegment = in.nextInt();
            int endSegment = in.nextInt();
            System.out.println(determineVehicleSuiteToServiceLane(laneSegments, startSegment, endSegment));
        }
    }

    public static int determineVehicleSuiteToServiceLane(int []segments, int startSegment, int endSegment) {
        int vehicle = Integer.MAX_VALUE;

        for (int i = startSegment;i <= endSegment;i++) {
            vehicle = Math.min(segments[i], vehicle);
        }

        return vehicle;
    }
}