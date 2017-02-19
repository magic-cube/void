package stuTset;

import student.StuService;
import student.Student;

public class TestStu {
	public static void main(String[] args) throws Exception{
//		testAdd();
//		testDel();
		testSel();
	}
	
	//测试添加方法
	public static void testAdd() throws Exception{
		//设置值
		Student stu=new Student();
		stu.setAge("50");
		stu.setId("103");
		stu.setName("sb");
		StuService.addStu(stu);
	}
	
	//测试删除方法
	public static void testDel() throws Exception{
		StuService.delStu("103");
	}
	
	
	//测试查询方法
	public static void testSel() throws Exception{
		Student stu=StuService.getStu("100");
		System.out.println(stu.toString());
	}
	
}



