package com.dengchao.util;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.dengchao.bean.Student;

public class XmlDom4j {
    private List<Student> list = new ArrayList<Student>();

    /**
     * @Decription:dom4j解析
     * @return
     * @return:List<Student>
     */
    public List<Student> record() {

        File file = new File("src/student.xml");

        SAXReader reader = new SAXReader();

        try {
            Document doc = reader.read(file);
            List<?> list1 = doc.selectNodes("/school/student/name");
            int length = list1.size();

            for (int i = 0; i < length; i++) {
                Student student = new Student();
                List<?> listName = doc.selectNodes("/school/student/name");
                student.setName(((Element) listName.get(i)).getText());
                List<?> listAge = doc.selectNodes("/school/student/age");
                student.setAge(((Element) listAge.get(i)).getText());
                List<?> listGender = doc.selectNodes("/school/student/gender");
                student.setGender(((Element) listGender.get(i)).getText());
                List<?> listPhone = doc.selectNodes("/school/student/phone");
                student.setPhone(((Element) listPhone.get(i)).getText());
                List<?> listAddress = doc
                        .selectNodes("/school/student/address");
                student.setAddress(((Element) listAddress.get(i)).getText());
                list.add(student);
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * @Decription:dom4j 递归方法解析
     * @param element
     * @return:void
     */
    @SuppressWarnings("unchecked")
    public static void query(Element element) {
        if (element == null) {
            return;
        }
        List<Attribute> list = element.attributes();
        for (Attribute attr : list) {
            System.out.println("节点名：" + element.getName() + "，属性名：" + attr.getName() + "，属性值："
                    + attr.getValue());
        }

        Iterator<Element> it = element.elementIterator();
        while (it.hasNext()) {
            Element ele = it.next();
            if (ele.elements().size() == 0) {
                System.out.print(ele.getName() + ":" + ele.getTextTrim());
            }
            System.out.println();
            query(ele);
        }
    }
}