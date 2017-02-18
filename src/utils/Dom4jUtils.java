package utils;

import java.io.FileOutputStream;
import java.io.IOException;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

/**
 * dom4j�Ĺ�����
 * @author hc
 *
 */
public class Dom4jUtils {
	
	//����ֱ���ڹ������н�·������Ϊһ������
	private static final String PATH="src/jaxp/person.xml";
	
	//����document
	public static Document getDocument(String path){
		try {
			//����������
			SAXReader reader=new SAXReader();
			//�õ�document
			Document document=reader.read(path);
			
			return document;
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	//��дxml�ķ���
	public static void xmlWriter(String path,Document document){
		try {
			OutputFormat format=OutputFormat.createPrettyPrint();
			XMLWriter xmlWriter=new XMLWriter(new FileOutputStream(""),format);
			xmlWriter.write(document);
			xmlWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
}
