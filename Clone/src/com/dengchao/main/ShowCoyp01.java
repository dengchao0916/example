package com.dengchao.main;

import com.dengchao.entity.Professor;
import com.dengchao.entity.Student;

//浅拷贝
public class ShowCoyp01 {

    public static void main(String[] args) {
        Professor p1 = new Professor();
        p1.setName("张教授");
        p1.setAge(30);

        Student s1 = new Student();
        s1.setName("小明");
        s1.setAge(18);
        s1.setProfessor(p1);

        System.out.println(s1);

        try {
            Student s2 = (Student) s1.clone();
            Professor p2 = s2.getProfessor();
            p2.setName("李教授");
            p2.setAge(45);
            s2.setProfessor(p2);
            System.out.println("复制后的：s1 = " + s1);
            System.out.println("复制后的：s2 = " + s2);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

    }

}
