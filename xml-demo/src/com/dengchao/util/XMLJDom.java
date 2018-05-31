package com.dengchao.util;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.List;

import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;

import com.dengchao.bean.Student;

public class XMLJDom {

    public static void print() throws Exception {
        // 1.创建一个SAXBuilder的对象
        SAXBuilder saxBuilder = new SAXBuilder();
        // 2.创建一个输入流，将xml文件加载到输入流中
        InputStreamReader isr = new InputStreamReader(new FileInputStream("src/student.xml"), "utf-8");
        // 3.通过saxBuilder的build方法，将输入流加载到saxBuilder中
        Document document = saxBuilder.build(isr);
        // 4.通过document对象获取xml文件的根节点
        Element rootElement = document.getRootElement();
        // 5.获取根节点下的子节点的List集合
        List<Element> studentList = rootElement.getChildren();
        for (Element element : studentList) {
            Student student = new Student();
            System.out.println("======开始解析第" + (studentList.indexOf(element) + 1)
                    + "个学生======");
            // 解析student的属性集合
            List<Attribute> attrList = element.getAttributes();
            // //知道节点下属性名称时，获取节点值
            // element.getAttributeValue("id");
            // 遍历attrList(针对不清楚book节点下属性的名字及数量)
            for (Attribute attr : attrList) {
                // 获取属性名
                String attrName = attr.getName();
                // 获取属性值
                String attrValue = attr.getValue();
                System.out.println("属性名：" + attrName + "， 属性值："
                        + attrValue);
                if (attrName.equals("name")) {
                    student.setName(attrValue);
                }
            }
            // 对book节点的子节点的节点名以及节点值的遍历
            List<Element> bookChilds = element.getChildren();
            for (Element child : bookChilds) {
                System.out.println("节点名：" + child.getName() + "----节点值："
                        + child.getValue());
                if (child.getName().equals("age")) {
                    student.setAge(child.getValue());
                }
                else if (child.getName().equals("gender")) {
                    student.setGender(child.getValue());
                }
                else if (child.getName().equals("phone")) {
                    student.setPhone(child.getValue());
                }
                else if (child.getName().equals("address")) {
                    student.setAddress(child.getValue());
                }

            }
            System.out.println("======结束解析第" + (studentList.indexOf(element) + 1)
                    + "个学生======");
        }
    }
}
