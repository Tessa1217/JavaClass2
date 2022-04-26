package co.edu.post;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountDBConnecter {

	static Connection con = null;
	static PreparedStatement pstmt = null;
	static ResultSet rs = null;

	// 계정 생성
	public static void accountAdd(Account account) {
		String sql = "INSERT INTO account VALUES (?, ?, ?, DEFAULT)";
		con = DBConnection.connection();

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, account.getId());
			pstmt.setString(2, account.getPassword());
			pstmt.setString(3, account.getValidation());

			pstmt.executeUpdate();
			System.out.println("계정이 생성되었습니다.");

		} catch (SQLException e) {
			System.out.println("계정 생성에 실패하였습니다.");
			e.printStackTrace();
		} finally {
			closeDB();
		}
	}

	// 계정 로그인
	public static boolean accountLogIn(String[] info) {
		boolean check = false;
		String sql = "SELECT account_pwd FROM account WHERE account_id = ";
		con = DBConnection.connection();

		try {
			pstmt = con.prepareStatement(sql + "'" + info[0] + "'");
			rs = pstmt.executeQuery();
			if (rs.next()) {
				if (rs.getString(1).equals(info[1])) {
					// 계정 로그인 시 계정 로그인 현황을 Yes 상태로 변경
					sql = "UPDATE account SET status = CASE WHEN account_id = '" + info[0] + "' THEN 'Y'";
					sql += "WHEN account_id <> '" + info[0] + "' THEN 'N' END";
					pstmt = con.prepareStatement(sql);
					pstmt.executeUpdate();
					check = true;
				} else {
					check = false;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeDB();
		}
		return check;

	}

	// 계정 로그아웃
	public static boolean accountLogOut() {
		// 현재 로그인 현황이 Yes인 상태의 계정을 No 상태로 변경
		String sql = "UPDATE account SET status = 'N' WHERE status = 'Y'";
		con = DBConnection.connection();
		boolean check = false;

		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			check = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeDB();
		}
		return check;
	}

	// 현재 계정 정보
	public static Account myInfo() {

		String sql = "SELECT account_id, account_pwd FROM account WHERE status = 'Y'";
		Account account = null;
		con = DBConnection.connection();

		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				account = new Account(rs.getString(1), rs.getString(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeDB();
		}
		return account;
	}

	// 아이디 변경
	public static boolean chgId(String currentId, String newId) {
		boolean check = false;
		String sql = "UPDATE account SET account_id = '" + newId + "' WHERE account_id = '" + currentId + "'";
		con = DBConnection.connection();

		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			check = rs.next();
		} catch (SQLException e) {
			System.out.println("아이디 변경에 실패하셨습니다.");
			e.printStackTrace();
		} finally {
			closeDB();
		}
		return check;
	}

	// 비밀번호 변경
	public static boolean chgPassword(String currentPwd, String newPwd) {
		String sql = "UPDATE account SET account_pwd = '" + newPwd + "' WHERE account_pwd = '" + currentPwd + "'";
		con = DBConnection.connection();
		boolean check = false;

		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			check = rs.next();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("비밀번호 변경에 실패하셨습니다.");
		} finally {
			closeDB();
		}
		return check;
	}

	// 계정 삭제
	public static void withdraw(String id, String password) {
		String sql = "DELETE FROM account where account_id = '" + id + "' AND account_pwd = '" + password + "'";
		con = DBConnection.connection();

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.executeQuery();
			System.out.println("계정 탈퇴가 완료되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeDB();
		}
	}

	// 포스트 페이지로 넘어가기 위해 현재 로그인 중인 아이디 조회
	public static String execution() {
		String sql = "SELECT account_id FROM account WHERE status = 'Y'";
		String author = "";
		con = DBConnection.connection();

		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				// 해당 사용자의 아이디가 포스트 페이지 실행을 위한 매개 변수로 넘어감
				author += rs.getString(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeDB();
		}
		return author;
	}

	private static void closeDB() {
		try {
			pstmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
