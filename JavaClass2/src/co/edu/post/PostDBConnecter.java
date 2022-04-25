package co.edu.post;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PostDBConnecter {

	static Connection con = null;
	static PreparedStatement pstmt = null;
	static ResultSet rs = null;

	public static void addPost(Post post) {

		String sql = "INSERT INTO post_table VALUES (NUM_INCREMENT.NEXTVAL, ?, ?, ?, DEFAULT)";
		con = DBConnection.connection();

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, post.getTitle());
			pstmt.setString(2, post.getContent());
			pstmt.setString(3, post.getAuthor());

			pstmt.executeUpdate();
			System.out.println("포스트가 추가되었습니다.");
		} catch (SQLException e) {
			System.out.println("포스트 추가에 실패하였습니다.");
			e.printStackTrace();
		} finally {
			closeDB();
		}

	}

	public static void modifyPost(String author, int boardNo) {
		String sql = "SELECT * post_table WHERE post_author = '" + author + "' ";
		sql += "AND post_no = " + boardNo;
		con = DBConnection.connection();

		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				PostList postList = new PostList();
			}
		} catch (SQLException e) {
			System.out.println("포스트 수정에 실패했습니다.");
			e.printStackTrace();
		} finally {
			closeDB();
		}
	}

	public static ArrayList<Post> listPost() {
		String sql = "SELECT * FROM post_table ORDER BY post_no";
		ArrayList<Post> listPost = new ArrayList<Post>();

		con = DBConnection.connection();

		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				listPost.add(new Post(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5)));
			}

		} catch (SQLException e) {
			System.out.println("포스트 목록을 불러오지 못했습니다.");
			e.printStackTrace();
		} finally {
			closeDB();
		}

		return listPost;

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
