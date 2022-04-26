package co.edu.post;

import java.util.Scanner;

public class AccountList implements AccountService {

	Scanner scn = new Scanner(System.in);
	boolean loginStatus = false;

	// 계정 페이지 실행
	public void execute() {

		while (true) {
			System.out.println(

					"====================================================================================================");
			System.out.println(
					"1.SIGN UP 2.LOG IN 3.MY INFO 4.CHANGE ID 5. CHANGE PWD 6. GO TO POST 7. WITHDRAW 8. LOG OUT 9. QUIT");
			System.out.println(
					"====================================================================================================");

			int menu = -1;

			try {
				menu = Integer.parseInt(scn.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("숫자를 입력해주세요.");
			}

			// 로그인이 아닌 상태가 필요한 작업
			if (loginStatus == false) {
				if (menu == 1) {
					if (loginStatus == false) {
						Account account = signUp();
						AccountDBConnecter.accountAdd(account);
					} else if (loginStatus == true) {
						System.out.println("** 로그인 중에는 계정 생성이 불가합니다. **");
					}
				} else if (menu == 2) {
					String[] info = logIn();
					boolean check = AccountDBConnecter.accountLogIn(info);
					if (check == true) {
						System.out.println("로그인에 성공하셨습니다.");
						loginStatus = true;

					} else if (check == false) {
						System.out.println("로그인에 실패하였습니다.");
					}
				} else {
					if (2 < menu && menu < 9) {
						System.out.println("** 로그인이 필요한 작업입니다. **");
						continue;
					} else {
						System.out.println("메뉴를 다시 선택해주세요.");
					}
				}
			} else if (loginStatus == true) {
				switch (menu) {
				case 1:
					System.out.println("** 로그인 중에는 계정 생성이 불가능합니다. **");
					break;
				case 2:
					System.out.println("** 로그인 상태입니다. **");
					break;
				}

			}
			// 로그인인 상태로 진행해야하는 작업
			if (loginStatus == true) {
				if (menu == 3) {
					myInfo();
				} else if (menu == 4) {
					chgId();
				} else if (menu == 5) {
					chgPassword();
				} else if (menu == 6) {
					goToPost();
					break;
				} else if (menu == 7) {
					withdraw();
				} else if (menu == 8) {
					logOut();
				}
			} else if (loginStatus == false) {
				System.out.println("** 로그인 해주세요. **");
				continue;
			} else {
				if (menu == 1 || menu == 2) {
					System.out.println("** 현재 로그인 상태입니다. **");
				} else {
					System.out.println("메뉴를 다시 입력해주세요.");
				}
			}
			if (menu == 9) {
				System.out.println("End of program");
				break;
			}
		}

	}

	// 계정 생성을 위한 입력 받기 + DB 연결
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

	// 계정 로그인을 위한 입력 받기 + DB 연결
	@Override
	public String[] logIn() {
		String[] info = new String[2];

		System.out.println("아이디 >>> ");
		info[0] = scn.nextLine();
		System.out.println("비밀번호 >>> ");
		info[1] = scn.nextLine();

		return info;
	}

	// 계정 로그아웃 여부 확인을 위한 입력 받기 + DB 연결
	@Override
	public void logOut() {
		System.out.println("로그아웃 하시겠습니까? yes|no ");
		String answer = scn.nextLine();
		if (answer.startsWith("y") == true) {
			loginStatus = false;
			boolean check = AccountDBConnecter.accountLogOut();
			if (check == true) {
				System.out.println("로그아웃 하였습니다.");
			} else if (check == false) {
				System.out.println("로그아웃에 실패하였습니다.");
			}
		} else if (answer.startsWith("n") == true) {
			System.out.println("로그인 상태를 유지합니다.");
		} else {
			System.out.println("로그아웃에 실패하였습니다.");
		}
	}

	// 현재 계정 출력
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

	// 계정 아이디 변경을 위한 입력 받기 + DB 연결
	@Override
	public void chgId() {
		System.out.println("현재 아이디 >>> ");
		String currentId = scn.nextLine();
		System.out.println("변경할 아이디 >>> ");
		String newId = scn.nextLine();
		boolean check = AccountDBConnecter.chgId(currentId, newId);
		if (check == true) {
			System.out.println("아이디가 변경되었습니다.");
		} else if (check == false) {
			System.out.println("변경할 아이디를 다시 확인해주세요.");
		}
	}

	// 계정 비밀번호 변경을 위한 입력 받기 + DB 연결
	@Override
	public void chgPassword() {
		System.out.println("현재 비밀번호 >>> ");
		String currentPwd = scn.nextLine();
		System.out.println("변경할 비밀번호 >>> ");
		String newPwd = scn.nextLine();
		boolean check = AccountDBConnecter.chgPassword(currentPwd, newPwd);
		if (check == true) {
			System.out.println("비밀번호가 변경되었습니다.");
		} else if (check == false) {
			System.out.println("변경할 비밀번호를 다시 확인해주세요.");
		}
	}

	// 포스트 페이지 이동
	@Override
	public void goToPost() {
		String author = AccountDBConnecter.execution();
		PostList postBoard = new PostList();
		postBoard.execute(author);
	}

	// 계정 삭제를 위한 입력 받기 + DB 연결
	@Override
	public void withdraw() {
		System.out.println("삭제할 아이디 >>> ");
		String id = scn.nextLine();
		System.out.println("계정 비밀번호 인증 >>> ");
		String password = scn.nextLine();
		AccountDBConnecter.withdraw(id, password);
	}

}
