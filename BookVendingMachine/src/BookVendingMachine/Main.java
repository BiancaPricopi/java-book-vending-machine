package BookVendingMachine;

public class Main 
{

	public static void main(String[] args)
	{
		Antiquarian antiquarian = new Antiquarian();
		Book book1 = new Book();
		book1.setTitle("Cronica pasarii arc");
		book1.setAuthor("Haruki Murakami");
		book1.setPages(688);
		AddBook antiquarianAddBook = new AddBook(antiquarian, book1);
		AntiquarianButton antiquarianButton = new AntiquarianButton(antiquarianAddBook);
		antiquarianButton.press();
		
		Book book2 = new Book();
		book2.setTitle("Padurea Norvegiana");
		book2.setAuthor("Haruki Murakami");
		book2.setPages(360);
		antiquarianAddBook = new AddBook(antiquarian, book2);
		antiquarianButton = new AntiquarianButton(antiquarianAddBook);
		antiquarianButton.press();
		
		RemoveBook antiquarianRemoveBook = new RemoveBook(antiquarian, book2);
		antiquarianButton = new AntiquarianButton(antiquarianRemoveBook);
		antiquarianButton.press();

	}

}
