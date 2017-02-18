package jaxp;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/*
 * sax解析,事件驱动,逐行解析
 * 不能执行增删改操作,只能执行查询操作
 */
public class TestSax {
	public static void main(String[] args) throws Exception {
		//创建解析器工厂
		//创建解析器
		//执行parse方法
		SAXParserFactory saxParserFactory=SAXParserFactory.newInstance();
		SAXParser saxParser=saxParserFactory.newSAXParser();
		saxParser.parse("src/jaxp/person.xml",new MyDefault1() );
	}
}

class MyDefault1 extends DefaultHandler{

	@Override
	public void startDocument() throws SAXException {
		super.startDocument();
	}


	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		super.characters(ch, start, length);
	}
	
	@Override
	public void endDocument() throws SAXException {
		super.endDocument();
	}
}












