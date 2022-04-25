package co.edu.post;

import java.util.Scanner;

public class AccountList implements AccountService {

	Scanner scn = new Scanner(System.in);
	
	@Override
	public void signUp() {
		
		System.out.println("사용할 아이디 >>> ");
		String id = scn.nextLine(); 
		System.out.println("사용할 패스워드 >>> ");
		String pwd = scn.nextLine(); 
		System.out.println("패스워드 확인키 >>> ");
		String validation = scn.nextLine();
		
		Account account = new Account(id, pwd, validation);
		
	}

	@Override
	public void logIn() {
		System.out.println("아이디 >>> ");
		String id = scn.nextLine(); 
		System.out.println("비밀번호 >>> ");
		String password = scn.nextLine(); 
	}

	@Override
	public void logOut() {
		System.out.println("로그아웃 하시겠습니까?");
		
	}

	@Override
	public void myInfo() {
		System.out.println();
	}

	@Override
	public void chgId() {
		System.out.println("현재 아이디 >>> ");
		String currentId = scn.nextLine(); 
		System.out.println("변경할 아이디 >>> ");
		String newId = scn.nextLine(); 
	}

	@Override
	public void chgPassword() {
		System.out.println("현재 비밀번호 >>> ");
		String currentPwd = scn.nextLine(); 
		System.out.println("변경할 비밀번호 >>> ");
		String newPwd = scn.nextLine(); 
	}

	@Override
	public void goToPost() {
		
	}

	@Override
	public void withdraw() {
		System.out.println("삭제할 아이디 >>> ");
		String id = scn.nextLine(); 
		System.out.println("계정 비밀번호 인증 >>> ");
		String password = scn.nextLine(); 
	}

}
