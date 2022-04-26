package listTest;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import collection.dto.StudentVO;

public class ListTest {
	
	public void listTest() {
		List<String> list = new ArrayList<String>();
		list.add("홍길동");
		list.add("박길동");
		list.add("이길동");
		
		for(String element : list) {
			System.out.println(element);
		}
		
		System.out.println(
				);
		
	}
	
	public void studentList() {
		
		// 학생 배열 리스트 생성 
		List<StudentVO> studentList = new ArrayList<StudentVO>();
		
		// 학생 인스턴스 생성 
		StudentVO student1 = new StudentVO();
		student1.setStudentId("202204001");
		student1.setName("Emily");
		student1.setAge(20);
		student1.setGender("Female");
		student1.setBirthday(Date.valueOf("2002-03-11"));
		
		StudentVO student2 = new StudentVO();
		student2.setStudentId("202204001");
		student2.setName("David");
		student2.setAge(20);
		student2.setGender("Male");
		student2.setBirthday(Date.valueOf("2002-05-11"));
		
		// 학생 배열 리스트에 인스턴스 추가 
		studentList.add(student1);
		studentList.add(student2);
		
		student2 = new StudentVO(); 
		student2.setStudentId("202204001");
		student2.setName("Amy");
		student2.setAge(20);
		student2.setGender("Female");
		student2.setBirthday(Date.valueOf("2002-11-17"));
		studentList.add(student2);
		
		for(StudentVO student : studentList) {
			System.out.println(student.toString());
			System.out.println();
		}
	}
	
	public static List<StudentVO> list() {
		
		List<StudentVO> studList = new ArrayList<StudentVO>();
		
		StudentVO student1 = new StudentVO();
		student1.setStudentId("202204001");
		student1.setName("Emily");
		student1.setAge(20);
		student1.setGender("Female");
		student1.setBirthday(Date.valueOf("2002-03-11"));
		
		StudentVO student2 = new StudentVO();
		student2.setStudentId("202204001");
		student2.setName("David");
		student2.setAge(20);
		student2.setGender("Male");
		student2.setBirthday(Date.valueOf("2002-05-11"));
		
		studList.add(student1);
		studList.add(student2);
		
		return studList;
	}


}
