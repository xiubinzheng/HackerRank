package com.hakerrank;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Anatoly Chernysh
 */
public class CavityMap {

    public static int X_VALUE = 999;

    public static class Cell {

        public int x;

        public int y;
    }

    public static void main(String []args) {

        Scanner in = new Scanner(System.in);
        int n = Integer.valueOf(in.nextLine());

        int [][]map = new int[n][n];
        for(int i = 0;i < n;i++) {

            String values = in.nextLine();
            for (int j = 0;j < n;j++) {
                map[i][j] = values.charAt(j) - 48;
            }
        }

        findCavityMap(map);
        printMatrix(map);
    }

    public static void findCavityMap(int [][]map) {
        ArrayList<Cell> cavityCells = new ArrayList<Cell>();

        for (int i = 1;i < map.length - 1;i++) {
            for (int j = 1;j < map.length - 1;j++) {
                int value = map[i][j];
                if (map[i - 1][j] < value && map[i + 1][j] < value &&
                        map[i][j - 1] < value && map[i][j + 1] < value) {
                    CavityMap.Cell cavityCell = new CavityMap.Cell();
                    cavityCell.x = i;
                    cavityCell.y = j;
                    cavityCells.add(cavityCell);
                }
            }
        }

        for (Cell cell : cavityCells) {
            map[cell.x][cell.y] = X_VALUE;
        }
    }

    static void printMatrix(int[][] map) {
        for(int i = 0;i < map.length;i++){
            for (int j = 0;j < map[i].length;j++) {
                if (map[i][j] == X_VALUE) {
                    System.out.print("X");
                }
                else {
                    System.out.print(map[i][j]);
                }
            }
            System.out.println("");
        }
    }
}