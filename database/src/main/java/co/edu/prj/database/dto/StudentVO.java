package co.edu.prj.database.dto;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentVO { // Data Transfer Object

	// Member Variable
	private String studentId;
	private String name;
	private Date birthday;
	private String major;
	private String address;
	private String tel;

	@Override
	public String toString() {
		System.out.print(studentId + " : ");
		System.out.print(name + " : ");
		System.out.print(birthday + " : ");
		System.out.print(major + " : ");
		System.out.print(address + " : ");
		System.out.println(tel);
		return null;
	}

}
