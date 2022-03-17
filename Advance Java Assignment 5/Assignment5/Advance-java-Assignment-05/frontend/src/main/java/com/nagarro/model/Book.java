package com.nagarro.model;

public class Book {
	private int id;
	private int bookCode;
	private String bookName;
	private String author;
	private String dateAdded;

	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Book(int id, int bookCode, String bookName, String author, String dateAdded) {
		super();
		this.id = id;
		this.bookCode = bookCode;
		this.bookName = bookName;
		this.author = author;
		this.dateAdded = dateAdded;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", bookCode=" + bookCode + ", bookName=" + bookName + ", author=" + author
				+ ", dateAdded=" + dateAdded + "]";
	}

	public int getBookCode() {
		return bookCode;
	}

	public String getBookName() {
		return bookName;
	}

	public String getAuthor() {
		return author;
	}

	public String getDateAdded() {
		return dateAdded;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setBookCode(int bookCode) {
		this.bookCode = bookCode;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setDateAdded(String dateAdded) {
		this.dateAdded = dateAdded;
	}

}
