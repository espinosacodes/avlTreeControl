package ui;

import collections.BinarySearchTree;

public class Main {

    public static void main(String[] args) {
        BinarySearchTree<Integer> abb = new BinarySearchTree<>();

        System.out.println(abb.find(0));
        abb.insert(0);
        System.out.println(abb.find(0).getValue());

        System.out.println("-------------------");

        abb.insert(-2);
        System.out.println(abb.find(-1));
        abb.insert(-1);
        System.out.println(abb.find(-1).getValue());
        System.out.println(abb.find(-2).getValue());
        abb.insert(-2);
        abb.insert(10);

        System.out.println("-------------------");
        System.out.println(abb.preorden());

    }
}
