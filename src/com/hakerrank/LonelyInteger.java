package com.hakerrank;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Anatoly Chernysh
 */
public class LonelyInteger {

    static int lonelyinteger(int[] a) {
        Map<Integer, Integer> lonelyArray  = new HashMap<Integer, Integer>();
        for (int i = 0;i < a.length;i++) {
            if (lonelyArray.containsKey(a[i])) {
                lonelyArray.put(a[i], lonelyArray.get(a[i]) + 1);
            }
            else {
                lonelyArray.put(a[i], 1);
            }
        }

        Iterator<Map.Entry<Integer, Integer>> lonelyIter = lonelyArray.entrySet().iterator();
        while (lonelyIter.hasNext()) {
            Map.Entry<Integer, Integer> entry = lonelyIter.next();
            if (entry.getValue().equals(Integer.valueOf(1))) {
                return entry.getKey();
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int res;

        int _a_size = Integer.parseInt(in.nextLine());
        int[] _a = new int[_a_size];
        int _a_item;
        String next = in.nextLine();
        String[] next_split = next.split(" ");


        for(int _a_i = 0; _a_i < _a_size; _a_i++) {
            _a_item = Integer.parseInt(next_split[_a_i]);
            _a[_a_i] = _a_item;
        }

        res = lonelyinteger(_a);
        System.out.println(res);
    }
}
