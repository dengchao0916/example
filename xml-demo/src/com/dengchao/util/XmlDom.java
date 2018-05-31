package com.dengchao.util;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XmlDom {
    public static void parseByDom(String filename) throws Exception {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document document = db.parse(filename);
        NodeList list = document.getElementsByTagName("student");
        System.out.println("一共有" + list.getLength() + "个学生");
        for (int i = 0; i < list.getLength(); i++) {
            System.out.println("第" + (i + 1) + "个学生：");
            Node student = list.item(i);
            NamedNodeMap attrs = student.getAttributes();
            System.out.println("第" + (i + 1) + "个学生有" + attrs.getLength() + "个属性");
            for (int j = 0; j < attrs.getLength(); j++) {
                Node attr = attrs.item(j);
                // 获取属性名
                System.out.print("属性名：" + attr.getNodeName());
                // 获取属性值
                System.out.println("， 属性值" + attr.getNodeValue());
            }
            NodeList childNodes = student.getChildNodes();
            System.out.println("第" + (i + 1) + "个学生公有" +
                    childNodes.getLength() + "个子节点");
            for (int k = 0; k < childNodes.getLength(); k++) {
              //区分出text类型的node以及element类型的node
                System.out.println("node类型：" + childNodes.item(k).getNodeType());
                if (childNodes.item(k).getNodeType() == Node.ELEMENT_NODE) {
                    // 获取了element类型节点的节点名
                    System.out.print("第" + (k + 1) + "个节点的节点名："
                            + childNodes.item(k).getNodeName());
                    // 获取了element类型节点的节点值
                    System.out.println("， 节点值是：" + childNodes.item(k).getFirstChild().getNodeValue());
                    // System.out.println("--节点值是：" +
                    // childNodes.item(k).getTextContent());
                }
            }
            System.out.println("======================结束遍历第" + (i + 1) + "个学生的内容=================");
        }
    }
}
