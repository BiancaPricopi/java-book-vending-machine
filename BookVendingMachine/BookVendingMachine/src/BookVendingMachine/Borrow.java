package BookVendingMachine;

public class Borrow implements readerCommand
{
	Reader reader;
	Book bookToBorrow;
	public Borrow(Reader newReader, Book newBook)
	{
		this.reader = newReader;
		this.bookToBorrow = newBook;
	}
	@Override
	public void execute() 
	{
		this.reader.borrowBook(this.bookToBorrow);
	}	
}
