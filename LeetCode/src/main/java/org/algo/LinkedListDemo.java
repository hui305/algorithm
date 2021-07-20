package org.algo;

import java.util.LinkedList;

/**
 * TODO
 *
 * @author bobstone
 * @version 1.0
 * @date 2021/7/20 14:55
 */
public class LinkedListDemo {

    public static void main(String[] args) {

        // creating an empty LinkedList
        LinkedList<String> list = new LinkedList<String>();
        // use add() method to add elements in the list
        list.add("Geeks");
        list.add("for");
        list.add("Geeks");
        list.add("10");
        list.add("20");

        // Output the present list
        System.out.println("The list is:" + list);
        // Adding new elements at the beginning
        list.addFirst("First");
        list.addFirst("At");

        // Displaying the new list
        System.out.println("The new List is:" + list);
    }
}
