package co.edu.post;

import java.util.Scanner;

public class AccountList implements AccountService {

	Scanner scn = new Scanner(System.in);

	public void execute() {

		while (true) {
			System.out.println(

					"=================================================================================================");
			System.out.println(
					"1.SIGN UP 2.LOG IN 3.MY INFO 4.CHANGE ID 5. CHANGE PWD 6. GO TO POST 7. WITHDRAW ACCOUNT 0. QUIT");
			System.out.println(
					"=================================================================================================");

			int menu = -1;

			try {
				menu = Integer.parseInt(scn.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("숫자를 입력해주세요.");
			}

			if (menu == 1) {
				Account account = signUp();
				AccountDBConnecter.accountAdd(account);
			} else if (menu == 2) {
				String[] info = logIn();
				boolean check = AccountDBConnecter.accountLogIn(info);
				if (check == true) {
					System.out.println("로그인에 성공하셨습니다.");
				} else if (check == false) {
					System.out.println("로그인에 실패하였습니다.");
				}

			} else if (menu == 3) {
				myInfo();
			} else if (menu == 4) {
				chgId();
			} else if (menu == 5) {
				chgPassword();
			} else if (menu == 6) {
				goToPost();
			} else if (menu == 7) {
				withdraw();
			} else if (menu == 0) {
				System.out.println("End of program");
				break;
			} else {
				System.out.println("메뉴를 다시 입력해주세요.");
			}
		}
	}

	@Override
	public Account signUp() {

		System.out.println("사용할 아이디 >>> ");
		String id = scn.nextLine();
		System.out.println("사용할 패스워드 >>> ");
		String pwd = scn.nextLine();
		System.out.println("비밀번호 찾기 질문: 비밀번호에 대한 힌트가 될만한 단어를 입력해주세요 >>> ");
		String validation = scn.nextLine();

		Account account = new Account(id, pwd, validation);

		return account;

	}

	@Override
	public String[] logIn() {
		String[] info = new String[2];

		System.out.println("아이디 >>> ");
		info[0] = scn.nextLine();
		System.out.println("비밀번호 >>> ");
		info[1] = scn.nextLine();

		return info;
	}

	@Override
	public void logOut() {
		System.out.println("로그아웃 하시겠습니까?");

	}

	@Override
	public void myInfo() {
		Account account = AccountDBConnecter.myInfo();
		try {
			System.out.println("=======================");
			System.out.println(account.toString());
			System.out.println("=======================");
		} catch (NullPointerException e) {
			System.out.println("사용자 정보를 찾을 수 없습니다.");
		}
	}

	@Override
	public void chgId() {
		System.out.println("현재 아이디 >>> ");
		String currentId = scn.nextLine();
		System.out.println("변경할 아이디 >>> ");
		String newId = scn.nextLine();
		AccountDBConnecter.chgId(currentId, newId);
	}

	@Override
	public void chgPassword() {
		System.out.println("현재 비밀번호 >>> ");
		String currentPwd = scn.nextLine();
		System.out.println("변경할 비밀번호 >>> ");
		String newPwd = scn.nextLine();
		AccountDBConnecter.chgPassword(currentPwd, newPwd);
	}

	@Override
	public void goToPost() {
		String author = AccountDBConnecter.execution();
		PostList postBoard = new PostList();
		postBoard.execute(author);
	}

	@Override
	public void withdraw() {
		System.out.println("삭제할 아이디 >>> ");
		String id = scn.nextLine();
		System.out.println("계정 비밀번호 인증 >>> ");
		String password = scn.nextLine();
		AccountDBConnecter.withdraw(id, password);
	}

}
