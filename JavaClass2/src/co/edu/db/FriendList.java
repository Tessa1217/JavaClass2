package co.edu.db;

import java.util.ArrayList;
import java.util.Scanner;

public class FriendList {

	ArrayList<Friend> friends = new ArrayList<Friend>();
	Scanner scn = new Scanner(System.in);

	public Friend execute() {
		while (true) {
			System.out.println("name >>> ");
			String name = scn.nextLine();
			System.out.println("age >>> ");
			int age = Integer.parseInt(scn.nextLine());
			System.out.println("contact >>> ");
			String contact = scn.nextLine();
			System.out.println("ssn >>> ");
			String ssn = scn.nextLine();

			Friend friend = new Friend(name, age, contact, ssn);
			return friend;

		}

	}

}
