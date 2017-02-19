package student;

import java.io.FileOutputStream;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class StuService {
	
	//增加
	public static void addStu(Student student) throws Exception{
		/*
		 * 1.创建解析器
		 * 2.得到document
		 * 3.获取根节点
		 * 4.在根节点上创建stu
		 * 5.在stu标签上面依次添加id name age
		 * 6.在id name age 上面依次添加值
		 * 7.回写
		 */
		SAXReader reader=new SAXReader();
		Document document=reader.read("src/student/student.xml");
		//得到根节点
		Element root=document.getRootElement();
		Element stu=root.addElement("stu");
		
		Element id1=stu.addElement("id");
		Element name1=stu.addElement("name");
		Element age1=stu.addElement("age");
		
		id1.setText(student.getId());
		name1.setText(student.getName());
		age1.setText(student.getAge());
		
		//回写
		OutputFormat format=OutputFormat.createPrettyPrint();
		XMLWriter xmlWriter=new XMLWriter(new FileOutputStream("src/student/student.xml"), format);
		xmlWriter.write(document);
		xmlWriter.close();
		
	}
	
	
	//删除,根据学生id删除
	public static void delStu(String id) throws Exception{
		/*
		 * 使用xpath //id 返回list集合
		 * P判断集合里面的id和传递的id是否相同
		 */
		SAXReader reader=new SAXReader();
		Document document=reader.read("src/student/student.xml");
		//获取所有id
		List<Node> list=document.selectNodes("//id");
		for (Node node : list) {
			String idv=node.getText();
			if(id.equals(idv)){
				Element stu=node.getParent();//得到父节点
				Element student=stu.getParent();
				student.remove(stu);
			}
		}
		//回写
		OutputFormat format=OutputFormat.createPrettyPrint();
		XMLWriter xmlWriter=new XMLWriter(new FileOutputStream("src/student/student.xml"),format);
		xmlWriter.write(document);
		xmlWriter.close();
		
	}
	
	//查询 根据id查询学生信息
	public static Student getStu(String id) throws Exception{
		//创建student对象
		Student student=new Student();
		
		SAXReader reader=new SAXReader();
		Document document=reader.read("src/student/student.xml");
		//获取所有id
		List<Node> list=document.selectNodes("//id");
		for (Node node : list) {
			String idv=node.getText();
			if(id.equals(idv)){
				Element stu=node.getParent();//得到父节点
				String agev=stu.element("age").getText();
				String namev=stu.element("name").getText();
				student.setId(idv);
				student.setAge(agev);
				student.setName(namev);
			}
		}

		return student;
	}
	
	
	
	
}
