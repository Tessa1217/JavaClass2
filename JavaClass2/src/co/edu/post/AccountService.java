package co.edu.post;

public interface AccountService {

	// Method

	// 회원가입
	public Account signUp();

	// 로그인
	public String[] logIn();

	// 로그아웃
	public void logOut();

	// 현재 계정 정보
	public void myInfo();

	// 아이디 변경
	public void chgId();

	// 패스워드 변경
	public void chgPassword();

	// 포스트 페이지로 이동
	public void goToPost();

	// 계정 삭제
	public void withdraw();

}
