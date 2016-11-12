package com.algorithms;

/**
 * @author Anatoly Chernysh
 */
public class LSDSort {

    public static void main(String[] args) {
        String a[] = {"4PGC938", "2IYE230", "3CIO720", "1ICK750", "10HV845", "3ATW723", "2RLA629", "4JZY524"};
        doLSDSort(a);
    }

    public static void doLSDSort(String[] a) {
        int W = a[0].length();
        int R = 256; // amount of characters
        String []aux = new String[a.length];

        for (int i = W - 1;i >= 0;i--) {
            int count[] = new int[R + 1];

            System.out.println("Repeat counter for " + i);
            for (int j = 0;j < a.length;j++) {
                count[a[j].charAt(i) + 1]++;
            }
            print(count);

            System.out.println("Index transformation");
            for (int j = 0;j < count.length - 1;j++) {
                count[j + 1] = count[j] + count[j + 1];
            }
            print(count);

            System.out.println("Data distribution");
            for (int j = 0;j < a.length;j++) {
                aux[count[a[j].charAt(i)]++] = a[j];
            }

            System.out.println("Copying data back");
            for (int j = 0;j < a.length;j++) {
                a[j] = aux[j];
            }
            print(a);
        }
    }

    static void print(int []count) {
        for (int i = 0;i < count.length;i++) {
            System.out.println("key = " + i + ", value = " + count[i]);
        }
        System.out.println("");
    }

    static void print(String []items) {
        for (int i = 0;i < items.length;i++) {
            System.out.println(items[i]);
        }
        System.out.println("");
    }

}