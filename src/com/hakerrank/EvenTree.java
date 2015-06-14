package com.hakerrank;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Anatoly Chernysh
 */
public class EvenTree {

    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);

        int N = scan.nextInt(); //points
        int M = scan.nextInt();

        int tree[] = new int[N];
        int count[] = new int[N];

        Arrays.fill(count, 1);

        for(int i = 0;i < M;i++) {
            int u = scan.nextInt();
            int v = scan.nextInt();

            tree[u - 1] = v;
            count[v - 1] += count[u - 1];

            int root = tree[v - 1];

            while(root != 0) {
                count[root - 1] += count[u - 1];
                root = tree[root - 1];
            }
        }

        int counter = -1;
        for(int i = 0;i < N;i++) {
            if(count[i] % 2 == 0) {
                counter++;
            }
        }

        System.out.println(counter);

    }
}
