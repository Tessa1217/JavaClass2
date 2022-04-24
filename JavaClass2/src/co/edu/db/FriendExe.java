package co.edu.db;

public class FriendExe {

	public static void main(String[] args) {
		FriendList friendList = new FriendList();
		FriendListDB friendListDb = new FriendListDB();

		for (int i = 0; i < 3; i++) {
			Friend friend = friendList.execute();
			friendListDb.friendListInsert(friend);

		}

	}

}
