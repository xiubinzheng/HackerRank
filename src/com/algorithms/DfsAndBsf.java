package com.algorithms;

import java.util.*;

/**
 * @author Anatoly Chernysh
 */
public class DfsAndBsf {

    static class Item {

        public String data;

        public List<Item> items;

        public Item(String data) {
            this.data = data;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Item)) return false;

            Item item = (Item) o;

            if (data != null ? !data.equals(item.data) : item.data != null) return false;

            return true;
        }

        @Override
        public int hashCode() {
            return data != null ? data.hashCode() : 0;
        }
    }

    public static void main(String[] args) {
        Item A = new DfsAndBsf.Item("A");
        A.items = new ArrayList<>();
        A.items.add(new Item("B"));

        Item S = new Item("S");
        S.items = new ArrayList<>();
        A.items.add(S);

        Item C = new Item("C");
        Item G = new Item("G");
        S.items.add(C);
        S.items.add(G);

        Item F = new Item("F");
        Item D = new Item("D");
        Item E = new Item("E");
        C.items = new ArrayList<>();
        C.items.add(D);
        C.items.add(E);
        C.items.add(F);

        Item H = new Item("H");
        E.items = new ArrayList<>();
        E.items.add(H);
        E.items.add(C);
        H.items = new ArrayList<>();
        H.items.add(E);
        H.items.add(G);

        F.items = new ArrayList<>();
        F.items.add(C);
        F.items.add(G);

        G.items = new ArrayList<>();
        G.items.add(F);
        G.items.add(H);

        breadFirstSearch(A);
    }

    public static void depthFirstSearch(Item root) {
        Stack<Item> stack = new Stack<>();
        HashSet<Item> visitedItems = new HashSet<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            Item current = stack.pop();

            if (!visitedItems.contains(current)) {
                System.out.print(current.data + " ");
                visitedItems.add(current);
                if (current.items != null) {
                    for (Item child : current.items) {
                        stack.push(child);
                    }
                }
            }
        }
    }

    public static void depthFirstSearchRec(Item root) {
        HashSet<Item> visitedItems = new HashSet<>();
        visitedItems.add(root);
        System.out.print(root.data + " ");
        depthFirstSearchRecHelper(root, visitedItems);
    }

    public static void depthFirstSearchRecHelper(Item root, HashSet<Item> visitedItems) {
        if (root.items == null) {
            return;
        }

        for (Item child : root.items) {
            if (!visitedItems.contains(child)) {
                System.out.print(child.data + " ");
                visitedItems.add(child);
                depthFirstSearchRecHelper(child, visitedItems);
            }
        }
    }

    public static void breadFirstSearch(Item root) {
        Queue<Item> queue = new ArrayDeque<>();
        HashSet<Item> visitedItems = new HashSet<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Item current = queue.poll();

            if (!visitedItems.contains(current)) {
                System.out.print(current.data + " ");
                visitedItems.add(current);
                if (current.items != null) {
                    for (Item child : current.items) {
                        queue.add(child);
                    }
                }
            }
        }
    }

}
