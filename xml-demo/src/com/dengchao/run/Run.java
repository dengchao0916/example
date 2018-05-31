package com.dengchao.run;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import com.dengchao.bean.Student;
import com.dengchao.util.SAXParserHandler;
import com.dengchao.util.XMLJDom;

public class Run {

    public static void main(String[] args) throws Exception {
        /*
         * List<Student> list = new XmlDom4j().record(); for (Student temp :
         * list) { System.out.println(temp); }
         */
        /*
         * File file = new File("src/student.xml"); SAXReader reader = new
         * SAXReader(); Document doc = reader.read(file);
         * 
         * Element root = doc.getRootElement(); XmlDom4j.query(root);
         */

        // XmlDom.parseByDom("src/student.xml");

        /*
         * SAXParserFactory factory = SAXParserFactory.newInstance(); SAXParser
         * parser = factory.newSAXParser(); SAXParserHandler handler = new
         * SAXParserHandler(); parser.parse("src/student.xml", handler); for
         * (Student student : handler.getStudentList()) {
         * System.out.println(student.getName());
         * System.out.println(student.getAge());
         * System.out.println(student.getGender());
         * System.out.println(student.getPhone());
         * System.out.println(student.getAddress());
         * 
         * }
         */

        XMLJDom.print();
    }
}
