package com.dengchao.main;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MethodDemo {
    public static void main(String[] args) {
        A a = new A();
        Class<?> clazz = a.getClass();
        try {
            // Method method = c.getMethod("print", int.class,int.class);
            Method method = null;
            method = clazz.getMethod("print", new Class[] { int.class, int.class });
            // Object obj = m.invoke(a1, 10,20);
            Object obj = null;
            obj = method.invoke(a, new Object[] { 10, 20 });
            System.out.println("a + b:" + obj);
            System.out.println("==================");
            method = clazz.getMethod("print", String.class, String.class);
            obj = method.invoke(a, "hello", "world!");
            System.out.println("==================");
            method = clazz.getMethod("print");
            obj = method.invoke(a);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}

class A {
    public void print() {
        System.out.println("helloworld");
    }

    public Integer print(int a, int b) {
        System.out.println(a + b);
        return a + b;
    }

    public void print(String a, String b) {
        System.out.println(a.toUpperCase() + "," + b.toLowerCase());
    }
}