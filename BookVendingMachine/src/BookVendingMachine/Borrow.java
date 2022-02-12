package BookVendingMachine;

public class Borrow implements readerCommand
{
	Reader reader;
	public Borrow(Reader newReader)
	{
		this.reader = newReader;
	}
	@Override
	public void execute() 
	{
		this.reader.borrowBook();
	}	
}
