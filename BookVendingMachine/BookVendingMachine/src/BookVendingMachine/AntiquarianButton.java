package BookVendingMachine;

public class AntiquarianButton 
{
	AntiquarianCommand command;
	public AntiquarianButton(AntiquarianCommand newCommand)
	{
		this.command = newCommand;
	}
	public void press()
	{
		this.command.execute();
	}
}
