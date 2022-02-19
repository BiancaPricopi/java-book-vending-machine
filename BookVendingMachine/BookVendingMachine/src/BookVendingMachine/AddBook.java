package BookVendingMachine;

public class AddBook implements AntiquarianCommand
{
	Antiquarian antiquarian;
	Book book;
	public AddBook(Antiquarian newAntiquarian, Book newBook)
	{
		this.antiquarian = newAntiquarian;
		this.book = newBook;
	}
	@Override
	public void execute()
	{
		this.antiquarian.addNewBook(this.book.getId(), this.book.getTitle(), this.book.getAuthor(), this.book.getPages());
	}
}
