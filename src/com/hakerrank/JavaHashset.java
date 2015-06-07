package com.hakerrank;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author Anatoly Chernysh
 */
public class JavaHashset {

    public static class Pair {

        private String first;

        private String second;

        public void setFirst(String first) {
            this.first = first;
        }

        public void setSecond(String second) {
            this.second = second;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            if (second != null ? !second.equals(pair.second) : pair.second != null) return false;

            return true;
        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }
    }

    public static void main(String []args) {
        Scanner in = new Scanner(System.in);
        int amountLines = Integer.parseInt(in.nextLine());

        Set<Pair> uniquePairs = new HashSet<Pair>();

        for (int i = 0;i < amountLines;i++) {
            String parsedPair[] = in.nextLine().split(" ");

            JavaHashset.Pair pair = new JavaHashset.Pair();
            pair.setFirst(parsedPair[0]);
            pair.setSecond(parsedPair[1]);

            uniquePairs.add(pair);

            System.out.println(uniquePairs.size());
        }
    }
}
