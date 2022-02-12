package BookVendingMachine;

public class Return implements readerCommand
{
	Reader reader;
	public Return(Reader newReader)
	{
		this.reader = newReader;
	}
	@Override
	public void execute()
	{
		this.reader.returnBook();
	}
}
