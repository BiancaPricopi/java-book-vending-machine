package BookVendingMachine;

public class DisplayBooks implements readerCommand
{
	Reader reader;
	public DisplayBooks(Reader newReader)
	{
		this.reader = newReader;
	}
	@Override
	public void execute() 
	{
		this.reader.displayAvailableBooks();
	}
}
