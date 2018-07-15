package com.dengchao.main;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import freemarker.ext.dom.NodeModel;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class FMTest {
    public static void main(String[] args) throws Exception {
        FMTest test = new FMTest();
        test.getFile();
    }

    public void getFile() throws IOException, TemplateException,
            SAXException, ParserConfigurationException {

        // 得FreeMarker配置对象
        Configuration cfg = new Configuration();
        cfg.setEncoding(Locale.getDefault(), "UTF-8");
        cfg.setClassForTemplateLoading(this.getClass(), "/resources");
        // 得FreeMarker的关键对象---------模板
        Template temp = cfg.getTemplate("test.ftl");

        // 得FMTest类运行时/resources/ddd.xml的输入流文件，以便FreeMarker读出来
        // 注意：FMTest运行时，ddd.xml在工程打包的包中。Java强烈要求只能读包内
        // 文件。如果要得到运行的绝对路径，再用可写的流打包，java会严重抗议！
        InputStream in = FMTest.class.getResourceAsStream("/resources/ddd.xml");
        // 下面是FreeMarker的输入接口，这里与上面的in流建立关系，
        // 以便读取ddd.xml文件
        InputSource ins = new org.xml.sax.InputSource(in);

        Map<String, NodeModel> root = new HashMap<String, NodeModel>();
        // 特别注意此时的doc,这个符号将是，FreeMarker模板中取数的根！！！！！
        // 这里读取xml文件，并处理成root对象
        NodeModel nm = freemarker.ext.dom.NodeModel.parse(ins);
        NodeList nodeList = nm.getNode().getChildNodes();
        showNode(nodeList);
        root.put("doc", nm);

        // 建立内存字符串流
        java.io.StringWriter w = new StringWriter();
        // 模板开始按模板中的要求把用户输入的数据进行转换，并输出到字符串流中
        temp.process(root, w);
        // 字符串流输出到屏幕
        System.out.println(w.toString());
    }

    public void showNode(NodeList nodeList) {
        int length = nodeList.getLength();
        for (int i = 0; i < length; i++) {
            if (nodeList.item(i).getNodeType() == Node.ELEMENT_NODE) {
                String value = nodeList.item(i).getFirstChild().getNodeValue().trim();
                if (!"".equals(value)) {
                    System.out.print("节点的节点名：" + nodeList.item(i).getNodeName());
                    System.out.println("， 节点值是：" + value);
                }
            }
            showNode(nodeList.item(i).getChildNodes());
        }
    }
}
