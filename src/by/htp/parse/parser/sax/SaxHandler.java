package by.htp.parse.parser.sax;

import java.util.ArrayList;
import java.util.List;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

import by.htp.parse.bean.Library;
import by.htp.parse.bean.person.Author;
import by.htp.parse.bean.person.Editor;
import by.htp.parse.bean.printing.Book;
import by.htp.parse.bean.printing.Magazine;
import by.htp.parse.bean.printing.Newspaper;

public class SaxHandler extends DefaultHandler {

	private static final int PARSE_BOOK = 1;
	private static final int PARSE_MAGAZINE = 2;
	private static final int PARSE_NEWSPAPER = 3;
	private static int parseCurrent;

	private List<Book> bookList = new ArrayList<>();
	private List<Magazine> magazineList = new ArrayList<>();
	private List<Newspaper> listNewspaper = new ArrayList<>();
	private List<Editor> listEditors;
	private List<Author> listAuthors;
	private Book book;
	private Magazine magazine;
	private Newspaper newspaper;
	private Author author;
	private Editor editor;
	private Library library = new Library(bookList, magazineList, listNewspaper);
	private StringBuilder text;

	public Library getLibrary() {
		return library;
	}

	public StringBuilder getText() {
		return text;
	}

	@Override
	public void startDocument() throws SAXException {
		System.out.println("Parsing started..");
	}

	@Override
	public void endDocument() throws SAXException {
		System.out.println("Parsing ended.\n");

	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		System.out.println("startElement -> " + "uri: " + uri + ", localName " + localName + ", qName: " + qName);
		text = new StringBuilder();
		if (qName.equals("book")) {
			parseCurrent = PARSE_BOOK;
			book = new Book();
			book.setId((Integer.parseInt(attributes.getValue("id"))));
			listAuthors = new ArrayList<>();
			book.setListAuthor(listAuthors);

		} else if (qName.equals("author")) {
			author = new Author();

		} else if (qName.equals("magazine")) {
			parseCurrent = PARSE_MAGAZINE;
			magazine = new Magazine();
			magazine.setId((Integer.parseInt(attributes.getValue("id"))));
			listEditors = new ArrayList<>();
			magazine.setListEditors(listEditors);

		} else if (qName.equals("editors")) {
			editor = new Editor();

		} else if (qName.equals("newspaper")) {
			parseCurrent = PARSE_NEWSPAPER;
			newspaper = new Newspaper();
			newspaper.setId((Integer.parseInt(attributes.getValue("id"))));
			listEditors = new ArrayList<>();
			newspaper.setListEditors(listEditors);
		}
	}

	@Override
	public void characters(char[] buffer, int start, int length) throws SAXException {
		text.append(buffer, start, length);
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		SaxTagName saxTagName = SaxTagName.valueOf(qName.toUpperCase());
		switch (saxTagName) {
		case TITLE:
			if (parseCurrent == PARSE_BOOK) {
				book.setTitle(text.toString());
			} else if (parseCurrent == PARSE_MAGAZINE) {
				magazine.setTitle(text.toString());
			} else if (parseCurrent == PARSE_NEWSPAPER) {
				newspaper.setTitle(text.toString());
			}
			break;

		case YEAR:
			if (parseCurrent == PARSE_BOOK) {
				book.setYear(Integer.parseInt(text.toString()));
			} else if (parseCurrent == PARSE_MAGAZINE) {
				magazine.setYear(Integer.parseInt(text.toString()));
			} else if (parseCurrent == PARSE_NEWSPAPER) {
				newspaper.setYear(Integer.parseInt(text.toString()));
			}
			break;

		case COUNT:
			if (parseCurrent == PARSE_BOOK) {
				book.setCount(Integer.parseInt(text.toString()));
			} else if (parseCurrent == PARSE_MAGAZINE) {
				magazine.setCount(Integer.parseInt(text.toString()));
			} else if (parseCurrent == PARSE_NEWSPAPER) {
				newspaper.setCount(Integer.parseInt(text.toString()));
			}
			break;

		case COUNTDAYS:
			if (parseCurrent == PARSE_BOOK) {
				book.setCountDay(Integer.parseInt(text.toString()));
			} else if (parseCurrent == PARSE_MAGAZINE) {
				magazine.setCountDays(Integer.parseInt(text.toString()));
			} else if (parseCurrent == PARSE_NEWSPAPER) {
				newspaper.setCountDays(Integer.parseInt(text.toString()));
			}
			break;

		case NAME:
			if (parseCurrent == PARSE_BOOK) {
				author.setName(text.toString());
			} else if (parseCurrent == PARSE_MAGAZINE) {
				editor.setName(text.toString());
			} else if (parseCurrent == PARSE_NEWSPAPER) {
				editor.setName(text.toString());
			}
			break;

		case SURNAME:
			if (parseCurrent == PARSE_BOOK) {
				author.setSurname(text.toString());
			} else if (parseCurrent == PARSE_MAGAZINE) {
				editor.setSurname(text.toString());
			} else if (parseCurrent == PARSE_NEWSPAPER) {
				editor.setSurname(text.toString());
			}
			break;

		case BOOK:
			bookList.add(book);
			book = null;
			break;

		case MAGAZINE:
			magazineList.add(magazine);
			magazine = null;
			break;

		case AUTHOR:
			listAuthors.add(author);
			author = null;
			break;

		case EDITORS:
			listEditors.add(editor);
			editor = null;
			break;

		case NEWSPAPER:
			listNewspaper.add(newspaper);
			newspaper = null;
			break;
		}
	}

	@Override
	public void warning(SAXParseException e) throws SAXException {
		System.err.println("WARNING" + e.getLineNumber() + e.getMessage());
	}

	@Override
	public void error(SAXParseException e) throws SAXException {
		System.err.println("ERROR" + e.getLineNumber() + e.getMessage());
	}

	@Override
	public void fatalError(SAXParseException e) throws SAXException {
		System.err.println("FATAL" + e.getLineNumber() + e.getMessage());
		throw (e);
	}

}