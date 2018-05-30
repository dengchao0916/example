package com.dengchao.main;

public class Main {
    public static void main(String[] args) {
        ClassUtil.printMethodMessage(new User());
        System.out.println("*****************");
        ClassUtil.printFieldMessage(new User());
        System.out.println("*****************");
        ClassUtil.printConMessage(new User());

    }
}

class User {
    public String name;
    public int age;

    public User() {

    }

    public User(String name, int age) {
        super();
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User [name=" + name + ", age=" + age + "]";
    }

}
