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
	
	//�޸�sex��ֵ
	public static void modifySex() throws Exception{
		DocumentBuilderFactory builderFactory=DocumentBuilderFactory.newInstance();
		DocumentBuilder builder=builderFactory.newDocumentBuilder();
		Document document=builder.parse("src/jaxp/person.xml");
		
		//�õ�sex
		Node sex1=document.getElementsByTagName("sex").item(0);
		//�޸�sex��ֵ
		sex1.setTextContent("nan");
		
		//��дxml
		TransformerFactory transformerFactory=TransformerFactory.newInstance();
		Transformer transformer=transformerFactory.newTransformer();
		transformer.transform(new DOMSource(document), new StreamResult("src/jaxp/person.xml"));
		
		
		
		
		
	}
	
	//��ȡdocument����
	private static Document init() throws Exception{
		DocumentBuilderFactory  builderFactory=DocumentBuilderFactory.newInstance();
		DocumentBuilder builder=builderFactory.newDocumentBuilder();
		return 	builder.parse("src/jaxp/person.xml");
	}
	
	//֮ǰ������document���ڴ��е�,��Ҫ���ļ�����ʾ,��Ҫ��д
	//�ڵ�һ��p1����(ĩβ)���<sex>nv</sex>
	public static void addSex() throws Exception{
		Document document=init();
		//��ȡp1
		NodeList list=document.getElementsByTagName("p1");
		//�õ�p1��ǩ
		Node p1=list.item(0);
		//����<sex>,�����ı�,���ı��ӵ�sex��
		Element sex1=document.createElement("sex");
		Text text1=document.createTextNode("nv");
		sex1.appendChild(text1);
		//��sex1��ӵ�p1����
		p1.appendChild(sex1);
		
		
		//��дxml
		TransformerFactory factory=TransformerFactory.newInstance();
		Transformer transformer=factory.newTransformer();
		transformer.transform(new DOMSource(document), new StreamResult("src/jaxp/person.xml"));
		
		
	}
	
	
	//��ѯxml�е�һ��nameԪ�ص�ֵ
	public static void selectSin() throws Exception{
		//��������������
		DocumentBuilderFactory builderFactory=DocumentBuilderFactory.newInstance();
		//����������
		DocumentBuilder builder=builderFactory.newDocumentBuilder();
		//����xml,�õ�document
		Document document=builder.parse("src/jaxp/person.xml");
		
		//��ȡname��ǩ
		NodeList list=document.getElementsByTagName("name");
		Node name=list.item(0);
		System.out.println(name.getTextContent());
	}
	
	//��ѯ����nameԪ�ص�ֵ
	private static void selectAll() throws Exception {
		//��������nameԪ�ص�ֵ
		/*
		 * 1.��������������
		 * 2.���ݽ���������������������
		 * 3.����xml����document
		 * 
		 * 4.�õ����е�nameԪ��
		 */
		//��������������
		DocumentBuilderFactory builderFactory=DocumentBuilderFactory.newInstance();
		//����������
		DocumentBuilder builder=builderFactory.newDocumentBuilder();
		//����xml,����document
		Document document=builder.parse("src/jaxp/person.xml");
		
		//�õ�nameԪ��
		NodeList list=document.getElementsByTagName("name");
		for(int i=0;i<list.getLength();i++){
			Node name1=list.item(i);
			//�õ�nameԪ�����ֵ
			String s=name1.getTextContent();
			System.out.println(s);
		}
	}
	
}










