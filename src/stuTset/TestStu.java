package stuTset;

import student.StuService;
import student.Student;

public class TestStu {
	public static void main(String[] args) throws Exception{
//		testAdd();
//		testDel();
		testSel();
	}
	
	//������ӷ���
	public static void testAdd() throws Exception{
		//����ֵ
		Student stu=new Student();
		stu.setAge("50");
		stu.setId("103");
		stu.setName("sb");
		StuService.addStu(stu);
	}
	
	//����ɾ������
	public static void testDel() throws Exception{
		StuService.delStu("103");
	}
	
	
	//���Բ�ѯ����
	public static void testSel() throws Exception{
		Student stu=StuService.getStu("100");
		System.out.println(stu.toString());
	}
	
}



