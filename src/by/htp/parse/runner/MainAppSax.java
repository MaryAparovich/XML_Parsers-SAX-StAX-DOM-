package by.htp.parse.runner;

import java.io.IOException;
import java.util.List;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import by.htp.parse.bean.printing.Book;
import by.htp.parse.bean.printing.Magazine;
import by.htp.parse.bean.printing.Newspaper;
import by.htp.parse.parser.sax.SaxHandler;
import by.htp.parse.printer.LibraryPrinter;

public class MainAppSax {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		
		XMLReader reader = XMLReaderFactory.createXMLReader();
		SaxHandler handler = new SaxHandler();
		reader.setContentHandler(handler);
		reader.parse(new InputSource("parse/library.xml"));
		LibraryPrinter libraryPrinter = new LibraryPrinter();
		List<Book> books = handler.getLibrary().getListBook();
		List<Magazine> magazines = handler.getLibrary().getListMagazines();
		List<Newspaper> newspapers = handler.getLibrary().getListNewspapers();
		libraryPrinter.printInfo(books, magazines, newspapers);
	}
}
