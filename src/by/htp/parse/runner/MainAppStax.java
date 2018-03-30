package by.htp.parse.runner;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import by.htp.parse.bean.person.Author;
import by.htp.parse.bean.person.Editor;
import by.htp.parse.printer.LibraryPrinter;
import by.htp.parse.bean.printing.Book;
import by.htp.parse.bean.printing.Magazine;
import by.htp.parse.bean.printing.Newspaper;
import by.htp.parse.parser.stax.StaxHandler;
import by.htp.parse.parser.stax.StaxTagName;

public class MainAppStax {

	public static void main(String[] args) throws FileNotFoundException {
		XMLInputFactory inputFactory = XMLInputFactory.newInstance();

		try {
			InputStream input = new FileInputStream("parse/library.xml");
			XMLStreamReader reader = inputFactory.createXMLStreamReader(input);
			StaxHandler handler = new StaxHandler();
			handler.process(reader);
			List<Book> books = handler.getListBook();
			List<Magazine> magazines = handler.getListMagazine();
			List<Newspaper> newspapers = handler.getListNewspaper();

			LibraryPrinter library = new LibraryPrinter();
			library.printInfo(books, magazines, newspapers);

		} catch (XMLStreamException e) {
			e.printStackTrace();
		}
	}
}
