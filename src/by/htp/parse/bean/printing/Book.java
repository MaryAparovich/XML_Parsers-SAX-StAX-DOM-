package by.htp.parse.bean.printing;

import java.util.ArrayList;
import java.util.List;
import by.htp.parse.bean.person.Author;

public class Book {

	private int id;
	private String title;
	private int year;
	private int count;
	private int countDays;
	private List<Author> listAuthor = new ArrayList<>();

	
	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getCountDay() {
		return countDays;
	}

	public void setCountDay(int countDays) {
		this.countDays = countDays;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public List<Author> getListAuthor() {
		return listAuthor;
	}

	public void setListAuthor(List<Author> listAuthor) {
		this.listAuthor = listAuthor;
	}

	public int getId() {
		return id;
	}

	public void setId(int i) {
		this.id = i;
	}
}
