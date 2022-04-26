package co.edu.post;

import java.util.ArrayList;
import java.util.Scanner;

public class PostList implements PostService {

	Scanner scn = new Scanner(System.in);
	int boardNo = 1;
	static String author = "";

	// 포스트 페이지 실행
	public void execute(String accountId) {

		author = accountId;

		while (true) {
			System.out.println("===============================================================================");
			System.out.println("1.Add Post 2.Modify Post 3.Delete Post 4.Search Post 5. List Post 6.My Account");
			System.out.println("===============================================================================");
			int menu = 0;

			try {
				menu = Integer.parseInt(scn.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("숫자를 입력해주세요.");
			}

			if (menu == 1) {
				addPost();
			} else if (menu == 2) {
				modifyPost();
			} else if (menu == 3) {
				deletePost();
			} else if (menu == 4) {
				srchPost();
			} else if (menu == 5) {
				listPost();
			} else if (menu == 6) {
				goToAccount();
				break;
			}
		}
	}

	// 포스트 추가를 위해 입력 받기 + DB 연결
	@Override
	public void addPost() {

		System.out.println("Title >>> ");
		String title = scn.nextLine();
		String content = addContent();
		Post post = new Post(title, content, author);
		PostDBConnecter.addPost(post);

	}

	public String addContent() {
		System.out.println("Content >>> ");
		String content = "";
		while (true) {
			String temp = scn.nextLine();
			if (temp.equals("")) {
				break;
			}
			content += temp + "\n";
		}
		return content;
	}

	// 포스트 수정을 위해 입력 받기 + DB 연결
	@Override
	public void modifyPost() {
		System.out.println("수정할 포스트 번호 >>> ");
		int postNum = Integer.parseInt(scn.nextLine());
		boolean check = PostDBConnecter.modifyPost(author, postNum);
		if (check == true) {
			System.out.println("수정이 완료되었습니다.");
		} else if (check == false) {
			System.out.println("수정할 게시물이 존재하지 않습니다.");
		}

	}

	// 포스트 삭제를 위한 입력 받기 + DB 연결
	@Override
	public void deletePost() {
		System.out.println("삭제할 포스트 번호 >>> ");
		int postNum = Integer.parseInt(scn.nextLine());
		boolean check = PostDBConnecter.deletePost(postNum, author);
		if (check == true) {
			System.out.println("삭제가 완료되었습니다.");
		} else if (check == false) {
			System.out.println("삭제할 포스트가 없습니다.");
		}

	}

	// 특정 포스트 조회를 위한 입력 받기 + DB 연결 + 상세 출력
	@Override
	public void srchPost() {
		System.out.println("상세 조회할 포스트 번호 >>> ");
		int postNum = Integer.parseInt(scn.nextLine());
		Post post = PostDBConnecter.searchPost(postNum);
		try {
			if (post.getAuthor() != null) {
				post.detailView();
			} else {
				System.out.println("해당 포스트가 존재하지 않습니다.");
			}
		} catch (NullPointerException e) {
			System.out.println("조회된 포스트가 없습니다.");
		}
	}

	// 포스트 조회
	@Override
	public void listPost() {
		ArrayList<Post> list = PostDBConnecter.listPost();
		System.out.println("=========================== 포스트 전체 목록 ===========================");
		for (Post post : list) {
			System.out.println(post.toString());
		}
		if (list.size() == 0) {
			System.out.println("목록이 비었습니다.");
		}
	}

	// 계정 페이지로 이동
	@Override
	public void goToAccount() {
		AccountList myAccount = new AccountList();
		myAccount.execute();
	}

}
