package BookVendingMachine;

public class checkLoan implements readerCommand
{
	Reader reader;
	public checkLoan(Reader newReader)
	{
		this.reader = newReader;
	}
	@Override
	public void execute()
	{
		this.reader.checkTimeToRead();
	}
}
