package com.algorithms;

/**
 * @author Anatoly Chernysh
 */
public class CountingSort {

    public static void main(String[] args) {
        Item[] items = new Item[20];

        items[0] = new Item(2, "Anderson");
        items[1] = new Item(3, "Brown");
        items[2] = new Item(3, "Davis");
        items[3] = new Item(4, "Garcia");
        items[4] = new Item(1, "Harris");
        items[5] = new Item(3, "Jackson");
        items[6] = new Item(4, "Johnson");
        items[7] = new Item(3, "Jones");
        items[8] = new Item(1, "Martin");
        items[9] = new Item(2, "Martinez");
        items[10] = new Item(2, "Miller");
        items[11] = new Item(1, "Moore");
        items[12] = new Item(2, "Robinson");
        items[13] = new Item(4, "Smith");
        items[14] = new Item(3, "Taylor");
        items[15] = new Item(4, "Thomas");
        items[16] = new Item(4, "Thompson");
        items[17] = new Item(2, "White");
        items[18] = new Item(3, "Williams");
        items[19] = new Item(4, "Wilson");

        doCountingSort(items, 5);
    }

    public static void doCountingSort(Item[] a, int R) {
        int count[] = new int[R + 1];

        for (int i = 0;i < a.length;i++) {
            count[a[i].key + 1]++;
        }

        System.out.println("Repeat counter");
        print(count);

        for (int i = 0;i < count.length - 1;i++) {
            count[i + 1] = count[i] + count[i + 1];
        }

        System.out.println("Initial index");
        print(count);

        System.out.println("Data distribution");
        Item aux[] = new Item[a.length];
        for (int i = 0;i < a.length;i++) {
            aux[count[a[i].key]++] = a[i];
        }
        print(aux);

        System.out.println("Copying data back");
        for (int i = 0;i < a.length;i++) {
            a[i] = aux[i];
        }
        print(a);
    }

    static void print(int []count) {
        for (int i = 0;i < count.length;i++) {
            System.out.println("key = " + i + ", value = " + count[i]);
        }

    }

    static void print(Item []items) {
        for (int i = 0;i < items.length;i++) {
            System.out.println(items[i].toString());
        }
    }

}

class Item {

    int key;

    String value;

    public Item(int key, String value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Item{");
        sb.append("key=").append(key);
        sb.append(", value='").append(value).append('\'');
        sb.append('}');
        return sb.toString();
    }
}