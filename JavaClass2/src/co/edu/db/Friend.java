package co.edu.db;

public class Friend {

	private String name;
	private int age;
	private String contact;
	private final String ssn;

	Friend(String name, int age, String contact, String ssn) {
		this.name = name;
		this.age = age;
		this.contact = contact;
		this.ssn = ssn;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getSsn() {
		return ssn;
	}

	@Override
	public String toString() {
		return "Friend\nName: " + name + "\nAge: " + age + "\nContact: " + contact;
	}

	public static String birthday(String ssn) {
		return "Friend's birthday: " + ssn.substring(2, 4) + "월 " + ssn.substring(4, 6) + "일";
	}

}
