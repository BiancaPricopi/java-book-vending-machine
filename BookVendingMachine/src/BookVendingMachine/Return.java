package BookVendingMachine;

public class Return implements readerCommand
{
	Reader reader;
	Book book;
	public Return(Reader newReader, Book newBook)
	{
		this.reader = newReader;
		this.book = newBook;
	}
	@Override
	public void execute()
	{
		this.reader.returnBook(this.book);
	}
}
