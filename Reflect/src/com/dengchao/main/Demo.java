package com.dengchao.main;

public class Demo {
    public static void main(String[] args) {
        Foo foo = new Foo();
        // 任何一个类都是Class的实例对象，这个实例对象有三种表示方式
        // c1 ,c2 表示了Foo类的类类型(class type)
        Class<?> c1 = foo.getClass();
        Class<?> c2 = Foo.class;
        Class<?> c3 = null;
        try {
            c3 = Class.forName("com.dengchao.main.Foo");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println(c1);
        System.out.println(c1 == c2);
        System.out.println(c2 == c3);

    }

}

class Foo {
}