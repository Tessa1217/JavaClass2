package co.edu.post;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class PostDBConnecter {

	static Connection con = null;
	static PreparedStatement pstmt = null;
	static ResultSet rs = null;
	static Scanner scn = new Scanner(System.in);

	// 포스트 추가
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

	// 포스트 수정
	public static boolean modifyPost(String author, int boardNo) {
		System.out.println("제목 수정 >>> ");
		String title = scn.nextLine();
		System.out.println("내용 수정 >>> ");
		String content = "";
		while (true) {
			String temp = scn.nextLine();
			if (temp.equals("")) {
				break;
			}
			content += temp + "\n";
		}

		String sql = "UPDATE post_table SET post_title = '" + title + "', post_content = '" + content + "' ";
		sql += "WHERE post_author = '" + author + "' ";
		sql += "AND post_no = " + boardNo;
		con = DBConnection.connection();
		boolean check = false;

		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			check = rs.next();

		} catch (SQLException e) {
			System.out.println("포스트 수정에 실패했습니다.");
			e.printStackTrace();
		} finally {
			closeDB();
		}

		return check;
	}

	// 게시물 번호를 받아 포스트 삭제
	public static boolean deletePost(int postNum, String author) {

		String sql = "DELETE FROM post_table WHERE post_no = " + postNum;
		sql += " AND post_author = '" + author + "'";
		boolean check = false;

		con = DBConnection.connection();

		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			// 삭제할 데이터의 여부를 확인하기 위해 불린형에 저장
			check = rs.next();
		} catch (SQLException e) {
			System.out.println("포스트 삭제에 실패하셨습니다.");
			e.printStackTrace();
		} finally {
			closeDB();
		}

		return check;

	}

	// 특정 포스트의 상세내역 조회
	public static Post searchPost(int postNum) {
		String sql = "SELECT * FROM post_table WHERE post_no = " + postNum;
		Post post = new Post();
		con = DBConnection.connection();

		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				post.setBoardNo(rs.getInt(1));
				post.setTitle(rs.getString(2));
				post.setContent(rs.getString(3));
				post.setAuthor(rs.getString(4));
				post.setDate(rs.getDate(5));
			}
		} catch (SQLException e) {
			System.out.println("포스트 조회에 실패했습니다.");
			e.printStackTrace();
		} finally {
			closeDB();
		}

		return post;

	}

	// 포스트 전체 조회
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
