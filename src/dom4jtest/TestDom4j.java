package dom4jtest;

import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

public class TestDom4j {
	public static void main(String[] args) throws Exception {
//		selectName();
		selectSin();
	}
	//��ȡ����һ��nameԪ�������ֵ
	public static void selectSin() throws Exception{
		SAXReader reader=new SAXReader();
		Document document=reader.read("src/jaxp/person.xml");
		//�õ����ڵ�
		Element root=document.getRootElement();
		//�õ���һ��p1
		Element p1=root.element("p1");
		Node name1=p1.element("name");
		System.out.println(name1.getText());
		
	}
	//��ѯxml��������ôԪ�ص�ֵ
	public static void selectName() throws Exception{
		/*
		 * 1.����������
		 * 2.�õ�document
		 * 3.�õ����ڵ�
		 * 4.�õ�p1
		 * 5.�õ�p1�����name
		 * 5.�õ�name���ֵ
		 */
		SAXReader reader=new SAXReader();
		Document document=reader.read("src/jaxp/person.xml");
		//�õ����ڵ�
		Element root=document.getRootElement();
		//�õ����е�p1
		List<Element> list=root.elements("p1");
		//����list
		for (Element element : list) {
			//element��ÿһ��p1Ԫ��
			Element name1=element.element("name");
			//�õ�name���ֵ
			String s=name1.getText();
			System.out.println(s);
			
		}
		
	}
}


