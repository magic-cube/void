package jaxp;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/*
 * sax����,�¼�����,���н���
 * ����ִ����ɾ�Ĳ���,ֻ��ִ�в�ѯ����
 */
public class TestSax {
	public static void main(String[] args) throws Exception {
		//��������������
		//����������
		//ִ��parse����
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












