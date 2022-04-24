package co.edu.db;

import java.util.ArrayList;
import java.util.Scanner;

public class FriendList {

	Scanner scn = new Scanner(System.in);

	// Executing the program
	public void execute() {
		while (true) {
			System.out.println("=============================================================");
			System.out.println("1.친구등록 2.친구조회 3.생일조회 4.친구삭제 5.성별조회 6.전체친구목록 7.종료");
			System.out.println("==============================================================");

			int menu = 0;
			try {
				menu = Integer.parseInt(scn.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("Please insert number");
				e.printStackTrace();
			}

			if (menu == 1) {
				Friend friend = addFriend();
				FriendListDB.friendInsert(friend);
				System.out.println("** New friend added. **");
			} else if (menu == 2) {
				Friend friend = searchFriend();
				try {
					System.out.println(friend.toString());
				} catch (NullPointerException e) {
					System.out.println("The friend your are looking for may not be on your list.");
				}
			} else if (menu == 3) {
				searchBirthday();
			} else if (menu == 4) {
				deleteFriend();
			} else if (menu == 5) {
				int genderCode = searchGender();
				String gender = genderVerify(genderCode);
				System.out.println("Friend's gender: " + gender);
			} else if (menu == 6) {
				ArrayList<Friend> friends = FriendListDB.friendList();
				listFriend(friends);
			} else if (menu == 7) {
				System.out.println("End of program");
				break;
			}

		}

	}

	// Adding new friend
	public Friend addFriend() {
		System.out.println("** ADD FRIENDS! **");
		System.out.println("Name >>> ");
		String name = scn.nextLine();
		System.out.println("Age >>> ");
		int age = Integer.parseInt(scn.nextLine());
		System.out.println("Contact >>> ");
		String contact = scn.nextLine();
		System.out.println("Social security number >>> ");
		String ssn = scn.nextLine();

		Friend friend = new Friend(name, age, contact, ssn);
		return friend;
	}

	// Searching friend
	public Friend searchFriend() {
		System.out.println("** SEARCH FRIEND! **");
		System.out.println("Name >>> ");
		String name = scn.nextLine();
		Friend friend = FriendListDB.friendSelect(name);
		return friend;
	}

	// Searching friend's birthday using social security number
	public void searchBirthday() {
		System.out.println("** SEARCH FRIEND'S BIRTHDAY **");
		System.out.println("Name >>> ");
		String name = scn.nextLine();
		String ssn = FriendListDB.friendBirthday(name);
		System.out.println(Friend.birthday(ssn));
	}

	// Deleting friend
	public void deleteFriend() {
		System.out.println("** DELETE FRIEND FROM LIST");
		System.out.println("Name >>> ");
		String name = scn.nextLine();
		System.out.println("Are you sure to delete " + name + " from the list? (yes or no)");
		String answer = scn.nextLine();
		if (answer.startsWith("y")) {
			FriendListDB.friendDelete(name);
			System.out.println(name + " has been deleted from your friend list.");
		} else if (answer.startsWith("n")) {
			System.out.println(name + " is still on your friend list.");
		}
	}

	// Searching friend's gender using social security number (8th num = gender
	// code)
	public int searchGender() {
		System.out.println("** SEARCH FRIEND'S GENDER **");
		System.out.println("Name >>> ");
		String name = scn.nextLine();
		int genderCode = FriendListDB.friendGender(name);
		return genderCode;
	}

	// Verifying gender code (odd = male, even = female)
	public String genderVerify(int genderCode) {
		String gender = null;
		if (genderCode % 2 != 0) {
			gender = "male";
		} else if (genderCode % 2 == 0) {
			gender = "female";
		}

		return gender;
	}

	// Listing friends
	public void listFriend(ArrayList<Friend> friends) {
		System.out.println("** Current Friend List **");
		System.out.println();
		for (Friend friend : friends) {
			System.out.println(friend.toString());
			System.out.println();
		}
	}

}
