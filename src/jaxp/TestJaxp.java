package jaxp;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class TestJaxp {
	
	public static void main(String[] args) throws Exception {
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










