package com.dengchao.main;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class Compile {

    public static void main(String[] args) {
        ArrayList list1 = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<String>();

        Class<?> c1 = list1.getClass();
        Class<?> c2 = list2.getClass();

        System.out.println(c1 == c2);
        //反射的操作都是编译之后的操作

        /*
         * c1==c2结果返回true说明编译之后集合的泛型是去泛型化的 Java中集合的泛型，是防止错误输入的，只在编译阶段有效，
         * 绕过编译就无效了 验证：我们可以通过方法的反射来操作，绕过编译
         */
        try {
            Method method = c1.getMethod("add", Object.class);
            method.invoke(list2, 20);
            System.out.println(list2);
            System.out.println(list2.size());
            /*for (String string : list1) {
            System.out.println(string);
        }*///现在不能这样遍历
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
