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

	}

}
