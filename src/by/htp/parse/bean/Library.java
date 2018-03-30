package by.htp.parse.bean;

import java.util.List;
import by.htp.parse.bean.printing.Book;
import by.htp.parse.bean.printing.Magazine;
import by.htp.parse.bean.printing.Newspaper;

public class Library {
	private List<Book> bookList;
	private List<Magazine> listMagazines;
	private List<Newspaper> listNewspapers;
	
	public Library(List<Book> bookList, List<Magazine> listMagazines, List<Newspaper> listNewspapers) {
		this.bookList = bookList;
		this.listMagazines = listMagazines;
		this.listNewspapers = listNewspapers;
	}

	public List<Book> getListBook() {
		return bookList;
	}

	public List<Magazine> getListMagazines() {
		return listMagazines;
	}

	public List<Newspaper> getListNewspapers() {
		return listNewspapers;
	}
}
