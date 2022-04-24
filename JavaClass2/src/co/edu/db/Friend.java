package co.edu.db;

public class Friend {

	// Fields
	private String name;
	private int age;
	private String contact;
	private final String ssn;

	// Constructor
	Friend(String name, int age, String contact, String ssn) {
		this.name = name;
		this.age = age;
		this.contact = contact;
		this.ssn = ssn;
	}

	// Getters and Setters
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

	// Social security number = final field, only getter added
	public String getSsn() {
		return ssn;
	}

	// Return String
	@Override
	public String toString() {
		return "Friend\nName: " + name + "\nAge: " + age + "\nContact: " + contact;
	}

	public static String birthday(String ssn) {
		return "Friend's birthday: " + ssn.substring(2, 4) + "월 " + ssn.substring(4, 6) + "일";
	}

}
