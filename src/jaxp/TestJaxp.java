package jaxp;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

public class TestJaxp {
	
	public static void main(String[] args) throws Exception {
//		selectAll();
//		selectSin();
//		addSex();
		modifySex();
	}
	
	//修改sex的值
	public static void modifySex() throws Exception{
		DocumentBuilderFactory builderFactory=DocumentBuilderFactory.newInstance();
		DocumentBuilder builder=builderFactory.newDocumentBuilder();
		Document document=builder.parse("src/jaxp/person.xml");
		
		//得到sex
		Node sex1=document.getElementsByTagName("sex").item(0);
		//修改sex的值
		sex1.setTextContent("nan");
		
		//回写xml
		TransformerFactory transformerFactory=TransformerFactory.newInstance();
		Transformer transformer=transformerFactory.newTransformer();
		transformer.transform(new DOMSource(document), new StreamResult("src/jaxp/person.xml"));
		
		
		
		
		
	}
	
	//获取document对象
	private static Document init() throws Exception{
		DocumentBuilderFactory  builderFactory=DocumentBuilderFactory.newInstance();
		DocumentBuilder builder=builderFactory.newDocumentBuilder();
		return 	builder.parse("src/jaxp/person.xml");
	}
	
	//之前操作的document是内存中的,想要在文件中显示,需要回写
	//在第一个p1下面(末尾)添加<sex>nv</sex>
	public static void addSex() throws Exception{
		Document document=init();
		//获取p1
		NodeList list=document.getElementsByTagName("p1");
		//拿到p1标签
		Node p1=list.item(0);
		//创建<sex>,创建文本,把文本加到sex下
		Element sex1=document.createElement("sex");
		Text text1=document.createTextNode("nv");
		sex1.appendChild(text1);
		//把sex1添加到p1下面
		p1.appendChild(sex1);
		
		
		//回写xml
		TransformerFactory factory=TransformerFactory.newInstance();
		Transformer transformer=factory.newTransformer();
		transformer.transform(new DOMSource(document), new StreamResult("src/jaxp/person.xml"));
		
		
	}
	
	
	//查询xml中第一个name元素的值
	public static void selectSin() throws Exception{
		//创建解析器工厂
		DocumentBuilderFactory builderFactory=DocumentBuilderFactory.newInstance();
		//创建解析器
		DocumentBuilder builder=builderFactory.newDocumentBuilder();
		//解析xml,得到document
		Document document=builder.parse("src/jaxp/person.xml");
		
		//获取name标签
		NodeList list=document.getElementsByTagName("name");
		Node name=list.item(0);
		System.out.println(name.getTextContent());
	}
	
	//查询所有name元素的值
	private static void selectAll() throws Exception {
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










