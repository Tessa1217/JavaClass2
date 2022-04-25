package co.edu.post;

public class Post {
	
	// Fields 
	private int boardNo;
	private String title; 
	private String content; 
	private String author; 
	
	// Constructor
	Post(int boardNo, String title, String content, String author) {
		this.boardNo = boardNo;
		this.title = title;
		this.content = content;
		this.author = author; 
	}

	
	// Getters and Setters 
	public int getBoardNo() {
		return boardNo;
	}


	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public String getAuthor() {
		return author;
	}


	public void setAuthor(String author) {
		this.author = author;
	}


	// toString()
	
	@Override
	public String toString() {
		return "Post [boardNo=" + boardNo + ", title=" + title + ", author=" + author + "]";
	}
	
	public String detailView() {
		return "Post [boardNo=\" + boardNo + \", title=\" + title + \", author=\" + author + \", date=\" + date + \"]";
	}
	
	

}
