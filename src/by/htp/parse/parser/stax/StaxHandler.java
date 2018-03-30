package by.htp.parse.parser.stax;

import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import by.htp.parse.bean.person.Author;
import by.htp.parse.bean.person.Editor;
import by.htp.parse.bean.printing.Book;
import by.htp.parse.bean.printing.Magazine;
import by.htp.parse.bean.printing.Newspaper;

public class StaxHandler {
	private static final int PARSE_BOOK = 1;
	private static final int PARSE_MAGAZINE = 2;
	private static final int PARSE_NEWSPAPER = 3;
	private static int parseCurrent;

	private List<Book> listBook = new ArrayList<>();
	private List<Magazine> listMagazine = new ArrayList<>();
	private List<Newspaper> listNewspaper = new ArrayList<>();

	public void process(XMLStreamReader reader) throws XMLStreamException {

		List<Author> listAuthors = new ArrayList<>();
		List<Editor> listEditors = new ArrayList<>();

		Editor editor = null;
		Author author = null;
		Newspaper newspaper = null;
		Book book = null;
		Magazine magazine = null;
		StaxTagName elementName = null;

		while (reader.hasNext()) {
			int type = reader.next();
			switch (type) {
			case XMLStreamConstants.START_ELEMENT:
				elementName = StaxTagName.getElementTagName(reader.getLocalName());
				switch (elementName) {
				case BOOK:
					parseCurrent = PARSE_BOOK;
					book = new Book();
					book.setId((Integer.parseInt(reader.getAttributeValue(null, "id"))));
					listAuthors = new ArrayList<>();
					book.setListAuthor(listAuthors);
					break;
				case MAGAZINE:
					parseCurrent = PARSE_MAGAZINE;
					magazine = new Magazine();
					magazine.setId((Integer.parseInt(reader.getAttributeValue(null, "id"))));
					listEditors = new ArrayList<>();
					magazine.setListEditors(listEditors);
					break;
				case NEWSPAPER:
					parseCurrent = PARSE_NEWSPAPER;
					newspaper = new Newspaper();
					newspaper.setId((Integer.parseInt(reader.getAttributeValue(null, "id"))));
					listEditors = new ArrayList<>();
					newspaper.setListEditors(listEditors);
					break;
				case AUTHOR:
					author = new Author();
				case EDITOR:
					editor = new Editor();
				}
				break;

			case XMLStreamConstants.CHARACTERS:
				String text = reader.getText().trim();

				if (text.isEmpty()) {
					break;
				}
				switch (elementName) {
				case TITLE:
					if (parseCurrent == PARSE_BOOK) {
						book.setTitle(text);
					} else if (parseCurrent == PARSE_MAGAZINE) {
						magazine.setTitle(text);
					} else if (parseCurrent == PARSE_NEWSPAPER) {
						newspaper.setTitle(text);
					}
					break;
				case YEAR:
					if (parseCurrent == PARSE_BOOK) {
						book.setYear(Integer.parseInt(text));
					} else if (parseCurrent == PARSE_MAGAZINE) {
						magazine.setYear(Integer.parseInt(text));
					} else if (parseCurrent == PARSE_NEWSPAPER) {
						newspaper.setYear(Integer.parseInt(text));
					}
					break;
				case COUNT:
					if (parseCurrent == PARSE_BOOK) {
						book.setCount(Integer.parseInt(text));
					} else if (parseCurrent == PARSE_MAGAZINE) {
						magazine.setCount(Integer.parseInt(text));
					} else if (parseCurrent == PARSE_NEWSPAPER) {
						newspaper.setCount(Integer.parseInt(text));
					}
					break;
				case COUNTDAYS:
					if (parseCurrent == PARSE_BOOK) {
						book.setCountDay(Integer.parseInt(text));
					} else if (parseCurrent == PARSE_MAGAZINE) {
						magazine.setCountDays(Integer.parseInt(text));
					} else if (parseCurrent == PARSE_NEWSPAPER) {
						newspaper.setCountDays(Integer.parseInt(text));
					}
					break;
				case NAME:
					if (parseCurrent == PARSE_BOOK) {
						author.setName(text);
					} else if (parseCurrent == PARSE_MAGAZINE || parseCurrent  == PARSE_NEWSPAPER) {
						editor.setName(text);
					}
					break;
				case SURNAME:
					if (parseCurrent == PARSE_BOOK) {
						author.setSurname(text);
					} else if (parseCurrent == PARSE_MAGAZINE || parseCurrent  == PARSE_NEWSPAPER) {
						editor.setSurname(text);
					}
					break;
				}
				break;

			case XMLStreamConstants.END_ELEMENT:
				elementName = StaxTagName.getElementTagName(reader.getLocalName());
				switch (elementName) {
				case BOOK:
					listBook.add(book);
					break;
				case AUTHOR:
					listAuthors.add(author);
					break;
				case EDITOR:
					listEditors.add(editor);
					break;
				case MAGAZINE:
					listMagazine.add(magazine);
					break;
				case NEWSPAPER:
					listNewspaper.add(newspaper);
					break;
				}
			}
		}
	}

	public List<Newspaper> getListNewspaper() {
		return listNewspaper;
	}

	public List<Book> getListBook() {
		return listBook;
	}

	public List<Magazine> getListMagazine() {
		return listMagazine;
	}
}
