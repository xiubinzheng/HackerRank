package com.amazon;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Anatoly Chernysh
 */
public class Amazon_3 {

    public static int WINNER = 1;
    public static int LOSER = 0;

    public static String ANY_FRUIT = "anything";

    class PromoItem {

        public String fruit;

        public boolean visited;

        public PromoItem(String fruit, boolean visited) {
            this.fruit = fruit;
            this.visited = visited;
        }
    }


    public int checkWinner(List<List<String>> codeList,
                           List<String> shoppingCart) {
        if (codeList.isEmpty()) {
            return WINNER;
        }

        int size = 0;
        for (List<String> fruitGroups : codeList) {
            size += fruitGroups.size();
        }

        PromoItem []promoItems = new PromoItem[size];
        int i = 0;
        for (List<String> fruitGroups : codeList) {
            for (String fruit : fruitGroups) {
                promoItems[i++] = new PromoItem(fruit, false);
            }
        }

        int currentPromoIndex = 0;
        for (String shoppingItem : shoppingCart) {

            if (currentPromoIndex >= promoItems.length) {
                break;
            }

            // normal case
            if (promoItems[currentPromoIndex].fruit.equals(shoppingItem)) {
                promoItems[currentPromoIndex++].visited = true;
            }

            // any case
            else if (promoItems[currentPromoIndex].fruit.equals(ANY_FRUIT)) {
                promoItems[currentPromoIndex++].visited = true;
            }

            // check if reset
            else if (currentPromoIndex > 0) {
                currentPromoIndex = 0;
                resetPromoItems(promoItems);
            }
        }

        // check winner
        for (PromoItem promoItem : promoItems) {
            if (!promoItem.visited) {
                return LOSER;
            }
        }

        return WINNER;
    }

    private void resetPromoItems(PromoItem []promoItems) {
        for (PromoItem promoItem : promoItems) {
            promoItem.visited = false;
        }
    }

    public static void main(String[] args) {
        Amazon_3 main = new Amazon_3();

        List<List<String>> codeList = new ArrayList<List<String>>();
        List<String> shoppingCart = new ArrayList<>();

        /*
        // test case 1
        List<String> group1 = new ArrayList<String>();
        group1.add("apple");
        group1.add("apple");
        codeList.add(group1);

        List<String> group2 = new ArrayList<String>();
        group2.add("banana");
        group2.add(ANY_FRUIT);
        group2.add("banana");
        codeList.add(group2);

        shoppingCart.add("orange");
        shoppingCart.add("apple");
        shoppingCart.add("apple");
        shoppingCart.add("banana");
        shoppingCart.add("orange");
        shoppingCart.add("banana");

        int result = main.checkWinner(codeList, shoppingCart);

        System.out.println(result);
        */

        /*
        // test case 2
        List<String> group1 = new ArrayList<String>();
        group1.add("apple");
        group1.add("apple");
        codeList.add(group1);

        List<String> group2 = new ArrayList<String>();
        group2.add("banana");
        group2.add(ANY_FRUIT);
        group2.add("banana");
        codeList.add(group2);

        shoppingCart.add("banana");
        shoppingCart.add("orange");
        shoppingCart.add("banana");
        shoppingCart.add("apple");
        shoppingCart.add("apple");

        int result = main.checkWinner(codeList, shoppingCart);

        System.out.println(result);
        */

        /*
        // test case 3
        List<String> group1 = new ArrayList<String>();
        group1.add("apple");
        group1.add("apple");
        codeList.add(group1);

        List<String> group2 = new ArrayList<String>();
        group2.add("banana");
        group2.add(ANY_FRUIT);
        group2.add("banana");
        codeList.add(group2);

        shoppingCart.add("apple");
        shoppingCart.add("banana");
        shoppingCart.add("apple");
        shoppingCart.add("banana");
        shoppingCart.add("orange");
        shoppingCart.add("banana");

        int result = main.checkWinner(codeList, shoppingCart);

        System.out.println(result);
        */

        /*
        // test case 4
        List<String> group1 = new ArrayList<String>();
        group1.add("apple");
        group1.add("apple");
        codeList.add(group1);

        List<String> group2 = new ArrayList<String>();
        group2.add("apple");
        group2.add("apple");
        group2.add("banana");
        codeList.add(group2);

        shoppingCart.add("apple");
        shoppingCart.add("apple");
        shoppingCart.add("apple");
        shoppingCart.add("banana");

        int result = main.checkWinner(codeList, shoppingCart);

        System.out.println(result);
        */

        // test case 4
        List<String> group1 = new ArrayList<String>();
        group1.add("apple");
        group1.add("apple");
        codeList.add(group1);

        List<String> group2 = new ArrayList<String>();
        group2.add("banana");
        group2.add(ANY_FRUIT);
        group2.add("banana");
        codeList.add(group2);

        shoppingCart.add("orange");
        shoppingCart.add("apple");
        shoppingCart.add("apple");
        shoppingCart.add("banana");
        shoppingCart.add("orange");
        shoppingCart.add("banana");
        shoppingCart.add("apple");

        int result = main.checkWinner(codeList, shoppingCart);

        System.out.println(result);

    }
}
