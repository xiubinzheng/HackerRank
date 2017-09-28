package com.epam;

/**
 * Stack is LIFO (last in, first out)
 *
 * @author Anatoly Chernysh
 */
public class MinValueStack {

    private Item tail;

    private int currentMin;

    public MinValueStack() {
        tail = null;
    }

    public void push(Integer value) {
        if (tail == null) {
            tail = new Item(value, value, null);
            currentMin = value;
        }
        else {
            Item tmp = tail;

            if (currentMin > value) {
                currentMin = value;
            }

            tail = new Item(value, currentMin, tmp);
        }
    }

    public Integer pop() {
        if (tail == null) {
            return null;
        }

        Item temp = tail.getPrev();
        Integer value = tail.getValue();
        tail = temp;
        return value;
    }

    public Integer getMinValue() {
        return tail.getMinValue();
    }

    public static void main(String[] args) {
        MinValueStack minValueStack = new MinValueStack();
        minValueStack.push(3);
        minValueStack.push(10);
        minValueStack.push(1);
        minValueStack.push(2);
        System.out.println(minValueStack.pop());
        System.out.println("min: " + minValueStack.getMinValue());
        System.out.println(minValueStack.pop());
        System.out.println("min: " + minValueStack.getMinValue());
    }
}

class Item {

    private Integer value;

    private Integer minValue;

    private Item prev;

    Item(Integer value, Integer minValue, Item prev) {
        this.value = value;
        this.minValue = minValue;
        this.prev = prev;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Integer getMinValue() {
        return minValue;
    }

    public void setMinValue(Integer minValue) {
        this.minValue = minValue;
    }

    public Item getPrev() {
        return prev;
    }

    public void setPrev(Item prev) {
        this.prev = prev;
    }
}