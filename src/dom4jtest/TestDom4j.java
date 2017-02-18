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
	//获取到第一个name元素里面的值
	public static void selectSin() throws Exception{
		SAXReader reader=new SAXReader();
		Document document=reader.read("src/jaxp/person.xml");
		//得到根节点
		Element root=document.getRootElement();
		//得到第一个p1
		Element p1=root.element("p1");
		Node name1=p1.element("name");
		System.out.println(name1.getText());
		
	}
	//查询xml中所有那么元素的值
	public static void selectName() throws Exception{
		/*
		 * 1.创建解析器
		 * 2.得到document
		 * 3.得到根节点
		 * 4.得到p1
		 * 5.得到p1下面的name
		 * 5.得到name里的值
		 */
		SAXReader reader=new SAXReader();
		Document document=reader.read("src/jaxp/person.xml");
		//得到根节点
		Element root=document.getRootElement();
		//得到所有的p1
		List<Element> list=root.elements("p1");
		//遍历list
		for (Element element : list) {
			//element是每一个p1元素
			Element name1=element.element("name");
			//得到name里的值
			String s=name1.getText();
			System.out.println(s);
			
		}
		
	}
}


