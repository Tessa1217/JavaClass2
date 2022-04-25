package co.edu.post;

import java.util.ArrayList;
import java.util.Scanner;

public class PostList implements PostService {

	Scanner scn = new Scanner(System.in);
	int boardNo = 1;
	static String author = "";

	public void execute(String accountId) {

		author = accountId;

		while (true) {
			System.out.println("===============================================================================");
			System.out.println("1.Add Post 2.Modify Post 3.Delete Post 4.Search Post 4. List Post 5.My Account");
			System.out.println("===============================================================================");
			int menu = 0;

			try {
				menu = Integer.parseInt(scn.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("숫자를 입력해주세요.");
			}

			if (menu == 1) {
				addPost();
			} else if (menu == 4) {
				listPost();
			} else if (menu == 5) {
				goToAccount();
			}

		}
	}

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

	@Override
	public void modifyPost() {

		System.out.println("");

	}

	@Override
	public void deletePost() {

	}

	@Override
	public void srchPost(String author) {

	}

	@Override
	public void listPost() {
		ArrayList<Post> list = PostDBConnecter.listPost();
		System.out.println("*** 포스트 전체 목록 ***");
		for (Post post : list) {
			System.out.println(post.toString());
		}
	}

	@Override
	public void goToAccount() {

		AccountList myAccount = new AccountList();
		myAccount.execute();

	}

}
