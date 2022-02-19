package BookVendingMachine;

public class ReaderButton 
{
	readerCommand command;
	public ReaderButton(readerCommand newCommand)
	{
		this.command = newCommand;
	}
	public void press()
	{
		this.command.execute();
	}
}
