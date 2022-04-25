package co.edu.post;

public class Account {
	
	// Fields 
	private String id;
	private String password; 
	private String validation;
	
	// Constructor 
	
//	Account(String id, String password) {
//		this.id = id;
//		this.password = password; 
//	}
	
	Account(String id, String password, String validation) {
		this.id = id;
		this.password = password;
		this.validation = validation; 
	}
	
	// Getters and Setters 
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getValidation() {
		return validation;
	}
	
	// toString 
	@Override
	public String toString() {
		return "** 나의 계정 정보 **\n" + 
				"[id = " + id + "]\n" + "[password = " + password + "]"; 
	}
	
	
	

}
