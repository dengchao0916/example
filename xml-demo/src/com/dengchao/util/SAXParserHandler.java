package com.dengchao.util;

import java.util.ArrayList;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.dengchao.bean.Student;

public class SAXParserHandler extends DefaultHandler {
    String value = null;
    Student student = null;
    private ArrayList<Student> studentList = new ArrayList<Student>();

    public ArrayList<Student> getStudentList() {
        return studentList;
    }

    int studentIndex = 0;

    @Override
    public void startDocument() throws SAXException {
        System.out.println("SAX解析开始");
        
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("SAX解析结束");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        // super.startElement(uri, localName, qName, attributes);
        if (qName.equals("student")) {
            studentIndex++;
            student = new Student();
            System.out.println("======================开始遍历某一个学生的内容=================");
            // 已知book元素下属性的名称，根据属性名称获取属性值
            // String value = attributes.getValue("id");
            // System.out.println("book的属性值是：" + value);
            // 不知道book元素下属性的名称以及个数，如何获取属性名以及属性值
            int num = attributes.getLength();
            for (int i = 0; i < num; i++) {
                System.out.print("student元素的第" + (i + 1) + "个属性名是："
                        + attributes.getQName(i));
                System.out.println("， 属性值是：" + attributes.getValue(i));

            }
        } else if (!qName.equals("school")) {
            System.out.print("节点名是：" + qName + "， ");
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        super.endElement(uri, localName, qName);
        if (qName.equals("student")) {
            System.out.println("======================结束遍历某一个学生的内容=================");
        } else if (qName.equals("name")) {
            student.setName(value);
        }
        else if (qName.equals("age")) {
            student.setAge(value);
        }
        else if (qName.equals("gender")) {
            student.setGender(value);
        }
        else if (qName.equals("phone")) {
            student.setPhone(value);
        }
        else if (qName.equals("address")) {
            student.setAddress(value);
        }

    }

    @Override
    public void characters(char[] ch, int start, int length)
            throws SAXException {
        super.characters(ch, start, length);
        value = new String(ch, start, length);
        if (!value.trim().equals("")) {
            System.out.println("节点值是：" + value);
        }
    }

}
