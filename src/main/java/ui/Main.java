package ui;

import collections.AvlTree;

import model.Car;

public class Main {

    public static void main(String[] args) {
        AvlTree<Car> avl = new AvlTree<>();

        //1) Se compra el auto Ford Focus con placa JKB458
        Car car1 = new Car("Ford", "Focus", "JKB458");

        avl.insert(car1);
        System.out.println(avl.find(car1));
        System.out.println(avl.find(car1).getValue());
        System.out.println("-------------------");

        //2) Se compra el auto Honda Civic con placa ESP526
        Car car2 = new Car("Honda", "Civic", "ESP526");
        avl.insert(car2);
        System.out.println(avl.find(car2).getValue());
        System.out.println("-------------------");

        //3) Se compra el auto Mazda 3 con placa GUI512
        Car car3 = new Car("Mazda", "3", "GUI512");
        avl.insert(car3);
        System.out.println(avl.find(car3).getValue());
        System.out.println("-------------------");

        //4) Se compra el auto Renault Clio con placa TRM323
        Car car4 = new Car("Renault", "Clio", "TRM323");
        avl.insert(car4);
        System.out.println(avl.find(car4).getValue());

        System.out.println("-------------------");

        //5) Se compra el auto Toyota Prius con placa QEE419
        Car car5 = new Car("Toyota", "Prius", "QEE419");
        avl.insert(car5);
        System.out.println(avl.find(car5).getValue());

        System.out.println("-------------------");


        //6) Se vende el auto Mazda 3 con placa GUI512
        avl.remove(car3);

        System.out.println("-------------------");
        //7) Se compra el auto Mitsubishi Montero con placa SAL420
        Car car6 = new Car("Mitsubishi", "Montero", "SAL420");
        avl.insert(car6);
        System.out.println(avl.find(car6).getValue());

        System.out.println("-------------------");
        //8) Se vende el auto Honda Civic con placa ESP526

        avl.remove(car2);

        System.out.println("-------------------");

        //9) Se compra el auto Audi A4 con placa OPS437

        Car car7 = new Car("Audi", "A4", "OPS437");
        avl.insert(car7);
        System.out.println(avl.find(car7).getValue());

        System.out.println("-------------------");

        //10)Se vende el auto Renault Clio con placa TRM323

        avl.remove(car4);

        System.out.println("-------------------");

        //pre orden

        System.out.println(avl.preorden());

    }
}
