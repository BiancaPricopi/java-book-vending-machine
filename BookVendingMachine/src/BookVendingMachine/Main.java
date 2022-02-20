package BookVendingMachine;

import java.nio.file.Files;
import java.nio.file.Paths;

public class Main 
{
	public static void main(String[] args)
	{
		delete();
		Antiquarian antiquarian = new Antiquarian();
		Book book1 = createBook(1, "Cronica pasarii arc", "Haruki Murakami", 688);
		AddBook antiquarianAddBook = new AddBook(antiquarian, book1);
		AntiquarianButton antiquarianButton = new AntiquarianButton(antiquarianAddBook);
		antiquarianButton.press();
		
		Book book2 = new Book();
		book2.setTitle("Padurea Norvegiana");
		book2.setAuthor("Haruki Murakami");
		book2.setPages(360);
		book2.setId(2);
		antiquarianAddBook = new AddBook(antiquarian, book2);
		antiquarianButton = new AntiquarianButton(antiquarianAddBook);
		antiquarianButton.press();
		antiquarianButton.press();
		
		Book book3 = new Book();
		book3.setTitle("1Q84");
		book3.setAuthor("Haruki Murakami");
		book3.setPages(1344);
		book3.setId(3);
		antiquarianAddBook = new AddBook(antiquarian, book3);
		antiquarianButton = new AntiquarianButton(antiquarianAddBook);
		antiquarianButton.press();
		
		RemoveBook antiquarianRemoveBook = new RemoveBook(antiquarian, book2);
		antiquarianButton = new AntiquarianButton(antiquarianRemoveBook);
		antiquarianButton.press();
		
		Reader reader = vendingMachineControl.getReader();
		Book borrow = new Book();
		borrow.setTitle("Cronica pasarii arc");
		borrow.setAuthor("Haruki Murakami");
		borrow.setPages(688);
		borrow.setId(1);
		Borrow readerBorrowBook = new Borrow(reader, borrow);
		ReaderButton readerButton = new ReaderButton(readerBorrowBook);
		readerButton.press();
		
		Book padureaNorvegiana = new Book();
		padureaNorvegiana.setTitle("Padurea Norvegiana");
		padureaNorvegiana.setAuthor("Haruki Murakami");
		padureaNorvegiana.setPages(360);
		padureaNorvegiana.setId(2);
		readerBorrowBook = new Borrow(reader, padureaNorvegiana);
		readerButton = new ReaderButton(readerBorrowBook);
		readerButton.press();
		
		Return readerReturnBook = new Return(reader, padureaNorvegiana);
		readerButton = new ReaderButton(readerReturnBook);
		readerButton.press();
		
		checkLoan check = new checkLoan(reader);
		readerButton = new ReaderButton(check);
		readerButton.press();
		
		DisplayBooks display = new DisplayBooks(reader);
		readerButton = new ReaderButton(display);
		readerButton.press();

	}
	public static Book createBook(int id, String title, String author, int pages)
	{
		Book newBook = new Book();
		newBook.setId(id);
		newBook.setTitle(title);
		newBook.setAuthor(author);
		newBook.setPages(pages);
		
		return newBook;
	}
	public static void delete()
	{
		try 
		{
            Files.deleteIfExists(Paths.get("C:\\Users\\Admin\\Documents\\java\\BookVendingMachine\\BookInventory.txt"));
            Files.deleteIfExists(Paths.get("C:\\Users\\Admin\\Documents\\java\\BookVendingMachine\\BorrowedBooks.txt"));
        }
        catch (Exception error) 
		{
            System.out.println(error.getMessage());
        }
	}
}
