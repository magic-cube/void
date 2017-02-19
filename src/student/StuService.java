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
	
	//����
	public static void addStu(Student student) throws Exception{
		/*
		 * 1.����������
		 * 2.�õ�document
		 * 3.��ȡ���ڵ�
		 * 4.�ڸ��ڵ��ϴ���stu
		 * 5.��stu��ǩ�����������id name age
		 * 6.��id name age �����������ֵ
		 * 7.��д
		 */
		SAXReader reader=new SAXReader();
		Document document=reader.read("src/student/student.xml");
		//�õ����ڵ�
		Element root=document.getRootElement();
		Element stu=root.addElement("stu");
		
		Element id1=stu.addElement("id");
		Element name1=stu.addElement("name");
		Element age1=stu.addElement("age");
		
		id1.setText(student.getId());
		name1.setText(student.getName());
		age1.setText(student.getAge());
		
		//��д
		OutputFormat format=OutputFormat.createPrettyPrint();
		XMLWriter xmlWriter=new XMLWriter(new FileOutputStream("src/student/student.xml"), format);
		xmlWriter.write(document);
		xmlWriter.close();
		
	}
	
	
	//ɾ��,����ѧ��idɾ��
	public static void delStu(String id) throws Exception{
		/*
		 * ʹ��xpath //id ����list����
		 * P�жϼ��������id�ʹ��ݵ�id�Ƿ���ͬ
		 */
		SAXReader reader=new SAXReader();
		Document document=reader.read("src/student/student.xml");
		//��ȡ����id
		List<Node> list=document.selectNodes("//id");
		for (Node node : list) {
			String idv=node.getText();
			if(id.equals(idv)){
				Element stu=node.getParent();//�õ����ڵ�
				Element student=stu.getParent();
				student.remove(stu);
			}
		}
		//��д
		OutputFormat format=OutputFormat.createPrettyPrint();
		XMLWriter xmlWriter=new XMLWriter(new FileOutputStream("src/student/student.xml"),format);
		xmlWriter.write(document);
		xmlWriter.close();
		
	}
	
	//��ѯ ����id��ѯѧ����Ϣ
	public static Student getStu(String id) throws Exception{
		//����student����
		Student student=new Student();
		
		SAXReader reader=new SAXReader();
		Document document=reader.read("src/student/student.xml");
		//��ȡ����id
		List<Node> list=document.selectNodes("//id");
		for (Node node : list) {
			String idv=node.getText();
			if(id.equals(idv)){
				Element stu=node.getParent();//�õ����ڵ�
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
