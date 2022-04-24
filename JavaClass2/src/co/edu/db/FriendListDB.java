package co.edu.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FriendListDB {

	public void friendListInsert(Friend friend) {

		Connection con = null;
		PreparedStatement pstmt = null;

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
			try {
				pstmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}
