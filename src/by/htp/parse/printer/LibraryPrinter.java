package by.htp.parse.printer;

import java.util.List;
import by.htp.parse.bean.printing.Book;
import by.htp.parse.bean.printing.Magazine;
import by.htp.parse.bean.printing.Newspaper;

public class LibraryPrinter {

	public void printInfo(List<Book> books, List<Magazine> magazines, List<Newspaper> newspapers) {

		System.out.println("BOOKS: ");
		if (books != null) {
			for (int i = 0; i < books.size(); i++) {
				System.out.print(
						books.get(i).getId() + ") " + books.get(i).getTitle() + ", " + books.get(i).getYear() + ", ");
				for (int j = 0; j < books.get(i).getListAuthor().size(); j++) {
					System.out.println(books.get(i).getListAuthor().get(j).getName() + " "
							+ books.get(i).getListAuthor().get(j).getSurname());
				}
				System.out.println(
						books.get(i).getCount() + " items, " + "available for " + books.get(i).getCountDay() + " days");
				System.out.println();
			}
		}

		if (magazines != null) {
			System.out.println();
			System.out.println("MAGAZINES: ");
			for (int i = 0; i < magazines.size(); i++) {
				System.out.print(magazines.get(i).getId() + ") " + magazines.get(i).getTitle() + ", "
						+ magazines.get(i).getYear() + ", ");
				for (int j = 0; j < magazines.get(i).getListEditors().size(); j++) {
					System.out.println(magazines.get(i).getListEditors().get(j).getName() + " "
							+ magazines.get(i).getListEditors().get(j).getSurname());
				}
				System.out.println(magazines.get(i).getCount() + " items, " + "available for "
						+ magazines.get(i).getCountDays() + " days");
				System.out.println();
			}
		}

		if (newspapers != null) {
			System.out.println();
			System.out.println("NEWSPAPERS: ");
			for (int i = 0; i < newspapers.size(); i++) {
				System.out.print(newspapers.get(i).getId() + ") " + newspapers.get(i).getTitle() + ", "
						+ newspapers.get(i).getYear() + ", ");
				for (int j = 0; j < newspapers.get(i).getListEditors().size(); j++) {
					System.out.println(newspapers.get(i).getListEditors().get(j).getName() + " "
							+ newspapers.get(i).getListEditors().get(j).getSurname());
				}
				System.out.println(newspapers.get(i).getCount() + " items, " + "available for "
						+ newspapers.get(i).getCountDays() + " days");
				System.out.println();
			}
		}
	}
}
