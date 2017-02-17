package jaxp;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class TestJaxp {
	
	public static void main(String[] args) throws Exception {
		//查新所有name元素的值
		/*
		 * 1.创建解析器工厂
		 * 2.根据解析器工厂来创建解析器
		 * 3.解析xml返回document
		 * 
		 * 4.得到所有的name元素
		 */
		//创建解析器工厂
		DocumentBuilderFactory builderFactory=DocumentBuilderFactory.newInstance();
		//创建解析器
		DocumentBuilder builder=builderFactory.newDocumentBuilder();
		//解析xml,返回document
		Document document=builder.parse("src/jaxp/person.xml");
		
		//得到name元素
		NodeList list=document.getElementsByTagName("name");
		for(int i=0;i<list.getLength();i++){
			Node name1=list.item(i);
			//得到name元素里的值
			String s=name1.getTextContent();
			System.out.println(s);
		}
		
	}
	
}










