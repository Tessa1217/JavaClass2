package co.edu.prj.database.service;

import java.util.List;

import co.edu.prj.database.dto.StudentVO;

public interface StudentService {

	List<StudentVO> selectListStudent(); // 전체 학생 목록

	StudentVO selectStudent(StudentVO student); // 한 명 학생 목록

	int insertStudent(StudentVO student); // 한 명 추가

	int updateStudent(StudentVO student); // 한 명 갱신

	int deleteStudent(StudentVO student); // 한 명 삭제

}
