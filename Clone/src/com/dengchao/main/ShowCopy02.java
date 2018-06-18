package com.dengchao.main;

import com.dengchao.entity.Car;
import com.dengchao.entity.Person;

//深拷贝
public class ShowCopy02 {

    public static void main(String[] args) {
        Car c1 = new Car();
        c1.setBrand("benz");
        c1.setCarId(12345);

        Person p1 = new Person();
        p1.setName("小明");
        p1.setAge(22);
        p1.setCar(c1);

        System.out.println(p1);

        try {
            Person p2 = (Person) p1.clone();
            p2.setName("小红");
            p2.setAge(25);
            Car c2 = p2.getCar();
            c2.setBrand("BMW");
            c2.setCarId(54321);
            p2.setCar(c2);
            System.out.println("复制后的：p1 = " + p1);
            System.out.println("复制后的：p2 = " + p2);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

    }

}
