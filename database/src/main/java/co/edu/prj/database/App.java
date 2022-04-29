package co.edu.prj.database;

import java.util.ArrayList;
import java.util.List;

import co.edu.prj.database.dto.StudentVO;
import co.edu.prj.database.service.StudentService;
import co.edu.prj.database.serviceImpl.StudentServiceImpl;

public class App {
	public static void main(String[] args) {

		StudentService dao = new StudentServiceImpl();
//
		// List
		List<StudentVO> students = new ArrayList<StudentVO>();
		students = dao.selectListStudent();
		for (StudentVO student : students) {
			student.toString();
		}
//
//		// Select
//		StudentVO student = students.get(0);
//		StudentVO foundStudent = dao.selectStudent(student);
//		foundStudent.toString();
//
//		// Insert
//		StudentVO insertStudent = new StudentVO();
//		insertStudent.setStudentId("micol@abc.com");
//		insertStudent.setName("박길동");
//		Date date = new Date(0, 1, 3);
//		insertStudent.setBirthday(date);
//		insertStudent.setMajor("Computer Science");
//		insertStudent.setAddress("대구광역시 북구");
//		int iResult = dao.insertStudent(insertStudent);
//		if (iResult != 0) {
//			System.out.println(iResult + "행이 삽입되었습니다.");
//		} else {
//			System.out.println("비정상적인 입력입니다.");
//		}
//
//		List<StudentVO> addList = new ArrayList<StudentVO>();
//
//		StudentVO vo = new StudentVO();
//		vo.setStudentId("lee22@abc.com");
//		vo.setName("이승기");
//		vo.setBirthday(Date.valueOf("2000-01-01"));
//		vo.setMajor("Music History");
//		vo.setTel("010-2222-4444");
//		addList.add(vo);
//
//		StudentVO vo2 = new StudentVO();
//		vo2.setStudentId("park333@abc.com");
//		vo2.setName("박길자");
//		vo2.setBirthday(Date.valueOf("1969-12-13"));
//		vo2.setMajor("Social Science");
//		vo2.setTel("010-3333-2222");
//		vo2.setAddress("부산광역시 수영구 해운대로");
//		addList.add(vo2);
//
//		int update = 0;
//		for (int i = 0; i < addList.size(); i++) {
//			update += dao.insertStudent(addList.get(i));
//		}
//		System.out.println(update + "행이 삽입되었습니다.");
//
//		// Update
//		StudentVO updateStudent = new StudentVO();
//		updateStudent.setStudentId("minsu@gmail.com");
//		updateStudent.setMajor("Computer Science");
//		updateStudent.setAddress("대구광역시 중구");
//		updateStudent.setTel("010-9444-9777");
//		int uResult = dao.updateStudent(updateStudent);
//		System.out.println(uResult + "행이 수정되었습니다.");
//
//		// Delete
//		StudentVO deleteStudent = new StudentVO();
//		deleteStudent.setStudentId("micol@abc.com");
//		int dResult = dao.deleteStudent(deleteStudent);
//		System.out.println(dResult + "행이 삭제되었습니다.");

	}
}
