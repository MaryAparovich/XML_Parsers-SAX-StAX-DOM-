package by.htp.parse.parser.dom;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import by.htp.parse.bean.person.Author;
import by.htp.parse.bean.person.Editor;
import by.htp.parse.bean.printing.Book;
import by.htp.parse.bean.printing.Magazine;
import by.htp.parse.bean.printing.Newspaper;

public class DomParser {

	
	public List<Book> parseBooks(Element root) {

		List<Book> listBooks = new ArrayList<>();

		NodeList bookNodes = root.getElementsByTagName("book");

		for (int i = 0; i < bookNodes.getLength(); i++) {

			Element bookElement = (Element) bookNodes.item(i);

			Book book = new Book();
			book.setId(Integer.parseInt(bookElement.getAttribute("id")));
			book.setTitle(getSingleChild(bookElement, "title").getTextContent().trim());
			book.setCount(Integer.parseInt(getSingleChild(bookElement, "count").getTextContent().trim()));
			book.setYear(Integer.parseInt(getSingleChild(bookElement, "year").getTextContent().trim()));
			book.setCountDay(Integer.parseInt(getSingleChild(bookElement, "countDays").getTextContent().trim()));

			List<Author> authors = new ArrayList<>();
			NodeList authorNodes = bookElement.getElementsByTagName("author");

			for (int j = 0; j < authorNodes.getLength(); j++) {
				Author author = new Author();
				Element authorElement = (Element) authorNodes.item(j);
				author.setName(getSingleChild(authorElement, "name").getTextContent().trim());
				author.setSurname(getSingleChild(authorElement, "surname").getTextContent().trim());
				authors.add(author);
			}
			book.setListAuthor(authors);
			listBooks.add(book);
		}
		return listBooks;
	}

	
	public List<Magazine> parseMagazine(Element root) {

		List<Magazine> listMagazines = new ArrayList<>();
		NodeList magazineNodes = root.getElementsByTagName("magazine");

		for (int i = 0; i < magazineNodes.getLength(); i++) {

			Element magazineElement = (Element) magazineNodes.item(i);

			Magazine magazine = new Magazine();
			magazine.setId(Integer.parseInt(magazineElement.getAttribute("id")));
			magazine.setTitle(getSingleChild(magazineElement, "title").getTextContent().trim());
			magazine.setCount(Integer.parseInt(getSingleChild(magazineElement, "count").getTextContent().trim()));
			magazine.setYear(Integer.parseInt(getSingleChild(magazineElement, "year").getTextContent().trim()));
			magazine.setCountDays(Integer.parseInt(getSingleChild(magazineElement, "countDays").getTextContent().trim()));

			List<Editor> listEditor = new ArrayList<>();
			NodeList editorNodes = magazineElement.getElementsByTagName("editor");

			for (int j = 0; j < editorNodes.getLength(); j++) {
				
				Editor editor = new Editor();
				
				Element editorElement = (Element) editorNodes.item(j);
				editor.setName(getSingleChild(editorElement, "name").getTextContent().trim());
				editor.setSurname(getSingleChild(editorElement, "surname").getTextContent().trim());
				listEditor.add(editor);
			}
			magazine.setListEditors(listEditor);
			listMagazines.add(magazine);
		}
		
		return listMagazines;
	}
	
	
	public List<Newspaper> parseNewspaper(Element root) {

		List<Newspaper> listNewspapers = new ArrayList<>();
		NodeList newspaperNodes = root.getElementsByTagName("newspaper");

		for (int i = 0; i < newspaperNodes.getLength(); i++) {
			
			Element newspaperElement = (Element) newspaperNodes.item(i);
			
			Newspaper newspaper = new Newspaper();
			newspaper.setId(Integer.parseInt(newspaperElement.getAttribute("id")));
			newspaper.setTitle(getSingleChild(newspaperElement, "title").getTextContent().trim());
			newspaper.setCount(Integer.parseInt(getSingleChild(newspaperElement, "count").getTextContent().trim()));
			newspaper.setYear(Integer.parseInt(getSingleChild(newspaperElement, "year").getTextContent().trim()));
			newspaper.setCountDays(Integer.parseInt(getSingleChild(newspaperElement, "countDays").getTextContent().trim()));

			List<Editor> listEditor = new ArrayList<>();
			NodeList editorNodes = newspaperElement.getElementsByTagName("editor");

			for (int j = 0; j < editorNodes.getLength(); j++) {
				
				Editor editor = new Editor();
				
				Element editorElement = (Element) editorNodes.item(j);
				editor.setName(getSingleChild(editorElement, "name").getTextContent().trim());
				editor.setSurname(getSingleChild(editorElement, "surname").getTextContent().trim());
				listEditor.add(editor);
			}
			newspaper.setListEditors(listEditor);
			listNewspapers.add(newspaper);
		}
		
		return listNewspapers;
	}

	
	private Element getSingleChild(Element element, String childName) {
		NodeList nList = element.getElementsByTagName(childName);
		Element child = (Element) nList.item(0);
		return child;
	}
}
