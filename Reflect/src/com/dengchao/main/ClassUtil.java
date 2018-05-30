package com.dengchao.main;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ClassUtil {
    /**
     * 打印类的信息，包括类的成员函数、成员变量(只获取成员函数)
     * @param obj 该对象所属类的信息
     */
    public static void printMethodMessage(Object obj) {
        Class<?> c = obj.getClass();
        System.out.println("类的名称是：" + c.getName());
        /*
         * Method类，方法对象 一个成员方法就是一个Method对象
         * getMethods()方法获取的是所有的public的函数，包括父类继承而来的
         * getDeclaredMethods()获取的是所有该类自己声明的方法，不问访问权限
         */
        Method[] m = c.getMethods();
        for (int i = 0; i < m.length; i++) {
            Class<?> returnType = m[i].getReturnType();
            System.out.print("方法返回值的类类型：" + returnType.getName());
            System.out.print("，方法名称：" + m[i].getName());
            Class<?>[] param = m[i].getParameterTypes();
            for (Class<?> class1 : param) {
                System.out.print("，方法参数列表的类类型：" + class1.getName());
            }
            System.out.println();

        }
    }

    /**
     * 获取成员变量的信息
     * @param obj
     */
    public static void printFieldMessage(Object obj) {
        Class<?> c = obj.getClass();
        /*
         * 成员变量也是对象
         * java.lang.reflect.Field
         * Field类封装了关于成员变量的操作
         * getFields()方法获取的是所有的public的成员变量的信息
         * getDeclaredFields获取的是该类自己声明的成员变量的信息
         */
        Field[] f = c.getDeclaredFields();

        for (Field field : f) {
            // 成员变量类型的类类型
            Class<?> fieldType = field.getType();
            String typeName = fieldType.getName();
            // 成员变量名称
            String fieldName = field.getName();
            System.out.print("成员变量类型的类类型：" + typeName);
            System.out.println("，成员变量名称：" + fieldName);

        }

    }
    
    public static void printConMessage(Object obj){
        Class<?> c = obj.getClass();
        Constructor<?>[] cs = c.getDeclaredConstructors();
        for (Constructor<?> constructor : cs) {
            System.out.print("构造方法名称：" +constructor.getName());
            Class<?>[] paramTypes = constructor.getParameterTypes();
            for (Class<?> class1 : paramTypes) {
                System.out.print(",参数的类类型：" + class1.getName());
            }
            System.out.println();
        }
        
    }
}
