package co.edu.post;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountDBConnecter {

	static Connection con = null;
	static PreparedStatement pstmt = null;
	static ResultSet rs = null;

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

	public static boolean accountLogIn(String[] info) {
		boolean check = false;
		String sql = "SELECT account_pwd FROM account WHERE account_id = ";
		con = DBConnection.connection();

		try {
			pstmt = con.prepareStatement(sql + "'" + info[0] + "'");
			rs = pstmt.executeQuery();
			if (rs.next()) {
				if (rs.getString(1).equals(info[1])) {
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

	public static void chgId(String currentId, String newId) {
		String sql = "UPDATE account SET account_id = '" + newId + "' WHERE account_id = '" + currentId + "'";
		con = DBConnection.connection();

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.executeQuery();
			System.out.println("아이디가 " + newId + "로 변경되었습니다.");
		} catch (SQLException e) {
			System.out.println("아이디 변경에 실패하셨습니다.");
			e.printStackTrace();
		} finally {
			closeDB();
		}
	}

	public static void chgPassword(String currentPwd, String newPwd) {
		String sql = "UPDATE account SET account_pwd = '" + newPwd + "' WHERE account_pwd = '" + currentPwd + "'";
		con = DBConnection.connection();

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.executeQuery();
			System.out.println("비밀번호 변경에 성공하셨습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("비밀번호 변경에 실패하셨습니다.");
		} finally {
			closeDB();
		}
	}

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

	public static String execution() {
		String sql = "SELECT account_id FROM account WHERE status = 'Y'";
		String author = "";
		con = DBConnection.connection();

		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
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
