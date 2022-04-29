package co.edu.prj.database.serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.edu.prj.database.dao.DataSource;
import co.edu.prj.database.dto.StudentVO;
import co.edu.prj.database.service.StudentService;

public class StudentServiceImpl implements StudentService {
	private DataSource dataSource = DataSource.getInstance();
	private Connection conn = dataSource.connection(); // DB connecter
	private PreparedStatement psmt; // sending SQL
	private ResultSet rs; // getting the selected result

	@Override
	public List<StudentVO> selectListStudent() {
		List<StudentVO> students = new ArrayList<StudentVO>();
		StudentVO student;
		String sql = "SELECT * FROM STUDENT";
		try {
			psmt = conn.prepareStatement(sql); // conn을 통해서 sql을 전송
			rs = psmt.executeQuery(); // psmt로 보낸 sql을 실행시켜서 rs를 받아옴
			while (rs.next()) {
				student = new StudentVO();
				student.setStudentId(rs.getString("student_id"));
				student.setName(rs.getString("name"));
				student.setBirthday(rs.getDate("birthday"));
				student.setMajor(rs.getString("major"));
				student.setAddress(rs.getString("address"));
				student.setTel(rs.getString("tel"));
				students.add(student);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return students;
	}

	@Override
	public StudentVO selectStudent(StudentVO student) {
		StudentVO foundStudent = new StudentVO();
		String sql = "SELECT * FROM STUDENT WHERE STUDENT_ID = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, student.getStudentId());
			rs = psmt.executeQuery();
			if (rs.next()) {
				foundStudent.setStudentId(rs.getString("student_id"));
				foundStudent.setName(rs.getString("name"));
				foundStudent.setBirthday(rs.getDate("birthday"));
				foundStudent.setMajor(rs.getString("major"));
				foundStudent.setAddress(rs.getString("address"));
				foundStudent.setTel(rs.getString("tel"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return foundStudent;
	}

	@Override
	public int insertStudent(StudentVO student) {
		String sql = "INSERT INTO STUDENT VALUES (?, ?, ?, ?, ?, ?)";
		int insertStudent = 0;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, student.getStudentId());
			psmt.setString(2, student.getName());
			psmt.setDate(3, student.getBirthday());
			psmt.setString(4, student.getMajor());
			psmt.setString(5, student.getAddress());
			psmt.setString(6, student.getTel());
			insertStudent = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return insertStudent;
	}

	@Override
	public int updateStudent(StudentVO student) {
		int update = 0;
		String sql = "UPDATE STUDENT SET MAJOR = ?, ADDRESS = ?, " + "TEL = ? WHERE STUDENT_ID = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, student.getMajor());
			psmt.setString(2, student.getAddress());
			psmt.setString(3, student.getTel());
			psmt.setString(4, student.getStudentId());
			update = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return update;
	}

	@Override
	public int deleteStudent(StudentVO student) {

		String sql = "DELETE FROM STUDENT WHERE STUDENT_ID = ?";
		int delete = 0;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, student.getStudentId());
			delete = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return delete;

	}

}
