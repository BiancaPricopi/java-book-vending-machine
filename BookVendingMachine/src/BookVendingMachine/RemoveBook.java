package BookVendingMachine;

public class RemoveBook implements AntiquarianCommand
{
	Antiquarian antiquarian;
	Book book;
	public RemoveBook(Antiquarian newAntiquarian, Book newBook)
	{
		this.antiquarian = newAntiquarian;
		this.book = newBook;
	}
	@Override
	public void execute()
	{
		this.antiquarian.removeBook(this.book);
	}

}
