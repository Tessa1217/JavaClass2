package co.edu.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class FriendListDB {

	static Connection con = null;
	static PreparedStatement pstmt = null;
	static ResultSet rs = null;

	public static void friendInsert(Friend friend) {

		String sql = "INSERT INTO friend_table values(?, ?, ?, ?, default)";

		con = DBConnecter.connection();

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, friend.getName());
			pstmt.setInt(2, friend.getAge());
			pstmt.setString(3, friend.getContact());
			pstmt.setString(4, friend.getSsn());

			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeDB();
		}

	}

	public static Friend friendSelect(String name) {

		con = DBConnecter.connection();

		String sql = "SELECT * FROM friend_table WHERE name = ";

		Friend friend = null;

		try {

			pstmt = con.prepareStatement(sql + "'" + name + "'");
			rs = pstmt.executeQuery();
			System.out.println("Searching for friend name " + name);
			System.out.println();
			while (rs.next()) {
				friend = new Friend(rs.getString("name"), rs.getInt("age"), rs.getString("contact"),
						rs.getString("social_num"));
			}

		} catch (SQLException e2) {
			e2.printStackTrace();
		} finally {
			closeDB();
		}
		return friend;

	}

	public static String friendBirthday(String name) {

		con = DBConnecter.connection();

		String sql = "SELECT social_num FROM friend_table WHERE name = ";
		Friend friend = null;

		String birthday = "";

		try {
			pstmt = con.prepareStatement(sql + "'" + name + "'");
			rs = pstmt.executeQuery();

			while (rs.next()) {
				birthday = rs.getString("social_num");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeDB();
		}

		return birthday;
	}

	public static int friendGender(String name) {

		con = DBConnecter.connection();
		String sql = "SELECT SUBSTR(social_num, 8, 1) AS gendercode FROM friend_table WHERE name = ";
		int genderCode = 0;

		try {
			pstmt = con.prepareStatement(sql + "'" + name + "'");
			rs = pstmt.executeQuery();

			while (rs.next()) {
				genderCode = Integer.parseInt(rs.getString("gendercode"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeDB();
		}

		return genderCode;
	}

	public static void friendDelete(String name) {
		con = DBConnecter.connection();
		String sql = "DELETE FROM friend_table WHERE name = ";

		try {
			pstmt = con.prepareStatement(sql + "'" + name + "'");
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeDB();
		}
	}

	public static ArrayList<Friend> friendList() {
		con = DBConnecter.connection();

		String sql = "SELECT * FROM friend_table";

		ArrayList<Friend> friends = new ArrayList<Friend>();

		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String contact = rs.getString("contact");
				String ssn = rs.getString("social_num");
				Friend friend = new Friend(name, age, contact, ssn);
				friends.add(friend);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeDB();
		}

		return friends;
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
