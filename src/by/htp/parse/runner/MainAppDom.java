package by.htp.parse.runner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import by.htp.parse.bean.Library;
import by.htp.parse.bean.person.Author;
import by.htp.parse.bean.printing.Book;
import by.htp.parse.bean.printing.Magazine;
import by.htp.parse.bean.printing.Newspaper;
import by.htp.parse.parser.dom.DomParser;
import by.htp.parse.printer.LibraryPrinter;

public class MainAppDom {

	public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException {

		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();

		DocumentBuilder builder = builderFactory.newDocumentBuilder();
		Document document = builder.parse("parse/library.xml");
		Element root = document.getDocumentElement();
		DomParser domParser = new DomParser();
		
		List<Book> books = domParser.parseBooks(root);
		List<Magazine> magazines = domParser.parseMagazine(root);
		List<Newspaper> newspapers = domParser.parseNewspaper(root);
		
		LibraryPrinter library = new LibraryPrinter ();
		library.printInfo(books, magazines, newspapers);
	}
}
