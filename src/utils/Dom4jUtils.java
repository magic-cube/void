package utils;

import java.io.FileOutputStream;
import java.io.IOException;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

/**
 * dom4j的工具类
 * @author hc
 *
 */
public class Dom4jUtils {
	
	//可以直接在工具类中将路径定义为一个常量
	private static final String PATH="src/jaxp/person.xml";
	
	//返回document
	public static Document getDocument(String path){
		try {
			//创建解析器
			SAXReader reader=new SAXReader();
			//得到document
			Document document=reader.read(path);
			
			return document;
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	//回写xml的方法
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
