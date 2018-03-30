package by.htp.parse.parser.stax;

import by.htp.parse.parser.stax.StaxTagName;

public enum StaxTagName {
	TITLE, YEAR, COUNT, COUNTDAYS, NAME, SURNAME, AUTHOR, AUTHORS, EDITOR, EDITORS, MAGAZINE, MAGAZINES, NEWSPAPER, NEWSPAPERS, BOOK, BOOKS, LIBRARY;

	public static StaxTagName getElementTagName(String element) {

		switch (element) {
		case "title":
			return TITLE;
		case "year":
			return YEAR;
		case "count":
			return COUNT;
		case "countDays":
			return COUNTDAYS;
		case "name":
			return NAME;
		case "surname":
			return SURNAME;
		case "author":
			return AUTHOR;
		case "authors":
			return AUTHORS;
		case "editor":
			return EDITOR;
		case "editors":
			return EDITORS;
		case "magazine":
			return MAGAZINE;
		case "magazines":
			return MAGAZINES;
		case "newspaper":
			return NEWSPAPER;
		case "newspapers":
			return NEWSPAPERS;
		case "book":
			return BOOK;
		case "books":
			return BOOKS;
		case "library":
			return LIBRARY;
		default: 
			throw new EnumConstantNotPresentException(StaxTagName.class, element);
		}
	}
}
