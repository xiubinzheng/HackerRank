package com.algorithms;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Anatoly Chernysh
 */
public class FindMedianValue {

    public PriorityQueue<Integer> minHeap, maxHeap;

    public FindMedianValue() {
        maxHeap = new PriorityQueue<Integer>(new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });

        minHeap = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });
    }

    public void addNewNumber(int randomNumber) {
        if (maxHeap.size() == minHeap.size()) {
            if (minHeap.peek() != null && randomNumber > minHeap.peek()) {
                maxHeap.add(minHeap.poll());
                minHeap.add(randomNumber);
            }
            else {
                maxHeap.add(randomNumber);
            }
        }
        else {
            if (randomNumber < maxHeap.peek()) {
                minHeap.add(maxHeap.poll());
                maxHeap.add(randomNumber);
            }
            else {
                minHeap.add(randomNumber);
            }
        }
    }

    public double getMedian() {
        if (maxHeap.isEmpty()) {
            return 0;
        }
        if (maxHeap.size() == minHeap.size()) {
            return (double)(maxHeap.peek() + minHeap.peek()) / 2;
        }
        else {
            return maxHeap.peek();
        }
    }

    public static void main(String[] args) {
        FindMedianValue findMedianValue = new FindMedianValue();
        findMedianValue.addNewNumber(13);
        findMedianValue.addNewNumber(23);
        findMedianValue.addNewNumber(11);
        findMedianValue.addNewNumber(16);
        findMedianValue.addNewNumber(15);
        findMedianValue.addNewNumber(10);
        findMedianValue.addNewNumber(26);
        findMedianValue.addNewNumber(14);
        System.out.println("max: " + findMedianValue.maxHeap.peek() + ", size: " + findMedianValue.maxHeap.size());
        System.out.println("min: " + findMedianValue.minHeap.peek() + ", size: " + findMedianValue.minHeap.size());
        System.out.println("median: " + findMedianValue.getMedian());
    }
}
